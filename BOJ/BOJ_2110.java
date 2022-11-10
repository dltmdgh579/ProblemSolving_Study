import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
    public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] houses = new int[N];

        for(int i=0; i<N; i++){
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int left = 1;
        int right = houses[N-1] - houses[0];
        int distance = 0;
        int ans = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            int start = houses[0];
            int cnt = 1;

            for(int i=1; i<N; i++){
                distance = houses[i] - start;
                if(distance >= mid){
                    cnt++;
                    start = houses[i];
                }
            }

            if(cnt >= C){
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);

    }
}