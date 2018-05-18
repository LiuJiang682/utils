package au.gov.vic.ecodev.utils.file;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FileNameUtilsTest {

	@Test
	public void shouldReturnTrueWhenTheFileNameContainsPartial() throws Exception {
		//Given
		String fileName = "mrt_eco123_partial.txt";
		//When
		boolean flag = FileNameUtils.INSTANCE.isPartialFileName(fileName);
		//Then
		assertThat(flag, is(true));
	}
	
	@Test
	public void shouldReturnTrueWhenTheFileNameContainsParti() throws Exception {
		//Given
		String fileName = "mrt_eco123_parti.txt";
		//When
		boolean flag = FileNameUtils.INSTANCE.isPartialFileName(fileName);
		//Then
		assertThat(flag, is(false));
	}
	
	@Test
	public void shouldReturnInstance() {
		//Given
		//When
		FileNameUtils testInstance = FileNameUtils.INSTANCE;
		//Then
		assertThat(testInstance, is(notNullValue()));
	}
	
}
