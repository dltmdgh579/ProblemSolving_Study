import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11444 {
    final static long MOD = 1000000007;
    public static long[][] origin = {{1, 1}, {1, 0}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        long[][] A = {{1, 1}, {1, 0}};

        System.out.println(pow(A, N-1)[0][0]);
    }

    public static long[][] pow(long[][] A, long exp){
        if(exp == 1 || exp == 0) return A;

        long[][] ret = pow(A, exp/2);

        ret = multiply(ret, ret);

        if(exp%2 == 1l){
            ret = multiply(ret, origin);
        }

        return ret;
    }

    public static long[][] multiply(long[][] o1, long[][] o2){
        long[][] ret = new long[2][2];

        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                for(int k=0; k<2; k++){
                    ret[i][j] += o1[i][k] * o2[k][j];
                    ret[i][j] %= MOD;
                }
            }
        }
        return ret;
    }
}
