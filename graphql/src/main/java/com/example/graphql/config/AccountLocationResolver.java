package com.example.graphql.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.graphql.data.Account;
import com.example.graphql.data.Location;

import graphql.kickstart.tools.GraphQLResolver;

@Component
public class AccountLocationResolver implements GraphQLResolver<Account>{
	
	@Autowired
	DataPopulator dataPopulator;
	
	public Location getLocation(Account account) {
		return dataPopulator.populateLocation().stream().filter(loc -> loc.getId().equals(account.getLocationId())).findFirst()
				.orElse(null);
	}
}
