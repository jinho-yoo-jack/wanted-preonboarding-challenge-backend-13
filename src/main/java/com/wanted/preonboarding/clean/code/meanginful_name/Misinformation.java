package com.wanted.preonboarding.clean.code.meanginful_name;

import java.util.ArrayList;
import java.util.Arrays;

public class Misinformation {
    public void exampleCode1(){
        String accountList = "송혜교,전지현,김태희,고소영";
    }
    public void exampleCode2(){
        String accountGroup = "송혜교,전지현,김태희,고소영";
        ArrayList<String> accountList = (ArrayList<String>) Arrays.stream(accountGroup.split(",")).toList();
    }
}
