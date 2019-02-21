package assignment04;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class InputParser {

	private static final String FIRST_NAME_GROUP = "firstName";
	private static final String SURNAME_GROUP = "Surname";
	private static final String BIRTHDATE_GROUP = "Birthdate";

	private static final String AZ_PATTERN = "(?:[A-Z]([a-z])+)";
	private static final String FIRST_NAME_PATTERN = "(?<" + FIRST_NAME_GROUP + ">" + AZ_PATTERN + ")";
    private static final String SURNAME_PATTERN = "(?<" + SURNAME_GROUP + ">" + AZ_PATTERN + ")";

    private static final String YEAR_PATTERN = "(?:[0-9]{4})";
    private static final String MONTH_PATTERN = "(?:(?:[0][1-9])|(?:[1][0-2]))";
    private static final String DAY_PATTERN = "(?:(?:[0][1-9])|(?:[1-2][0-9])|(?:[3][0-1]))";
    private static final String SEP = "-";

    private static final String BIRTHDATE_PATTERN ="(?<" + BIRTHDATE_GROUP +">" + YEAR_PATTERN + SEP +MONTH_PATTERN +SEP+DAY_PATTERN+")";

    private static final String WHITESPACE_PATTERN = "(?:[ \t]+)";

    private static final String LINE_PATTERN =
            FIRST_NAME_PATTERN + WHITESPACE_PATTERN + SURNAME_PATTERN + WHITESPACE_PATTERN +BIRTHDATE_PATTERN;

    private static final Pattern REGEX = Pattern.compile(LINE_PATTERN);

	public static List<Person> parse(File file) {
	    List<Person> people = new ArrayList<>();
	try {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null)
        {
            Matcher matcher = REGEX.matcher(line);
             if (matcher.matches())
                people.add(new Person(matcher.group(FIRST_NAME_GROUP),matcher.group(SURNAME_GROUP),matcher.group(BIRTHDATE_GROUP)));
        }
    }catch (ParseException | IOException e) {
        e.printStackTrace();
    }
        return people;
}
}
