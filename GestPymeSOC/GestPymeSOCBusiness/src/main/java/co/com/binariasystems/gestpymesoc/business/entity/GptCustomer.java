/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.binariasystems.gestpymesoc.business.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import co.com.binariasystems.gestpymesoc.business.utils.GestPymeSOCBusinessConstants;
import co.com.binariasystems.mastercentral.shared.business.entity.MatThirdPerson;

/**
 *
 * @author Alexander
 */
@Entity
@Table(schema= GestPymeSOCBusinessConstants.GPS_DBSCHEMA, name = "GPT_CLIENTES")
@NamedQueries({
    @NamedQuery(name = "GptCustomer.findAll", query = "SELECT g FROM GptCustomer g")})
public class GptCustomer extends MatThirdPerson {
    
}
