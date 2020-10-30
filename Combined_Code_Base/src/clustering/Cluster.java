package clustering;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.Random;

public class Cluster {
    public static void cluster() throws Exception {
        BufferedReader reader;
        List<Integer> test_list = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(
                    "test_list.txt"));
            String line = reader.readLine();
            while (line != null) {
                test_list.add(Integer.parseInt(line));
                //System.out.println(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(test_list.size());
/*


*/   /*   List<Integer>list= new ArrayList<>();
for(int i=1;i<=669;i++){
    list.add(i);
}
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {

            // take a raundom index between 0 to size
            // of given List
            int randomIndex = rand.nextInt(list.size());

            // add element in temporary list
            test_list.add(list.get(randomIndex));

            // Remove selected element from orginal list
            list.remove(randomIndex);
        }*/
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String directory = "Edit Trees";
        int count = 669;
        PatternMatcher pm = new PatternMatcher();
        pm.Init(directory, count,test_list);
        EditPattern editClusters = pm.cluster();
        JsonObject dendogram = editClusters.convert2Json();
        String data = gson.toJson(dendogram);

        FileWriter writer = new FileWriter("dendogram.json");
        writer.write(data);
        writer.flush();
        writer.close();
        Fixer.fixer(test_list);
    }
}
