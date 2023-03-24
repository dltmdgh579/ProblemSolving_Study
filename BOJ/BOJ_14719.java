import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] map = new int[W];

        int water = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<W; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<W-1; i++){
            int cur = map[i];
            int leftMax = cur;
            int rightMax = cur;

            for(int j=0; j<i; j++){
                if(map[j] > cur){
                    leftMax = Math.max(leftMax, map[j]);
                }
            }
            for(int j=i+1; j<W; j++){
                if(map[j] > cur){
                    rightMax = Math.max(rightMax, map[j]);
                }
            }

            if(Math.min(leftMax, rightMax) > cur){
                water += (Math.min(leftMax, rightMax) - map[i]);
            }

        }

        System.out.println(water);
    }
}
