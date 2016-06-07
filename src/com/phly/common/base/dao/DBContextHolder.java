package com.phly.common.base.dao;

public class DBContextHolder {
	private static final ThreadLocal<String> dbHolder = new ThreadLocal<String>();

	/**
	 * 在开事务的上一层进行设置数据源名称才能生效,即在action层设置数据源名称
	 * @param dbName
	 */
	public static void setDbName(String dbName) {
		dbHolder.set(dbName);
	}

	public static String getDbName() {
		return dbHolder.get();
	}
	
	public static void removeDB(){
		dbHolder.remove();
	}
}
