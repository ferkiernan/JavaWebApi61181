package com.educacionit.utilidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Fechas {
	
	public static String PATRON_FECHA_YYYYMMDD;
	public static String PATRON_FECHA_YYYYMMDD_HHMMSS;

	static {
		PATRON_FECHA_YYYYMMDD = "yyyy-MM-dd";
		PATRON_FECHA_YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";
	}
	
	private Fechas() {
		
	}
	
	public static LocalDate getLocalDateFromString(String fecha) {
		return LocalDate.parse(fecha, DateTimeFormatter.ofPattern(PATRON_FECHA_YYYYMMDD));
	}
	
	public static String getStringFromLocalDate(LocalDate fecha) {
		return fecha.format(DateTimeFormatter.ofPattern(PATRON_FECHA_YYYYMMDD));
	}
	
	public static LocalDateTime getLocalDateTimeFromString(String fecha) {
		return LocalDateTime.parse(fecha, DateTimeFormatter.ofPattern(PATRON_FECHA_YYYYMMDD_HHMMSS));
	}
	
	public static String getStringFromLocalDateTime(LocalDateTime fecha) {
		return fecha.format(DateTimeFormatter.ofPattern(PATRON_FECHA_YYYYMMDD_HHMMSS));
	}
	
}
