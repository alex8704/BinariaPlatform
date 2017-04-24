package co.com.binariasystems.gestpymesoc.business.dto;

import java.io.Serializable;
import java.util.Date;

import co.com.binariasystems.commonsmodel.enumerated.PayrollPeriodType;
import co.com.binariasystems.commonsmodel.enumerated.SN2Boolean;
import co.com.binariasystems.mastercentral.shared.business.dto.CompanyDTO;

public class PayrollSettlementPeriodDTO implements Serializable {
    private Integer payrollPeriodId;
    private String description;
    private PayrollPeriodType payrollPeriodType;
    private Date startDate;
    private Date terminationDate;
    private SN2Boolean isSettled;
    private String creationUser;
    private String modificationUser;
    private Date creationDate;
    private Date modificationDate;
    private CompanyDTO company;
    
	/**
	 * @return the payrollPeriodId
	 */
	public Integer getPayrollPeriodId() {
		return payrollPeriodId;
	}
	/**
	 * @param payrollPeriodId the payrollPeriodId to set
	 */
	public void setPayrollPeriodId(Integer payrollPeriodId) {
		this.payrollPeriodId = payrollPeriodId;
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
	 * @return the payrollPeriodType
	 */
	public PayrollPeriodType getPayrollPeriodType() {
		return payrollPeriodType;
	}
	/**
	 * @param payrollPeriodType the payrollPeriodType to set
	 */
	public void setPayrollPeriodType(PayrollPeriodType payrollPeriodType) {
		this.payrollPeriodType = payrollPeriodType;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the terminationDate
	 */
	public Date getTerminationDate() {
		return terminationDate;
	}
	/**
	 * @param terminationDate the terminationDate to set
	 */
	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}
	/**
	 * @return the isSettled
	 */
	public SN2Boolean getIsSettled() {
		return isSettled;
	}
	/**
	 * @param isSettled the isSettled to set
	 */
	public void setIsSettled(SN2Boolean isSettled) {
		this.isSettled = isSettled;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((payrollPeriodType == null) ? 0 : payrollPeriodType.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((terminationDate == null) ? 0 : terminationDate.hashCode());
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
		if (!(obj instanceof PayrollSettlementPeriodDTO))
			return false;
		PayrollSettlementPeriodDTO other = (PayrollSettlementPeriodDTO) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (payrollPeriodType != other.payrollPeriodType)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (terminationDate == null) {
			if (other.terminationDate != null)
				return false;
		} else if (!terminationDate.equals(other.terminationDate))
			return false;
		return true;
	}
}
