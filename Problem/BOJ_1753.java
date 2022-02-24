package _0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {

	// 정점, 간선 정보
	static class Vertex implements Comparable<Vertex>{
		int no, weight;

		public Vertex(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken()); // 정점 개수
		int E = Integer.parseInt(st.nextToken()); // 간선 개수

		int start = Integer.parseInt(br.readLine()); // 시작 정점
		
		ArrayList<ArrayList<Vertex>> adjList = new ArrayList<>(); // 인접리스트

		// 인접리스트 초기화
		for (int i = 0; i <= V; i++) {
			adjList.add(new ArrayList<>());
		}

		// 정점, 간선 정보 입력
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adjList.get(u).add(new Vertex(v, w));
		}

		int[] distance = new int[V + 1];

		// 거리 초기화
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		distance[start] = 0; // 시작점 0

		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		
		pq.offer(new Vertex(start, 0)); // 시작점부터

		while(!pq.isEmpty()) {
			Vertex current = pq.poll();
			
			// 현재 최단거리보다 큰 거리값이 들어올 경우 무시
			if(current.weight > distance[current.no]) continue;
			
			// 현재 정점의 모든 간선 탐색
			int size = adjList.get(current.no).size();
			for(int i=0; i<size; i++) {
				Vertex vt = (Vertex) adjList.get(current.no).get(i);
				
				// 현재 정점을 경유하는 경우가 더 작을경우 최단거리 갱신 후 offer
				if(distance[vt.no] > current.weight + vt.weight) {
					distance[vt.no] = current.weight + vt.weight;
					pq.offer(new Vertex(vt.no, distance[vt.no]));
				}
			}
			
		}
		
		// 출력
		for (int i = 1; i <= V; i++) {
			// 경로가 존재하지 않는 경우
			if (distance[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
				continue;
			}
			System.out.println(distance[i]);
		}
	}
}
