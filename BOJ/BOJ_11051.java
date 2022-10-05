import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11051 {
	public static final int div = 10007;
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

        int[][] pascal = new int[N+1][N+1];

        for(int i=0; i<pascal.length; i++){
            for(int j=0; j<=i; j++){
                if(i == j || j == 0) pascal[i][j] = 1;
                else pascal[i][j] = (pascal[i-1][j-1] + pascal[i-1][j]) % 10007;
            }
        }
        System.out.println(pascal[N][K]);
	}
 
}