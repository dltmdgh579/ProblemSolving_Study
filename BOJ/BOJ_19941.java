import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19941 {
    static int N, K, count;
    static char[] table;
    static boolean[] picked;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        String tableStr = br.readLine();
        table = tableStr.toCharArray();
        picked = new boolean[N];

        for(int i=0; i<N; i++){
            char cur = table[i];
            if(cur == 'P'){
                check(i);
            }
        }

        System.out.println(count);
    }

    public static void check(int idx){
        int tmp = K;
        while(idx - tmp < 0){
            tmp--;
        }
        for(int i=idx-tmp; i<idx; i++){
            if(table[i] == 'H' && !picked[i]){
                count++;
                picked[i] = true;
                return;
            }
        }

        tmp = K;
        while(idx + tmp >= N){
            tmp--;
        }
        for(int i=idx+1; i<=idx+tmp; i++){
            if(table[i] == 'H' && !picked[i]){
                count++;
                picked[i] = true;
                return;
            }
        }
    }
}
