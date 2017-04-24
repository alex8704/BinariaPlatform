package co.com.binariasystems.gestpymesoc.business.bean.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.binariasystems.fmw.business.domain.Order;
import co.com.binariasystems.fmw.business.domain.Order.Direction;
import co.com.binariasystems.fmw.business.domain.Page;
import co.com.binariasystems.fmw.business.domain.PageRequest;
import co.com.binariasystems.fmw.util.ObjectUtils;
import co.com.binariasystems.gestpymesoc.business.bean.EmployeeBean;
import co.com.binariasystems.gestpymesoc.business.dao.EmployeeDAO;
import co.com.binariasystems.gestpymesoc.business.dto.EmployeeDTO;
import co.com.binariasystems.gestpymesoc.business.entity.GptEmployee;
import co.com.binariasystems.gestpymesoc.business.specification.EmployeeSpecifications;
import co.com.binariasystems.gestpymesoc.business.utils.GestPymeSOCBusinessUtils;

@Service
@Transactional
public class EmployeeBeanImpl implements EmployeeBean {
	@Autowired
	private EmployeeDAO dao;
	
	@Override
	public Page<EmployeeDTO> findAll(PageRequest pageRequest) {
		return GestPymeSOCBusinessUtils.toPage(
				dao.findAll(GestPymeSOCBusinessUtils.buildPageRequest(pageRequest, new Order(Direction.DESC, "creationDate"))), 
				EmployeeDTO.class);
	}

	@Override
	public Page<EmployeeDTO> findAll(EmployeeDTO thirdPerson, PageRequest pageRequest) {
		return GestPymeSOCBusinessUtils.toPage(
				dao.findAll(EmployeeSpecifications.filledFieldsEqualsTo(thirdPerson),
						GestPymeSOCBusinessUtils.buildPageRequest(pageRequest, new Order(Direction.DESC, "creationDate"))), 
						EmployeeDTO.class);
	}

	@Override
	public EmployeeDTO save(EmployeeDTO thirdPerson) {
		return ObjectUtils.transferProperties(dao.save(ObjectUtils.transferProperties(thirdPerson, GptEmployee.class)), EmployeeDTO.class);
	}

	@Override
	public void delete(EmployeeDTO thirdPerson) {
		dao.delete(ObjectUtils.transferProperties(thirdPerson, GptEmployee.class));
	}

	@Override
	public EmployeeDTO findByIdentificationNumber(String identificationNumber) {
		return ObjectUtils.transferProperties(dao.findByIdentificationNumber(identificationNumber), EmployeeDTO.class);
	}

}
