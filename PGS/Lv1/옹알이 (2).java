class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String word : babbling){
            word = word.replaceAll("ayaaya|yeye|woowoo|mama", " ");
            word = word.replaceAll("aya|ye|woo|ma", "");
            
            if(word.length() == 0) answer++;
        }
        
        return answer;
    }
}