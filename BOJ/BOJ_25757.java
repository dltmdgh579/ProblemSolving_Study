import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_25757 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        char game = st.nextToken().charAt(0);
        int gameCount = 0;

        Set<String> set = new HashSet<>();
        
        for(int i=0; i<N; i++){
            set.add(br.readLine());
        }

        if(game == 'Y'){
            gameCount = set.size();
        } else if(game == 'F'){
            gameCount = set.size()/2;
        } else {
            gameCount = set.size()/3;
        }

        System.out.println(gameCount);
    }
}
