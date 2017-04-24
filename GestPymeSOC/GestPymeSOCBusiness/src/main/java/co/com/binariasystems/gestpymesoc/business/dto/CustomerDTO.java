package co.com.binariasystems.gestpymesoc.business.dto;

import java.io.Serializable;

import co.com.binariasystems.fmw.entity.annot.CRUDViewConfig;
import co.com.binariasystems.fmw.entity.annot.Entity;
import co.com.binariasystems.fmw.entity.annot.SearcherConfig;
import co.com.binariasystems.fmw.entity.cfg.PKGenerationStrategy;
import co.com.binariasystems.gestpymesoc.business.utils.GestPymeSOCBusinessConstants;
import co.com.binariasystems.mastercentral.shared.business.dto.ThirdPersonDTO;

@Entity(table=GestPymeSOCBusinessConstants.GPS_DBSCHEMA+"."+"GPT_CLIENTES",pkGenerationStrategy=PKGenerationStrategy.IDENTITY)
@CRUDViewConfig(
		deleteEnabled=false, isAuditable=true,
		searcherConfig=@SearcherConfig(searchField="identificationNumber", 
		descriptionFields={"businessName"},
		gridColumnFields={"identificationType", "identificationNumber", "businessName", "emailAddress", "city", "economicActivity"})
)
public class CustomerDTO extends ThirdPersonDTO implements Serializable {
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof CustomerDTO))
			return false;
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return 31 * super.hashCode() + CustomerDTO.class.getSimpleName().hashCode();
	}
}
