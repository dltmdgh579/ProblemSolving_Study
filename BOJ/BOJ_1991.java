import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1991 {

    static List<Node>[] list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        for(int i=0; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<N; i++){
            String[] nodeList = br.readLine().split(" ");
            int origin = nodeList[0].charAt(0) - 'A' + 1;
            int left = nodeList[1].charAt(0) - 'A' + 1;
            int right = nodeList[2].charAt(0) - 'A' + 1;
            list[origin].add(new Node(left, right));
        }

        preorder(1);
        sb.append('\n');
        inorder(1);
        sb.append('\n');
        postorder(1);
        sb.append('\n');
        System.out.println(sb.toString());
    }

    static void preorder(int start){
        for(Node node : list[start]){
            int l = node.left;
            int r = node.right;
            sb.append((char)(start + 'A' - 1));
            if(l != -18) preorder(l);
            if(r != -18) preorder(r);
        }
    }

    static void inorder(int start){
        for(Node node : list[start]){
            int l = node.left;
            int r = node.right;
            if(l != -18) inorder(l);
            sb.append((char)(start + 'A' - 1));
            if(r != -18) inorder(r);
        }
    }

    static void postorder(int start){
        for(Node node : list[start]){
            int l = node.left;
            int r = node.right;
            if(l != -18) postorder(l);
            if(r != -18) postorder(r);
            sb.append((char)(start + 'A' - 1));
        }
    }

    static class Node {
        int left, right;
        public Node(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
}