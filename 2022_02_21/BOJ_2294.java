import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2294 {
    static int n, k, min;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        int[] coin = new int[n];

        // 동전 가치 입력
        for(int i=0; i<n; i++){
            coin[i] = sc.nextInt();
        }

        // 배열의 인덱스는 가치의 합을 이루는 동전의 개수
        int[] dp = new int[k+1];
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0] = 0;

        // 동전의 개수 count
        for(int i=0; i<n; i++){
            for(int j=coin[i]; j<=k; j++){
                dp[j] = Math.min(dp[j], dp[j-coin[i]]+1);
            }
        }
        if(dp[k] == Integer.MAX_VALUE-1){ // 불가능한 경우
            System.out.println(-1);
        } else{
            System.out.println(dp[k]);
        }
    }

}
