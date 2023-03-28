class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        int max = 0;
        
        for(int i=0; i<arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        
        int num = 1;
        while(true){
            int divNum = max * num;
            boolean flag = false;
            
            for(int i=0; i<arr.length; i++){
                if(divNum % arr[i] != 0) {
                    flag = true;
                    break;
                }
            }
            
            if(!flag){
                answer = divNum;
                break;
            }
            num++;
        }
        return answer;
    }
}