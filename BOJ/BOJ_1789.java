import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());
        long cnt = 0;
        long num = 1;

        while(S > 0){
            S -= num;
            if(S < 0) break;
            num++;
            cnt++;
        }

        System.out.println(cnt);
    }
}
