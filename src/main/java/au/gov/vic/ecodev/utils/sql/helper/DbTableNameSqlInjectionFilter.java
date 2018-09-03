package au.gov.vic.ecodev.utils.sql.helper;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class DbTableNameSqlInjectionFilter {

	private static final Pattern TABLE_NAME_INJECTED_PATTERN = Pattern.compile("[\\p{Punct}&&[^_]]");
	private static final Pattern COLUMN_NAME_INJECTED_PATTERN = Pattern.compile("[\\p{Punct}&&[^_,]]");
	private static final Pattern SQL_INJECTED_PATTERN = Pattern.compile("[\\p{Punct}&&[^_,.*?=]]");
	private static final Pattern RESTRICT_SQL_INJECTED_PATTERN = Pattern.compile("[\\p{Punct}&&[^_,?=]]");
	
	public static final boolean foundSqlInjectedTableName(final String tableName) {
		if (StringUtils.isNotBlank(tableName)) {
			return TABLE_NAME_INJECTED_PATTERN.matcher(tableName).find();
		}
		return false;
	}
	
	public static final boolean foundSqlInjectedColumnName(final String tableName) {
		if (StringUtils.isNotBlank(tableName)) {
			return COLUMN_NAME_INJECTED_PATTERN.matcher(tableName).find();
		}
		return false;
	}
	
	public static final boolean foundSqlInjectedSqlTag(final String tableName) {
		if (StringUtils.isNotBlank(tableName)) {
			return SQL_INJECTED_PATTERN.matcher(tableName).find();
		}
		return false;
	}
	
	public static final boolean foundRestrictedSqlInjectedSqlTag(final String tableName) {
		if (StringUtils.isNotBlank(tableName)) {
			return RESTRICT_SQL_INJECTED_PATTERN.matcher(tableName).find();
		}
		return false;
	}
}
