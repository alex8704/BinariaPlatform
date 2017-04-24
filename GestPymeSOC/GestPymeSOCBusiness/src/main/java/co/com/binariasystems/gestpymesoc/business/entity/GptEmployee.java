/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.binariasystems.gestpymesoc.business.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import co.com.binariasystems.gestpymesoc.business.utils.GestPymeSOCBusinessConstants;
import co.com.binariasystems.mastercentral.shared.business.entity.MatCompany;
import co.com.binariasystems.mastercentral.shared.business.entity.MatHealthAdminCompany;
import co.com.binariasystems.mastercentral.shared.business.entity.MatMasterData;
import co.com.binariasystems.mastercentral.shared.business.entity.MatPensionFundAdminCompany;
import co.com.binariasystems.mastercentral.shared.business.entity.MatState;
import co.com.binariasystems.mastercentral.shared.business.entity.MatThirdPerson;

/**
 *
 * @author Alexander
 */
@Entity
@Table(schema= GestPymeSOCBusinessConstants.GPS_DBSCHEMA, name = "GPT_EMPLEADOS")
@NamedQueries({
    @NamedQuery(name = "GptEmployee.findAll", query = "SELECT g FROM GptEmployee g")})
public class GptEmployee extends MatThirdPerson {
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID_ESTADO")
    @ManyToOne(optional = false,fetch=FetchType.EAGER)
    private MatState state;
    @JoinColumn(name = "ID_EPS", referencedColumnName = "ID_EPS")
    @ManyToOne(optional = false,fetch=FetchType.EAGER)
    private MatHealthAdminCompany healthAdminCompany;
    @JoinColumn(name = "ID_PROFESION", referencedColumnName = "ID_DATO_MAESTRA")
    @ManyToOne(fetch=FetchType.EAGER)
    private MatMasterData profession;
    @JoinColumn(name = "ID_GENERO", referencedColumnName = "ID_DATO_MAESTRA")
    @ManyToOne(optional = false,fetch=FetchType.EAGER)
    private MatMasterData gender;
    @JoinColumn(name = "ID_AFP", referencedColumnName = "ID_AFP")
    @ManyToOne(optional = false,fetch=FetchType.EAGER)
    private MatPensionFundAdminCompany pensionFundAdminCompany;
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne(fetch=FetchType.EAGER)
    private MatCompany company;

    /**
     * @return the healthAdminCompany
     */
    public MatHealthAdminCompany getHealthAdminCompany() {
        return healthAdminCompany;
    }

    /**
     * @param healthAdminCompany the healthAdminCompany to set
     */
    public void setHealthAdminCompany(MatHealthAdminCompany healthAdminCompany) {
        this.healthAdminCompany = healthAdminCompany;
    }
    
    /**
     * @return the profession
     */
    public MatMasterData getProfession() {
        return profession;
    }

    /**
     * @param profession the profession to set
     */
    public void setProfession(MatMasterData profession) {
        this.profession = profession;
    }

    /**
     * @return the gender
     */
    public MatMasterData getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(MatMasterData gender) {
        this.gender = gender;
    }

    /**
     * @return the pensionFundAdminCompany
     */
    public MatPensionFundAdminCompany getPensionFundAdminCompany() {
        return pensionFundAdminCompany;
    }

    /**
     * @param pensionFundAdminCompany the pensionFundAdminCompany to set
     */
    public void setPensionFundAdminCompany(MatPensionFundAdminCompany pensionFundAdminCompany) {
        this.pensionFundAdminCompany = pensionFundAdminCompany;
    }

	/**
	 * @return the state
	 */
	public MatState getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(MatState state) {
		this.state = state;
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
