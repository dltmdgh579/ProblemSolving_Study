import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019 {
    static class Register{
        int num;
        String cal;
        public Register(int num, String cal){
            this.num = num;
            this.cal = cal;
        }
    }
    static int a, b; 
    static String[] cal = {"D", "S", "L", "R"};
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            // 최소한의 명령어 찾기 -> bfs
            sb.append(bfs()).append("\n"); 
        }
        System.out.println(sb.toString());

    }

    public static String bfs(){
        Queue<Register> q = new LinkedList<>();
        q.offer(new Register(a, ""));
        visited = new boolean[10000];
        visited[a] = true;

        while(!q.isEmpty()){
            Register cur = q.poll();

            if(cur.num == b){
                return cur.cal;
            }

            // D, S, L, R 모두 계산
            for(int i=1; i<=4; i++){
                int next = calc(i, cur.num);
                if(!visited[next]){
                    q.offer(new Register(next, cur.cal + cal[i-1]));
                    visited[next] = true;
                }
            }
        }
        return "";
    }
    
    public static int calc(int i, int cur){
        // 1:D, 2:S, 3:L, 4:R
        if(i == 1){
            return (2*cur)%10000;
        } else if(i == 2){
            if(cur == 0) return 9999;
            else return cur-1;
        } else if(i == 3){
            return cur%1000 * 10 + cur/1000;
        }else {
            return cur%10 * 1000 + cur/10;
        }
    }
}
