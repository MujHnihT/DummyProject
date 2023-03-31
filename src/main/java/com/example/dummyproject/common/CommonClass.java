package com.example.dummyproject.common;

public class CommonClass {
    public static String censorEmail(String email){
        int indexOfSymbol = email.indexOf("@");
        if(indexOfSymbol <= 3){
            return "**" + email.substring(indexOfSymbol-1);
        }else {
            return "***" + email.substring(indexOfSymbol-3);
        }
    }
}
