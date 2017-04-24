package co.com.binariasystems.gestpymesoc.business.bean;

import co.com.binariasystems.fmw.business.domain.Page;
import co.com.binariasystems.fmw.business.domain.PageRequest;
import co.com.binariasystems.gestpymesoc.business.dto.ProviderDTO;

public interface ProviderBean {
	public Page<ProviderDTO> findAll(PageRequest pageRequest);
	public Page<ProviderDTO> findAll(ProviderDTO thirdPerson, PageRequest pageRequest);
	public ProviderDTO save(ProviderDTO thirdPerson);
	public void delete(ProviderDTO thirdPerson);
}
