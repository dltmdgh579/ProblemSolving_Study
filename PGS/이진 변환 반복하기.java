class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        int zeroCount = 0;
        int oneCount = 0;
        int transCount = 0;
        int size = s.length();
        String binary = s;
        
        while(size > 1){
            transCount++;
            
            for(int i=0; i<size; i++){
                // 제거할 0 개수
                if(binary.charAt(i) == '0') zeroCount++;
                // 남은 문자열 개수
                else oneCount++;
            }
            
            size = oneCount;
            oneCount = 0;
            binary = "";
            
            int tmp = size;
            //이진변환
            while(tmp >= 1){
                binary = tmp%2 + binary;
                tmp /= 2;
            }
            
            size = binary.length();
        }
        
        answer = new int[] {transCount, zeroCount};
        return answer;
    }
}