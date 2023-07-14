import java.util.*;
import java.io.*;
public class BOJ_1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int count = 0;
        while(A != B){
            A = A%2 + A/2;
            B = B%2 + B/2;

            count++;
        }
        
        System.out.println(count);
    }
}
