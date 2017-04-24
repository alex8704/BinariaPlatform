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

import co.com.binariasystems.commonsmodel.enumerated.SN2Boolean;
import co.com.binariasystems.gestpymesoc.business.utils.GestPymeSOCBusinessConstants;

/**
 *
 * @author Alexander
 */
@Entity
@Table(schema= GestPymeSOCBusinessConstants.GPS_DBSCHEMA, name = "GPT_MOTIVOS_TERMINAC_CONTRATO")
@NamedQueries({
    @NamedQuery(name = "GptContractTerminationReason.findAll", query = "SELECT g FROM GptContractTerminationReason g")})
public class GptContractTerminationReason implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MOTIVO_TERMINACION")
    private Integer contractTerminationReasonId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "NOMBRE")
    private String name;
    @Size(max = 256)
    @Column(name = "DESCRIPCION")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "OBLIGA_INDEMNIZACION")
    private SN2Boolean forceCompensation;
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
     * @return the contractTerminationReasonId
     */
    public Integer getContractTerminationReasonId() {
        return contractTerminationReasonId;
    }

    /**
     * @param contractTerminationReasonId the contractTerminationReasonId to set
     */
    public void setContractTerminationReasonId(Integer contractTerminationReasonId) {
        this.contractTerminationReasonId = contractTerminationReasonId;
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
     * @return the forceCompensation
     */
    public SN2Boolean getForceCompensation() {
        return forceCompensation;
    }

    /**
     * @param forceCompensation the forceCompensation to set
     */
    public void setForceCompensation(SN2Boolean forceCompensation) {
        this.forceCompensation = forceCompensation;
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
