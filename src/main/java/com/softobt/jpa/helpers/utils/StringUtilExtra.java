package com.softobt.jpa.helpers.utils;

import com.google.common.base.Strings;

public final class StringUtilExtra {
    public static String convertFirstLettersEachWord(String str){
        if(Strings.isNullOrEmpty(str))return str;
        StringBuilder rsp = new StringBuilder();
        for(String s : str.split(" ")){
            rsp.append(convertFirstLetterInSentence(s)).append(" ");
        }
        return rsp.toString().trim();
    }

    public static String convertFirstLetterInSentence(String str){
        if(Strings.isNullOrEmpty(str))return str;
        return (str.substring(0,1).toUpperCase() + str.substring(1)).trim();
    }
}
