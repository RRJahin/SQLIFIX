package ExtractQuery;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;


import java.io.*;
import java.util.ArrayList;import java.util.List;


public class Extract_Query_Main {
    static class Info{
        ArrayList<Integer> lines = new ArrayList<>();
        String stmt, str, query;
    }
    static List<Info> infoSet=new ArrayList<>();
    static ExtractQuery eq = new ExtractQuery();


    public static void FindExecute(File file){
        //System.out.println("fff"+file.getName());
        try {
            new VoidVisitorAdapter<Object>() {
                @Override
                public void visit(MethodCallExpr n, Object arg) {
                    super.visit(n, arg);
                    //System.out.println(n.getNameAsString());
                    if(n.getArguments().isNonEmpty() && (n.getNameAsString().equals("prepareStatement")
                            || n.getNameAsString().equals("executeUpdate")
                            || n.getNameAsString().equals("executeQuery") || n.getNameAsString().equals("execute"))) {
                        //System.out.println("**" + n.getNameAsString());
                        Info info = new Info();
                        for(int i = n.getBegin().get().line; i <= n.getEnd().get().line; i++)
                            info.lines.add(n.getBegin().get().line);
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
                                info.lines.add(n.getBegin().get().line);
                            list.add(n.getBegin().get().line);
                        }
                        else if(n.getInitializer().isPresent() && n.getName().toString().equals(info.str)
                                && n.getBegin().get().line < info.lines.get(0) && !list.contains(n.getBegin().get().line)){
                            //System.out.println(n.getName().toString() + " " + n.getBegin().get().line);
                            for(int i = n.getBegin().get().line; i <= n.getEnd().get().line; i++)
                                info.lines.add(n.getBegin().get().line);
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
                        //System.out.println(n);
                        if ((n.getTarget().toString().equals(info.stmt) || n.getTarget().toString().equals(info.str))
                                && n.getBegin().get().line < info.lines.get(0) && !list.contains(n.getBegin().get().line)) {
                            System.out.println(n.getTarget() + " " + n.getBegin().get().line);
                            for(int i = n.getBegin().get().line; i <= n.getEnd().get().line; i++)
                                info.lines.add(n.getBegin().get().line);
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

    public static void Extractor(String basePath, String fileName)  {
        File file = new File(basePath+"\\"+fileName);
        if(file.isDirectory()) return;

        /////***** Parse file by selecting line numbers ******////
        infoSet.clear();

        FindExecute(file);
        FindStmtStr(file);
        System.out.println(infoSet.size());
        String[] ffName = fileName.split("[.]");
        int i = 1;
        for(Info info: infoSet) {

            if(info.query == null) continue;
            try {
                File f = new File(basePath+"\\Temp\\"+ffName[0]);

                if(!f.exists()) f.mkdir();
                FileWriter myWriter = new FileWriter(basePath+"\\Temp\\"+ffName[0]+"\\String"+i+".txt");
                myWriter.write(info.query);
                myWriter.close();
                eq.Extract(info.query,basePath+"\\Temp\\"+ffName[0]+"\\Query"+i+".sql", basePath+"\\Temp\\"+ffName[0]+"\\Map"+i+".txt");
                System.out.println(info.query);
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }

    }

}

