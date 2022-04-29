import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_5430 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        label : for(int tc=0; tc<T; tc++){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            ArrayDeque<Integer> dq = new ArrayDeque<>();

            for(int i=0; i<n; i++){
                dq.add(Integer.parseInt(st.nextToken()));
            }

            // true일 경우 덱의 first, false일 경우 덱의 last에서 접근
            boolean flag = true;

            // 함수처리
            for(int i=0; i<p.length(); i++){
                char c = p.charAt(i);
                // 순서 뒤집기
                if(c == 'R'){
                    flag = !flag;
                    continue;
                }

                // 첫 번째 수 삭제
                else if(c == 'D'){
                    if(flag){
                        // 덱이 비어있을 경우 error 출력 후 continue
                        if(dq.size() == 0){
                            sb.append("error").append('\n');
                            continue label;
                        } else{
                            dq.pollFirst();
                        }
                    } else{
                        if(dq.size() == 0){
                            sb.append("error").append('\n');
                            continue label;
                        } else{
                            dq.pollLast();
                        }
                    }
                }
            }
            // 출력
            sb.append('[');
            if(dq.size() > 0){
                if(flag){
                sb.append(dq.pollFirst());
                    while(!dq.isEmpty()){
                        sb.append(',').append(dq.pollFirst());
                    }
                }
                else {
                    sb.append(dq.pollLast());
                    while(!dq.isEmpty()){
                        sb.append(',').append(dq.pollLast());
                    }
                }
            }
            sb.append(']').append('\n');
        }
        System.out.println(sb.toString());
    }
}
