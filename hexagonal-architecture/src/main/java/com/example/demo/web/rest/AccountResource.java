package com.example.demo.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Account;
import com.example.demo.service.AccountService;

@RestController
@RequestMapping(path = "/api")
public class AccountResource {

	@Autowired
	private AccountService orderService;

	@GetMapping(path = "/account/{accountNumber}", produces = "application/json")
	public ResponseEntity<Account> getAccountInfo(@PathVariable("accountNumber") String accountNumber) {
		return ResponseEntity.ok(orderService.getAccountInfo(accountNumber));
	}
}
