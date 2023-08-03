import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_21921 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] count = new int[N];
        int max = 0;
        int maxCount = 1;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            count[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i=0; i<X; i++){
            sum += count[i];
        }
        
        max = sum;

        for(int i=X; i<N; i++){
            sum += count[i] - count[i-X];
            if(sum == max) maxCount++;
            else if(sum > max){
                max = sum;
                maxCount = 1;
            }
        }

        if(max == 0){
            System.out.println("SAD");
        } else {
            System.out.println(max + "\n" + maxCount);
        }
    }
}
