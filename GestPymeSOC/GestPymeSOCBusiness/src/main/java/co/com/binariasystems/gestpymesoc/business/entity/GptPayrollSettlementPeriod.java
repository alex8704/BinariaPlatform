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
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import co.com.binariasystems.commonsmodel.enumerated.PayrollPeriodType;
import co.com.binariasystems.commonsmodel.enumerated.SN2Boolean;
import co.com.binariasystems.gestpymesoc.business.utils.GestPymeSOCBusinessConstants;
import co.com.binariasystems.mastercentral.shared.business.entity.MatCompany;

/**
 *
 * @author Alexander
 */
@Entity
@Table(schema= GestPymeSOCBusinessConstants.GPS_DBSCHEMA, name = "GPT_PERIODO_LIQUID_NOMINA")
@NamedQueries({
    @NamedQuery(name = "GptPayrollSettlementPeriod.findAll", query = "SELECT g FROM GptPayrollSettlementPeriod g")})
public class GptPayrollSettlementPeriod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PERIODO_NOMINA")
    private Integer payrollPeriodId;
    @Size(max = 128)
    @Column(name = "DESCRIPCION")
    private String description;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "COD_TIPO_PERIODO_NOMINA")
    private PayrollPeriodType payrollPeriodType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_INICIO_PERIODO")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_FIN_PERIODO")
    @Temporal(TemporalType.DATE)
    private Date terminationDate;
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "ES_LIQUIDADO")
    private SN2Boolean isSettled;
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
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne(optional = false,fetch=FetchType.EAGER)
    private MatCompany company;

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
    public MatCompany getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(MatCompany company) {
        this.company = company;
    }

}
