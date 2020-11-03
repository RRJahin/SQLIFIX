package com.company;

import com.google.gson.*;
import gumtree.spoon.AstComparator;
import gumtree.spoon.builder.Json4SpoonGenerator;
import gumtree.spoon.diff.Diff;
import gumtree.spoon.diff.operations.Operation;
import org.apache.commons.io.FileUtils;
import spoon.reflect.declaration.CtElement;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AstBuilder {
    File file;
    ArrayList<Integer> lineNum;
    HashMap<String, String> hash;
    AstBuilder(File file, ArrayList<Integer> lineNum, HashMap<String, String> hash){
        this.file = file;
        this.lineNum = lineNum;
        this.hash = hash;
    }
    String getTargetAst() throws Exception {
        List<CtElement> before = new ArrayList<>();
        String beforeCode = "";
        List<CtElement> after = new ArrayList<>();
        String afterCode = "";
        for(Integer x: lineNum){
            String line = (String) FileUtils.readLines(file).get(x-1);
            //int a = 0;
            //while(true){
                //if (line.contains(";")) break;
                //line += " "+(String)FileUtils.readLines(file).get(x + a).trim();
                //a++;
            //}
            System.out.println(line);
            beforeCode += line;
            Diff result = new AstComparator().compare("class dummy{void f(){"+line+"}}" ,"class dummy{void f(){}}");
            final List<Operation> allOps = result.getRootOperations();


            for(Operation op: allOps) {
                before.add(op.getSrcNode());
            }
        }

        return convert2Json(before,after,beforeCode);
    }
    public String convert2Json(List<CtElement> before, List<CtElement> after, String bCode) throws Exception {
        Json4SpoonGenerator jsonGen = new Json4SpoonGenerator();

        JsonObject root = new JsonObject();
        JsonArray beforeEdits = new JsonArray();
        JsonArray afterEdits = new JsonArray();
        JsonObject beforeTree = new JsonObject();
        JsonObject hashMap = new JsonObject();
        JsonObject afterTree = new JsonObject();
        String beforeCode = "";
        String afterCode = "";

        for(String st: hash.keySet())
            hashMap.addProperty(st,hash.get(st));

        beforeTree.addProperty("label", "edit_root");
        afterTree.addProperty("label", "edit_root");

        beforeTree.addProperty("type", "edit_unit");
        afterTree.addProperty("type", "edit_unit");

        for(CtElement ct: before)
        {
            JsonObject ctJson = jsonGen.getJSONasJsonObject(ct);

            if(ctJson.getAsJsonArray("children").size() == 1)
            {
                JsonObject child = ctJson.getAsJsonArray("children").get(0).getAsJsonObject();
                beforeEdits.add(child);
            }
            else
            {
                beforeEdits.add(ctJson);
                System.out.println("Anomaly-----------?");
            }


            //beforeCode += ct.toString();
            //beforeCode += "\n";

        }

        for(CtElement ct: after)
        {
            JsonObject ctJson = jsonGen.getJSONasJsonObject(ct);

            if(ctJson.getAsJsonArray("children").size() == 1)
            {
                JsonObject child = ctJson.getAsJsonArray("children").get(0).getAsJsonObject();
                afterEdits.add(child);
            }
            else
            {
                afterEdits.add(ctJson);
                System.out.println("Anomaly-----------?");
            }

            afterCode += ct.toString();
            afterCode += "\n";
        }


        beforeTree.add("children", beforeEdits);
        afterTree.add("children", afterEdits);

        root.addProperty("before_code",bCode);
        root.add("before_hashMap", hashMap);
        root.addProperty("after_code", afterCode);
        root.add("before_tree",beforeTree);
        root.add("after_tree",afterTree);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonStr = gson.toJson(root);

        return jsonStr;
    }

}
