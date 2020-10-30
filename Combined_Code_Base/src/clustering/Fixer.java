package clustering;

import com.google.gson.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class Fixer {
    public static String toPrettyFormat(String jsonString)
    {
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(jsonString).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(json);

        return prettyJson;
    }

    static ArrayList<FixerEditPattern> patterns;
    static ArrayList<ReplaceSuggestion> replaceSuggestions;
    public static void fixer(List<Integer> test_list)  {

        int count=  0;
        for(int i=0;i<test_list.size();i++){
            System.out.println(test_list.get(i));
        }
        for(int i=0;i<test_list.size();i++) {
            String filename = "dendogram.json";
            Gson gson = new Gson();
            JsonObject jsonObject;
            try {
                jsonObject = gson.fromJson(new FileReader("Edit Trees\\change_pair"+test_list.get(i)+ ".json"), JsonObject.class);
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                continue;
            }
            System.out.print("for "+test_list.get(i)+": ");

            FixerEditPattern target = new FixerEditPattern(jsonObject.getAsJsonObject("before_tree"), jsonObject.getAsJsonObject("after_tree"));
            try {

                JsonObject root = gson.fromJson(new FileReader(filename), JsonObject.class);
                patterns = new ArrayList<>();
                getEditPatterns(root, target);

                JsonObject obj = new JsonObject();
                obj.add("target", target.beforePattern);
                System.out.println(patterns.size());
                for (int j = 0; j < patterns.size(); j++) {
                    //System.out.println("From suggestion "+j+":");

                    PatternMatcher pm = new PatternMatcher();
                    replaceSuggestions = new ArrayList<>();
                    pm.antiUnify(target.beforePattern,patterns.get(j).beforePattern,true);

                    String afterString = patterns.get(j).afterPattern.toString();
                    String afterCode = patterns.get(j).afterCode;
                    //System.out.println(replaceSuggestions.size());
                    //System.out.println(afterCode);
                    for(ReplaceSuggestion replaceSuggestion: replaceSuggestions){
                        //System.out.println("After: "+replaceSuggestion.after.toString()+" Before: "+replaceSuggestion.before.toString());
                        afterString=afterString.replace(replaceSuggestion.before.toString().replace("\"",""),replaceSuggestion.after.toString().replace("\"",""));
                        afterCode=afterCode.replace(replaceSuggestion.before.toString().replace("\"",""),replaceSuggestion.after.toString().replace("\"",""));

                    }
                   // System.out.println(afterCode);

                    JsonParser jsonParser = new JsonParser();
                    patterns.get(j).afterPattern = (JsonObject)jsonParser.parse(afterString);
                    patterns.get(j).afterCode=afterCode;
                   //obj.add("unified" + j, unified);
                    obj.add("suggestion" + j, patterns.get(j).convert2Json());
                }

                //System.out.println(toPrettyFormat(obj.toString()));
                //System.out.println(patterns.size());
                if(patterns.size()!=0){
                    count++;
                }
                File solution = new File("output\\output"+test_list.get(i)+".json");
                FileWriter fileWriter = new FileWriter(solution);
                fileWriter.write(toPrettyFormat(obj.toString()));
                fileWriter.flush();
                fileWriter.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        System.out.println("Solution found for "+count+" out of "+test_list.size()+" \nSolution found rate: "+((count*100.0)/test_list.size()));
    }

    public static FixerEditPattern getEditPatterns(JsonObject obj,FixerEditPattern target)
    {

        //should have done a null check and return zero otherwise sum of (1+nodes in child(i) for all i )
        JsonArray children = obj.getAsJsonArray("children");
        if (children.size() != 0) {
            for (int i = 0; i < children.size(); i++) {
                if (Match(children.get(i).getAsJsonObject().get("before_pattern").getAsJsonObject(), target.beforePattern)) {
                    //System.out.println("**Match:"+children.get(i).getAsJsonObject().get("before_pattern").toString());

                    getEditPatterns(children.get(i).getAsJsonObject(), target);
                }
//                else {
//                    //System.out.println("noMatch"+children.get(i).getAsJsonObject().get("before_pattern").toString());
//                }
            }
        }
        if(children.size()==0){
            patterns.add(new FixerEditPattern(obj,0));
//            Set<Map.Entry<String, JsonElement>> entries = obj.entrySet();//will return members of your object
//            for (Map.Entry<String, JsonElement> entry: entries) {
//                System.out.println(entry.getKey());
//            }
            //System.out.println("*** Suggestion:  "+obj.get("pattern_id").toString());
        }

        return new FixerEditPattern(obj,0);
    }

    public static boolean Match(JsonObject suggestionBT, JsonObject targetBT){
        //System.out.println(suggestionBT);
        String labelS = suggestionBT.get("label").getAsString();
        String labelT = targetBT.get("label").getAsString();
        String typeS = suggestionBT.get("type").getAsString();
        String typeT = targetBT.get("type").getAsString();
        JsonArray childrenS = suggestionBT.getAsJsonArray("children");
        JsonArray childrenT = targetBT.getAsJsonArray("children");

        /*if(map.containsKey(labelS)) {
            if (!map.get(labelS).equals(labelT)) return false;
        }
        else{
            if(map.containsValue(labelT)) return false;
            map.put(labelS,labelT);
        }*/

        if(!typeS.equals("?") && !typeS.equals(typeT)) return false;

        if(labelS.contains("hole_")) return true;

        if(childrenS.size() != childrenT.size()) return false;
        else{
            for(int i = 0; i < childrenS.size(); i++){
                JsonObject chS = childrenS.get(i).getAsJsonObject();
                JsonObject chT = childrenT.get(i).getAsJsonObject();
                if(!Match(chS, chT)) return false;
            }
        }

        return true;
    }
}
