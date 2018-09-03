package au.gov.vic.ecodev.utils.strings;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import au.gov.vic.ecodev.utils.constants.Constants.Strings;

public class StringToUniqueListHelper {

	private StringToUniqueListHelper() {
	}
	
	public static final List<String> extractUniqueTemplate(String templates) {
		if (StringUtils.isEmpty(templates)) {
			throw new IllegalArgumentException("TemplateDataServicesImpl.extractUniqueTemplate -- templates parameter cannot be null!");
		}
		String[] templateArray = templates.split(Strings.COMMA);
		String[] distinctTemplates = Arrays.stream(templateArray)
				.map(String::toUpperCase)
				.distinct()
				.toArray(String[]::new);
		return Arrays.asList(distinctTemplates);
	}
}
