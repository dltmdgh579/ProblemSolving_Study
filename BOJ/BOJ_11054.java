import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11054 {
    static int max;
    static int[] A, dp_left, dp_right, dp_result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
    
        A = new int[N];
        dp_left = new int[N];
        dp_right = new int[N];
        dp_result = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            LIS(i);
            LDS(i);
        }

        for(int i=0; i<N; i++){
            dp_result[i] = dp_left[i] + dp_right[i] - 1;
            max = Math.max(max, dp_result[i]);
        }

        System.out.println(max);

    }

    public static int LIS(int N){
        if(dp_left[N] == 0){
            dp_left[N] = 1;

            for(int i=N-1; i>=0; i--){
                if(A[i] < A[N]){
                    dp_left[N] = Math.max(dp_left[N], LIS(i) + 1);
                }
            }
        }

        return dp_left[N];
    }

    public static int LDS(int N){
        if(dp_right[N] == 0){
            dp_right[N] = 1;

            for(int i=N+1; i<dp_right.length; i++){
                if(A[i] < A[N]){
                    dp_right[N] = Math.max(dp_right[N], LDS(i) + 1);
                }
            }
        }

        return dp_right[N];
    }
}
