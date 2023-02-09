import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        int count = 0;

        
        for(int i=0; i<=A.length()-B.length(); i++){
            boolean flag = false;
            for(int j=0; j<B.length(); j++){
                if(A.charAt(i+j) != B.charAt(j)){
                    flag = true;
                }
            }
            if(!flag) {
                count++;
                i += B.length()-1;
            }
        }

        System.out.println(count);

    }
}
