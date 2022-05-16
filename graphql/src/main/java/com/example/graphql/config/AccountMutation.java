package com.example.graphql.config;

import org.springframework.stereotype.Component;

import com.example.graphql.data.Account;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class AccountMutation implements GraphQLMutationResolver {

	public Account newAccount(String id, String type, String locationId) {
		Account acct = new Account();
		acct.setId(id);
		acct.setType(type);
		acct.setLocationId(locationId);
		return acct;
	}
}
