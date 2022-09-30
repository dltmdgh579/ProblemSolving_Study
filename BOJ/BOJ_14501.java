import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501 {

	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int max = 0;
        int[] dp = new int[N+1];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            if(i+T-1 > N) continue;
            if(dp[i-1] + P > dp[i+T-1]){
                dp[i+T-1] = dp[i-1] + P;
                for(int j=i+T; j<=N; j++){
                    dp[j] = Math.max(dp[j], dp[i+T-1]);
                }
            }
            // dp[i+T-1] = Math.max(dp[i+T-2] + P, dp[i+T-1]);
            max = Math.max(max, dp[i+T-1]);

        }

        System.out.println(max);

	}
}