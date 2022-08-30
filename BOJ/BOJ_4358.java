import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.Map.Entry;

public class BOJ_4358 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        TreeMap<String, Integer> trees = new TreeMap<>();
        String tree = br.readLine();
        int total = 0;

        while(true){
            trees.put(tree, trees.getOrDefault(tree, 0) + 1);
            total++;

            tree = br.readLine();
            if(tree == null) {
                break;
            }
        }

        for(Entry<String, Integer> t : trees.entrySet()){
            int count = t.getValue();
            double ratio = (double) (count * 100) / total;

            sb.append(t.getKey() + " " + String.format("%.4f", ratio) + "\n");
        }

        System.out.println(sb.toString());
    }
}