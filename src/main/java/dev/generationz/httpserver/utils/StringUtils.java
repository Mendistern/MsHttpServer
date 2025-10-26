package dev.generationz.httpserver.utils;

public class StringUtils {
    public static String removeDoubleSpaces(String input){
        if(input==null){
            throw new IllegalArgumentException("Cannot remove double spaces from empty string");
        }

        char[] chars = input.toCharArray();
        boolean isLastCharASpace = false;
        StringBuilder sb = new StringBuilder();

        for ( int i=0; i<chars.length; i++) {
            if(chars[i]!=' '){
                sb.append(chars[i]);
                isLastCharASpace = false;
            }else{
                if(isLastCharASpace==true){
                    continue;
                }
                isLastCharASpace =true;
                sb.append(' ');
            }
        }

        return sb.toString();
    }
}
