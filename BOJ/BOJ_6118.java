import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6118 {

	static int N, M, size, max = Integer.MIN_VALUE, minNum = Integer.MAX_VALUE;
	static int[] ans;
	static boolean[] visited;
	static List<Integer>[] nodes;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nodes = new ArrayList[N+1];
		visited = new boolean[N+1];
		ans = new int[N+1];

		for(int i=0; i<=N; i++){
			nodes[i] = new ArrayList<>();
		}

		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			nodes[A].add(B);
			nodes[B].add(A);
		}

		bfs();
		System.out.println(minNum + " " + max + " " + size);
		
	}

	public static void bfs(){
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(1, 0));
		visited[1] = true;

		while(!q.isEmpty()){
			Node cur = q.poll();

			if(max < cur.dist){
				max = cur.dist;
				minNum = cur.idx;
				size = 1;
			} else if(max == cur.dist){
				minNum = Math.min(minNum, cur.idx);
				size++;
			}

			for(Integer next : nodes[cur.idx]){
				if(visited[next]) continue;
				q.add(new Node(next, cur.dist + 1));
				visited[next] = true;
			}
		}
	}

	static class Node{
		int idx, dist;
		public Node(int idx, int dist){
			this.idx = idx;
			this.dist = dist;
		}
	}
}