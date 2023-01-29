package br.com.api.rickandmorty.validation;

import java.time.LocalDate;

/**
 * Message template to show when a exception occurs
 * @author Adriel Rodrigues
 *
 */
public class ExceptionMessage {
	
	private LocalDate date;
	private Integer statusCode;
	private String message;
	
	public ExceptionMessage(LocalDate date, Integer statusCode, String message) {
		this.date = date;
		this.statusCode = statusCode;
		this.message = message;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
