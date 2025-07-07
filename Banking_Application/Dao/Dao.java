package edu.jsp.BankingApplication.Banking_Application.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.jsp.BankingApplication.Banking_Application.Entity.Account;
import edu.jsp.BankingApplication.Banking_Application.Repositry.JpaRepo;

@Repository
public class Dao {
	
	@Autowired
	private JpaRepo repo;
	
	public Account createAccount(Account ac) {
		return repo.save(ac);
	}
	public Account getAcc(Long no) {
		try {
		Optional<Account> ac=repo.findById(no);
		return ac.get();
		}
		catch(Exception e) {
			return null;
		}
	}
	public List<Account> getall(){
		List<Account> aclist=repo.findAll();
		return aclist;
	}
	
	public void deletById(Long acno) {
		repo.deleteById(acno);
	}

} 
