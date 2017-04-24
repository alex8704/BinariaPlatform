package co.com.binariasystems.gestpymesoc.business.specification;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import co.com.binariasystems.gestpymesoc.business.dto.EmployeeDTO;
import co.com.binariasystems.gestpymesoc.business.entity.GptEmployee;
import co.com.binariasystems.gestpymesoc.business.entity.GptEmployee_;
import co.com.binariasystems.mastercentral.shared.business.entity.MatCity_;
import co.com.binariasystems.mastercentral.shared.business.entity.MatEconomicActivity_;
import co.com.binariasystems.mastercentral.shared.business.entity.MatIdentificationType_;
import co.com.binariasystems.mastercentral.shared.business.entity.MatTaxpayerType_;

public final class EmployeeSpecifications {
	public static Specification<GptEmployee> filledFieldsEqualsTo(final EmployeeDTO thirdPerson){
		return new Specification<GptEmployee>() {
			@Override
			public Predicate toPredicate(Root<GptEmployee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if(thirdPerson == null)
					return cb.and(new Predicate[]{});
				Set<Predicate> predicates = new HashSet<Predicate>();
				if(thirdPerson.getMiddleName() != null)
					predicates.add(cb.like(root.get(GptEmployee_.middleName), thirdPerson.getMiddleName().replace("*", "%")));
				if(thirdPerson.getBusinessName() != null)
					predicates.add(cb.like(root.get(GptEmployee_.businessName), thirdPerson.getBusinessName().replace("*", "%")));
				if(thirdPerson.getLastName() != null)
					predicates.add(cb.like(root.get(GptEmployee_.lastName), thirdPerson.getLastName().replace("*", "%")));
				if(thirdPerson.getLastName() != null)
					predicates.add(cb.like(root.get(GptEmployee_.secondLasName), thirdPerson.getSecondLasName().replace("*", "%")));
				if(thirdPerson.getEconomicActivity() != null)
					predicates.add(cb.equal(root.join(GptEmployee_.economicActivity).get(MatEconomicActivity_.economicActivityId), thirdPerson.getEconomicActivity().getEconomicActivityId()));
				if(thirdPerson.getPhoneNumber2() != null)
					predicates.add(cb.equal(root.get(GptEmployee_.phoneNumber2), thirdPerson.getPhoneNumber2()));
				if(thirdPerson.getPhoneNumber1() != null)
					predicates.add(cb.equal(root.get(GptEmployee_.phoneNumber1), thirdPerson.getPhoneNumber1()));
				if(thirdPerson.getEmailAddress() != null)
					predicates.add(cb.equal(root.get(GptEmployee_.emailAddress), thirdPerson.getEmailAddress()));
				if(thirdPerson.getCity() != null)
					predicates.add(cb.equal(root.join(GptEmployee_.city).get(MatCity_.cityId), thirdPerson.getCity().getCityId()));
				if(thirdPerson.getIdentificationType() != null)
					predicates.add(cb.equal(root.join(GptEmployee_.identificationType).get(MatIdentificationType_.identificationTypeId), thirdPerson.getIdentificationType().getIdentificationTypeId()));
				if(thirdPerson.getTaxpayerType()  != null)
					predicates.add(cb.equal(root.join(GptEmployee_.taxpayerType).get(MatTaxpayerType_.taxpayerTypeId), thirdPerson.getTaxpayerType().getTaxpayerTypeId()));
				if(thirdPerson.getPersonType()  != null)
					predicates.add(cb.equal(root.get(GptEmployee_.personType), thirdPerson.getPersonType()));
				if(thirdPerson.getFirstName() != null)
					predicates.add(cb.like(root.get(GptEmployee_.firstName), thirdPerson.getFirstName().replace("*", "%")));
				if(thirdPerson.getIdentificationNumber()  != null)
					predicates.add(cb.equal(root.get(GptEmployee_.identificationNumber), thirdPerson.getIdentificationNumber()));

				
				return cb.and(predicates.toArray(new Predicate[]{}));
			}
		};
	}
}
