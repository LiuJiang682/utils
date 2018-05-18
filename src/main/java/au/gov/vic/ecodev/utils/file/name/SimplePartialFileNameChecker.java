package au.gov.vic.ecodev.utils.file.name;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;

public class SimplePartialFileNameChecker {

	private static final String FILE_NAME_UTILS_NAME_PATTERN = "file.name.utils.name.pattern";

	public final boolean isPatternMatchedFileName(final String fileName, final ResourceBundle bundle) {
		boolean patternMatched = false;
		if (StringUtils.isNoneBlank(fileName)) {
			if (null == bundle) {
				throw new IllegalArgumentException("SimplePartialFileNameChecker.isPatternMatchedFileName: Parameter bundle of ResourceBundle cannot be null!");
			}
			String pattern = null;
			try {
				pattern = bundle.getString(FILE_NAME_UTILS_NAME_PATTERN);
			} catch (MissingResourceException e) {
				throw new IllegalArgumentException("SimplePartialFileNameChecker.isPatternMatchedFileName: No file name pattern provided!");
			}
			if (StringUtils.isBlank(pattern)) {
				throw new IllegalArgumentException("SimplePartialFileNameChecker.isPatternMatchedFileName: File name pattern cannot be blank!");
			}
			
			//		return fileName.matches("(?i:.*_partial\\..*)");
			patternMatched = fileName.matches(pattern);
		}
		return patternMatched;
	}
}
