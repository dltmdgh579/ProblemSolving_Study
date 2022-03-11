import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309{
    static int[] arr, seven;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        arr = new int[9];
        seven = new int[7];
        for(int i=0; i<9; i++){
            arr[i] = sc.nextInt();
        }
        comb(0, 0);

    }
    public static void comb(int cnt, int start){
        if(cnt == 7){
            int sum = 0;
            for(int i=0; i<7; i++){
                sum += seven[i];
            }
            if(sum == 100){
                Arrays.sort(seven);
                for(int i=0; i<7; i++){
                    System.out.println(seven[i]);
                }
                System.exit(0);
            }
            return;
        }

        for(int i=start; i<9; i++){
            seven[cnt] = arr[i]; 
            comb(cnt+1, i+1);
        }
    }
}