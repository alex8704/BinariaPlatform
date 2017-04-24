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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import co.com.binariasystems.gestpymesoc.business.utils.GestPymeSOCBusinessConstants;

/**
 *
 * @author Alexander
 */
@Entity
@Table(schema= GestPymeSOCBusinessConstants.GPS_DBSCHEMA, name = "GPT_CARGOS")
@NamedQueries({
    @NamedQuery(name = "GptAppointment.findAll", query = "SELECT g FROM GptAppointment g")})
public class GptAppointment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CARGO")
    private Integer appointmentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "COD_CARGO")
    private String appointmentCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "NOMBRE")
    private String name;
    @Size(max = 256)
    @Column(name = "DESCRIPCION")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VLR_SALARIO_BASE")
    private Double baseSalaryValue;
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
    
}
