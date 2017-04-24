package co.com.binariasystems.gestpymesoc.business.dto;

import java.io.Serializable;
import java.util.Date;

import co.com.binariasystems.commonsmodel.enumerated.SN2Boolean;

public class ContractTypeDTO implements Serializable {
    private Integer contractTypeId;
    private String contractTypeCode;
    private String name;
    private String description;
    private Integer defaultDurationInMoths;
    private SN2Boolean isFinishigNotificationAllowed;
    private Integer finishingNotificationDays;
    private SN2Boolean isExtraWorkPaymentAllowed;
    private SN2Boolean isExtendable;
    private Integer maxDuration;
    private SN2Boolean isTrialPeriodAllowed;
    private SN2Boolean isFixedDuration;
    private String creationUser;
    private String modificationUser;
    private Date creationDate;
    private Date modificationDate;
	public Integer getContractTypeId() {
		return contractTypeId;
	}
	public void setContractTypeId(Integer contractTypeId) {
		this.contractTypeId = contractTypeId;
	}
	public String getContractTypeCode() {
		return contractTypeCode;
	}
	public void setContractTypeCode(String contractTypeCode) {
		this.contractTypeCode = contractTypeCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getDefaultDurationInMoths() {
		return defaultDurationInMoths;
	}
	public void setDefaultDurationInMoths(Integer defaultDurationInMoths) {
		this.defaultDurationInMoths = defaultDurationInMoths;
	}
	public SN2Boolean getIsFinishigNotificationAllowed() {
		return isFinishigNotificationAllowed;
	}
	public void setIsFinishigNotificationAllowed(SN2Boolean isFinishigNotificationAllowed) {
		this.isFinishigNotificationAllowed = isFinishigNotificationAllowed;
	}
	public Integer getFinishingNotificationDays() {
		return finishingNotificationDays;
	}
	public void setFinishingNotificationDays(Integer finishingNotificationDays) {
		this.finishingNotificationDays = finishingNotificationDays;
	}
	public SN2Boolean getIsExtraWorkPaymentAllowed() {
		return isExtraWorkPaymentAllowed;
	}
	public void setIsExtraWorkPaymentAllowed(SN2Boolean isExtraWorkPaymentAllowed) {
		this.isExtraWorkPaymentAllowed = isExtraWorkPaymentAllowed;
	}
	public SN2Boolean getIsExtendable() {
		return isExtendable;
	}
	public void setIsExtendable(SN2Boolean isExtendable) {
		this.isExtendable = isExtendable;
	}
	public Integer getMaxDuration() {
		return maxDuration;
	}
	public void setMaxDuration(Integer maxDuration) {
		this.maxDuration = maxDuration;
	}
	public SN2Boolean getIsTrialPeriodAllowed() {
		return isTrialPeriodAllowed;
	}
	public void setIsTrialPeriodAllowed(SN2Boolean isTrialPeriodAllowed) {
		this.isTrialPeriodAllowed = isTrialPeriodAllowed;
	}
	public SN2Boolean getIsFixedDuration() {
		return isFixedDuration;
	}
	public void setIsFixedDuration(SN2Boolean isFixedDuration) {
		this.isFixedDuration = isFixedDuration;
	}
	public String getCreationUser() {
		return creationUser;
	}
	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}
	public String getModificationUser() {
		return modificationUser;
	}
	public void setModificationUser(String modificationUser) {
		this.modificationUser = modificationUser;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contractTypeCode == null) ? 0 : contractTypeCode.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ContractTypeDTO))
			return false;
		ContractTypeDTO other = (ContractTypeDTO) obj;
		if (contractTypeCode == null) {
			if (other.contractTypeCode != null)
				return false;
		} else if (!contractTypeCode.equals(other.contractTypeCode))
			return false;
		return true;
	}
    
    
}
