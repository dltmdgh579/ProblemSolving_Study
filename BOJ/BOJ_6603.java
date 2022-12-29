import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603 {
	static int k;
	static int[] S, ansArr;
	static boolean[] visited;
    public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());

			k = Integer.parseInt(st.nextToken());

			if(k == 0) break;

			S = new int[k];
			ansArr = new int[6];
			visited = new boolean[k];

			for(int i=0; i<k; i++){
				S[i] = Integer.parseInt(st.nextToken());
			}

			comb(0, 0);
			System.out.println();
		}
	}

	public static void comb(int start, int cnt){
		if(cnt == 6){
			for(int i=0; i<cnt; i++){
				System.out.print(ansArr[i] + " ");
			}
			System.out.println();
			return;
		}

		for(int i=start; i<k; i++){
			if(visited[i]) continue;
			ansArr[cnt] = S[i];
			visited[i] = true;
			comb(i+1, cnt+1);
			visited[i] = false;
		}
	}
}