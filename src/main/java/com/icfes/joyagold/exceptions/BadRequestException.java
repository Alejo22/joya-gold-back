package com.icfes.joyagold.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BadRequestException extends MicroserviceException {

	private static final long serialVersionUID = 1L;

	public BadRequestException(String message, String code) {
		super(message, code);
	}
	
	public BadRequestException(String message, String code, Throwable throwable ) {
		super(message, code , throwable);
	}
}
