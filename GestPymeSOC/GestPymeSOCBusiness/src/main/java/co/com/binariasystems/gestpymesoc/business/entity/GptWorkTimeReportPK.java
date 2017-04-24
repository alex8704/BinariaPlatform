/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.binariasystems.gestpymesoc.business.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Alexander
 */
@Embeddable
public class GptWorkTimeReportPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERIODO_NOMINA")
    private int payrollSettlementPeriodId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EMPLEADO")
    private int employeeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
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
}
