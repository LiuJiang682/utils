package au.gov.vic.ecodev.utils.file.name;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.Enumeration;
import java.util.ResourceBundle;

import org.junit.Before;
import org.junit.Test;


public class SimplePartialFileNameCheckerTest {

	private SimplePartialFileNameChecker testInstance;
	
	@Before
	public void setUp() {
		this.testInstance = new SimplePartialFileNameChecker();
	}
	
	@Test
	public void shouldReturnTrueWhenFileNameContainsPartial() {
		//Given
		String fileName = "mrt_eco_partial.zip";
		ResourceBundle mockBundle = getResourceBundle();
		//When
		boolean flag = testInstance.isPatternMatchedFileName(fileName, mockBundle);
		//Then
		assertThat(flag, is(true));
	}
	
	@Test
	public void shouldReturnFalseWhenFileNameContainsParti() {
		//Given
		String fileName = "mrt_eco_parti.zip";
		ResourceBundle mockBundle = getResourceBundle();
		//When
		boolean flag = testInstance.isPatternMatchedFileName(fileName, mockBundle);
		//Then
		assertThat(flag, is(false));
	}
	
	@Test
	public void shouldReturnFalseWhenFileNameIsBlank() {
		//Given
		String fileName = null;
		ResourceBundle mockBundle = getResourceBundle();
		//When
		boolean flag = testInstance.isPatternMatchedFileName(fileName, mockBundle);
		//Then
		assertThat(flag, is(false));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldRaiseExceptionWhenResourceBundleIsNull() {
		//Given
		String fileName = "mrt_eco_parti.zip";
		ResourceBundle mockBundle = null;
		//When
		testInstance.isPatternMatchedFileName(fileName, mockBundle);
		fail("Program reached unexpected point!");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldRaiseExceptionWhenFileNamePatternIsNotProvided() {
		//Given
		String fileName = "mrt_eco_parti.zip";
		ResourceBundle mockBundle = new ResourceBundle() {

			@Override
			protected Object handleGetObject(String key) {
				return null;
			}

			@Override
			public Enumeration<String> getKeys() {
				return Collections.emptyEnumeration();
			}
			
		};
		//When
		testInstance.isPatternMatchedFileName(fileName, mockBundle);
		fail("Program reached unexpected point!");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldRaiseExceptionWhenFileNamePatternIsBlank() {
		//Given
		String fileName = "mrt_eco_parti.zip";
		ResourceBundle mockBundle = new ResourceBundle() {

			@Override
			protected Object handleGetObject(String key) {
				return "";
			}

			@Override
			public Enumeration<String> getKeys() {
				return Collections.emptyEnumeration();
			}
			
		};
		//When
		testInstance.isPatternMatchedFileName(fileName, mockBundle);
		fail("Program reached unexpected point!");
	}
	
	@Test
	public void shouldReturnInstance() {
		//Given
		//When
		//Then
		assertThat(testInstance, is(notNullValue()));
	}
	
	private static ResourceBundle getResourceBundle() {
		return new ResourceBundle() {

			@Override
			protected Object handleGetObject(String key) {
				return "(?i:.*_partial.*)";
			}

			@Override
			public Enumeration<String> getKeys() {
				return Collections.emptyEnumeration();
			}
			
		};
	}
}
