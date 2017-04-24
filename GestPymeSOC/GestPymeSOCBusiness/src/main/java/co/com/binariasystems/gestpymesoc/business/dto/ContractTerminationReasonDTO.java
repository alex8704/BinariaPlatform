package co.com.binariasystems.gestpymesoc.business.dto;

import java.io.Serializable;
import java.util.Date;

import co.com.binariasystems.commonsmodel.enumerated.SN2Boolean;
import co.com.binariasystems.fmw.entity.annot.CRUDViewConfig;
import co.com.binariasystems.fmw.entity.annot.Column;
import co.com.binariasystems.fmw.entity.annot.Entity;
import co.com.binariasystems.fmw.entity.annot.Key;
import co.com.binariasystems.fmw.entity.annot.SearcherConfig;
import co.com.binariasystems.fmw.entity.cfg.PKGenerationStrategy;
import co.com.binariasystems.gestpymesoc.business.utils.GestPymeSOCBusinessConstants;

@Entity(table=GestPymeSOCBusinessConstants.GPS_DBSCHEMA+"."+"GPT_MOTIVOS_TERMINAC_CONTRATO",pkGenerationStrategy=PKGenerationStrategy.IDENTITY)
@CRUDViewConfig(
		deleteEnabled=false, isAuditable=true,
		searcherConfig=@SearcherConfig(searchField="contractTerminationReasonId", 
		descriptionFields={"name"},
		gridColumnFields={"name", "description", "forceCompensation"})
)
public class ContractTerminationReasonDTO implements Serializable {
	@Key(column = "ID_MOTIVO_TERMINACION")
    private Integer contractTerminationReasonId;
    @Column(name = "NOMBRE")
    private String name;
    @Column(name = "DESCRIPCION")
    private String description;
    @Column(name = "OBLIGA_INDEMNIZACION")
    private SN2Boolean forceCompensation;
    @Column(name = "USUARIO_CREACION")
    private String creationUser;
    @Column(name = "USUARIO_MODIFICACION")
    private String modificationUser;
    @Column(name = "FEC_CREACION")
    private Date creationDate;
    @Column(name = "FEC_MODIFICACION")
    private Date modificationDate;
	/**
	 * @return the contractTerminationReasonId
	 */
	public Integer getContractTerminationReasonId() {
		return contractTerminationReasonId;
	}
	/**
	 * @param contractTerminationReasonId the contractTerminationReasonId to set
	 */
	public void setContractTerminationReasonId(Integer contractTerminationReasonId) {
		this.contractTerminationReasonId = contractTerminationReasonId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the forceCompensation
	 */
	public SN2Boolean getForceCompensation() {
		return forceCompensation;
	}
	/**
	 * @param forceCompensation the forceCompensation to set
	 */
	public void setForceCompensation(SN2Boolean forceCompensation) {
		this.forceCompensation = forceCompensation;
	}
	/**
	 * @return the creationUser
	 */
	public String getCreationUser() {
		return creationUser;
	}
	/**
	 * @param creationUser the creationUser to set
	 */
	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}
	/**
	 * @return the modificationUser
	 */
	public String getModificationUser() {
		return modificationUser;
	}
	/**
	 * @param modificationUser the modificationUser to set
	 */
	public void setModificationUser(String modificationUser) {
		this.modificationUser = modificationUser;
	}
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the modificationDate
	 */
	public Date getModificationDate() {
		return modificationDate;
	}
	/**
	 * @param modificationDate the modificationDate to set
	 */
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((forceCompensation == null) ? 0 : forceCompensation.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ContractTerminationReasonDTO))
			return false;
		ContractTerminationReasonDTO other = (ContractTerminationReasonDTO) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (forceCompensation != other.forceCompensation)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
