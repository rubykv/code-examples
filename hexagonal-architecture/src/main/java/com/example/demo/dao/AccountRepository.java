package com.example.demo.dao;

import com.example.demo.domain.Account;

public interface AccountRepository {

	public Account findAccount(String acctNumber);

}
