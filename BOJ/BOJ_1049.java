import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] string_package = new int[M];
        int[] string_one = new int[M];
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            
            string_package[i] = Integer.parseInt(st.nextToken());
            string_one[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(string_package);
        Arrays.sort(string_one);

        min = Math.min(((N-1)/6 + 1) * string_package[0], (N/6) * string_package[0] + N%6 * string_one[0]);
        min = Math.min(min, N * string_one[0]);

        System.out.println(min);
    }
}
