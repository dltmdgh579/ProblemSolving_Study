import java.util.Scanner;

public class BOJ_9663 {
    static int N, count;
    static int[] col;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        col = new int[N+1];

        // 첫 번째 행
        setQueen(1);
        
        System.out.println(count);
    }
    public static void setQueen(int row){
        // 마지막 행에 도착하면 count
        if(row > N){
            count++;
            return;
        }
        // 행마다 퀸이 놓인 열값 체크
        for(int i=1; i<=N; i++){
            col[row] = i;
            if(isPossible(row))
                setQueen(row+1);
        }
    }
    public static boolean isPossible(int row){
        // 같은 열 또는 대각선 체크
        for(int i=1; i<row; i++){
            if(col[row] == col[i] || row-i == Math.abs(col[row]-col[i])) return false;
        }
        return true;
    }
} 
