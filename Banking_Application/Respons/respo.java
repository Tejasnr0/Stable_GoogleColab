package edu.jsp.BankingApplication.Banking_Application.Respons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class respo<T> {

	private int statuscode;
	private String message;
	private T data;
}
