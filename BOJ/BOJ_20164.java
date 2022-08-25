import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20164 {

    static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        operate(N, getOdd(N));
        System.out.println(min + " " + max);
    }

    public static void operate(int n, int total){
        // 한 자릿수일 경우
        if(n < 10){
            min = Math.min(min, total);
            max = Math.max(max, total);
            return;
        } 
        // 두 자릿수일 경우
        else if (n < 100){
            int sum = n/10 + n%10;
            operate(sum, total + getOdd(sum));
        } 
        // 세 자릿수 이상일 경우
        else {
            String str = Integer.toString(n);
            for(int i=0; i<str.length()-2; i++){
                for(int j=i+1; j<str.length()-1; j++){
                    String s1 = str.substring(0, i+1);
                    String s2 = str.substring(i+1, j+1);
                    String s3 = str.substring(j+1, str.length());

                    int sum = Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3);
                    operate(sum, total+getOdd(sum));
                }
            }
        }
    }

    // 홀수 개수 계산
    public static int getOdd(int num){
        int count = 0;
        while(num != 0){
            int numOne = num%10;
            if(numOne % 2 == 1) count++;
            num /= 10;
        }
        return count;
    }
}