package _0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1238_Contact {

	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visit;
	static int[] depth;
	static int ans, max;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken()); // 길이
			int start = Integer.parseInt(st.nextToken()); // 시작점
			
			// 2차원 ArrayList로 그래프 저장
			graph = new ArrayList<ArrayList<Integer>>();
			
			// 초기화
			for(int i=0; i<101; i++) {
				graph.add(new ArrayList<Integer>());
			}
			
			// from, to 입력
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<L/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				// 중복 제거
				if(graph.get(from).contains(to)) continue;
				// from 인덱스 ArrayList에 to 저장
				graph.get(from).add(to);
			}
			
			// 연락망 깊이
			depth = new int[101];
			max = Integer.MIN_VALUE;
			ans = 0;
			
			bfs(start);
			
			// 가장 나중에 연락을 받는 사람 중 번호가 가장 큰 사람
			for(int i=0; i<101; i++) {
				if(depth[i] >= max) {
					max = depth[i];
					if(i > ans) ans = i;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[101]; // 방문 체크
		
		queue.offer(start);
		visited[start] = true; // 방문
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			// 현재 연락받은 사람이 연락 가능한 모든 사람
			for(int i=0; i<graph.get(current).size(); i++) {
				if(!visited[graph.get(current).get(i)]) {
					// 연락 가능한 사람 저장
					queue.offer(graph.get(current).get(i));
					visited[graph.get(current).get(i)] = true; // 방문
					// 연락받을 사람의 깊이는 현재의 깊이 + 1
					depth[graph.get(current).get(i)] = depth[current] + 1;
				}
			}
		}
	}
}
