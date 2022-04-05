import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OL_2577 {

	static int N, d, k, c;
	static int[] belt, sushi;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		belt = new int[N];
		sushi = new int[d+1];
		
		for(int i=0; i<N; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(slide());
	}
	
	public static int slide() {
		int max = 0;
		int total = 0;
		
		// 처음 k 접시의 초밥 가짓수 계산
		for(int i=0; i<k; i++) {
			if(sushi[belt[i]] == 0) total++;
			sushi[belt[i]]++;
		}
		max = total;
		
		// 다음 접시부터 순서대로 계산
		for(int i=1; i<N; i++) {
			// 쿠폰 적용
			if(total >= max) {
				// 먹은 접시에 쿠폰 초밥이 없을 경우
				if(sushi[c] == 0) 
					max = total+1;
				// 먹은 접시에 쿠폰 초밥이 있을 경우
				else 
					max = total;
			}
			
			// 첫번째 초밥 제거
			sushi[belt[i-1]]--;
			// 제거한 초밥이 한 개 였을 경우
			if(sushi[belt[i-1]] == 0) total--;
			
			// 마지막 초밥의 다음 초밥 추가
			if(sushi[belt[(i + k - 1) % N]] == 0) total++;
			// 초밥 가짓수 추가
			sushi[belt[(i + k - 1) % N]]++;
		}
		return max;
	}
}
