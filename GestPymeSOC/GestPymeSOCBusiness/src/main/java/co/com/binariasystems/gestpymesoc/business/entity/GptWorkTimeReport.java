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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import co.com.binariasystems.commonsmodel.enumerated.SN2Boolean;
import co.com.binariasystems.gestpymesoc.business.enumerated.WorkTurnType;
import co.com.binariasystems.gestpymesoc.business.utils.GestPymeSOCBusinessConstants;

/**
 *
 * @author Alexander
 */
@Entity
@Table(schema= GestPymeSOCBusinessConstants.GPS_DBSCHEMA, name = "GPT_REPORTE_TIEMPO")
@NamedQueries({
    @NamedQuery(name = "GptWorkTimeReport.findAll", query = "SELECT g FROM GptWorkTimeReport g")})
public class GptWorkTimeReport implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private GptWorkTimeReportPK id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORA_ENTRADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkInTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORA_SALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departTime;
    @Enumerated(EnumType.STRING)
    @Column(name = "ES_TURNO")
    private SN2Boolean isTurn;
    @Enumerated(EnumType.STRING)
    @Column(name = "COD_TIPO_TURNO")
    private WorkTurnType workTurnType;
    @Enumerated(EnumType.STRING)
    @Column(name = "ES_DESCANSO")
    private SN2Boolean isRecess;
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
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_TERCERO", insertable = false, updatable = false)
    @ManyToOne(optional = false,fetch=FetchType.EAGER)
    private GptEmployee employee;
    @JoinColumn(name = "ID_PERIODO_NOMINA", referencedColumnName = "ID_PERIODO_NOMINA", insertable = false, updatable = false)
    @ManyToOne(optional = false,fetch=FetchType.EAGER)
    private GptPayrollSettlementPeriod payrollSettlementPeriod;

    /**
     * @return the id
     */
    public GptWorkTimeReportPK getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(GptWorkTimeReportPK id) {
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
    public GptEmployee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(GptEmployee employee) {
        this.employee = employee;
    }

    /**
     * @return the payrollSettlementPeriod
     */
    public GptPayrollSettlementPeriod getPayrollSettlementPeriod() {
        return payrollSettlementPeriod;
    }

    /**
     * @param payrollSettlementPeriod the payrollSettlementPeriod to set
     */
    public void setPayrollSettlementPeriod(GptPayrollSettlementPeriod payrollSettlementPeriod) {
        this.payrollSettlementPeriod = payrollSettlementPeriod;
    }

}
