package _0222;

import java.util.HashSet;
import java.util.Scanner;

public class SW_7465 {

	static int N, M;
	static int[] parent;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt(); // N명의 사람
			M = sc.nextInt(); // 관계 수
			
			parent = new int[N+1]; // 무리 번호
			makeSet(); // 초기화
			
			// 관계 정리
			for(int i=0; i<M; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				union(from, to);
			}
			
			// path compression
			for(int i=1; i<parent.length; i++) {
				findSet(i);
			}
			
			// 루트가 다른사람 체크
			HashSet<Integer> hset = new HashSet<>();
			for(int i=1; i<parent.length; i++) {
				hset.add(parent[i]);
			}
			System.out.println("#" + tc + " " + hset.size());
		}
		sc.close();
	}
	
	// 자신의 값으로 부모 초기화
	public static void makeSet() {
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
	}
	
	// 합치기
	public static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot != bRoot) parent[bRoot] = aRoot;
	}
	
	// 루트 찾기
	public static int findSet(int a) {
		if(a == parent[a]) return a;
		return parent[a] = findSet(parent[a]);
	}
}
