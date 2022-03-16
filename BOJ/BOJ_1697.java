import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697 {
    static int N, K;
    static int[] count;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        K = sc.nextInt();
        
        // N이 K보다 클 경우 -1의 경우만 존재
        if(N > K){
            System.out.println(N - K);
        } 
        // 같을 경우 0
        else if (N == K){
            System.out.println(0);
        }
        else {
            bfs();
        }
    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        count = new int[100001]; // 시간 count

        q.offer(N);
        
        count[N] = 1;

        while(!q.isEmpty()){
            int current = q.poll();

            // 3가지 경우 모두 큐에 저장
            for(int i=0; i<3; i++){
                int next = 0;

                if(i == 0) next = current + 1;
                else if(i == 1) next = current -1;
                else next = current * 2;

                // 출력 조건
                if(next == K){
                    System.out.println(count[current]);
                    return;
                }

                // 저장 조건
                if(next >= 0 && next < 100001 && count[next] == 0){
                    q.offer(next);
                    count[next] = count[current] + 1; // 이동하는 곳에 현재시간 + 1 입력
                }
            }
        }
        return;
    }
}
