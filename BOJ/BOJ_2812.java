import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2812 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();

        String str = br.readLine();
        stack.push(str.charAt(0) - '0');

        for(int i=1; i<N; i++){
            while(!stack.isEmpty() && stack.peek() < str.charAt(i) - '0' && K > 0){
                stack.pop();
                K--;
            }
            stack.push(str.charAt(i) - '0');
        }

        for(int i=0; i<stack.size()-K; i++){
            sb.append(stack.elementAt(i));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}