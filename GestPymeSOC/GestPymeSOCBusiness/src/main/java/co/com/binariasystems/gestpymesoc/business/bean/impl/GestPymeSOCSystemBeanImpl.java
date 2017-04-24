package co.com.binariasystems.gestpymesoc.business.bean.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.binariasystems.gestpymesoc.business.bean.GestPymeSOCSystemBean;
import co.com.binariasystems.gestpymesoc.business.dao.GestPymeSOCSystemDAO;

@Service
@Transactional
public class GestPymeSOCSystemBeanImpl implements GestPymeSOCSystemBean {
	@Autowired
	private GestPymeSOCSystemDAO dao;
}
