import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1515{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String fullNum = br.readLine();
        int base = 1;
        int pointer = 0;

        for(int i=0; i<30000; i++){
            String tmp = String.valueOf(base);

            for(int j=0; j<tmp.length(); j++){
                int baseNum = tmp.charAt(j) - '0';
                int curNum = fullNum.charAt(pointer) - '0';
                if(baseNum == curNum) pointer++;
                if(pointer == fullNum.length()){
                    System.out.println(base);
                    return;
                }
            }
            base++;
        }        
    }
}