class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int leftStart = 1;
        
        for(int station : stations){
            if(station - w > leftStart){
                int leftEnd = station - w;
                int length = leftEnd - leftStart;
                
                int count = length / (2 * w + 1);
                if(length%(2 * w + 1) != 0){
                    count++;
                }
                
                answer += count;
            }
            leftStart = station + w + 1;
        }
        
        if(stations[stations.length-1] + w < n){
            int count = (n - leftStart + 1)/(2 * w + 1);
            if((n - leftStart + 1)%(2 * w + 1) != 0){
                count++;
            }
            
            answer += count;
        }
        
        return answer;
    }
}