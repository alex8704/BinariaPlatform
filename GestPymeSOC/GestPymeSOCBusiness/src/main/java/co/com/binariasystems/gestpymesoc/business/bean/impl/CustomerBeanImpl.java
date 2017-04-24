package co.com.binariasystems.gestpymesoc.business.bean.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.binariasystems.fmw.business.domain.Order;
import co.com.binariasystems.fmw.business.domain.Order.Direction;
import co.com.binariasystems.fmw.business.domain.Page;
import co.com.binariasystems.fmw.business.domain.PageRequest;
import co.com.binariasystems.fmw.util.ObjectUtils;
import co.com.binariasystems.gestpymesoc.business.bean.CustomerBean;
import co.com.binariasystems.gestpymesoc.business.dao.CustomerDAO;
import co.com.binariasystems.gestpymesoc.business.dto.CustomerDTO;
import co.com.binariasystems.gestpymesoc.business.entity.GptCustomer;
import co.com.binariasystems.gestpymesoc.business.specification.CustomerSpecifications;
import co.com.binariasystems.gestpymesoc.business.utils.GestPymeSOCBusinessUtils;

@Service
@Transactional
public class CustomerBeanImpl implements CustomerBean {
	@Autowired
	private CustomerDAO dao;

	@Override
	public Page<CustomerDTO> findAll(PageRequest pageRequest) {
		return GestPymeSOCBusinessUtils.toPage(
				dao.findAll(GestPymeSOCBusinessUtils.buildPageRequest(pageRequest, new Order(Direction.DESC, "creationDate"))), 
				CustomerDTO.class);
	}

	@Override
	public Page<CustomerDTO> findAll(CustomerDTO thirdPerson, PageRequest pageRequest) {
		return GestPymeSOCBusinessUtils.toPage(
				dao.findAll(CustomerSpecifications.filledFieldsEqualsTo(thirdPerson),
						GestPymeSOCBusinessUtils.buildPageRequest(pageRequest, new Order(Direction.DESC, "creationDate"))), 
						CustomerDTO.class);
	}

	@Override
	public CustomerDTO save(CustomerDTO thirdPerson) {
		return ObjectUtils.transferProperties(dao.save(ObjectUtils.transferProperties(thirdPerson, GptCustomer.class)), CustomerDTO.class);
	}

	@Override
	public void delete(CustomerDTO thirdPerson) {
		dao.delete(ObjectUtils.transferProperties(thirdPerson, GptCustomer.class));
	}

}
