package com.interview.probs.customer.rewards.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.interview.probs.customer.rewards.models.CustomerRewardsResponse;
import com.interview.probs.customer.rewards.models.CustomerSpendRequest;
import com.interview.probs.customer.rewards.service.CustomerSpendService;

@Service
public class CustomerSpendServiceImpl implements CustomerSpendService{

	@Override
	public CustomerRewardsResponse getCustomerRewardsResponse(CustomerSpendRequest customerSpendRequest) {

		CustomerRewardsResponse customerRewardsResponse = new CustomerRewardsResponse();
		Map<String, Map<String, Integer>> rewardsByMonthAndCustomer = customerRewardsResponse.getRewardsByMonthAndCustomer();

		Map<String, Map<String, List<Integer>>> customerSpendDetails = customerSpendRequest.getCustomerSpendDetails(); 
		Integer totalRewards = 0;

		//Each Month's Record
		for(Map.Entry<String, Map<String, List<Integer>>> eachMonthRecord : customerSpendDetails.entrySet()) {

			Map<String, Integer> customerWithRewardsPoint = new HashMap<>();

			//Each Customer's Record in a month
			for(Map.Entry<String, List<Integer>> eachCustomerRecord: customerSpendDetails.get(eachMonthRecord.getKey()).entrySet()) {

				Integer totalPerMonthRewards = 0;

				//Each Customer's Spend in a month
				for(Integer eachSpend: eachCustomerRecord.getValue()) {

					if(eachSpend <= 0)
						continue;
					Integer oneRewardDollerCount = 0;
					Integer twoRewardDollerCount = 0;
					Integer temp = eachSpend;
					
					if(eachSpend > 100) {
						twoRewardDollerCount = eachSpend - 100;
						temp -= twoRewardDollerCount;
					}

					if(eachSpend > 50)
						oneRewardDollerCount = temp - 50;
					
					totalPerMonthRewards += oneRewardDollerCount+(twoRewardDollerCount*2);

				}
				totalRewards += totalPerMonthRewards;
				customerWithRewardsPoint.put(eachCustomerRecord.getKey(), totalPerMonthRewards);
			}
			rewardsByMonthAndCustomer.put(eachMonthRecord.getKey(), customerWithRewardsPoint);
		}
		customerRewardsResponse.setRewardsByMonthAndCustomer(rewardsByMonthAndCustomer);
		customerRewardsResponse.setTotalRewards(totalRewards);

		return customerRewardsResponse;
	}

}
