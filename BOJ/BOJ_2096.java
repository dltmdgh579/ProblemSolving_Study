import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_2096 {

    static int N;
    static int[] beforeNum = {-1, 0, 1};
    static int[] map, dpMax, dpMin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        dpMax = new int[3];
        dpMin = new int[3];


        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int x3 = Integer.parseInt(st.nextToken());

            if(i == 0){
                dpMax[0] = dpMin[0] = x1;
                dpMax[1] = dpMin[1] = x2;
                dpMax[2] = dpMin[2] = x3;
            } else {
                int beforeMax0 = dpMax[0], beforeMax2 = dpMax[2];
                dpMax[0] = Math.max(dpMax[0], dpMax[1]) + x1;
                dpMax[2] = Math.max(dpMax[1], dpMax[2]) + x3;
                dpMax[1] = Math.max(Math.max(beforeMax0, dpMax[1]), beforeMax2) + x2;

                int beforeMin0 = dpMin[0], beforeMin2 = dpMin[2];
                dpMin[0] = Math.min(dpMin[0], dpMin[1]) + x1;
                dpMin[2] = Math.min(dpMin[1], dpMin[2]) + x3;
                dpMin[1] = Math.min(Math.min(beforeMin0, dpMin[1]), beforeMin2) + x2;
            }
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<3; i++){
            max = Math.max(max, dpMax[i]);
            min = Math.min(min, dpMin[i]);
        }
        System.out.println(max + " " + min);
    }
}