import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13172 {
    static final long mod = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());

        long N = 1, S = 0;
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            S = s * N + S * n;
            N *= n;

            S %= mod;
            N %= mod;

        }

        if(S % N != 0)
            System.out.println((search(N, mod-2) * S) % mod);
        else
            System.out.println(S/N);
    }

    public static long search(long N, long index) {
        if(index == 1)
            return N;
        long temp = search(N, index/2);
        if(index % 2 == 1)
            return temp * temp % mod * N % mod;
        else
            return temp * temp % mod;
    }
}
