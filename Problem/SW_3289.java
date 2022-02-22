package _0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_3289 {
	static int[] parent;
	static int n, m;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			parent = new int[n+1];
			makeSet(); // 초기화
			
			sb.append("#").append(tc).append(" ");
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int oper = Integer.parseInt(st.nextToken()); // 연산
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				// 0일 경우 합치기, 1일 경우 확인
				if(oper == 0) union(a, b);
				else if(oper == 1) {
					if(find(a) == find(b)) sb.append(1);
					else sb.append(0);
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	// 루트 찾기
	public static int find(int i) {
		if(parent[i] == i) return i;
		else {
			parent[i] = find(parent[i]);
			return parent[i];
		}
	}
	
	// 합치기
	public static void union(int i, int j) {
		int pi = find(i);
		int pj = find(j);
		
		if(pi != pj) {
			parent[pj] = pi;
		}
	}
	
	public static void makeSet() {
		//자신의 부모노드를 자신의 값으로 세팅
		for (int i = 0; i < n+1; i++) {
			parent[i] = i;
		}
	}
	
}
