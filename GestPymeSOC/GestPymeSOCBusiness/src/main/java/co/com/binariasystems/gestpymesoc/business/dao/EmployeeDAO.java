package co.com.binariasystems.gestpymesoc.business.dao;

import co.com.binariasystems.fmw.dataaccess.JPABasedDAO;
import co.com.binariasystems.gestpymesoc.business.entity.GptEmployee;

public interface EmployeeDAO extends JPABasedDAO<GptEmployee, Integer> {
	public GptEmployee findByIdentificationNumber(String identificationNumber);
}
