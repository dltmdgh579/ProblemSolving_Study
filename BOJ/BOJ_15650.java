import java.util.Scanner;

public class BOJ_15650 {
    static int N, M;
    static int[] arr, result;
    static boolean[] selected;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        // 전체 수열을 담은 배열
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = i+1;
        }

        // 전체 수열 중 M개
        result = new int[M];

        selected = new boolean[N];
        combination(0, 0);
    }

    // 조합
    public static void combination(int cnt, int start){
        // M개 만큼 선택된 경우 출력
        if(cnt == M){
            for(int i=0; i<result.length; i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=start; i<N; i++){
            // result 배열에 출력할 수열 저장
            result[cnt] = arr[i];
            combination(cnt+1, i+1); // 다음 수 선택
        }
    }
}
