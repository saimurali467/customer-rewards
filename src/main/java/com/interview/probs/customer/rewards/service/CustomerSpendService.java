package com.interview.probs.customer.rewards.service;

import com.interview.probs.customer.rewards.models.CustomerRewardsResponse;
import com.interview.probs.customer.rewards.models.CustomerSpendRequest;

public interface CustomerSpendService {
	
	public CustomerRewardsResponse getCustomerRewardsResponse(CustomerSpendRequest customerSpendRequest);

}
