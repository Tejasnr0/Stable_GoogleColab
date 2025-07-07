package edu.jsp.BankingApplication.Banking_Application.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.BankingApplication.Banking_Application.Entity.Account;
import edu.jsp.BankingApplication.Banking_Application.Respons.respo;
import edu.jsp.BankingApplication.Banking_Application.Service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService service;
	
	@PostMapping("create")
	public ResponseEntity<respo<Account>> createAccount(@RequestBody Account acc) {
		return service.createAccount(acc);
	}
	
	//when using the pathevarible the name present in {name} and name passed as argument should be same
	//because its taking the varible from the varible so 
	@GetMapping("{id}")
	public ResponseEntity<respo<Account>> getAccount(@PathVariable Long id){
		return service.getAccountDeatilsbyAccNumber(id);
	}
	
	@GetMapping("allacc")
	public ResponseEntity<respo<List<Account>>> getAllAcc(){
		return service.getAllAccount();
	}
	
	@PutMapping("depo/{accountnumber}/{amount}")
	public Account depoAcc(@PathVariable("accountnumber") Integer accno,@PathVariable("amount") Double money) {
		return service.depositAmount(accno, money);	
	}
	
	@PutMapping("withdraw/{accountnumber}/{amount}")
	public Account withdraw(@PathVariable Integer accountnumber, @PathVariable Double amount ) {
		return service.withdrawAmount(accountnumber, amount);
	}
	
	@DeleteMapping("delete/{accno}")
	public ResponseEntity<respo<Account>> deleacc(@PathVariable Long accno){
		return service.ClosingAccount(accno);
	}
	
}
