package co.com.binariasystems.gestpymesoc.business.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import co.com.binariasystems.commonsmodel.enumerated.SN2Boolean;
import co.com.binariasystems.gestpymesoc.business.utils.GestPymeSOCBusinessConstants;

@Entity
@Table(schema= GestPymeSOCBusinessConstants.GPS_DBSCHEMA, name = "GPT_TIPOS_CONTRATO_LABORAL")
public class GptContractType implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_CONTRATO")
    private Integer contractTypeId;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "COD_TIPO_CONTRATO")
    private String contractTypeCode;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "NOMBRE")
    private String name;
    @Size(max = 256)
    @Column(name = "DESCRIPCION")
    private String description;
    @Max(value=999)
    @Column(name = "DURACION_DEFAULT_MESES")
    private Integer defaultDurationInMoths;
    @Enumerated(EnumType.STRING)
    @Column(name = "APLICA_NOFICACION_TERMINACION")
    private SN2Boolean isFinishigNotificationAllowed;
    @Max(value=999)
    @Column(name = "DIAS_NOTIFICACION_TERMINACION")
    private Integer finishingNotificationDays;
    @Enumerated(EnumType.STRING)
    @Column(name = "APLICA_PAGO_EXTRAS")
    private SN2Boolean isExtraWorkPaymentAllowed;
    @Enumerated(EnumType.STRING)
    @Column(name = "ES_PRORROGABLE")
    private SN2Boolean isExtendable;
    @Max(value=999)
    @Column(name = "DURACION_MAXIMA")
    private Integer maxDuration;
    @Enumerated(EnumType.STRING)
    @Column(name = "APLICA_PERIODO_PRUEBA")
    private SN2Boolean isTrialPeriodAllowed;
    @Enumerated(EnumType.STRING)
    @Column(name = "ES_DURACION_FIJA")
    private SN2Boolean isFixedDuration;
    @Enumerated(EnumType.STRING)
    @Column(name = "ES_PARA_INDEPENDIENTES")
    private SN2Boolean isForIndependents;//Campo importante para descartar de liquidaciones de nomina este tipo de contratos
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USUARIO_CREACION")
    private String creationUser;
    @Size(max = 30)
    @Column(name = "USUARIO_MODIFICACION")
    private String modificationUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "FEC_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    
    
	/**
	 * @return the contractTypeId
	 */
	public Integer getContractTypeId() {
		return contractTypeId;
	}
	/**
	 * @param contractTypeId the contractTypeId to set
	 */
	public void setContractTypeId(Integer contractTypeId) {
		this.contractTypeId = contractTypeId;
	}
	/**
	 * @return the contractTypeCode
	 */
	public String getContractTypeCode() {
		return contractTypeCode;
	}
	/**
	 * @param contractTypeCode the contractTypeCode to set
	 */
	public void setContractTypeCode(String contractTypeCode) {
		this.contractTypeCode = contractTypeCode;
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
	 * @return the defaultDurationInMoths
	 */
	public Integer getDefaultDurationInMoths() {
		return defaultDurationInMoths;
	}
	/**
	 * @param defaultDurationInMoths the defaultDurationInMoths to set
	 */
	public void setDefaultDurationInMoths(Integer defaultDurationInMoths) {
		this.defaultDurationInMoths = defaultDurationInMoths;
	}
	/**
	 * @return the isFinishigNotificationAllowed
	 */
	public SN2Boolean getIsFinishigNotificationAllowed() {
		return isFinishigNotificationAllowed;
	}
	/**
	 * @param isFinishigNotificationAllowed the isFinishigNotificationAllowed to set
	 */
	public void setIsFinishigNotificationAllowed(SN2Boolean isFinishigNotificationAllowed) {
		this.isFinishigNotificationAllowed = isFinishigNotificationAllowed;
	}
	/**
	 * @return the finishingNotificationDays
	 */
	public Integer getFinishingNotificationDays() {
		return finishingNotificationDays;
	}
	/**
	 * @param finishingNotificationDays the finishingNotificationDays to set
	 */
	public void setFinishingNotificationDays(Integer finishingNotificationDays) {
		this.finishingNotificationDays = finishingNotificationDays;
	}
	/**
	 * @return the isExtraWorkPaymentAllowed
	 */
	public SN2Boolean getIsExtraWorkPaymentAllowed() {
		return isExtraWorkPaymentAllowed;
	}
	/**
	 * @param isExtraWorkPaymentAllowed the isExtraWorkPaymentAllowed to set
	 */
	public void setIsExtraWorkPaymentAllowed(SN2Boolean isExtraWorkPaymentAllowed) {
		this.isExtraWorkPaymentAllowed = isExtraWorkPaymentAllowed;
	}
	/**
	 * @return the isExtendable
	 */
	public SN2Boolean getIsExtendable() {
		return isExtendable;
	}
	/**
	 * @param isExtendable the isExtendable to set
	 */
	public void setIsExtendable(SN2Boolean isExtendable) {
		this.isExtendable = isExtendable;
	}
	/**
	 * @return the maxDuration
	 */
	public Integer getMaxDuration() {
		return maxDuration;
	}
	/**
	 * @param maxDuration the maxDuration to set
	 */
	public void setMaxDuration(Integer maxDuration) {
		this.maxDuration = maxDuration;
	}
	/**
	 * @return the isTrialPeriodAllowed
	 */
	public SN2Boolean getIsTrialPeriodAllowed() {
		return isTrialPeriodAllowed;
	}
	/**
	 * @param isTrialPeriodAllowed the isTrialPeriodAllowed to set
	 */
	public void setIsTrialPeriodAllowed(SN2Boolean isTrialPeriodAllowed) {
		this.isTrialPeriodAllowed = isTrialPeriodAllowed;
	}
	/**
	 * @return the isFixedDuration
	 */
	public SN2Boolean getIsFixedDuration() {
		return isFixedDuration;
	}
	/**
	 * @param isFixedDuration the isFixedDuration to set
	 */
	public void setIsFixedDuration(SN2Boolean isFixedDuration) {
		this.isFixedDuration = isFixedDuration;
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
	public SN2Boolean getIsForIndependents() {
		return isForIndependents;
	}
	public void setIsForIndependents(SN2Boolean isForIndependents) {
		this.isForIndependents = isForIndependents;
	}
    
    
	
}
