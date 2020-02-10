package com.interview.probs.customer.rewards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.interview.probs.customer.rewards.models.CustomerRewardsResponse;
import com.interview.probs.customer.rewards.models.CustomerSpendRequest;
import com.interview.probs.customer.rewards.service.CustomerSpendService;

@RestController
public class CustomerSpendController {

	@Autowired
	CustomerSpendService customerSpendService; 
	
	@PostMapping(path = "/customer/spend", consumes = "application/json", produces = "application/json")
	public CustomerRewardsResponse customerSpen(@RequestBody CustomerSpendRequest customerSpendsRequest) {
		return customerSpendService.getCustomerRewardsResponse(customerSpendsRequest);
	}
}
