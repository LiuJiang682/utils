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
	public void shouldReturnTrueWhenColumnNameIsPrintableCharacterWithSqlInjectedCharacter() {
		//Given
		String tableName = "SAMPLE_ID,'; drop table samp_medadata; -- CORE_ID";
		//When
		boolean flag = DbTableNameSqlInjectionFilter.foundSqlInjectedColumnName(tableName);
		//Then
		assertThat(flag, is(true));
	}
	
	@Test
	public void shouldReturnTrueWhenSqlTagIsPrintableCharacterWithSqlInjectedCharacter() {
		//Given
		String tableName = "SELECT * FROM SAMP_META s WHERE s.LOADER_ID = ?'; drop table samp_medadata; -- ";
		//When
		boolean flag = DbTableNameSqlInjectionFilter.foundSqlInjectedSqlTag(tableName);
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
	
	@Test
	public void shouldReturnFalseWhenColumnNameIsPrintableCharacterWithUnderLineComma() {
		//Given
		String tableName = "abc_def,ghi_jkl";
		//When
		boolean flag = DbTableNameSqlInjectionFilter.foundSqlInjectedColumnName(tableName);
		//Then
		assertThat(flag, is(false));
	}
	
	@Test
	public void shouldReturnFalseWhenColumnNameIsPrintableCharacterWithUnderLine() {
		//Given
		String tableName = "abc_def";
		//When
		boolean flag = DbTableNameSqlInjectionFilter.foundSqlInjectedColumnName(tableName);
		//Then
		assertThat(flag, is(false));
	}
	
	@Test
	public void shouldReturnFalseWhenColumnNameIsPrintableCharacter() {
		//Given
		String tableName = "abc";
		//When
		boolean flag = DbTableNameSqlInjectionFilter.foundSqlInjectedColumnName(tableName);
		//Then
		assertThat(flag, is(false));
	}
	
	@Test
	public void shouldReturnFalseWhenColumnNameIsNull() {
		//Given
		String tableName = null;
		//When
		boolean flag = DbTableNameSqlInjectionFilter.foundSqlInjectedColumnName(tableName);
		//Then
		assertThat(flag, is(false));
	}
	
	@Test
	public void shouldReturnFalseWhenSqlTagIsPrintableCharacterStar() {
		//Given
		String tableName = "SELECT * FROM SAMP_META s WHERE s.LOADER_ID = ?";
		//When
		boolean flag = DbTableNameSqlInjectionFilter.foundSqlInjectedSqlTag(tableName);
		//Then
		assertThat(flag, is(false));
	}
	
	@Test
	public void shouldReturnFalseWhenSqlTagIsPrintableCharacterWithUnderLineCommaFullStop() {
		//Given
		String tableName = "abc_def,ghi_jkl,a.FILE_NAME";
		//When
		boolean flag = DbTableNameSqlInjectionFilter.foundSqlInjectedSqlTag(tableName);
		//Then
		assertThat(flag, is(false));
	}
	
	@Test
	public void shouldReturnFalseWhenSqlTagIsPrintableCharacterWithUnderLineComma() {
		//Given
		String tableName = "abc_def,ghi_jkl";
		//When
		boolean flag = DbTableNameSqlInjectionFilter.foundSqlInjectedSqlTag(tableName);
		//Then
		assertThat(flag, is(false));
	}
	
	@Test
	public void shouldReturnFalseWhenSqlTagIsPrintableCharacterWithUnderLine() {
		//Given
		String tableName = "abc_def";
		//When
		boolean flag = DbTableNameSqlInjectionFilter.foundSqlInjectedSqlTag(tableName);
		//Then
		assertThat(flag, is(false));
	}
	
	@Test
	public void shouldReturnFalseWhenSqlTagIsPrintableCharacter() {
		//Given
		String tableName = "abc";
		//When
		boolean flag = DbTableNameSqlInjectionFilter.foundSqlInjectedSqlTag(tableName);
		//Then
		assertThat(flag, is(false));
	}
	
	@Test
	public void shouldReturnFalseWhenSqlTagIsNull() {
		//Given
		String tableName = null;
		//When
		boolean flag = DbTableNameSqlInjectionFilter.foundSqlInjectedSqlTag(tableName);
		//Then
		assertThat(flag, is(false));
	}
	
	@Test
	public void shouldReturnFalseWhenRestrictedSqlTagIsPrintableCharacterStar() {
		//Given
		String tableName = "select ID, TEMPLATE from SESSION_HEADER WHERE REJECTED = ?";
		//When
		boolean flag = DbTableNameSqlInjectionFilter.foundRestrictedSqlInjectedSqlTag(tableName);
		//Then
		assertThat(flag, is(false));
	}
	
	@Test
	public void shouldReturnFalseWhenRestrictedSqlTagIsPrintableCharacterWithUnderLineCommaFullStop() {
		//Given
		String tableName = "abc_def,ghi_jkl,FILE_NAME";
		//When
		boolean flag = DbTableNameSqlInjectionFilter.foundRestrictedSqlInjectedSqlTag(tableName);
		//Then
		assertThat(flag, is(false));
	}
	
	@Test
	public void shouldReturnFalseWhenRestrictedSqlTagIsPrintableCharacterWithUnderLineComma() {
		//Given
		String tableName = "abc_def,ghi_jkl";
		//When
		boolean flag = DbTableNameSqlInjectionFilter.foundRestrictedSqlInjectedSqlTag(tableName);
		//Then
		assertThat(flag, is(false));
	}
	
	@Test
	public void shouldReturnFalseWhenRestrictedSqlTagIsPrintableCharacterWithUnderLine() {
		//Given
		String tableName = "abc_def";
		//When
		boolean flag = DbTableNameSqlInjectionFilter.foundRestrictedSqlInjectedSqlTag(tableName);
		//Then
		assertThat(flag, is(false));
	}
	
	@Test
	public void shouldReturnFalseWhenRestrictedSqlTagIsPrintableCharacter() {
		//Given
		String tableName = "abc";
		//When
		boolean flag = DbTableNameSqlInjectionFilter.foundRestrictedSqlInjectedSqlTag(tableName);
		//Then
		assertThat(flag, is(false));
	}
	
	@Test
	public void shouldReturnFalseWhenRestrictedSqlTagIsNull() {
		//Given
		String tableName = null;
		//When
		boolean flag = DbTableNameSqlInjectionFilter.foundRestrictedSqlInjectedSqlTag(tableName);
		//Then
		assertThat(flag, is(false));
	}
}
