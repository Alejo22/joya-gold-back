package com.icfes.joyagold.util;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetalles {
	
	private Date timestamp;
	private String errorCode;
	private String message;
	private String url;
}
