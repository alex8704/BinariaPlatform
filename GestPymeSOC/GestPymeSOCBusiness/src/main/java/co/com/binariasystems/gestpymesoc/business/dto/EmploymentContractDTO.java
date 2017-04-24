package co.com.binariasystems.gestpymesoc.business.dto;

import java.io.Serializable;
import java.util.Date;

import co.com.binariasystems.commonsmodel.enumerated.SN2Boolean;
import co.com.binariasystems.gestpymesoc.business.enumerated.ContractTermType;
import co.com.binariasystems.mastercentral.shared.business.dto.CompanyDTO;


public class EmploymentContractDTO implements Serializable {
    private Integer employmentContractId;
    private Double baseSalaryValue;
    private SN2Boolean isCurrent;
    private SN2Boolean isFullSalary;
    private SN2Boolean haveSurcharge;
    private Date startDate;
    private Date terminationDate;
    private ContractTermType termType;
    private SN2Boolean mustReportWorkTime;
    private String creationUser;
    private String modificationUser;
    private Date creationDate;
    private Date modificationDate;
    private EmployeeDTO employee;
    private CompanyDTO company;
    private ContractTerminationReasonDTO terminationReason;
    private AppointmentDTO appointment;
	/**
	 * @return the employmentContractId
	 */
	public Integer getEmploymentContractId() {
		return employmentContractId;
	}
	/**
	 * @param employmentContractId the employmentContractId to set
	 */
	public void setEmploymentContractId(Integer employmentContractId) {
		this.employmentContractId = employmentContractId;
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
	 * @return the isCurrent
	 */
	public SN2Boolean getIsCurrent() {
		return isCurrent;
	}
	/**
	 * @param isCurrent the isCurrent to set
	 */
	public void setIsCurrent(SN2Boolean isCurrent) {
		this.isCurrent = isCurrent;
	}
	/**
	 * @return the isFullSalary
	 */
	public SN2Boolean getIsFullSalary() {
		return isFullSalary;
	}
	/**
	 * @param isFullSalary the isFullSalary to set
	 */
	public void setIsFullSalary(SN2Boolean isFullSalary) {
		this.isFullSalary = isFullSalary;
	}
	/**
	 * @return the haveSurcharge
	 */
	public SN2Boolean getHaveSurcharge() {
		return haveSurcharge;
	}
	/**
	 * @param haveSurcharge the haveSurcharge to set
	 */
	public void setHaveSurcharge(SN2Boolean haveSurcharge) {
		this.haveSurcharge = haveSurcharge;
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
	 * @return the termType
	 */
	public ContractTermType getTermType() {
		return termType;
	}
	/**
	 * @param termType the termType to set
	 */
	public void setTermType(ContractTermType termType) {
		this.termType = termType;
	}
	/**
	 * @return the mustReportWorkTime
	 */
	public SN2Boolean getMustReportWorkTime() {
		return mustReportWorkTime;
	}
	/**
	 * @param mustReportWorkTime the mustReportWorkTime to set
	 */
	public void setMustReportWorkTime(SN2Boolean mustReportWorkTime) {
		this.mustReportWorkTime = mustReportWorkTime;
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
	 * @return the employee
	 */
	public EmployeeDTO getEmployee() {
		return employee;
	}
	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
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
	/**
	 * @return the terminationReason
	 */
	public ContractTerminationReasonDTO getTerminationReason() {
		return terminationReason;
	}
	/**
	 * @param terminationReason the terminationReason to set
	 */
	public void setTerminationReason(ContractTerminationReasonDTO terminationReason) {
		this.terminationReason = terminationReason;
	}
	/**
	 * @return the appointment
	 */
	public AppointmentDTO getAppointment() {
		return appointment;
	}
	/**
	 * @param appointment the appointment to set
	 */
	public void setAppointment(AppointmentDTO appointment) {
		this.appointment = appointment;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appointment == null) ? 0 : appointment.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
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
		if (!(obj instanceof EmploymentContractDTO))
			return false;
		EmploymentContractDTO other = (EmploymentContractDTO) obj;
		if (appointment == null) {
			if (other.appointment != null)
				return false;
		} else if (!appointment.equals(other.appointment))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
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
