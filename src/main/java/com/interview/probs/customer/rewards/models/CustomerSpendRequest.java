package com.interview.probs.customer.rewards.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerSpendRequest {

	private Map<String, Map<String, List<Integer>>> customerSpendDetails = null;

	public Map<String, Map<String, List<Integer>>> getCustomerSpendDetails() {
		if(customerSpendDetails == null) {
			return new HashMap<String, Map<String, List<Integer>>>();
		}
		return this.customerSpendDetails;

	}

	public void setCustomerSpendDetails(Map<String, Map<String, List<Integer>>> customerSpendDetails) {
		this.customerSpendDetails = customerSpendDetails;
	}

}
