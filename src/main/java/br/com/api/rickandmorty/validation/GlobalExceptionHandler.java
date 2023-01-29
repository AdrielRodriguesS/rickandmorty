package br.com.api.rickandmorty.validation;

import java.time.LocalDate;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpClientErrorException.Forbidden;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ControllerAdvice
	public class ValidationExceptionHandler{
		
	
		@ExceptionHandler(EntityNotFoundException.class)
	    public ResponseEntity<ExceptionMessage> EntityNotFoundException(EntityNotFoundException e){
	
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
	            new ExceptionMessage(LocalDate.now(), HttpStatus.NOT_FOUND.value(), "Not Found")
	        );
	    }
		
		@ExceptionHandler(NotFoundException.class)
	    public ResponseEntity<ExceptionMessage> NotFoundException(NotFoundException e){
	
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
	            new ExceptionMessage(LocalDate.now(), HttpStatus.NOT_FOUND.value(), e.getMessage())
	        );
	    }
		
		@ExceptionHandler(Forbidden.class)
	    public ResponseEntity<ExceptionMessage> ForbiddenException(Forbidden e){
	
	        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
	            new ExceptionMessage(LocalDate.now(), HttpStatus.FORBIDDEN.value(), e.getMessage())
	        );
	    }
		
		@ExceptionHandler(BadRequest.class)
	    public ResponseEntity<ExceptionMessage> BadRequestException(BadRequest e){
	
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
	            new ExceptionMessage(LocalDate.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage())
	        );
	    }
		
		@ExceptionHandler(MissingPathVariableException.class)
	    public ResponseEntity<ExceptionMessage> MissingPathVariableException(MissingPathVariableException e){
	
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
	            new ExceptionMessage(LocalDate.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage())
	        );
	    }
		
		@ExceptionHandler(IllegalArgumentException.class)
	    public ResponseEntity<ExceptionMessage> IllegalArgumentException(IllegalArgumentException e){
	
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
	            new ExceptionMessage(LocalDate.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage())
	        );
	    }
		
		@ExceptionHandler(DataIntegrityViolationException.class)
	    public ResponseEntity<ExceptionMessage> DataIntegrityViolationException(DataIntegrityViolationException e){
	
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
	            new ExceptionMessage(LocalDate.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage())
	        );
	    }
		
		@ExceptionHandler(HttpMessageNotReadableException.class)
	    public ResponseEntity<ExceptionMessage> HttpMessageNotReadableException(HttpMessageNotReadableException e){
	
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
	            new ExceptionMessage(LocalDate.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage())
	        );
	    }
		
		@ExceptionHandler(ConstraintViolationException.class)
	    public ResponseEntity<ExceptionMessage> ConstraintViolationException(ConstraintViolationException e){
	
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
	            new ExceptionMessage(LocalDate.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage())
	        );
	    }
		
		@ExceptionHandler(EmptyResultDataAccessException.class)
	    public ResponseEntity<ExceptionMessage> EmptyResultDataAccessException(EmptyResultDataAccessException e){
	
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
	            new ExceptionMessage(LocalDate.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage())
	        );
	    }
	
	}

}
