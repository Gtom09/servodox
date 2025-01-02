package com.carelon.policy.dao;

import com.carelon.policy.entity.Policy;

public interface PolicyDAO {

	public String savePolicyData(Policy p);

	public Policy getPolicy(String schemeNumber);

}

