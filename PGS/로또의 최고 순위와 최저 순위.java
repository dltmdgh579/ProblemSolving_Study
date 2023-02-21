import java.util.HashSet;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        
        int count = 0;
        int zeroCount = 0;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<win_nums.length; i++){
            set.add(win_nums[i]);
        }
        
        for(int n : lottos){
            if(set.contains(n)) count++;
            if(n == 0) zeroCount++;
        }
        
        if(count == 0 && zeroCount == 0) count = 1;
        
        answer = new int[] {7 - (count + zeroCount), 7 - count == 7 ? 6 : 7 - count};
        
        return answer;
    }
}