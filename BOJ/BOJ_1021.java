import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1021 {
    
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        LinkedList<Integer> dq = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++){
            dq.offer(i);
        }

        int[] seq = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for(int i=0; i<M; i++){
            int target = dq.indexOf(seq[i]);
            int half = 0;

            if(dq.size()%2 == 0){
                half = dq.size()/2 - 1;
            } else {
                half = dq.size()/2;
            }

            if(target <= half){
                for(int j=0; j<target; j++){
                    int tmp = dq.pollFirst();
                    dq.addLast(tmp);
                    count++;
                }
            } else {
                for(int j=0; j<dq.size() - target; j++){
                    int tmp = dq.pollLast();
                    dq.addFirst(tmp);
                    count++;
                }
            }
            dq.pollFirst();
        }
        System.out.println(count);
    }
}