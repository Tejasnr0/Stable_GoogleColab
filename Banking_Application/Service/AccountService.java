package edu.jsp.BankingApplication.Banking_Application.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import edu.jsp.BankingApplication.Banking_Application.Entity.Account;
import edu.jsp.BankingApplication.Banking_Application.Respons.respo;

public interface AccountService {

	public ResponseEntity<respo<Account>> createAccount(Account ac);
	public ResponseEntity<respo<Account>> getAccountDeatilsbyAccNumber(long accountNumber);
	public ResponseEntity<respo<List<Account>>> getAllAccount();
	public Account depositAmount(long AccountNumber,double money);
	public Account withdrawAmount(long AccountNumber,double money);
	public ResponseEntity<respo<Account>> ClosingAccount(long AccountNumber);
}
