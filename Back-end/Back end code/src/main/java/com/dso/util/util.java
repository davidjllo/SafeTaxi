package com.dso.util;

public class util {
	public static java.sql.Date To_JavaSqlDate(java.util.Date jDate) {
	    java.sql.Date sqlDate = new java.sql.Date(jDate.getTime());
	    return sqlDate;
	}
	
	public static java.util.Date To_JavaUtilDate(java.sql.Date sqlDate) {
		return new java.util.Date();
	}

}
