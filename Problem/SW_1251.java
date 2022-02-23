package _0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SW_1251 {
	
	// 각 섬을 연결하는 간선 정보
	static class Edge implements Comparable<Edge>{
		int x, y;
		long weight;
		
		public Edge(int x, int y, long weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		// weight 기준으로 오름차순 정렬
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
	}

	static int N;
	static int[] parents;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			ArrayList<Edge> edgeList = new ArrayList<>(); // 간선 정보 저장 리스트
			
			int[] arrX = new int[N];
			int[] arrY = new int[N];

			// 각 섬의 x, y좌표 입력
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arrX[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arrY[i] = Integer.parseInt(st.nextToken());
			}
			
			double E = Double.parseDouble(br.readLine()); // 환경 부담 세율
			
			// 모든 섬들을 연결
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					long dx = Math.abs(arrX[i] - arrX[j]);
					long dy = Math.abs(arrY[i] - arrY[j]);
					edgeList.add(new Edge(i, j, dx*dx + dy*dy));
				}
			}
			
			Collections.sort(edgeList); // 오름차순 정렬
			
			makeSet(); // 루트 집합 초기화
			
			long result = 0, cnt = 0;
			
			// weight가 작은 순으로 연결
			for(Edge edge : edgeList) {
				// 연결 가능한지 체크
				if(union(edge.x, edge.y)) {
					result += edge.weight;
					if(++cnt == N-1) break; // 모두 연결 시 종료
				}
			}
			System.out.println("#" + tc + " " + Math.round(result*E));
		}
	}
	
	// 단위집합 생성
	public static void makeSet() {
		parents = new int[N];
		// 자신의 부모노드를 자신의 값으로 세팅
		for(int i=0; i<N; i++) {
			parents[i] = i;
		}
	}
	
	// a, b 두 집합 합치기
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	// a의 집합 찾기 : a의 대표자 찾기
	public static int findSet(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
}
