package au.gov.vic.ecodev.utils.file;

import java.lang.reflect.Method;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;

public enum FileNameUtils {

	INSTANCE;
	
	private static final String FILE_NAME_UTILS_BUNDLE = "FileNameUtilsBundle";
	private static final String FILE_NAME_UTILS_METHOD_NAME = "file.name.utils.method.name";
	private static final String FILE_NAME_UTILS_CLASS_NAME = "file.name.utils.class.name";

	public final boolean isPartialFileName(String fileName) throws Exception {
		if (StringUtils.isNotBlank(fileName)) {
			String className = BUNDLE.getString(FILE_NAME_UTILS_CLASS_NAME);
			String methodName = BUNDLE.getString(FILE_NAME_UTILS_METHOD_NAME);
			Class<?> fileNameUtilsClass = Class.forName(className);
			Method method = fileNameUtilsClass.getDeclaredMethod(methodName, String.class, ResourceBundle.class);
			Object object = fileNameUtilsClass.newInstance();
			return (Boolean) method.invoke(object, fileName, BUNDLE);
		}
		return false;
	}
	
	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(FILE_NAME_UTILS_BUNDLE);

}
