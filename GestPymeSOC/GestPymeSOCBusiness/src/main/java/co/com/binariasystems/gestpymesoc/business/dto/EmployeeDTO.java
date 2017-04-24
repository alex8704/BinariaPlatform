package co.com.binariasystems.gestpymesoc.business.dto;

import java.io.Serializable;

import co.com.binariasystems.fmw.entity.annot.CRUDViewConfig;
import co.com.binariasystems.fmw.entity.annot.Entity;
import co.com.binariasystems.fmw.entity.annot.Ignore;
import co.com.binariasystems.fmw.entity.annot.Relation;
import co.com.binariasystems.fmw.entity.annot.SearcherConfig;
import co.com.binariasystems.fmw.entity.cfg.PKGenerationStrategy;
import co.com.binariasystems.gestpymesoc.business.utils.GestPymeSOCBusinessConstants;
import co.com.binariasystems.mastercentral.shared.business.dto.CompanyDTO;
import co.com.binariasystems.mastercentral.shared.business.dto.HealthAdminCompanyDTO;
import co.com.binariasystems.mastercentral.shared.business.dto.MasterDataDTO;
import co.com.binariasystems.mastercentral.shared.business.dto.PensionFundAdminCompanyDTO;
import co.com.binariasystems.mastercentral.shared.business.dto.StateDTO;
import co.com.binariasystems.mastercentral.shared.business.dto.ThirdPersonDTO;

@Entity(table=GestPymeSOCBusinessConstants.GPS_DBSCHEMA+"."+"GPT_EMPLEADOS",pkGenerationStrategy=PKGenerationStrategy.IDENTITY)
@CRUDViewConfig(
		deleteEnabled=false, isAuditable=true,
		searcherConfig=@SearcherConfig(searchField="identificationNumber", 
		descriptionFields={"businessName"},
		gridColumnFields={"identificationType", "identificationNumber", "businessName"})
)
public class EmployeeDTO extends ThirdPersonDTO implements Serializable {
	@Ignore
	@Relation(column = "ID_ESTADO")
	private StateDTO state;
	@Ignore
	@Relation(column = "ID_EPS")
	private HealthAdminCompanyDTO healthAdminCompany;
	@Ignore
	@Relation(column = "ID_PROFESION")
	private MasterDataDTO profession;
	@Ignore
	@Relation(column = "ID_GENERO")
	private MasterDataDTO gender;
	@Ignore
	@Relation(column = "ID_AFP")
	private PensionFundAdminCompanyDTO pensionFundAdminCompany;
	@Ignore
	private CompanyDTO company;
	/**
	 * @return the state
	 */
	public StateDTO getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(StateDTO state) {
		this.state = state;
	}
	/**
	 * @return the healthAdminCompany
	 */
	public HealthAdminCompanyDTO getHealthAdminCompany() {
		return healthAdminCompany;
	}
	/**
	 * @param healthAdminCompany the healthAdminCompany to set
	 */
	public void setHealthAdminCompany(HealthAdminCompanyDTO healthAdminCompany) {
		this.healthAdminCompany = healthAdminCompany;
	}
	/**
	 * @return the profession
	 */
	public MasterDataDTO getProfession() {
		return profession;
	}
	/**
	 * @param profession the profession to set
	 */
	public void setProfession(MasterDataDTO profession) {
		this.profession = profession;
	}
	/**
	 * @return the gender
	 */
	public MasterDataDTO getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(MasterDataDTO gender) {
		this.gender = gender;
	}
	/**
	 * @return the pensionFundAdminCompany
	 */
	public PensionFundAdminCompanyDTO getPensionFundAdminCompany() {
		return pensionFundAdminCompany;
	}
	/**
	 * @param pensionFundAdminCompany the pensionFundAdminCompany to set
	 */
	public void setPensionFundAdminCompany(PensionFundAdminCompanyDTO pensionFundAdminCompany) {
		this.pensionFundAdminCompany = pensionFundAdminCompany;
	}
	
	/**
	 * @return the company
	 */
	public CompanyDTO getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(CompanyDTO company) {
		this.company = company;
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof EmployeeDTO))
			return false;
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return 31 * super.hashCode() + EmployeeDTO.class.getSimpleName().hashCode();
	}
	
}
