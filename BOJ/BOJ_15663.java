import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_15663 {

    static int N, M;
    static int[] arr;
    static int[] nums;
    static boolean[] visited;
    static HashSet<String> set;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        arr = new int[N];
        visited = new boolean[N];
        set = new HashSet<>();

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        per(0);
        System.out.println(sb.toString());
    }

    public static void per(int cnt){
        if(cnt == M){
            StringBuilder sb2 = new StringBuilder();
            for(int i=0; i<M; i++){
                sb2.append(arr[i] + " ");
            }
            if(!set.contains(sb2.toString())){
                set.add(sb2.toString());
                sb.append(sb2.toString()).append('\n');
            }
            return;
        }

        for(int i=0; i<N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            arr[cnt] = nums[i];
            per(cnt + 1);
            visited[i] = false;
        }
    }
}