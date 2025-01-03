package com.carelon.rates.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carelon.rates.dao.RatesDAO;
import com.carelon.rates.entity.EntityRates;
import com.carelon.rates.pojo.Rates;


@Service
public class RatesService {

	@Autowired
	RatesDAO ratesDAO;

	@Transactional
	public Rates getRatesData() {
		List<EntityRates> rateList = ratesDAO.getRatesData();
		List<com.carelon.rates.pojo.Rate> list = new ArrayList<>();
		com.carelon.rates.pojo.Rate r = null;
		for (EntityRates rt : rateList) {
			r = new com.carelon.rates.pojo.Rate();
			r.setAge(rt.getAge());
			r.setRatesMaleNo(rt.getMale());
			r.setRatesFemaleNo(rt.getFemale());
			list.add(r);
		}
		Rates rates = new Rates();
		rates.setRates(list);

		return rates;

	}

	@Transactional
	public String updateRatesData(String Age, int Male, int Female) {
		String message = ratesDAO.updateRatesData(Age, Male, Female);
		return message;
	}

}
