package com.example.graphql.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.graphql.data.Account;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class SampleQuery implements GraphQLQueryResolver {

	@Autowired
	DataPopulator dataPopulator;

	public Account accountById(String id) {
		return dataPopulator.populateAccount().stream().filter(acct -> acct.getId().equals(id)).findFirst()
				.orElse(null);
	}
}
