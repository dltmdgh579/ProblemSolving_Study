import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        
        for(int i=0; i<N; i++){
            boolean flag = false;
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();

            for(int j=0; j<str.length(); j++){
                char c = str.charAt(j);
                if(c == '('){
                    stack.push(c);
                } else {
                    if(stack.size() == 0){
                        flag = true;
                        break;
                    }
                    stack.pop();
                }
            }
            if(flag || stack.size() > 0) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}