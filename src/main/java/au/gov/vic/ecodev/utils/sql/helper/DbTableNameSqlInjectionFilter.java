package au.gov.vic.ecodev.utils.sql.helper;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class DbTableNameSqlInjectionFilter {

	private static final Pattern TABLE_NAME_INJECTED_PATTERN = Pattern.compile("[\\p{Punct}&&[^_]]");
	
	public static final boolean foundSqlInjectedTableName(final String tableName) {
		if (StringUtils.isNotBlank(tableName)) {
			return TABLE_NAME_INJECTED_PATTERN.matcher(tableName).find();
		}
		return false;
	}
}
