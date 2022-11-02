import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14881 {
    public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(c > a && c > b) {
                System.out.println("NO");
                continue;
            }

            while(a != 0 && b != 0){
                if(a >= b){
                    a = a % b;
                } else {
                    b = b % a;
                }
            }

            int gcd = a == 0 ? b : a;

            String result = c % gcd == 0 ? "YES" : "NO";
            System.out.println(result); 
        } 
    }
}