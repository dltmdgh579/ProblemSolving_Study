import java.util.Scanner;

public class BOJ_1068 {

    static int N, removeIdx;
    static int[] arr;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
    
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        removeIdx = sc.nextInt();

        
        remove(removeIdx);

        int count = 0;
        boolean[] check = new boolean[N];
        for(int i=0; i<N; i++){
            if(arr[i] == -2) continue; // 삭제된 노드 스킵
            if(arr[i] == -1){
                count++;
                continue;
            }
            // 첫번째 자식노드 count 스킵
            if(!check[arr[i]]){
                check[arr[i]] = true;
                continue;
            }
            count++;
        }
        System.out.println(count);
    }

    public static void remove(int r){
        // 삭제할 노드 삭제
        arr[r] = -2;
        for(int i=0; i<N; i++){
            if(arr[i] == r){
                remove(i); // 삭제할 노드의 자식노드 삭제
            }
        }
    }
}
