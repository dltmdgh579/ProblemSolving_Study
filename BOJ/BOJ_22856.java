import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_22856 {

    static int N, count;
    static boolean rootFlag;
    static List<Node>[] tree;
    static List<Integer> inOrder;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        for(int i=0; i<N+1; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            tree[cur].add(new Node(left, right));
        }

        inOrder = new ArrayList<>();
        dfs(1, true);
        dfs(1, false);
    }

    public static void dfs(int curNode, boolean flag){
        Node n = tree[curNode].get(0);
        // if(curNode == N && rootFlag) {
        //     System.out.println(count);
        //     System.exit(0);
        // }
        if(n.left != -1){
            dfs(n.left, flag);
            if(!rootFlag) rootFlag = true;
            if(!flag) count++;
        }
        if(flag){
            inOrder.add(curNode);
        } else {
            if(inOrder.get(inOrder.size()-1) == curNode){
                System.out.println(count);
                return;
            }
            count++;
        }
        if(n.right != -1){
            dfs(n.right, flag);
            if(!rootFlag) rootFlag = true;
            if(!flag) count++;
        }
    }

    static class Node{
        int left, right;
        public Node(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
}