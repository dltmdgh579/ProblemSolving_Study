package _0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
	
	// 토마토 위치, 일수 정보
	static class Point {
		int x, y, day;
		
		public Point(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
	
	static int N, M;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] box;
	static Queue<Point> q;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		box = new int[N][M]; // 토마토 박스 배열
		
		q = new LinkedList<>(); // 위치, 일수 정보
		
		// 토마토 박스 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 1) q.offer(new Point(i, j, 0)); // 익은 토마토 저장
			}
		}
		
		bfs();
		
	}
	
	public static void bfs() {
		
		int day = 0;
		
		while(!q.isEmpty()){
			Point p = q.poll(); // 익은 토마토
			day = p.day; // 진행된 일수
			
			// 4방탐색
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				// 1. 배열 범위 내    2. 익지 않은 토마토 
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && box[nx][ny] == 0) {
					box[nx][ny] = 1; // 익은 토마토로 갱신
					q.offer(new Point(nx, ny, day+1)); // 위치, 진행 일수 저장
				}
			}
		}
		
		// 탐색 후 익지 않은 토마토가 있을 경우 -1
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(box[i][j] == 0) {
					System.out.println(-1);
					return;
				} 
			}
		}
		
		// 마지막으로 익은 토마토 진행 일수 출력
		System.out.println(day);
		return;
	}
}
