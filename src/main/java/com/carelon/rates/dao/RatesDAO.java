package com.carelon.rates.dao;

import java.util.List;

import com.carelon.rates.entity.EntityRates;

public interface RatesDAO {

	public List<EntityRates> getRatesData();

	public String updateRatesData(String age, int ratesMaleNo, int ratesFemaleNo);

}
