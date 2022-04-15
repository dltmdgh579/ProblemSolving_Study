import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1389 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1];

        int INF = 10000000;

        // 초기화
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i == j) continue;
                arr[i][j] = INF;
            }
        }
        
        // 간선 입력
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        
        // 플로이드 와샬
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                if(i == k) continue;
                for(int j=1; j<=N; j++){
                    if(arr[i][j] > arr[i][k] + arr[k][j]){
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        int minIdx = -1;

        // 가장 작은 케빈 베이컨의 수를 가진 인덱스 탐색
        for(int i=1; i<=N; i++){
            int sum = 0;
            for(int j=1; j<=N; j++){
                sum += arr[i][j];
            }

            if(sum < min){
                min = sum;
                minIdx = i;
            }
        }
        System.out.println(minIdx);
    }
}
