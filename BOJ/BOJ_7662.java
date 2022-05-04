import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_7662 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int tc=0; tc<T; tc++){
            int k = Integer.parseInt(br.readLine());

            // 우선순위큐 2개로 풀이시 시간초과
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();

            for(int i=0; i<k; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
    
                String oper = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
    
                // 삽입연산
                if(oper.equals("I")){
                    // 해당 정수가 없으면 default 값 1, 있으면 현재 count + 1
                    treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
                } 
                // 삭제연산
                else {
                    if(treeMap.isEmpty()) continue;
                    // 최솟값 삭제
                    if(num == -1){
                        int minKey = treeMap.firstKey();
                        // 현재 treeMap에 해당 key가 한 개 남아있을 경우
                        if(treeMap.get(minKey) == 1){
                            treeMap.remove(minKey);
                        } 
                        // 한 개 보다 많을 경우 1 감소
                        else {
                            treeMap.put(minKey, treeMap.get(minKey) - 1);
                        }
                    } 
                    // 최댓값 삭제
                    else {
                        int maxKey = treeMap.lastKey();
                        if(treeMap.get(maxKey) == 1){
                            treeMap.remove(maxKey);
                        } else {
                            treeMap.put(maxKey, treeMap.get(maxKey) - 1);
                        }
                    }
                }
            }
            if(treeMap.isEmpty()){
                sb.append("EMPTY\n");
            } else {
                sb.append(treeMap.lastKey() + " " + treeMap.firstKey()).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
