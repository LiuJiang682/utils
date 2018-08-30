package au.gov.vic.ecodev.utils.sql.helper;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DbTableNameSqlInjectionFilterTest {

	@Test
	public void shouldReturnTrueWhenTableNameIsPrintableCharacterWithSqlInjectedCharacter() {
		//Given
		String tableName = "samp_metadata'; drop table samp_medadata; --";
		//When
		boolean flag = DbTableNameSqlInjectionFilter.foundSqlInjectedTableName(tableName);
		//Then
		assertThat(flag, is(true));
	}
	
	@Test
	public void shouldReturnFalseWhenTableNameIsPrintableCharacterWithUnderLine() {
		//Given
		String tableName = "abc_def";
		//When
		boolean flag = DbTableNameSqlInjectionFilter.foundSqlInjectedTableName(tableName);
		//Then
		assertThat(flag, is(false));
	}
	
	@Test
	public void shouldReturnFalseWhenTableNameIsPrintableCharacter() {
		//Given
		String tableName = "abc";
		//When
		boolean flag = DbTableNameSqlInjectionFilter.foundSqlInjectedTableName(tableName);
		//Then
		assertThat(flag, is(false));
	}
	
	@Test
	public void shouldReturnFalseWhenTableNameIsNull() {
		//Given
		String tableName = null;
		//When
		boolean flag = DbTableNameSqlInjectionFilter.foundSqlInjectedTableName(tableName);
		//Then
		assertThat(flag, is(false));
	}
}
