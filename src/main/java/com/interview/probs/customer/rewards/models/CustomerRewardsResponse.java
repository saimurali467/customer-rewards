package com.interview.probs.customer.rewards.models;

import java.util.HashMap;
import java.util.Map;

public class CustomerRewardsResponse {

	private Map<String, Map<String, Integer>> rewardsByMonthAndCustomer = null;

	private Integer totalRewards;

	public Map<String, Map<String, Integer>> getRewardsByMonthAndCustomer() {
		if(rewardsByMonthAndCustomer == null)
			return new HashMap<String, Map<String, Integer>>();
		return rewardsByMonthAndCustomer;
	}

	public void setRewardsByMonthAndCustomer(Map<String, Map<String, Integer>> rewardsByMonthAndCustomer) {
		this.rewardsByMonthAndCustomer = rewardsByMonthAndCustomer;
	}

	public Integer getTotalRewards() {
		return totalRewards;
	}

	public void setTotalRewards(Integer totalRewards) {
		this.totalRewards = totalRewards;
	}
	
	
}
