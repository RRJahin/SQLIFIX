package ExtractQuery;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class ExtractQuery {

    public void Extract(String query, String qPath, String vPath) {

        boolean foundQuote = false, foundConcat = false, vMode = false, putSQuote = false;
        String newQuery = "";
        HashMap<String, String> vNames = new HashMap<>();
        int t = 0;

        String str = query;

        // System.out.println("-" + str + "-");
        str = str.replace("`", "'");
        str = str.replace("\"", " \" ");
        str = str.replace("+", " + ");
        str = str.replace(";", " ; ");
        str = str.replace("     ", " ");
        str = str.replace("    ", " ");
        str = str.replace("   ", " ");
        str = str.replace("  ", " ");
        // str = str.replace("("," ( ");
        // str = str.replace(")"," ) ");
        // System.out.println(data);

        String[] strings = str.split(" ");
        String data = "";
        String vName = "";

        // System.out.println(strings.length);

        // for(int i = 0; i < strings.length; i++) System.out.println(strings[i]);
        for (int i = 0; i < strings.length; i++) {
            data = strings[i];


            if (data.contains("\"")) {
                foundQuote = !foundQuote;
                // if (foundQuote)
                foundConcat = false;
                vMode = false;
                // newQuery += " " + data.replace("\"", "");
                continue;
                // System.out.println(data.replace("\"", ""));
            }

            if (foundQuote) {
                newQuery += " " + data;
                continue;
            }

            if (data.contains("+")) {
                if (vMode) {
                    String temp = "X_" + System.currentTimeMillis() + t++;
                    if (!vNames.containsKey(vName))
                        vNames.put(vName, temp);
                    newQuery += " " + vNames.get(vName);
                    vName = "";
                }
                vMode = !vMode;
                continue;
            }

            if (vMode) {
                // newQuery += " " + data;
                vName += " " + data;
                // foundConcat = false;

            }

        }
        if (vMode) {
            String temp = "X_" + System.currentTimeMillis() + t++;
            if (!vNames.containsKey(vName))
                vNames.put(vName, temp);
            newQuery += " " + vNames.get(vName);
        }

        strings = newQuery.split("'");
        newQuery = strings[0];
        for (int i = 1; i < strings.length; i += 2) {
            newQuery += "'" + strings[i].trim() + "'";
            if (i + 1 < strings.length)
                newQuery += strings[i + 1];
        }

        // System.out.println(newQuery);

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
            // System.out.println("******" + newQuery);
        }

        // newQuery = newQuery.replace("''", "'");
        System.out.println(newQuery);
        try {
            FileWriter myWriter = new FileWriter(qPath);
            myWriter.write(newQuery);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter(vPath);
            for (String s : vNames.keySet()) {
                System.out.println(s + " " + vNames.get(s));
                myWriter.write(s + "$" + vNames.get(s) + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

