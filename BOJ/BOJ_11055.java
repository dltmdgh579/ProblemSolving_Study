import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11055 {
    public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] map = new int [1000];
        int[] dp = new int[1000];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            map[i] = Integer.parseInt(st.nextToken());
            dp[i] = map[i];
        }

        int result = dp[0];

        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                if(map[j] < map[i]){
                    dp[i] = Math.max(dp[j] + map[i], dp[i]);
                    result = Math.max(result, dp[i]);
                }
            }
        }

        System.out.println(result);

    }
}