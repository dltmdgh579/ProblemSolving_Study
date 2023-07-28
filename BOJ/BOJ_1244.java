import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int[] switchState = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++){
            switchState[i] = Integer.parseInt(st.nextToken());
        }

        int students = Integer.parseInt(br.readLine());

        for(int i=0; i<students; i++){
            st = new StringTokenizer(br.readLine());

            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(sex == 1){
                int tmp = num;
                while(num <= N){
                    switchState[num] = switchState[num] == 1 ? 0 : 1;
                    num += tmp;
                }
            } else {
                int idx = 1;
                while(true){
                    if(num-idx < 1 || num + idx > N) break;
                    if(switchState[num-idx] == switchState[num+idx]) idx++;
                    else break;
                }
                idx--;
                for(int j=num-idx; j<=num+idx; j++){
                    switchState[j] = switchState[j] == 1 ? 0 : 1;
                }
            }
        }

        for(int i=1; i<=N; i++){
            sb.append(switchState[i]).append(" ");
            if(i%20 == 0) sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}
