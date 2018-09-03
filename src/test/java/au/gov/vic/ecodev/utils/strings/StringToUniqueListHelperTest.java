package au.gov.vic.ecodev.utils.strings;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

public class StringToUniqueListHelperTest {

	@Test
	public void shouldExtractUniqueTemplate() {
		//Given
		String templates = "MRT,MRT";
		//When
		List<String> templateList = StringToUniqueListHelper.extractUniqueTemplate(templates);
		//Then
		assertThat(templateList, is(notNullValue()));
		assertThat(templateList.size(), is(equalTo(1)));
		assertThat(templateList.get(0), is(equalTo("MRT")));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldRaiseExceptionWhenCalledExtractUniqueTemplateWithNullTemplates() {
		//Given
		String templates = null;
		//When
		StringToUniqueListHelper.extractUniqueTemplate(templates);
		fail("Program reached unexpected point!");
	}
}
