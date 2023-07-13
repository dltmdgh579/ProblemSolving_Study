class Solution {
    static int zero, one;
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        
        int size = arr.length;
        
        backtracking(arr, 0, 0, size);
        
        answer[0] = zero;
        answer[1] = one;
        
        return answer;
    }
    
    public void backtracking(int[][] arr, int startX, int startY, int size){
        boolean allClear = true;
        int zeroOrOne = arr[startX][startY];
        
        loop : for(int i=startX; i<startX + size; i++){
            for(int j=startY; j<startY + size; j++){
                if(arr[i][j] != zeroOrOne){
                    allClear = false;
                    break loop;
                }
            }
        }
        
        if(allClear){
            if(zeroOrOne == 1) one++;
            else zero++;
            return;
        }
        
        int nextSize = size/2;
        
        backtracking(arr, startX, startY, nextSize);
        backtracking(arr, startX, startY + nextSize, nextSize);
        backtracking(arr, startX + nextSize, startY, nextSize);
        backtracking(arr, startX + nextSize, startY + nextSize, nextSize);
    }
}