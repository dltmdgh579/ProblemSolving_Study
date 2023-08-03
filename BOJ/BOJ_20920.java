import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_20920 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++){
            String word = br.readLine();

            if(word.length() < M) continue;
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> list = map.keySet().stream().collect(Collectors.toList());

        list.sort((o1, o2) -> {
            int countA = map.get(o1);
            int countB = map.get(o2);

            if(countA == countB){
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                return o2.length() - o1.length();
            }
            return countB - countA;
        });

        StringBuilder sb = new StringBuilder();
        for(String word : list){
            sb.append(word).append('\n');
        }
        System.out.println(sb.toString());
    }
}
