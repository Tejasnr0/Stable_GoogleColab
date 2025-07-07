package edu.jsp.BankingApplication.Banking_Application.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.BankingApplication.Banking_Application.Entity.Account;

public interface JpaRepo extends JpaRepository<Account, Long>{

}
