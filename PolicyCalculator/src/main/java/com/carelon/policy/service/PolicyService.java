package com.carelon.policy.service;

import java.util.ArrayList;
import java.util.List;
 
import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.carelon.discount.dao.DiscountDAO;
import com.carelon.discount.entity.Discount;
import com.carelon.policy.dao.PolicyDAO;
import com.carelon.policy.entity.Category;
import com.carelon.policy.entity.Policy;
import com.carelon.rates.dao.RatesDAO;
import com.carelon.rates.entity.EntityRates;
 
@Service
public class PolicyService {
 
	private static final String String = null;
	@Autowired
	PolicyDAO premiumDao;
	@Autowired
	RatesDAO ratesDAO;
	@Autowired
	DiscountDAO discountDAO;
 
	@Transactional
	public float savePolicyData(com.carelon.policy.pojo.Policy policyInfo) {
		Policy policy = premiumDao.getPolicy(policyInfo.getSchemeNumber());
		float premium = 0;
		if (policy == null) {
			policy = new Policy();
			policy.setSchemeNumber(policyInfo.getSchemeNumber());
			policy.setSchemeName(policyInfo.getSchemeName());
			policy.setEffectiveDate(policyInfo.getEffectiveDate());
			policy.setAnniversary(policyInfo.getAnniversary());
			policy.setBusinessSource(policyInfo.getBusinessSource());
			policy.setTaxID(policyInfo.getTaxID());
			policy.setCounty(policyInfo.getCounty());
			policy.setEmployerContactInfo(policyInfo.getEmployerContactInfo());
			policy.setAddress1(policyInfo.getAddress1());
			policy.setAddress2(policyInfo.getAddress2());
			policy.setAddress3(policyInfo.getAddress3());
			policy.setCity(policyInfo.getCity());
			policy.setState(policyInfo.getState());
			policy.setZip(policyInfo.getZip());
			policy.setEmployerPhone(policyInfo.getEmployerPhone());
			policy.setEmployerExt(policyInfo.getEmployerExt());
			policy.setEmployerFax(policyInfo.getEmployerFax());
			List<Category> categiryList = new ArrayList<>();
			policyInfo.getCategories().forEach(cat -> {
				Category category = new Category();
				category.setCategoryName(cat.getCategoryName());
				category.setMale(cat.getMale());
				category.setFemale(cat.getFemale());
				categiryList.add(category);
 
			});
			policy.setCategories(categiryList);
			premium = calculatePremium(policy);
			policy.setPremium(premium);
			premiumDao.savePolicyData(policy);
		} else {
			policy.setSchemeNumber(policyInfo.getSchemeNumber());
			policy.setSchemeName(policyInfo.getSchemeName());
			policy.setEffectiveDate(policyInfo.getEffectiveDate());
			policy.setAnniversary(policyInfo.getAnniversary());
			policy.setBusinessSource(policyInfo.getBusinessSource());
			policy.setTaxID(policyInfo.getTaxID());
			policy.setCounty(policyInfo.getCounty());
			policy.setEmployerContactInfo(policyInfo.getEmployerContactInfo());
			policy.setAddress1(policyInfo.getAddress1());
			policy.setAddress2(policyInfo.getAddress2());
			policy.setAddress3(policyInfo.getAddress3());
			policy.setCity(policyInfo.getCity());
			policy.setState(policyInfo.getState());
			policy.setZip(policyInfo.getZip());
			policy.setEmployerPhone(policyInfo.getEmployerPhone());
			policy.setEmployerExt(policyInfo.getEmployerExt());
			policy.setEmployerFax(policyInfo.getEmployerFax());
			List<Category> categiryList = new ArrayList<>();
			policyInfo.getCategories().forEach(cat -> {
				Category category = new Category();
				category.setCategoryName(cat.getCategoryName());
				category.setMale(cat.getMale());
				category.setFemale(cat.getFemale());
				categiryList.add(category);
 
			});
			policy.getCategories().clear();
			policy.getCategories().addAll(categiryList);
			premium = calculatePremium(policy);
			policy.setPremium(premium);
			premiumDao.savePolicyData(policy);
		}
		return premium;
	}
 
	private float calculatePremium(Policy policy) {
		float finalPremium = 0;
		float maleCount=0;
		float maleCount1=0;
		float premiumMale=0;
		float femaleCount=0;
		float femaleCount1=0;
		float premiumFemale=0;
		List<EntityRates> listRates = ratesDAO.getRatesData();
		List<Discount> listDiscounts = discountDAO.getDiscountData();
 
		for (int i = 0; i < 3; i++) {
 
			 maleCount1 = Float.parseFloat(policy.getCategories().get(i).getMale());
			 premiumMale = premiumMale+ maleCount1* listRates.get(i).getMale();
			 femaleCount1 = Float.parseFloat(policy.getCategories().get(i).getFemale());
		     premiumFemale = premiumFemale+femaleCount1 * listRates.get(i).getFemale();
		     maleCount=maleCount+maleCount1;
		     femaleCount=femaleCount+femaleCount1;
		}	
			// Calculating male discount
			if (maleCount >= 1 && maleCount <= 200) {
				premiumMale = (premiumMale * (100 - listDiscounts.get(0).getMaleNo())) / 100 ;
 
			} else if (maleCount >= 201 && maleCount <= 400) {
				premiumMale = (premiumMale * (100 - listDiscounts.get(1).getMaleNo())) / 100;
 
			} else {
				premiumMale = (premiumMale * (100 - listDiscounts.get(2).getMaleNo())) / 100;
 
			}
 
			// Calculating female discount
			if (femaleCount >= 1 && femaleCount <= 200) {
				premiumFemale = (premiumFemale * (100 - listDiscounts.get(0).getFemaleNo())) / 100;
 
			} else if (femaleCount >= 201 && femaleCount <= 400) {
				premiumFemale = (premiumFemale * (100 - listDiscounts.get(1).getFemaleNo())) / 100;
 
			} else {
				premiumFemale = (premiumFemale * (100 - listDiscounts.get(2).getFemaleNo())) / 100;
			}
 
			finalPremium =  premiumMale+premiumFemale;
		System.out.println("calcualted value" + finalPremium);
		return finalPremium;
	}
 
}
