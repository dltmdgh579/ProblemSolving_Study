import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16916 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String P = br.readLine();

        System.out.println(KMP(S, P));
    }

    public static int KMP(String S, String P){
        int[] table = makeTable(P);
        int n1 = S.length();
        int n2 = P.length();

        int idx = 0;
        for(int i=0; i<n1; i++){
            while(idx > 0 && S.charAt(i) != P.charAt(idx)){
                idx = table[idx-1];
            }

            if(S.charAt(i) == P.charAt(idx)){
                if(idx == n2-1){
                    idx = table[idx];
                    return 1;
                } else{
                    idx++;
                }
            }
        }
        return 0;
    }

    public static int[] makeTable(String P){
        int n = P.length();
        int[] table = new int[n];

        int idx=0;
        for(int i=1; i<n; i++){
            while(idx>0 && P.charAt(i) != P.charAt(i)){
                idx = table[idx-1];
            }

            if(P.charAt(i) == P.charAt(idx)){
                idx++;
                table[i] = idx;
            }
        }
        return table;
    }
}
