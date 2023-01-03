import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1062 {
    static int N, K, max;
    static boolean[] visited;
    static String[] words;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];
        visited = new boolean[26];

        for(int i=0; i<N; i++){
            String word = br.readLine();
            word = word.replace("anta", "");
            word = word.replace("tica", "");
            words[i] = word;
        }

        if(K < 5){
            System.out.println("0");
            return;
        } else if(K == 26){
            System.out.println(N);
            return;
        }

        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        
        backtracking(0, 0);
        System.out.println(max);
    }

    public static void backtracking(int start, int cnt){
        if(cnt == K-5){
            int count = 0;
            for(int i=0; i<N; i++){
                boolean check = true;
                for(int j=0; j<words[i].length(); j++){
                    if(!visited[words[i].charAt(j) - 'a']){
                        check = false;
                        break;
                    }
                }
                if(check) count++;
            }
            max = Math.max(max, count);
            return;
        }

        for(int i=start; i<26; i++){
            if(visited[i]) continue;
            visited[i] = true;
            backtracking(i, cnt+1);
            visited[i] = false;
        }
    }
}
