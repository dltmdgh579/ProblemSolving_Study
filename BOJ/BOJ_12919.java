import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12919 {
    static boolean flag;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        dfs(S, T);

        if(flag) System.out.println(1);
        else System.out.println(0);
    }

    public static void dfs(String S, String T){
        if(T.length() == S.length()){
            if(T.equals(S)){
                flag = true;
            }
            return;
        }

        if(T.charAt(T.length()-1) == 'A'){
            dfs(S, T.substring(0, T.length()-1));
        }

        if(T.charAt(0) == 'B'){
            StringBuilder sb = new StringBuilder(T.substring(1));
            dfs(S, sb.reverse().toString());
        }
    }
}
