package com.carelon.policy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carelon.policy.entity.Policy;
import com.carelon.policy.service.PolicyService;

@RequestMapping("/premium")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PolicyController {

	@Autowired
	PolicyService premiumService;

	@RequestMapping(value = "savePolicy", method = RequestMethod.POST)
	public float savePolicyData(@RequestBody com.carelon.policy.pojo.Policy policyinfo) {
		float message = premiumService.savePolicyData(policyinfo);
		return message;
	}
	
	

}
