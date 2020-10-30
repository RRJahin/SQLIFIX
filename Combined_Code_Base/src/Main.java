import ExtractQuery.Extract_Query_Main;
import GSP.GSP;
import AST_Builder.AST_Builder;
import clustering.Cluster;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        for(int i = 1; i <=669; i++) {
            File src = new File("Before/before_"+i+".java");
            File dst = new File("After/after_"+i+".java");
            try {
                System.out.println(i);
                AST_Builder.process(src, dst,i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String now ;
        for(int j=0;j<2;j++){
            if(j==0){
                now = "Before";
            }
            else{
                now = "After";
            }
            String basePath = now;

            File directoryPath = new File(basePath);
            String[] contents = directoryPath.list();

            for(int i = 0; i < contents.length; i++){  //contents.length
                System.out.println("******"+contents[i]);
                try {
                    Extract_Query_Main.Extractor(basePath, contents[i]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //break;
            }
            //break;
        }
        try {
            GSP.parse_Qeury();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            // It does not work with for the reason of permission issues.
            // We have to manually run this python file.
            System.out.println("Running Python file");
            Process process = Runtime.getRuntime().exec("python \"D:\\Thesis\\Getafix for SQLIV\\Combined_Code_Base\\json_edit.py\"");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while(true){
                String line = reader.readLine();
                if(line==null){
                    break;
                }
                System.out.println(line);
            }
        }catch(Exception e) {
            System.out.println("Exception Raised " + e.toString());
        }
        try {
            Cluster.cluster();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
