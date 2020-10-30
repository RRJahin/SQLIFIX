package AST_Builder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import gumtree.spoon.AstComparator;
import gumtree.spoon.builder.Json4SpoonGenerator;
import gumtree.spoon.builder.SpoonGumTreeBuilder;
import gumtree.spoon.diff.Diff;
import gumtree.spoon.diff.operations.*;
import spoon.reflect.declaration.CtElement;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AST_Builder {
    public static boolean isContained(CtElement op1, CtElement op2)
    {
        int op1Start = op1.getPosition().getLine();
        int op1End = op1.getPosition().getEndLine();
        int op2Start = op2.getPosition().getLine();
        int op2End = op2.getPosition().getEndLine();

        if((op1Start < op2Start) && (op1End > op2End))
        {
            return true;
        }
        else if((op1Start < op2Start) && (op1End >= op2End))
        {
            return true;
        }
        else if((op1Start <= op2Start) && (op1End > op2End))
        {
            return true;
        }
        else {
            return false;
        }
    }
    /*
        check a CtElement is a descendent of a list of CtElement
    */
    public static boolean isDescendent(List<CtElement> opList, CtElement op2)
    {
        int op2Start = op2.getPosition().getLine();
        int op2End = op2.getPosition().getEndLine();

        for(CtElement op1:opList) {
            int op1Start = op1.getPosition().getLine();
            int op1End = op1.getPosition().getEndLine();

            if(isContained(op1,op2))
            {
                return true;
            }
            else if(isContained(op2,op1))
            {
                opList.remove(op1);
                return false;
            }
            else if((op1Start == op2Start) && (op1End == op2End))
            {
                String op1Str = op1.toString().replaceAll("\\s+","");
                String op2Str = op2.toString().replaceAll("\\s+","");
                if(op1Str.contains(op2Str))
                {
                    return true;
                }
                else if(op2Str.contains(op1Str))
                {
                    opList.remove(op1);
                    return false;
                }
                else
                {
                    return true;
                }
            }
        }

        return false;
    }

    /*
        Dump the ast of difference in code into a json
    */

    public static void   convert2Json(List<CtElement> before, List<CtElement> after,List<Integer>beforeLine,
                                      List<Integer>afterLine, int id) throws Exception {
        Json4SpoonGenerator jsonGen = new Json4SpoonGenerator();

        JsonObject root = new JsonObject();
        JsonArray beforeEdits = new JsonArray();
        JsonArray afterEdits = new JsonArray();
        JsonArray beforeLines = new JsonArray();
        JsonArray afterLines = new JsonArray();
        JsonObject beforeTree = new JsonObject();
        JsonObject afterTree = new JsonObject();
        String beforeCode = "";
        String afterCode = "";

        beforeTree.addProperty("label", "edit_root");
        afterTree.addProperty("label", "edit_root");

        beforeTree.addProperty("type", "edit_unit");
        afterTree.addProperty("type", "edit_unit");
        for(int x: beforeLine){
            beforeLines.add(x);
        }
        for(int x: afterLine){
            afterLines.add(x);
        }

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


            beforeCode += ct.toString();
            beforeCode += "\n";

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

        root.addProperty("before_code",beforeCode);
        root.addProperty("after_code", afterCode);
        root.add("before_line",beforeLines);
        root.add("after_line",afterLines);
        root.add("before_tree",beforeTree);
        root.add("after_tree",afterTree);

        Gson gson =  new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
        String jsonStr = gson.toJson(root);

        File jsonFile = new File("Edit Trees/change_pair"+id+".json");
        jsonFile.createNewFile();
        FileWriter writer = new FileWriter(jsonFile);
        writer.write(jsonStr);
        writer.flush();
        writer.close();
        return;
    }

/*
    Given a starting and ending line number, convert them in a single line and get ast of that line
*/

    public static CtElement getContext(File orginal,int start,int end) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(orginal));
        int lines = 0; String context="";
        String read = "";
        while (true ){
            read=reader.readLine();
            if(read==null){
                break;
            }
            lines++;
            if(lines>=start && lines<=end){
                context+=read;
                context+=" ";
                //break;
            }
        }
        reader.close();
        context = context.trim();
        if(context.length()==0){
            return null;
        }
        Diff result = new AstComparator().compare("class x{void f(){"+context+"}}", "class x{void f(){}}");
        final List<Operation> allOps = result.getRootOperations();
        for(Operation op: allOps) {
            if(op instanceof DeleteOperation)
                return op.getSrcNode();
        }
        return null;
    }


    /*
        Find out if any code line contains execute
    */
    public static ArrayList<Integer> getExecuteLine(File orginal) throws IOException {
        ArrayList<Integer> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(orginal));
        int line = 0;
        String read = "";
        while (true ){
            read=reader.readLine();
            if(read==null){
                break;
            }
            line++;
            if(read.contains("execute")){
                lines.add(line);
            }



        }
        reader.close();
        return lines;
    }

    /*
        Process the difference of two file
    */
    public static void process(File src, File dst, int count) throws Exception {

        Diff result = new AstComparator().compare(src, dst);
        final List<Operation> allOps = result.getRootOperations();
        List<CtElement> before = new ArrayList<>();
        List<CtElement> after = new ArrayList<>();
        ArrayList<CtElement> sortedBefore = new ArrayList<>();
        ArrayList<CtElement> sortedAfter = new ArrayList<>();
        for (Operation op : allOps) {
            System.out.println(op);
            if (op instanceof InsertOperation) sortedAfter.add(op.getSrcNode());
            if (op instanceof DeleteOperation) sortedBefore.add(op.getSrcNode());
            if (op instanceof MoveOperation) {
                sortedBefore.add(op.getSrcNode());
                CtElement ct = (CtElement) op.getAction().getNode().getMetadata(SpoonGumTreeBuilder.SPOON_OBJECT_DEST);
                sortedAfter.add(ct);
            }
            if (op instanceof UpdateOperation) {
                sortedBefore.add(op.getSrcNode());
                sortedAfter.add(op.getDstNode());
            }
        }
        Comparator cmpCt = Comparator.comparing((CtElement op)->op.getPosition().getLine()) .thenComparing(op->-1*op.getPosition().getEndLine()) .thenComparing(op->-1*op.toString().length());
        Collections.sort(sortedBefore, cmpCt);
        Collections.sort(sortedAfter, cmpCt);
        for(CtElement ct: sortedBefore) {
            if(!isDescendent(before,ct)) before.add(ct);
        }
        for(CtElement ct: sortedAfter)
        {
            if(!isDescendent(after,ct))
                after.add(ct);
        }

        List<CtElement> before1=new ArrayList<>();
        List<Integer> beforeLine = new ArrayList<>();
        List<CtElement> after1=new ArrayList<>();
        List<Integer> afterLine = new ArrayList<>();

        System.out.println("Before----->");
        for(CtElement op: before) {

            int pos = op.getPosition().getLine();
            int endPos = op.getPosition().getEndLine();

            CtElement current_context = getContext(src,pos,endPos);
            if(current_context!=null){
                beforeLine.add(pos);
                before1.add(current_context);
            }


        }
        ArrayList<Integer> lines = getExecuteLine(dst);
        int prev = -1;
        int now = -1;
        if(lines.size()!=0){
            now=0;
            prev=lines.get(now);
        }
        System.out.println("After----->");
        for(CtElement op: after) {
            int pos = op.getPosition().getLine();
            int endPos = op.getPosition().getEndLine();
            if(prev!=-1){
                if(pos>prev){
                    CtElement current_context = getContext(dst,prev,prev);
                    if(current_context!=null){
                        afterLine.add(prev);
                        after1.add(current_context);
                    }

                    if(now!=lines.size()-1){
                        now++;
                        prev=lines.get(now);
                    }
                    else{
                        now=-1;
                        prev=-1;
                    }
                }
                else if(pos==prev){
                    if(now!=lines.size()-1){
                        now++;
                        prev=lines.get(now);
                    }
                    else{
                        now=-1;
                        prev=-1;
                    }
                }
            }
            CtElement current_context = getContext(dst,pos,endPos);
            if(current_context!=null){
                afterLine.add(pos);
                after1.add(current_context);
            }
        }
        if(prev!=-1){
            CtElement current_context = getContext(dst,prev,prev);
            if(current_context!=null){
                afterLine.add(prev);
                after1.add(current_context);
            }


        }
        convert2Json(before1, after1,beforeLine,afterLine, count);
        return;
    }
}
