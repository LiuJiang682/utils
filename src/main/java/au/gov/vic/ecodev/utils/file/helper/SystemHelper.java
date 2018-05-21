package au.gov.vic.ecodev.utils.file.helper;

import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;

public class SystemHelper {

	private static final String FILE_NAME_UTILS_BUNDLE = "FileNameUtilsBundle";
	
	public ResourceBundle getBundle() {
		ResourceBundle bundle = null;
		String propertiesFileName = System.getProperty(FILE_NAME_UTILS_BUNDLE);
		if (StringUtils.isBlank(propertiesFileName)) {
			bundle = ResourceBundle.getBundle(FILE_NAME_UTILS_BUNDLE);
		} else {
			bundle = ResourceBundle.getBundle(propertiesFileName);
		}
		return bundle;
	}

}
