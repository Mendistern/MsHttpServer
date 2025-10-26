package dev.generationz.httpserver.parsers;

import dev.generationz.httpserver.model.FirstLine;
import dev.generationz.httpserver.model.enums.MsMethod;
import dev.generationz.httpserver.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Locale;

public class FirstLineParser {

    private static final Logger log = LoggerFactory.getLogger(FirstLineParser.class);

    private static FirstLineParser instance;

    private FirstLineParser() {
    }

    public FirstLine parseFirstLine(String firstLineStr) {
        if (firstLineStr == null || firstLineStr.isBlank()) {
            throw new IllegalArgumentException("First line of HTTP request cannot be empty");
        }

        firstLineStr = StringUtils.removeDoubleSpaces(firstLineStr);
        String[] splitted = firstLineStr.split(" ");
        if (splitted.length != 3) {
            throw new IllegalArgumentException("The first line of an HTTP request may only contain 3 parts (method, location, and version");
        }

        FirstLine firstLine = new FirstLine();
        firstLine.setMethod(MsMethod.valueOf(splitted[0].toUpperCase(Locale.ROOT)));
        firstLine.setLocation(splitted[1]);
        firstLine.setVersion(splitted[2]);

        return firstLine;
    }


    public static FirstLineParser getInstance() {
        if (instance == null) {
            instance = new FirstLineParser();
        }
        return instance;
    }
}
