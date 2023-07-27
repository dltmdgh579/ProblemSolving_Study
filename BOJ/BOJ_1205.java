import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1205 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int rankScore = 1;

        List<Integer> rank = new ArrayList<>();

        
        if(N == 0){
            System.out.println(1);
        } else {
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                int curScore = Integer.parseInt(st.nextToken());
                rank.add(curScore);
            }
            
            if(N == P && rank.get(rank.size()-1) >= newScore){
                System.out.println(-1);
            } else {
                for(int r : rank){
                    if(r > newScore){
                        rankScore++;
                    } else {
                        break;
                    }
                }
                System.out.println(rankScore);
            }

        }
        
    }
}
