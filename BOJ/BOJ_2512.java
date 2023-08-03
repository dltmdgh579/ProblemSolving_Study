import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] expectBudgets = new int[N];
        int budget = 0;
        int max = 0;
        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int expectBudget = Integer.parseInt(st.nextToken());
            expectBudgets[i] = expectBudget;
            sum += expectBudget;
            max = Math.max(max, expectBudget);
        }

        budget = Integer.parseInt(br.readLine());
        
        if(budget >= sum) {
            System.out.println(max);
            return;
        }
        
        int left = 0;
        int right = max;
        int result = 0;
        while(left <= right){
            int mid = (left + right) / 2;

            int tmpSum = 0;
            for(int i=0; i<N; i++){
                if(expectBudgets[i] >= mid) tmpSum += mid; 
                else tmpSum += expectBudgets[i];
            }

            if(tmpSum > budget) {
                right = mid - 1;
            }
            else {
                result = mid;
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}
