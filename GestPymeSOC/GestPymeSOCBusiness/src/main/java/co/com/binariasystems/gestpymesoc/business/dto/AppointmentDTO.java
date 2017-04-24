package co.com.binariasystems.gestpymesoc.business.dto;

import java.io.Serializable;
import java.util.Date;

import co.com.binariasystems.fmw.entity.annot.CRUDViewConfig;
import co.com.binariasystems.fmw.entity.annot.Column;
import co.com.binariasystems.fmw.entity.annot.Entity;
import co.com.binariasystems.fmw.entity.annot.Key;
import co.com.binariasystems.fmw.entity.annot.SearcherConfig;
import co.com.binariasystems.fmw.entity.cfg.PKGenerationStrategy;
import co.com.binariasystems.gestpymesoc.business.utils.GestPymeSOCBusinessConstants;

@Entity(table=GestPymeSOCBusinessConstants.GPS_DBSCHEMA+"."+"GPT_CARGOS",pkGenerationStrategy=PKGenerationStrategy.IDENTITY)
@CRUDViewConfig(
		deleteEnabled=false, isAuditable=true,
		searcherConfig=@SearcherConfig(searchField="appointmentCode", 
		descriptionFields={"name"},
		gridColumnFields={"appointmentCode", "name", "description", "baseSalaryValue"})
)
public class AppointmentDTO implements Serializable {
	@Key(column = "ID_CARGO")
    private Integer appointmentId;
    @Column(name = "COD_CARGO")
    private String appointmentCode;
    @Column(name = "NOMBRE")
    private String name;
    @Column(name = "DESCRIPCION")
    private String description;
    @Column(name = "VLR_SALARIO_BASE")
    private Double baseSalaryValue;
    @Column(name = "USUARIO_CREACION")
    private String creationUser;
    @Column(name = "USUARIO_MODIFICACION")
    private String modificationUser;
    @Column(name = "FEC_CREACION")
    private Date creationDate;
    @Column(name = "FEC_MODIFICACION")
    private Date modificationDate;
	/**
	 * @return the appointmentId
	 */
	public Integer getAppointmentId() {
		return appointmentId;
	}
	/**
	 * @param appointmentId the appointmentId to set
	 */
	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}
	/**
	 * @return the appointmentCode
	 */
	public String getAppointmentCode() {
		return appointmentCode;
	}
	/**
	 * @param appointmentCode the appointmentCode to set
	 */
	public void setAppointmentCode(String appointmentCode) {
		this.appointmentCode = appointmentCode;
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
	 * @return the baseSalaryValue
	 */
	public Double getBaseSalaryValue() {
		return baseSalaryValue;
	}
	/**
	 * @param baseSalaryValue the baseSalaryValue to set
	 */
	public void setBaseSalaryValue(Double baseSalaryValue) {
		this.baseSalaryValue = baseSalaryValue;
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
		result = prime * result + ((appointmentCode == null) ? 0 : appointmentCode.hashCode());
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
		if (!(obj instanceof AppointmentDTO))
			return false;
		AppointmentDTO other = (AppointmentDTO) obj;
		if (appointmentCode == null) {
			if (other.appointmentCode != null)
				return false;
		} else if (!appointmentCode.equals(other.appointmentCode))
			return false;
		return true;
	}
}
