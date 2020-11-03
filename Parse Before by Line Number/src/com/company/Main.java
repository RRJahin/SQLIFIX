package com.company;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.eclipse.jdt.internal.core.nd.db.IString;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Info{
    ArrayList<Integer> lines = new ArrayList<>();
    String stmt, str, query;
}

class Info2{
    int line;
    String stmt, con;
}

public class Main {

    static List<Info> infoSet=new ArrayList<>();
    static List<Info2> infoSet2=new ArrayList<>();
    static int create = 0, execute = 0;
    static String con = "";
    static ExtractQuery eq = new ExtractQuery();

    public static String toPrettyFormat(String jsonString)
    {
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(jsonString).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(json);

        return prettyJson;
    }

    public static void FindExecute(File file){
        System.out.println("fff"+file.getName());
        try {
            new VoidVisitorAdapter<Object>() {
                @Override
                public void visit(MethodCallExpr n, Object arg) {
                    super.visit(n, arg);
                    //System.out.println(n.getNameAsString());
                    if(n.getArguments().isNonEmpty() && (n.getNameAsString().equals("executeUpdate")
                            || n.getNameAsString().equals("executeQuery") || n.getNameAsString().equals("execute"))) {
                        //System.out.println("**" + n.getNameAsString());
                        Info info = new Info();
                        for(int i = n.getBegin().get().line; i <= n.getEnd().get().line; i++)
                            info.lines.add(i);
                        if(n.getArguments().get(0).getMetaModel().toString().equals("NameExpr")){
                            info.str = n.getArguments().get(0).toString();
                        }
                        else{
                            info.query = n.getArguments().get(0).toString();
                            info.str = "";
                        }
                        info.stmt = n.getChildNodes().get(0).toString();

                        infoSet.add(info);
                    }

                }
            }.visit(JavaParser.parse(file), null);
            // System.out.println(); // empty line
        } catch (RuntimeException e) {
            new RuntimeException(e);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void FindStmtStr(File file){
        List<Integer> list = new ArrayList<>();
        ///If as Declaration
        ///If as Assignment
        infoSet.forEach(info -> {

            try {
                new VoidVisitorAdapter<Object>() {
                    @Override

                    public void visit(VariableDeclarator n, Object arg) {
                        super.visit(n, arg);
                        //if(n.getName().toString().equals(info.stmt))System.out.println(info.stmt);
                        if (n.getName().toString().equals(info.stmt) && n.getBegin().get().line < info.lines.get(0)
                                && !list.contains(n.getBegin().get().line)) {
                            //System.out.println(n.getName().toString() + " " + n.getBegin().get().line);
                            for(int i = n.getBegin().get().line; i <= n.getEnd().get().line; i++)
                                info.lines.add(i);
                            list.add(n.getBegin().get().line);
                        }
                        else if(n.getInitializer().isPresent() && n.getName().toString().equals(info.str)
                                && n.getBegin().get().line < info.lines.get(0) && !list.contains(n.getBegin().get().line)){
                            //System.out.println(n.getName().toString() + " " + n.getBegin().get().line);
                            for(int i = n.getBegin().get().line; i <= n.getEnd().get().line; i++)
                                info.lines.add(i);
                            list.add(n.getBegin().get().line);
                            info.query = n.getInitializer().get().toString();
                        }
                    }
                }.visit(JavaParser.parse(file), null);
            } catch (RuntimeException e) {
                new RuntimeException(e);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                new VoidVisitorAdapter<Object>() {
                    @Override

                    public void visit(AssignExpr n, Object arg) {
                        super.visit(n, arg);

                        if ((n.getTarget().toString().equals(info.stmt) || n.getTarget().toString().equals(info.str))
                                && n.getBegin().get().line < info.lines.get(0) && !list.contains(n.getBegin().get().line)) {
                            //System.out.println(n.getTarget() + " " + n.getBegin().get().line);
                            for(int i = n.getBegin().get().line; i <= n.getEnd().get().line; i++)
                                info.lines.add(i);
                            list.add(n.getBegin().get().line);
                            if(n.getTarget().toString().equals(info.str)){
                                info.query = n.getValue().toString();
                            }
                        }

                    }
                }.visit(JavaParser.parse(file), null);
            } catch (RuntimeException e) {
                new RuntimeException(e);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //System.out.println("QQQQQQQQQ "+info.query);
        });
    }

    public static void FindProb(File file){
        //System.out.println("Method Call:");

        try {
            new VoidVisitorAdapter<Object>() {
                @Override

                public void visit(MethodCallExpr n, Object arg) {
                    super.visit(n, arg);

                    if(n.getNameAsString().equals("createStatement")) {
                        //System.out.println(n.getNameAsString() + " " + n.getChildNodes().get(0).toString()
                                //+ " " + n.getParentNode().toString() + " " + n.getParentNode().get().getParentNode().toString());
                        create++;
                        con = n.getChildNodes().get(0).toString();
                    }
                    else if(n.getNameAsString().equals("executeUpdate") || n.getNameAsString().equals("executeQuery") || n.getNameAsString().equals("execute")){
                        execute++;
                        if(execute > create){
                            Info2 info = new Info2();
                            info.con = con;
                            info.stmt = n.getChildNodes().get(0).toString();
                            info.line = n.getBegin().get().line;
                            create++;
                            infoSet2.add(info);
                        }
                    }

                }
            }.visit(JavaParser.parse(file), null);
            // System.out.println(); // empty line
        } catch (RuntimeException e) {
            new RuntimeException(e);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void ParseBefore(String basePath, String fileName) throws Exception {
        File file = new File(basePath+"\\"+fileName);
        if(file.isDirectory()) return;

        ///***** Find if Redundant createStatement() needed *****///
        infoSet2.clear();
        FindProb(file);
        int j = 1;
        for(Info2 info: infoSet2) {
            System.out.println("*** createStatement() added ");
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            String code = "", line = raf.readLine();
            int i = 1;
            do{
                code += line+"\n";
                if(i+j == info.line)
                    code += info.stmt+" = " + info.con + ".createStatement();\n";
                line = raf.readLine();
                i++;
            }while(line != null);
            raf.close();
            FileWriter myWriter = new FileWriter(file);
            myWriter.write(code);
            myWriter.close();
            j--;
        }

        /////***** Parse file by selecting line numbers ******////
        infoSet.clear();
        FindExecute(file);
        FindStmtStr(file);
        //System.out.println(fileName);
        String[] ffName = fileName.split("[.]");
        int i = 0;
        for(Info info: infoSet) {
            if(info.query == null) continue;
            HashMap<String, String> hash = eq.extractQuery(info.query,basePath+"\\Query\\"+ffName[0]+"_"+i+".sql");

            Collections.sort(info.lines);
            String json = new AstBuilder(file,info.lines,hash).getTargetAst();
            FileWriter fw = new FileWriter(basePath+"\\Edit Trees\\"+ffName[0]+"_"+i+".json");
            i += 1;
            fw.write(toPrettyFormat(json));
            fw.close();
            //System.out.println("llll"+info.lines);
        }


        //String basePath = "C:\\Users\\shami\\Documents\\Undergrad-Thesis\\Getafix Code\\Dataset_Large - Train Test Split\\Test_Before";


        //System.out.println(toPrettyFormat(json));

        //JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();

        //File out = new File("tree.json");

    }

    public static void main(String[] args) throws Exception {
        String basePath = "C:\\Users\\shami\\Documents\\Undergrad-Thesis\\Getafix Code\\TEST2";

        //File file = new File(basePath+"\\before_27.java");
        //FindExecute(file);
        //ParseBefore(basePath, "before_27.java");
        File directoryPath = new File(basePath);
        String[] contents = directoryPath.list();

        for(int i = 0; i < contents.length; i++){  //contents.length
            System.out.println("******"+contents[i]);
            ParseBefore(basePath, contents[i]);
        }
        //ExtractQuery ex = new ExtractQuery();
        //ex.extractQuery(basePath+"\\string1.txt",basePath+"\\query1.sql");
    }
}
