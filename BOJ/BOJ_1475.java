import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String N = br.readLine();
        int[] plastic_num = new int[10];
        int max = 0;

        for(int i=0; i<N.length(); i++){
            if(N.charAt(i) - '0' == 9) plastic_num[6]++;
            else plastic_num[N.charAt(i) - '0']++;
        }

        plastic_num[6] = plastic_num[6]/2 + plastic_num[6]%2;
        
        for(int i=0; i<plastic_num.length; i++){
           max = Math.max(max, plastic_num[i]);
        }
            
        System.out.println(max);

    }
}
