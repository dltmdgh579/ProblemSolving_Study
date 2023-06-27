class Solution {
    public String solution(String a, String b) {
        StringBuilder answer = new StringBuilder();
        
        char[] aNum = new char[a.length()];
        char[] bNum = new char[b.length()];
        
        for(int i=0; i<a.length(); i++){
            aNum[a.length() - i - 1] = a.charAt(i);
        }
        
        for(int i=0; i<b.length(); i++){
            bNum[b.length() - i - 1] = b.charAt(i);
        }
        
        int maxSize = Math.max(aNum.length, bNum.length);
        int minSize = Math.min(aNum.length, bNum.length);
        
        char longer = (aNum.length >= bNum.length) ? 'a' : 'b';
        int[] answerNum = new int[maxSize + 1];
        
        for(int i=0; i<maxSize; i++){
            if(i >= minSize){
                if(longer == 'a'){
                    int sum = aNum[i] - '0' + answerNum[maxSize - i];
                    oper(maxSize, i, sum, answerNum);

                } else {
                    int sum = bNum[i] - '0' + answerNum[maxSize - i];
                    oper(maxSize, i, sum, answerNum);
                }
            } else {
                int sum = (aNum[i] - '0' + bNum[i] - '0') + answerNum[maxSize - i];
                oper(maxSize, i, sum, answerNum);
            }
        }
        
        for(int i=0; i<answerNum.length; i++){
            if(i == 0 && answerNum[i] == 0) continue;
            answer.append(answerNum[i]);
        }
        
        if(answer.length() == 0) answer.append("0");
        
        return answer.toString();
    }
    
    public void oper(int maxSize, int i, int sum, int[] answerNum){
        if(sum >= 10){
            if(answerNum[maxSize - i] > 0){
                answerNum[maxSize - i] += sum%10 - answerNum[maxSize - i];
                answerNum[maxSize - i - 1] += sum/10;                        
            } else {
                answerNum[maxSize - i] += sum%10;
                answerNum[maxSize - i - 1] += sum/10;
            }
        } else {
            if(answerNum[maxSize - i] > 0){
                answerNum[maxSize - i] += sum - answerNum[maxSize - i];
            } else {
                answerNum[maxSize - i] += sum;
            }
        }
    }
}