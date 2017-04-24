package co.com.binariasystems.gestpymesoc.business.bean.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.binariasystems.fmw.business.domain.Order;
import co.com.binariasystems.fmw.business.domain.Order.Direction;
import co.com.binariasystems.fmw.business.domain.Page;
import co.com.binariasystems.fmw.business.domain.PageRequest;
import co.com.binariasystems.fmw.util.ObjectUtils;
import co.com.binariasystems.gestpymesoc.business.bean.ProviderBean;
import co.com.binariasystems.gestpymesoc.business.dao.ProviderDAO;
import co.com.binariasystems.gestpymesoc.business.dto.ProviderDTO;
import co.com.binariasystems.gestpymesoc.business.entity.GptProvider;
import co.com.binariasystems.gestpymesoc.business.specification.ProviderSpecifications;
import co.com.binariasystems.gestpymesoc.business.utils.GestPymeSOCBusinessUtils;

@Service
@Transactional
public class ProviderBeanImpl implements ProviderBean {
	@Autowired
	private ProviderDAO dao;
	
	@Override
	public Page<ProviderDTO> findAll(PageRequest pageRequest) {
		return GestPymeSOCBusinessUtils.toPage(
				dao.findAll(GestPymeSOCBusinessUtils.buildPageRequest(pageRequest, new Order(Direction.DESC, "creationDate"))), 
				ProviderDTO.class);
	}

	@Override
	public Page<ProviderDTO> findAll(ProviderDTO thirdPerson, PageRequest pageRequest) {
		return GestPymeSOCBusinessUtils.toPage(
				dao.findAll(ProviderSpecifications.filledFieldsEqualsTo(thirdPerson),
						GestPymeSOCBusinessUtils.buildPageRequest(pageRequest, new Order(Direction.DESC, "creationDate"))), 
						ProviderDTO.class);
	}

	@Override
	public ProviderDTO save(ProviderDTO thirdPerson) {
		return ObjectUtils.transferProperties(dao.save(ObjectUtils.transferProperties(thirdPerson, GptProvider.class)), ProviderDTO.class);
	}

	@Override
	public void delete(ProviderDTO thirdPerson) {
		dao.delete(ObjectUtils.transferProperties(thirdPerson, GptProvider.class));
	}

}
