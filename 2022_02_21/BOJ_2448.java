import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2448 {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        String[] star = new String[N];
        star[0] = "  *  ";
        star[1] = " * * ";
        star[2] = "*****";

        // 
        for(int k=1; 3*Math.pow(2, k)<=N; k++){
            print(star, k);
        }

        for(int i=0; i<star.length; i++){
            sb.append(star[i]).append('\n');
        }
        System.out.println(sb);
    }

    public static void print(String[] star, int k){
        int last = 3*(int)Math.pow(2, k); //마지막 라인
        int j=0;
        // 중간라인 이후부터 마지막 라인까지 출력할 별 저장
        for(int i=last/2; i<last; i++){
            star[i] = star[j] + " " + star[j];
            j++;
        }

        // 첫 번째 라인부터 중간 라인까지 공간 저장
        String space = "";
        for(int i=0; i<last/2; i++){
            space += " ";
        }

        // 첫 번째 라인부터 중간 라인까지 출력할 별 저장
        for(int i=0; i<last/2; i++){
            star[i] = space + star[i] + space;
        }
    }
}
