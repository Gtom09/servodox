package com.carelon.discount.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carelon.discount.pojo.Discount;
import com.carelon.discount.pojo.Discounts;
import com.carelon.discount.services.DiscountService;

@RequestMapping("/discount")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class DiscountController {
	
		

		
		@Autowired
		DiscountService discountService;

		@RequestMapping(value = "viewDiscounts", method = RequestMethod.GET)
		public Discounts viewEmployeesData() {
			Discounts discountlist= discountService.getEmployeeData();
			return discountlist;
		}
		

		
//		@RequestMapping(value = "updateDiscountsData", method = RequestMethod.PUT)
//		public String updateEmployeesData(@RequestBody Discount discount) {
//			String message = discountService.updateDiscountsData(discount.getSlab(), discount.getMaleNo(), discount.getFemaleNo());
//			return message;
//		}
		
		@RequestMapping(value = "updateDiscountsData", method = RequestMethod.PUT)
		public ResponseEntity<Map<String, String>> updateEmployeesData(@RequestBody Discount discount) {
		    String message = discountService.updateDiscountsData(discount.getSlab(), discount.getMaleNo(), discount.getFemaleNo());
		    Map<String, String> response = new HashMap<>();
		    response.put("message", message);
		    return ResponseEntity.ok(response);
		}
		
	}
