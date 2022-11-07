package com.appl.java.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Util {
	/**
	 * Convierte double a bigdecimal
	 * @param value double
	 * @return bigdecimal
	 */
	public BigDecimal doubleToBigDecimal (double value) {
		try {
			return BigDecimal.valueOf(value);
		}catch(Exception e) {
			System.out.println("Error al convertir double a bigdecimal. "+e.toString());
		}
		return BigDecimal.valueOf(0);
	}
	/**
	 * Convierte bigdecimal a double
	 * @param value bigdecimal
	 * @return double
	 */
	public double bigDecimalToDouble (BigDecimal value) {
		try {
			return value.doubleValue();
		}catch(Exception e) {
			System.out.println("Error al convertir double a bigdecimal. "+e.toString());
		}
		return 0;
	}
	/**
	 * Convierte long a string
	 * @param value long
	 * @return string
	 */
	public String longToStr (long value) {
		try {
			return String.valueOf(value);
		}catch(Exception e) {
			System.out.println("Error al convertir long a string. "+e.toString());
		}
		return "";
	}
	/**
	 * Valida un valor entero
	 * @param value int
	 * @return int
	 */
	public int validateInt(int value) {
		try {
			return Integer.parseInt(String.valueOf(value));
		}catch(Exception e) {
			System.out.println("Error al validar int. "+e.toString());
		}
		return 0;
	}
	/**
	 * Trunca un string
	 * @param value string
	 * @param max int
	 * @return string
	 */
	public String truncateStr(String value, int max) {
		try {
			String actual = value.trim();
			if(actual.length()>=max) {
				return actual.substring(0,max);
			}
			return value;
		}catch(Exception e) {
			System.out.println("Error al truncar string. "+e.toString());
		}
		return "";
	}
	/**
	 * trunca un string desde long
	 * @param value long
	 * @param max int
	 * @return string
	 */
	public String truncateStr (long value, int max ) {
		try {
			String actual = longToStr(value);
			if(actual.length()>=max) {
				return actual.substring(0, max);
			}
			return actual;
		}catch(Exception e) {
			System.out.println("Error al truncar string desde long. "+e.toString());
		}
		return "";
	}
	/**
	 * Convierte long a timestamp
	 * @param value long
	 * @return timestamp
	 */
	public Timestamp timeFromLong(long value) {
		try {
			Date d = new Date(value*1000L);
			//System.out.println(d.toString());
			//System.out.println(d.getTime());
			return new Timestamp(d.getTime());
		}catch(Exception e) {
			System.out.println("Error al convertir long a date. "+e.toString());
		}
		return new Timestamp(System.currentTimeMillis());
	}
	/**
	 * Obtiene la fecha del sistema
	 * @return long
	 */
	public long getCurrentDate() {
		try {
			Date d = new Date();
			//System.out.println(d.toString());
			//System.out.println(d.getTime());
			return d.getTime();
		}catch(Exception e) {
			System.out.println("Error al obtener la fecha actual del sistema. "+e.toString());
		}
		return System.currentTimeMillis();
	}
	/**
	 * Obtiene la fecha anterior
	 * @param dif cuantos
	 * @param opt mes o dia
	 * @return
	 */
	public long getPastDate(String opt, int dif) {
		try {
			Calendar calendar = Calendar.getInstance();
			if(opt.equalsIgnoreCase("mes")) {
				calendar.add(Calendar.MONTH, -dif);
			}else {
				calendar.add(Calendar.DAY_OF_MONTH, -dif);
			}
	        return calendar.getTimeInMillis();
		}catch(Exception e) {
			System.out.println("Error al obtener la fecha anterior. dia o mes anterior. "+e.toString());
		}
		return System.currentTimeMillis();
	}
	/**
	 * Convierte la fecha con formato a long
	 * @param target fecha yyyy-mm-dd
	 * @return long
	 */
	public long strDateToLong(String target) {
		try {
			Date d = new SimpleDateFormat("yyyy-MM-dd").parse(target);
			//System.out.println(d.toString());
			//System.out.println(d.getTime());
			return d.getTime();
		}catch(Exception e) {
			System.out.println("Error al obtener la fecha actual del sistema. "+e.toString());
		}
		return 0;
	}
}
