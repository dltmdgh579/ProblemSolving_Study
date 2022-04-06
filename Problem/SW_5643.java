import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_5643 {
	
	static int N, M, taller, shorter;
	static ArrayList<Integer>[] tallerList, shorterList;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			tallerList = new ArrayList[N+1];
			shorterList = new ArrayList[N+1];
			
			for(int i=0; i<=N; i++) {
				tallerList[i] = new ArrayList<>();
				shorterList[i] = new ArrayList<>();
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				tallerList[a].add(b); // a 키 < b 키
				shorterList[b].add(a); // b 키 > a 키
			}
			
			int result = 0;
			for(int i = 1; i<=N; i++) {
				taller = shorter = 0;
				bfs(i);
				// 본인 제외 모두 탐색된 경우
				if(taller + shorter == N-1) result++;
			}
			System.out.println("#" + tc + " " + result);
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		q.offer(start);
		visited[start] = true;
		
		// 키가 큰 사람
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i : tallerList[cur]) {
				if(!visited[i]) {
					visited[i] = true;
					taller++;
					q.offer(i);
				}
			}
		}
		
		// 키가 작은 사람
		q.offer(start);
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i : shorterList[cur]) {
				if(!visited[i]) {
					visited[i] = true;
					shorter++;
					q.offer(i);
				}
			}
		}
	}
	
}
