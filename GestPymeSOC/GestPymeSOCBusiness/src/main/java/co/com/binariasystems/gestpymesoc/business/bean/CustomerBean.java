package co.com.binariasystems.gestpymesoc.business.bean;

import co.com.binariasystems.fmw.business.domain.Page;
import co.com.binariasystems.fmw.business.domain.PageRequest;
import co.com.binariasystems.gestpymesoc.business.dto.CustomerDTO;

public interface CustomerBean {
	public Page<CustomerDTO> findAll(PageRequest pageRequest);
	public Page<CustomerDTO> findAll(CustomerDTO thirdPerson, PageRequest pageRequest);
	public CustomerDTO save(CustomerDTO thirdPerson);
	public void delete(CustomerDTO thirdPerson);
}
