package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ExtractQuery {

    public HashMap<String,String> extractQuery(String str, String file) {

        boolean foundQuote = false, vMode = false;
        String newQuery = "";
        HashMap<String, String> vNames = new HashMap<>();
        int t = 0;

        System.out.println("QQQQQQ "+str);

        str = str.replace("`", "'");
        str = str.replace("\"", " \" ");
        str = str.replace("+", " + ");
        str = str.replace(";", " ; ");
        str = str.replace("     ", " ");
        str = str.replace("    ", " ");
        str = str.replace("   ", " ");
        str = str.replace("  ", " ");

        String[] strings = str.split(" ");
        String data = "";
        String vName = "";

        for (int i = 0; i < strings.length; i++) {
            data = strings[i];

            if (data.contains("\"")) {
                foundQuote = !foundQuote;
                vMode = false;
                continue;
            }
            if (foundQuote) {
                newQuery += " " + data;
                continue;
            }
            if (data.contains("+")) {
                if (vMode) {
                    String temp = "X_" + System.currentTimeMillis() + t++;
                    newQuery += " "+temp;
                    vNames.put(temp, vName);
                    vName = "";
                }
                vMode = !vMode;
                continue;
            }
            if (vMode) {
                vName += " "+data;
                continue;
            }

        }

        if (vMode) {
            String temp = "X_" + System.currentTimeMillis() + t++;
            newQuery += " "+temp;
            vNames.put(temp, vName);
        }


        String[] strings2 = newQuery.split("'");
        newQuery = strings2[0];
        for (int i = 1; i < strings2.length; i += 2) {
            newQuery += "'" + strings2[i].trim() + "'";
            if (i + 1 < strings2.length)
                newQuery += strings2[i + 1];
        }

        int lp, rp;

        lp = rp = 0;
        for (int i = 0; i < newQuery.length(); i++) {
            if (newQuery.charAt(i) == '(')
                lp++;
            else if (newQuery.charAt(i) == ')')
                rp++;
        }
        if (rp > lp) {
            newQuery = newQuery.substring(0, newQuery.length() - 1);
        }

        System.out.println(newQuery);
        try {
            FileWriter myWriter = new FileWriter(file);
            myWriter.write(newQuery);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s : vNames.keySet()) {
            System.out.println(s + " " + vNames.get(s));
        }
        return vNames;
    }
}
