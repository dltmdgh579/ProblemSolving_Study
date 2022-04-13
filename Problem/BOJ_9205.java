import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205 {

	static int n, sx, sy, dx, dy;
	static ArrayList<int[]> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			n = Integer.parseInt(br.readLine());
			
			list = new ArrayList<>();
			
			// 좌표 입력
			for(int i=0; i<n+2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				// 집, 페스티벌
				if(i == 0) {
					sx = x;
					sy = y;
				} else if(i == n+1) {
					dx = x;
					dy = y;
				}
				list.add(new int[] {x, y});
			}
			
			if(bfs()) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}
		}
	}
	public static boolean bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[n+2];
		
		q.offer(list.get(0));
		visited[0] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			// 현재 지점에서 페스티벌까지 갈 수 있는 거리일 경우 종료
			if(Math.abs(cur[0] - dx) + Math.abs(cur[1] - dy) <= 1000)
				return true;
			
			// 현재 지점으로부터 갈 수 있는 모든 지점 큐에 저장
			for(int i=0; i<n+1; i++) {
				if(!visited[i]) {
					int dist = Math.abs(cur[0] - list.get(i)[0]) + Math.abs(cur[1] - list.get(i)[1]);
					
					if(dist <= 1000) {
						visited[i] = true;
						q.offer(list.get(i));
					}
				}
			}
		}
		return false;
	}
}
