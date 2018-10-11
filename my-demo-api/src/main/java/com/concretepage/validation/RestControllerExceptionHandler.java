/*package com.concretepage.validation;

import java.util.Arrays;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


//should handle all exception for classes annotated with         
@ControllerAdvice
@RestController
public class RestControllerExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleUnexpectedException(Exception e) {
	
		 // below object should be serialized to json
		 //ErrorResponse errorResponse = new ErrorResponse("asdasd"); 
		 ErrorDetails errorDetails = new ErrorDetails((java.sql.Date) new Date(), "Validation Failed",e.toString());
		 System.out.println(e.toString()+"....................");
		 return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		 
	}
}
*/