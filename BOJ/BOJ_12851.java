import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_12851 {
    static int N, K, minCount, minTime = Integer.MAX_VALUE;
    static int[] count;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        K = sc.nextInt();
        
        // N이 K보다 클 경우 -1의 경우만 존재
        if(N > K){
            System.out.println((N - K) + "\n1");
            return;
        } 
        // 같을 경우 0
        else if (N == K){
            System.out.println(0 + "\n1");
            return;
        }

        bfs();
        
        System.out.println(minTime + "\n" + minCount);
    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        count = new int[100001]; // 시간 count

        q.offer(N);
        
        count[N] = 1;

        while(!q.isEmpty()){
            int current = q.poll();

            // 현재 시간이 최소 시간보다 클 경우 종료
            if(minTime < count[current]) return;

            // 3가지 경우 모두 큐에 저장
            for(int i=0; i<3; i++){
                int next = 0;

                if(i == 0) next = current + 1;
                else if(i == 1) next = current -1;
                else next = current * 2;

                // 출력 조건
                if(next == K){
                    minTime = count[current];
                    minCount++;
                }

                // 저장 조건
                if(next >= 0 && next < 100001){
                    // 방문하지 않은 곳 또는 현재 자신의 시간과 동일한 경우
                    if(count[next] == 0 || count[next] == count[current] + 1){
                        q.offer(next);
                        count[next] = count[current] + 1; // 이동하는 곳에 현재시간 + 1 입력
                    }
                }
            }
        }
        return;
    }
}
