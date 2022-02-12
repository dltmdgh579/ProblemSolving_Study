import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11286{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 우선순위 큐 재정의
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) ->{
            if(Math.abs(o1) == Math.abs(o2)) return o1 - o2; // 절댓값 같을 경우 원본 비교
            return Math.abs(o1) - Math.abs(o2); // 절댓값 비교
        });

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(pq.isEmpty()) 
                    sb.append(0 + "\n"); // 배열 크기가 0일때 0 출력
                else 
                    sb.append(pq.poll() + "\n"); // 0 입력시 출력
            } else{
                pq.offer(num);
            }
        }
        System.out.println(sb);

    }
}