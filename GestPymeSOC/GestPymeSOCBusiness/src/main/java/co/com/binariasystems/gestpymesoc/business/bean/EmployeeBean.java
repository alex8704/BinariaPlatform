package co.com.binariasystems.gestpymesoc.business.bean;

import co.com.binariasystems.fmw.business.domain.Page;
import co.com.binariasystems.fmw.business.domain.PageRequest;
import co.com.binariasystems.gestpymesoc.business.dto.EmployeeDTO;

public interface EmployeeBean {
	public Page<EmployeeDTO> findAll(PageRequest pageRequest);
	public Page<EmployeeDTO> findAll(EmployeeDTO thirdPerson, PageRequest pageRequest);
	public EmployeeDTO save(EmployeeDTO thirdPerson);
	public void delete(EmployeeDTO thirdPerson);
	public EmployeeDTO findByIdentificationNumber(String identificationNumber);
}
