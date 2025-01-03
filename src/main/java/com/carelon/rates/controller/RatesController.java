package com.carelon.rates.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carelon.rates.pojo.Rate;
import com.carelon.rates.pojo.Rates;
import com.carelon.rates.service.RatesService;

@RequestMapping("/rates")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class RatesController {
	@Autowired
	RatesService ratesService;

	@RequestMapping(value = "viewRates", method = RequestMethod.GET)
	public Rates viewRatesData() {
		Rates rates = ratesService.getRatesData();
		return rates;
	}

//	@RequestMapping(value = "updateRates", method = RequestMethod.PUT)
//	public String updateRatesData(@RequestBody Rate rate) {
//		String message = ratesService.updateRatesData(rate.getAge(), rate.getRatesMaleNo(), rate.getRatesFemaleNo());
//		return message;
//
//	}
	
	@RequestMapping(value = "updateRates", method = RequestMethod.PUT)
	public ResponseEntity<Map<String, String>> updateRatesData(@RequestBody Rate rate) {
	    String message = ratesService.updateRatesData(rate.getAge(), rate.getRatesMaleNo(), rate.getRatesFemaleNo());
	    Map<String, String> response = new HashMap<>();
	    response.put("message", message);
	    return ResponseEntity.ok(response);
	}

}
