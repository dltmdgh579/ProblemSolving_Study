import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5639 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        String input;

        while(true){
            input = br.readLine();
            if(input == null || input.equals("")) break;

            root.insert(Integer.parseInt(input));
        }

        postOrder(root);

    }

    public static void postOrder(Node node){
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
    }

    static class Node{
        int num;
        Node left, right;

        Node(int num){
            this.num = num;
        }

        Node(int num, Node left, Node rigth){
            this.num = num;
            this.left = left;
            this.right = rigth;
        }

        void insert(int n){
            if(n < this.num){
                if(this.left == null){
                    this.left = new Node(n);
                } else {
                    this.left.insert(n);
                }
            } else {
                if(this.right == null){
                    this.right = new Node(n);
                } else {
                    this.right.insert(n);
                }
            }
        }
    }
}
