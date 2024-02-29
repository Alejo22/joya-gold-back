package com.icfes.joyagold.util;

import java.util.Arrays;
import java.util.Optional;

public enum ErrorCodeEnum {
	
	BAD_REQUEST_FILEDS("BRF-001", "One o more fields not found in request"),
	NOT_FOUND_RESOURCE("NFR-001" , "Resource not found at database by field"),
	INTERNAL_ERROR("IE-001" , "Error not controlled by Handle"),
	EXTERNAL_ERROR_SERVICE("EES-001" , "Error at service consulting"),
	RESOURCE_CONFLICT_EXIST_ERROR("RCR-001" , "The resource already exist on data base");
	
	
	public static ErrorCodeEnum[] ENUM_VALUES = ErrorCodeEnum.values();
	
    private String value;
	private String description;

    ErrorCodeEnum(String value, String description) {
		this.value = value;
		this.description = description;
	}

	public String getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}
	
	public static ErrorCodeEnum get(final String value) {
		Optional<ErrorCodeEnum> optinalErroCode = Arrays.stream(ENUM_VALUES).filter( s -> s.getValue().equals(value)).findFirst();
		return optinalErroCode.isPresent() ? optinalErroCode.get() : null;
	}

}
