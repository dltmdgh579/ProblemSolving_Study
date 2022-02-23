package _0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236 {

	// 상하좌우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] map;
	static int N, time, eat, size = 2;
	static Queue<Point> q;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N]; // 공간
		
		q = new LinkedList<>(); // 좌표, 거리 값 정보
		
		// 공간 배열 입력
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 아기 상어 위치 저장
				if(map[i][j] == 9) {
					q.offer(new Point(i, j, 0));
					map[i][j] = 0;
				}
			}
		}
		
		bfs();
		
	}
	
	public static void bfs() {
		// 더 이상 물고기를 먹을 수 없을 때 까지 반복
		while(true) {
			
			ArrayList<Point> fish = new ArrayList<>(); // 물고기 좌표, 거리 저장
			int[][] dist = new int[N][N]; // 아기 상어로부터 거리값
			
			// 현재 아기 상어 위치 기반으로 모든 공간 탐색
			while(!q.isEmpty()) {
				Point current = q.poll(); // 현재 아기 상어 위치
				
				// 4방탐색
				for(int i=0; i<4; i++) {
					int nx = current.x + dx[i];
					int ny = current.y + dy[i];
					
					// 공간 범위 내, 방문하지 않은 곳, 아기 상어보다 크지 않은 물고기
					if(nx >= 0 && nx < N && ny >= 0 && ny < N && dist[nx][ny] == 0 && map[nx][ny] <= size) {
						dist[nx][ny] = dist[current.x][current.y] + 1; // 거리 값 저장
						q.add(new Point(nx, ny, dist[nx][ny])); // 좌표, 거리 저장
						
						// 이동한 구간에 크기가 작은 물고기가 있을 경우 물고기 정보 저장
						if(map[nx][ny] >= 1 && map[nx][ny] <= 6 && map[nx][ny] < size) {
							fish.add(new Point(nx, ny, dist[nx][ny]));
						}
					}
				}
			}
			
			// 먹을 수 있는 물고기가 없을 경우
			if(fish.size() == 0) {
				System.out.println(time);
				return;
			}
			
			// 먹을 수 있는 물고기 중 가장 가까운 물고기 탐색
			Point toFish = fish.get(0);
			for(int i=1; i<fish.size(); i++) {
				// 거리가 가까운 물고기로 갱신
				if(fish.get(i).dist < toFish.dist) {
					toFish = fish.get(i);
				}
				// 거리가 같을 경우
				else if(toFish.dist == fish.get(i).dist) {
					// 위에 있는 물고기로 갱신
					if(fish.get(i).x < toFish.x) toFish = fish.get(i);
					// 상하 좌표값이 같을 경우 왼쪽에 있는 물고기로 갱신
					else if(fish.get(i).x == toFish.x){
						if(fish.get(i).y < toFish.y) toFish = fish.get(i);
					}
					// 그 외는 기존 물고기 그대로 유지
				}
			}
			
			time += toFish.dist; // 먹을 수 있는 가장 가까운 물고기의 거리만큼 시간 증가
			eat++; // 먹은 물고기 count
			
			map[toFish.x][toFish.y] = 0; // 먹은 곳 빈 칸으로 갱신
			
			// 아기 상어의 크기만큼 먹었을 경우 크기 1 증가
			if(eat == size) {
				size++;
				eat = 0;
			}
			
			// 물고기를 먹은 곳으로 아기 상어 위치 저장
			q.add(new Point(toFish.x, toFish.y, 0));
		}
	}
	
	// 좌표, 거리값 정보
	static class Point {
		int x;
		int y;
		int dist;
		
		public Point(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
}
