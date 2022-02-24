package _0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class OL_1681 {
	
	// 간선 정보
	static class Edge{
		int to, weight;
		
		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	static int N, min;
	static int[] parents;
	static boolean[] visited;
	static ArrayList[] adjList;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 장소 수
		
		adjList = new ArrayList[N]; // 인접리스트
		
		// 인접리스트 초기화
		for(int i=0; i<N; i++) {
			adjList[i] = new ArrayList<Edge>();
		}
		
		// 인접리스트 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int w = Integer.parseInt(st.nextToken());
				if(w != 0) adjList[i].add(new Edge(j, w)); // 갈 수 있는 경로만 저장
			}
		}
		
		visited = new boolean[N]; // 방문 체크 배열
		min = Integer.MAX_VALUE;
		
		dfs(0, 0, 0);
		System.out.println(min);
	}
	
	public static void dfs(int now, int cnt, int weight) {
		// 현재 최소 비용보다 많아질 경우 리턴
		if(weight >= min) return;
		
		// 모든 장소 방문 후 시작 도시로 돌아왔을 경우 최소 비용 갱신
		if(now == 0 && cnt == N) {
			min = Math.min(min, weight);
			return;
		}
		
		// 시작 도시부터 모든 도시 탐색
		for(int i=0; i<adjList[now].size(); i++) {
			Edge e = (Edge) adjList[now].get(i);
			
			if(!visited[e.to]) { // 방문하지 않은 도시
				visited[e.to] = true;
				dfs(e.to, cnt + 1, weight + e.weight);
				visited[e.to] = false;
			}
		}
	}
}
