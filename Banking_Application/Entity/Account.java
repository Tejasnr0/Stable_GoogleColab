package edu.jsp.BankingApplication.Banking_Application.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Account_Number;
	private String Account_Holder;
	private Double Account_Balance;
	
	public long getAccount_Number() {
		return Account_Number;
	}
	public void setAccount_Number(long account_Number) {
		Account_Number = account_Number;
	}
	public String getAccount_Holder() {
		return Account_Holder;
	}
	public void setAccount_Holder(String account_Holder) {
		Account_Holder = account_Holder;
	}
	public Double getAccount_Balance() {
		return Account_Balance;
	}
	public void setAccount_Balance(Double account_Balance) {
		Account_Balance = account_Balance;
	}
	//This is All Argument Constructor but it dosen't involve the AccountNumber because it will be Auto generated b the Hibrenate
	public Account(String account_Holder, Double account_Balance) {
		super();
		Account_Holder = account_Holder;
		Account_Balance = account_Balance;
	}
//	
	public Account() {
		super();
	}
	@Override
	public String toString() {
		return "model1 [Account_Number=" + Account_Number + ", Account_Holder=" + Account_Holder + ", Account_Balance="
				+ Account_Balance + "]";
	}	
}
