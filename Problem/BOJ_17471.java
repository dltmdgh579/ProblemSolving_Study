import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471 {

	static int N, min = Integer.MAX_VALUE;
	static int[] people;
	static boolean[] isSelected;
	static ArrayList<ArrayList<Integer>> list;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		people = new int[N+1];
		isSelected = new boolean[N+1];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<>());
		}
		
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j=0; j<num; j++) {
				int con = Integer.parseInt(st.nextToken());
				list.get(i).add(con);
			}
		}
		
		subSet(0);
		System.out.println(min==Integer.MAX_VALUE ? -1 : min);
	}

	public static void subSet(int cnt) {
		if(cnt == N) {
			// A 구역, B 구역 저장
			ArrayList<Integer> a = new ArrayList<>();
			ArrayList<Integer> b = new ArrayList<>();
			for(int i=1; i<=N; i++) {
				if(isSelected[i]) a.add(i);
				else b.add(i);
			}
			
			// A 구역과 B 구역 연결 확인
			if(isAvailable(a, 'a') && isAvailable(b, 'b')) {
				int A = 0, B = 0;
				for(int i=1; i<=N; i++) {
					if(isSelected[i]) {
						A += people[i];
					}
					else {
						B += people[i];
					}
				}
				min = Math.min(min, Math.abs(A-B));
				
			}
			return;
		}
		
		isSelected[cnt] = true; // A 구역
		subSet(cnt + 1);
		isSelected[cnt] = false; // B 구역
		subSet(cnt + 1);
	}
	
	public static boolean isAvailable(ArrayList<Integer> area, char team) {
		// A 또는 B 구역이 없을 경우
		if(area.size() == 0) return false;
		
		// bfs로 연결 확인
		boolean[] isConnected = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		q.offer(area.get(0));
		isConnected[area.get(0)] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i : list.get(cur)) {
				int next = i;
				if(isConnected[next]) continue;
				if((team == 'a' && isSelected[next]) || (team == 'b' && !isSelected[next])) {
					q.offer(next);
					isConnected[next] = true;
				}
			}
		}
		
		// 해당 구역에 연결되지 않은 지역 체크
		for(int i=0; i<area.size(); i++) {
			if(!isConnected[area.get(i)]) return false;
		}
		return true;
	}
}
