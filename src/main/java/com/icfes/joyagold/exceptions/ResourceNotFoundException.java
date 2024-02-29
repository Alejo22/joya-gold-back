package com.icfes.joyagold.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ResourceNotFoundException extends MicroserviceException {

	private static final long serialVersionUID = 1L;
	
	private String nombreCampo;
	private String nombreRecurso;
	private Integer valorCampo;
	
	public ResourceNotFoundException(String nombreCampo, String nombreRecurso, String valorCampo, String code) {
		super(String.format("El recurso %s no encontrado por el campo %s y el valor %s ", nombreRecurso, nombreCampo, valorCampo), code);
	}
	
	public ResourceNotFoundException(String nombreCampo, String nombreRecurso, String valorCampo, String code, Throwable throwable ) {
		super(String.format("El recurso %s no encontrado por el campo %s y el valor %s ", nombreRecurso, nombreCampo, valorCampo), code , throwable);
	}

}
