import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        // 뺄셈 기준으로 분리
        String[] str1 = str.split("-");
        
        int result = 0;
        for(int i=0; i<str1.length; i++){
            int sum = 0;

            // 분리된 수식 더하기 계산
            String[] str2 = str1[i].split("\\+");
            for(int j=0; j<str2.length; j++){
                sum += Integer.parseInt(str2[j]);
            }

            // 첫 번째 덧셈 수식 결과일 경우 +, 그 이후 -
            if(i == 0){
                result += sum;
            } else {
                result -= sum;
            }
        }

        System.out.println(result);
    }
}
