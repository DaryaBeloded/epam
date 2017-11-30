package com.company.parse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dasha on 22.10.2017.
 */
public final class Parser {
    public static String[] parse(String expression) {
        Pattern pattern = Pattern.compile("^[0-9]{1,10}\\.?([0-9]?){1,10}[+\\-/*][0-9]{1,10}\\.?([0-9]?){1,10}$");
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            String[] a = matcher.group().split("[+\\-/*]");
            return a;
        } else {
            return null;
        }
    }

    public static String getSignFromString(String expression){
        if (expression.contains("+")) {
            return "+";
        }
        if (expression.contains("-")) {
            return "-";
        }
        if (expression.contains("*")) {
            return "*";
        }
        if (expression.contains("/")) {
            return "/";
        }
        return null;
    }


    public Parser(){}
}
