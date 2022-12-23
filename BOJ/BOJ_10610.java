import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10610 {
    public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        
		String nStr = br.readLine();
		int sum = 0;

		char[] charArr = nStr.toCharArray();
		int len = charArr.length;
        
		Arrays.sort(charArr);
		for(int i = len - 1; i >= 0; i--) {
			int num = charArr[i] - '0';
			sum += num;
			sb.append(num);
			
		}
				
		if(charArr[0] != '0' || sum % 3 != 0) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(sb.toString());
	}
}