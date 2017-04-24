package co.com.binariasystems.gestpymesoc.business.dto;

import java.io.Serializable;
import java.util.Date;

import co.com.binariasystems.commonsmodel.enumerated.SN2Boolean;
import co.com.binariasystems.gestpymesoc.business.enumerated.WorkTurnType;

public class WorkTimeReportDTO implements Serializable {
	private WorkTimeReportPK id;
    private Date checkInTime;
    private Date departTime;
    private SN2Boolean isTurn;
    private WorkTurnType workTurnType;
    private SN2Boolean isRecess;
    private String creationUser;
    private String modificationUser;
    private Date creationDate;
    private Date modificationDate;
    private EmployeeDTO employee;
    private PayrollSettlementPeriodDTO payrollSettlementPeriod;
    
	/**
	 * @return the id
	 */
	public WorkTimeReportPK getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(WorkTimeReportPK id) {
		this.id = id;
	}
	/**
	 * @return the checkInTime
	 */
	public Date getCheckInTime() {
		return checkInTime;
	}
	/**
	 * @param checkInTime the checkInTime to set
	 */
	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}
	/**
	 * @return the departTime
	 */
	public Date getDepartTime() {
		return departTime;
	}
	/**
	 * @param departTime the departTime to set
	 */
	public void setDepartTime(Date departTime) {
		this.departTime = departTime;
	}
	/**
	 * @return the isTurn
	 */
	public SN2Boolean getIsTurn() {
		return isTurn;
	}
	/**
	 * @param isTurn the isTurn to set
	 */
	public void setIsTurn(SN2Boolean isTurn) {
		this.isTurn = isTurn;
	}
	/**
	 * @return the workTurnType
	 */
	public WorkTurnType getWorkTurnType() {
		return workTurnType;
	}
	/**
	 * @param workTurnType the workTurnType to set
	 */
	public void setWorkTurnType(WorkTurnType workTurnType) {
		this.workTurnType = workTurnType;
	}
	/**
	 * @return the isRecess
	 */
	public SN2Boolean getIsRecess() {
		return isRecess;
	}
	/**
	 * @param isRecess the isRecess to set
	 */
	public void setIsRecess(SN2Boolean isRecess) {
		this.isRecess = isRecess;
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
	 * @return the payrollSettlementPeriod
	 */
	public PayrollSettlementPeriodDTO getPayrollSettlementPeriod() {
		return payrollSettlementPeriod;
	}
	/**
	 * @param payrollSettlementPeriod the payrollSettlementPeriod to set
	 */
	public void setPayrollSettlementPeriod(PayrollSettlementPeriodDTO payrollSettlementPeriod) {
		this.payrollSettlementPeriod = payrollSettlementPeriod;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (!(obj instanceof WorkTimeReportDTO))
			return false;
		WorkTimeReportDTO other = (WorkTimeReportDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
