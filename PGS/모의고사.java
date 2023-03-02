import java.util.ArrayList;
class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int[] A_num = new int[] {1, 2, 3, 4, 5};
        int[] B_num = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] C_num = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int A_count = 0;
        int B_count = 0;
        int C_count = 0;
        for(int i=0; i<answers.length; i++){
            if(answers[i] == A_num[i%5]) A_count++;
            if(answers[i] == B_num[i%8]) B_count++;
            if(answers[i] == C_num[i%10]) C_count++;
        }
        
        int max = 0;
        max = Math.max(A_count, B_count);
        max = Math.max(max, C_count);
        
        if(A_count == max) answer.add(1);
        if(B_count == max) answer.add(2);
        if(C_count == max) answer.add(3);
        
        int[] result = new int[answer.size()];
        int idx3 = 0;
        for(int n : answer){
            result[idx3++] = n;
        }
        return result;
    }
}