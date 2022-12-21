import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1339 {
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result = 0;
        int[] alphabet = new int[26];

        for(int i=0; i<N; i++){
            String word = br.readLine();

            int size = word.length();

            for(int j=0; j<size; j++){
                alphabet[word.charAt(j) - 'A'] += (int) Math.pow(10, size-j-1);
            }
        }

        Arrays.sort(alphabet);

        for(int i=25; i>16; i--){
            result += alphabet[i] * (i-16);
        }

        System.out.println(result);
    }
}