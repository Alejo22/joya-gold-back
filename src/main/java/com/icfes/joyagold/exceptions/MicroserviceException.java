package com.icfes.joyagold.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class MicroserviceException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	protected String errorCode;
	
	public MicroserviceException(String message, String code) {
		super(message);
		this.errorCode = code;
	}
	
	public MicroserviceException(String message, String code, Throwable throwable) {
		super(message, throwable);
		this.errorCode = code;
	}
}
