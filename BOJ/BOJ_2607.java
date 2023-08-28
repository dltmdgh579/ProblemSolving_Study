import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_2607 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result = 0;
        String firstWord = br.readLine();

        Map<Character, Integer> map = new HashMap<>();
        
        for(char alphabet : firstWord.toCharArray()){
            map.put(alphabet, map.getOrDefault(alphabet, 0) + 1);
        }
        
        Map<Character, Integer> tempMap = new HashMap<>(map);
        for(int i=1; i<N; i++){
            int noCount = 0;
            String word = br.readLine();

            for(char alphabet : word.toCharArray()){
                if(tempMap.containsKey(alphabet)){
                    if(tempMap.get(alphabet) <= 0) {
                        noCount++;
                        continue;
                    }
                    tempMap.replace(alphabet, tempMap.get(alphabet) - 1);
                } else {
                    noCount++;
                }
            }

            int sum = 0;
            for(int count : tempMap.values()){
                sum += count;
            }
            if(sum > 0) sum--;
            if(noCount > 0) noCount--;
            sum += noCount;

            tempMap = new HashMap<>(map);

            if(sum == 0) {
                result++;
            }
        }

        System.out.println(result);
    }
}
