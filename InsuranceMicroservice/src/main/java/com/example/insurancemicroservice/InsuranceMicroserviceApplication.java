package com.example.insurancemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InsuranceMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceMicroserviceApplication.class, args);
	}


	/**
	 *
	 * HMO Limited access to network, no out-of-network benefits, referral required
	 * EPO Full access to network, no out-of-network benefits, no referral required, affordable premiums
	 * PPO FUll access to network, out-of-network benefits, no referral required, higher premiums
	 *
	 *
	 * sercet key open api
	 * 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
	 */
}
