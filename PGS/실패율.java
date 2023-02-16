import java.util.ArrayList;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        
        int[] clear = new int[N+2];
        int[] challenge = new int[N+2];
        ArrayList<Double[]> failureRate = new ArrayList<>();
        
        for(int i=0; i<stages.length; i++){
            challenge[stages[i]]++;
        }
        
        clear[N] = challenge[N] + challenge[N + 1]; 
        for (int i = N-1; i >= 1; i--) {
            clear[i] = challenge[i] + clear[i + 1];
        }
        
        for(int i=1; i<=N; i++){
            if(clear[i] == 0){
                failureRate.add(new Double[] {(double) i, (double) 0});
                continue;
            }
            
            failureRate.add(new Double[] {(double) i, (double) challenge[i]/clear[i]});
        }
        
        failureRate.sort((o1, o2) -> Double.compare(o2[1], o1[1]));
        
        answer = failureRate.stream().mapToInt(value -> value[0].intValue()).toArray();
        
        return answer;
    }
}