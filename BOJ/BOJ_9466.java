import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9466 {
    static int count;
    static int[] students;
    static boolean[] selected, check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int n = Integer.parseInt(br.readLine());
            count = 0;
            students = new int[n+1];

            selected = new boolean[n+1];
            check = new boolean[n+1];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int i=1; i<=n; i++){
                students[i] = Integer.parseInt(st.nextToken());
            }
            
            for(int i=1; i<=n; i++){
                if(selected[i]) continue;
                dfs(i);
            }

            System.out.println(n - count);
        }
    }

    public static void dfs(int student){
        if(selected[student]) return;

        if(check[student]) {
            selected[student] = true;
            count++;
        }

        check[student] = true;
        dfs(students[student]);
        selected[student] = true;
        check[student] = false;
    }
}
