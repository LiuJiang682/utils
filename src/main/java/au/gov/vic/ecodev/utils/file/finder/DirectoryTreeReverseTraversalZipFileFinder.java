package au.gov.vic.ecodev.utils.file.finder;

import java.io.File;

import org.apache.commons.lang3.StringUtils;

import au.gov.vic.ecodev.utils.constants.Constants.Strings;

public class DirectoryTreeReverseTraversalZipFileFinder {

//	private static final String ZIP_FILE_EXTENSION = ".zip";
//	private static final String EMPTY = "";
	
	private final String parentName;
	
	public DirectoryTreeReverseTraversalZipFileFinder(String parentName) {
		if (StringUtils.isEmpty(parentName)) {
			throw new IllegalArgumentException("Parameter parentName cannot be empty!");
		}
		this.parentName = parentName;
	}

	public String findZipFile() {
		File file = new File(parentName);
		
		return backTracking(file);
	}
	
	protected final String backTracking(File file) {
		File parent = file.getParentFile();
		if (null == parent) {
			return null;
		}
		File[] filesInParent = parent.listFiles();
		for (File fileInParent : filesInParent) {
			if (fileInParent.isFile() 
					&& (fileInParent.getName().endsWith(Strings.ZIP_FILE_EXTENSION))) {
				String name = fileInParent.getName().replaceAll(Strings.ZIP_FILE_EXTENSION, Strings.EMPTY);
				if (this.parentName.contains(name)) {
					return fileInParent.getAbsolutePath();
				}
			}
		}
		
		return backTracking(parent);
	}
}
