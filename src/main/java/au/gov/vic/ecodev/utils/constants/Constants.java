package au.gov.vic.ecodev.utils.constants;

import au.gov.vic.ecodev.mrt.constants.LogSeverity;

public interface Constants {

	interface Strings {
		static final String ZIP_FILE_EXTENSION = ".zip";
		static final String EMPTY = "";
		static final String COLON = ":";
		static final String SPACE = " ";
		static final String LOG_INFO_HEADER = LogSeverity.INFO.name() + COLON + SPACE;
		static final String LOG_WARNING_HEADER = LogSeverity.WARNING.name() + COLON + SPACE;
		static final String LOG_ERROR_HEADER = LogSeverity.ERROR.name() + COLON + SPACE;
	}
	
	interface Numeral {
		static final int ZERO = 0;
		static final int ONE = 1;
	}
}
