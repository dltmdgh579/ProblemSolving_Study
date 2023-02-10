import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int count = 1;

        int E_count = 1;
        int S_count = 1;
        int M_count = 1;

        while(true){
            if(E_count == E && S_count == S && M_count == M) break;

            E_count++;
            S_count++;
            M_count++;
            
            if(E_count == 16){
                E_count = 1;
            }
            if(S_count == 29){
                S_count = 1;
            }
            if(M_count == 20){
                M_count = 1;
            }
            count++;
        }

        System.out.println(count);
    }
}
