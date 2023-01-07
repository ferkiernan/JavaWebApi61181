package com.educacionit.DTOs;

public class ErrorDTO {
	private int codigoError;
	private String descripcion;
	
	
	
	
	public ErrorDTO(int codigoError, String descripcion) {
		super();
		this.codigoError = codigoError;
		this.descripcion = descripcion;
	}
	public int getCodigoError() {
		return codigoError;
	}
	public void setCodigoError(int codigoError) {
		this.codigoError = codigoError;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
