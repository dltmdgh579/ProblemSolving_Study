import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10431 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int P = Integer.parseInt(br.readLine());

        for(int T=0; T<P; T++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int tc = Integer.parseInt(st.nextToken());
            int result = 0;
            int[] arr = new int[20];
            
            for(int i=0; i<20; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<20; i++){
                for(int j=0; j<i; j++){
                    if(arr[i] < arr[j]){
                        result++;
                    }
                }
            }
            System.out.println(tc + " " + result);
        }
    }
}
