import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String origin = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<origin.length(); i++){
            stack.push(origin.charAt(i));
            // 스택 size가 폭발 문자열 길이 이상일 경우 폭발 문자열과 비교
            if(stack.size() >= bomb.length()){
                boolean boom = true;
                // 폭발 문자열과 다를경우
                for(int j=0; j<bomb.length(); j++){
                    if(stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)){
                        boom = false;
                        break;
                    }
                }
                // 폭발 문자열과 일치할 경우
                if(boom){
                    for(int j=0; j<bomb.length(); j++){
                        stack.pop();
                    }
                }
            }
        }
        // 남아있는 문자가 없는 경우
        if(stack.size() == 0){
            System.out.println("FRULA");
        } else{
            StringBuilder sb = new StringBuilder();
            for(char c : stack){
                sb.append(c);
            }
            System.out.println(sb.toString());
        }
    }
}