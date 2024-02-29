package com.icfes.joyagold.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.icfes.joyagold.util.ErrorCodeEnum;
import com.icfes.joyagold.util.ErrorDetalles;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetalles> handlerMicroserviceExceptions( Exception exception,  WebRequest webRequest ){
		ErrorDetalles errorDetalles = new ErrorDetalles(new Date(), ErrorCodeEnum.INTERNAL_ERROR.getValue(), exception.getMessage() , webRequest.getDescription(false));
		return new ResponseEntity<ErrorDetalles>(errorDetalles , HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorDetalles> handlerBadRequestException( BadRequestException badRequestException ,  WebRequest webRequest ){
		ErrorDetalles errorDetalles = new ErrorDetalles(new Date(), badRequestException.errorCode, badRequestException.getMessage() , webRequest.getDescription(false));
		return new ResponseEntity<ErrorDetalles>(errorDetalles , HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetalles> handlerResourceNotFoundtException( ResourceNotFoundException resourceNotFoundException ,  WebRequest webRequest ){
		ErrorDetalles errorDetalles = new ErrorDetalles(new Date(), resourceNotFoundException.errorCode, resourceNotFoundException.getMessage() , webRequest.getDescription(false));
		return new ResponseEntity<ErrorDetalles>(errorDetalles , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public  ResponseEntity<ErrorDetalles> handlerResourceConflictException( MethodArgumentNotValidException methodArgumentNotValidException, WebRequest webRequest ){
		ErrorDetalles errorDetalles = new ErrorDetalles(new Date(),methodArgumentNotValidException.getFieldError().getCode(), methodArgumentNotValidException.getFieldError().getDefaultMessage(), webRequest.getDescription(false));
		return new ResponseEntity<ErrorDetalles>(errorDetalles , HttpStatus.BAD_REQUEST);
	}
}
