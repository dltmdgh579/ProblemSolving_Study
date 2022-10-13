import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {
    static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] numbers, operator;
 
    public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        operator = new int[4];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        back(1, numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void back(int cnt, int total){
        if(cnt == N){
            max = Math.max(max, total);
            min = Math.min(min, total);
            return;
        }

        for(int i=0; i<4; i++){
            if(operator[i] > 0){
                operator[i]--;

                switch(i){
                    case 0: back(cnt + 1, total + numbers[cnt]);
                    break;
                    case 1: back(cnt + 1, total - numbers[cnt]);
                    break;
                    case 2: back(cnt + 1, total * numbers[cnt]);
                    break;
                    case 3: back(cnt + 1, total / numbers[cnt]);
                    break;
                }

                operator[i]++;
            }
        }
    }
}