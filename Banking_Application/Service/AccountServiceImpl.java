package edu.jsp.BankingApplication.Banking_Application.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.jsp.BankingApplication.Banking_Application.Dao.Dao;
import edu.jsp.BankingApplication.Banking_Application.Entity.Account;
import edu.jsp.BankingApplication.Banking_Application.Respons.respo;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private Dao dao;

	@Override
	public ResponseEntity<respo<Account>> createAccount(Account ac) {
		
		Account cretedAccount=dao.createAccount(ac);
		respo<Account> res=new respo<Account>();
		res.setStatuscode(HttpStatus.CREATED.value());
		res.setMessage("Account Created");
		res.setData(cretedAccount);
		
		return new ResponseEntity<respo<Account>>(res,HttpStatus.CREATED); 
	}

	@Override
	public ResponseEntity<respo<Account>> getAccountDeatilsbyAccNumber(long accountNumber) {
		Account res=dao.getAcc(accountNumber);
		respo<Account> r=new respo<Account>();
		if(res==null) {
			r.setMessage("The Account Not found:");
			r.setStatuscode(HttpStatus.NOT_FOUND.value());
			r.setData(res);
			
			return new ResponseEntity<respo<Account>>(r,HttpStatus.NOT_FOUND);
		}
		else {
		r.setMessage("The Account is:");
		r.setStatuscode(HttpStatus.OK.value());
		r.setData(res);
		
		return new ResponseEntity<>(r,HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<respo<List<Account>>> getAllAccount() {
		 List<Account> acList=dao.getall();
		 System.out.println(acList.get(2));
		 respo<List<Account>> r=new respo<List<Account>>();
		 r.setMessage("Accounts Present are");
		 r.setData(acList);
		 r.setStatuscode(HttpStatus.OK.value());
		 
		 return new ResponseEntity<respo<List<Account>>>(r,HttpStatus.OK);
	}
/*to save/persist this tranction in the database you can return dao.save(acc) save is the method
 * in the dao class which save's in the database
 * or use @Transactional annoation to save/persist the changes
 * dao.save(object/bean) or @Transactional
 */
	
	@Override
	@Transactional
	public Account depositAmount(long AccountNumber, double money) {
		
		 Account acc = dao.getAcc(AccountNumber);
		 if(acc!=null) {
			 acc.setAccount_Balance(acc.getAccount_Balance()+money);
			 return acc;
		 }else {
			 return null;
		 }
		
	}

	@Override
	@Transactional
	public Account withdrawAmount(long AccountNumber, double money) {
		// TODO Auto-generated method stub
		Account acc=dao.getAcc(AccountNumber);
		if(acc!=null) {
			acc.setAccount_Balance(acc.getAccount_Balance()-money);
			return acc;
		}else {
			return null;
		}
	}

	@Override
	public ResponseEntity<respo<Account>> ClosingAccount(long AccountNumber) {
		
		Account ac=dao.getAcc(AccountNumber);
		if(ac!=null) {
			dao.deletById(AccountNumber);
			respo<Account> rr=new respo<Account>();
			rr.setData(null);
			rr.setMessage("Account has been deleted");
			rr.setStatuscode(HttpStatus.OK.value());
			
			return new ResponseEntity<respo<Account>>(rr,HttpStatus.OK);
		}
		else {
			respo<Account> rr=new respo<Account>();
			rr.setData(null);
			rr.setMessage("Account not present");
			rr.setStatuscode(HttpStatus.NOT_FOUND.value());
			
			
			return new ResponseEntity<respo<Account>>(rr,HttpStatus.NOT_FOUND);
		}
	}

}
