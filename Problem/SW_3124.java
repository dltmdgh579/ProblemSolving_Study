import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_3124 {
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	static int V, E;
	static int[] parents;
	static Edge[] edgeList;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			edgeList = new Edge[E];
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				edgeList[i] = new Edge(from, to, weight);
			}
			Arrays.sort(edgeList); // 간선비용의 오름차순정렬
			makeSet();
			
			long result = 0; 
			int cnt = 0;
			
			for(Edge e : edgeList) {
				if(union(e.from, e.to)) {
					result += e.weight;
					if(++cnt == V-1) break;
				}
			}
			System.out.println("#" + tc + " " + result);
		}
	}
	// 단위집합 생성
	public static void makeSet() {
		parents = new int[V+1];
		//자신의 부모노드를 자신의 값으로 세팅
		for(int i=0; i<=V; i++) {
			parents[i] = i;
		}
	}
	
	//a의 집합 찾기: a의 대표자 찾기
	public static int findSet(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findSet(parents[a]); // path compression
	}
	
	// a, b 두 집합 합치기
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
}
