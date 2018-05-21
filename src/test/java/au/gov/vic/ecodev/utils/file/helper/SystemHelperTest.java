package au.gov.vic.ecodev.utils.file.helper;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.ResourceBundle;

import org.junit.Test;

public class SystemHelperTest {

	@Test
	public void shouldReturnPartWhenTheFileNameContainsOverrided() throws Exception {
		//Given
		System.setProperty("FileNameUtilsBundle", "FileNameUtilsBundleTest");
		//When
		ResourceBundle bundle = new SystemHelper().getBundle();
		//Then
		assertThat(bundle, is(notNullValue()));
		assertThat(bundle.getString("file.name.utils.name.pattern"), is(equalTo("(?i:.*_part\\..*)")));
	}
	
	@Test
	public void shouldReturnPartialWhenTheFileNameIsDefault() throws Exception {
		//Given
		System.clearProperty("FileNameUtilsBundle");
		//When
		ResourceBundle bundle = new SystemHelper().getBundle();
		//Then
		assertThat(bundle, is(notNullValue()));
		assertThat(bundle.getString("file.name.utils.name.pattern"), is(equalTo("(?i:.*_partial\\..*)")));
	}
}
