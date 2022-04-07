import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686 {
	
	static class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M, result, min;
	static boolean[] isSelected;
	static ArrayList<Point> chicken, house;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		chicken = new ArrayList<>();
		house = new ArrayList<>();
		
		map = new int[N][N];
		
		// 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 집
				if(map[i][j] == 1) house.add(new Point(i, j));
				// 치킨집
				else if(map[i][j] == 2) chicken.add(new Point(i, j));
			}
		}
		
		isSelected = new boolean[chicken.size()];
		min = Integer.MAX_VALUE;
		comb(0, 0);
		
		System.out.println(min);
	}
	
	public static void comb(int cnt, int start) {
		// 폐업시키지 않을 치킨집 M개
		if(cnt == M) {
			result = 0;
			// 모든 집의 치킨거리 계산
			for(int i=0; i<house.size(); i++) {
				int dist_sum = Integer.MAX_VALUE;
				for(int j=0; j<chicken.size(); j++) {
					if(isSelected[j]) {
						int dist = Math.abs(house.get(i).x - chicken.get(j).x) 
								+ Math.abs(house.get(i).y - chicken.get(j).y);
						
						dist_sum = Math.min(dist_sum, dist);
					}
				}
				result += dist_sum;
			}
			// 도시의 치킨 거리
			min = Math.min(min, result);
			return;
		}
		
		for(int i=start; i<chicken.size(); i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				comb(cnt+1, i+1);
				isSelected[i] = false; // 폐업된 치킨집
			}
		}
	}

}
