import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1446 {

    static int N, D, INF = 987654321;
    static List<ShortPath> paths;
    static Pair[] pairs;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        paths = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if(to > D) continue;
            if(dist >= (to - from)) continue;
            paths.add(new ShortPath(from, to, dist));
        }

        pairs = new Pair[D+1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0; i<pairs.length; i++){
            Pair p = new Pair(i, INF);
            pairs[i] = p;
            if(i == 0){
                p.dist = 0;
                pq.offer(p);
            }
        }

        while(!pq.isEmpty()){
            Pair front = pq.poll();
            if(front.no == D) break;

            Pair next = pairs[front.no + 1];
            if(next.dist > front.dist + 1){
                next.dist = front.dist + 1;
                pq.offer(next);
            }

            for(ShortPath path : paths){
                if(path.from == front.no){
                    Pair spNext = pairs[path.to];
                    if(spNext.dist > front.dist + path.dist){
                        spNext.dist = front.dist + path.dist;
                        pq.offer(spNext);
                    }
                }
            }
        }
        System.out.println(pairs[D].dist);
    }

    static class Pair implements Comparable<Pair>{
        int no, dist;
        public Pair(int no, int dist){
            this.no = no;
            this.dist = dist;
        }
        @Override
        public int compareTo(Pair o) {
            return this.dist - o.dist;
        }
    }

    static class ShortPath {
        int from, to, dist;
        public ShortPath(int from, int to, int dist){
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }
}