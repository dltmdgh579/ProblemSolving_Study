import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_11725{
    static ArrayList<ArrayList<Integer>> node;
    static int[] parents;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        parents = new int[N+1];
        node = new ArrayList<>();

        for(int i=0; i<=N; i++){
            node.add(new ArrayList<>());
        }

        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            node.get(p).add(c);
            node.get(c).add(p);
        }
        
        bfs();
        for(int i=2; i<=N; i++){
            System.out.println(parents[i]);
        }
    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        parents[1] = 1;

        while(!q.isEmpty()){
            int parent = q.poll();

            for(int n : node.get(parent)){
                if(parents[n] == 0){
                    parents[n] = parent;
                    q.add(n);
                }
            }
        }
    }
}