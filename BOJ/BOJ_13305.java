import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305 {
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dist = new long[N-1];
        long[] gas = new long[N];
        long result = 0;
        long minGas = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++){
            dist[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            gas[i] = Integer.parseInt(st.nextToken());
        }

        minGas = gas[0];

        for(int i=0; i<N-1; i++){
            if(minGas > gas[i]){
                minGas = gas[i];
            }
            result += dist[i] * minGas;
        }

        System.out.println(result);
    }
}