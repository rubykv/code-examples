package com.example.graphql.config;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.graphql.data.Account;
import com.example.graphql.data.Location;

@Component
public class DataPopulator {

	public List<Account> populateAccount() {
		Account account = new Account();
		account.setId("acct-1");
		account.setLocationId("loc-1");
		account.setName("my account 1");
		account.setType("savings");

		Account account1 = new Account();
		account1.setId("acct-2");
		account1.setLocationId("loc-2");
		account1.setName("my account 2");
		account1.setType("checking");

		return new ArrayList<>(Arrays.asList(account, account1));
	}

	public List<Location> populateLocation() {
		Location location = new Location();
		location.setId("loc-1");
		location.setState("NJ");
		location.setZip("08012");

		Location location1 = new Location();
		location1.setId("loc-2");
		location1.setState("UT");
		location1.setZip("07021");

		return new ArrayList<>(Arrays.asList(location, location1));
	}
}
