import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928{
    static int N, M;
    static HashMap<Integer, Integer> hmap;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        hmap = new HashMap<>();

        // 사다리, 뱀 위치 -> 이동되는 위치 저장
        for(int i=0; i<N+M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            hmap.put(x, y);
        }

        System.out.println(bfs());
    }
    public static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[101];
        q.offer(new int[] {1, 0});

        while(!q.isEmpty()){
            int[] cur = q.poll();

            // 도착
            if(cur[0] == 100){
                return cur[1];
            }
            
            // 1부터 6까지 주사위를 굴렸을 때의 모든 경우 계산
            for(int i=1; i<=6; i++){
                int next = cur[0] + i; // 다음 지점

                if(next > 100) continue; 
                
                // 사다리, 뱀일 경우
                if(hmap.containsKey(next)){
                    if(!visited[hmap.get(next)]){
                        q.offer(new int[] {hmap.get(next), cur[1] + 1});
                        visited[hmap.get(next)] = true;
                    }
                } else {
                    if(!visited[next]){
                        q.offer(new int[] {next, cur[1] + 1});
                        visited[next] = true;
                    }
                }
            }
        }
        return 0;
    }
}