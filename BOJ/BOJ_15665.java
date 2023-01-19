import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15665{

    static int N, M;
    static int[] A, selected;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];
        selected = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        comb(0);
        System.out.println(sb.toString());
    }

    public static void comb(int cnt){
        if(cnt == M){
            for(int i=0; i<M; i++){
                sb.append(selected[i] + " ");
            }
            sb.append('\n');
            return;
        }

        int num = 0;
        for(int i=0; i<N; i++){
            if(num == A[i]) continue;
            num = A[i];
            selected[cnt] = A[i];
            comb(cnt + 1);
        }
    }
}