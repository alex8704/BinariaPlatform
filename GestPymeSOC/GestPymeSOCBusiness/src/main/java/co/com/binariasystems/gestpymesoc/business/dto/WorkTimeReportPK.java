package co.com.binariasystems.gestpymesoc.business.dto;

import java.io.Serializable;
import java.util.Date;

public class WorkTimeReportPK implements Serializable {
	private int payrollSettlementPeriodId;
    private int employeeId;
    private Date date;
	/**
	 * @return the payrollSettlementPeriodId
	 */
	public int getPayrollSettlementPeriodId() {
		return payrollSettlementPeriodId;
	}
	/**
	 * @param payrollSettlementPeriodId the payrollSettlementPeriodId to set
	 */
	public void setPayrollSettlementPeriodId(int payrollSettlementPeriodId) {
		this.payrollSettlementPeriodId = payrollSettlementPeriodId;
	}
	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + employeeId;
		result = prime * result + payrollSettlementPeriodId;
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
		if (!(obj instanceof WorkTimeReportPK))
			return false;
		WorkTimeReportPK other = (WorkTimeReportPK) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (payrollSettlementPeriodId != other.payrollSettlementPeriodId)
			return false;
		return true;
	}
	
	
}
