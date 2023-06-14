class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            if(numbers[i]%2 == 0){
                answer[i] = numbers[i] + 1;
            } else {
                StringBuilder sb = new StringBuilder();
                String num = Long.toString(numbers[i], 2);
                
                if(!num.contains("0")){
                    sb.append("10");
                    sb.append(num.substring(1));
                } else {
                    int lastIndex = num.lastIndexOf("0");
                    int firstOneIndex = num.indexOf("1", lastIndex);
                    
                    sb.append(num, 0, lastIndex).append("1");
                    sb.append("0");
                    sb.append(num.substring(firstOneIndex+1));
                }
                
                answer[i] = Long.parseLong(sb.toString(), 2);
            }
        }
        
        return answer;
    }
}