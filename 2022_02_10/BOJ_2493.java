import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2493 {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

		int[] arr = new int[N+1];
		for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
			int cur = arr[i];
			int idx = i;
			while(true) {
				if(idx-1 == 0) {
					sb.append(0 + " ");
					break;
				}
				if(arr[idx-1] > cur) {
					sb.append((idx-1) + " ");
					break;
				}
				idx--;
			}
		}
        bw.write(sb.toString());
        bw.flush();
	}
}
