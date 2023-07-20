import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4659 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String password = "";

        while(true){
            password = br.readLine();

            if(password.equals("end")) break;

            boolean flag = true;

            if(!password.contains("a") 
            && !password.contains("e") 
            && !password.contains("i") 
            && !password.contains("o") 
            && !password.contains("u")){
                flag = false;
            };

            for(int i=0; i<password.length()-2; i++){
                char c = password.charAt(i);

                if(checkConsonant(c)){
                    if(checkConsonant(password.charAt(i+1)) && checkConsonant(password.charAt(i+2))){
                        flag =false;
                        break;
                    }
                }
                if(checkVowel(c)){
                    if(checkVowel(password.charAt(i+1)) && checkVowel(password.charAt(i+2))){
                        flag =false;
                        break;
                    }
                }
            }

            for(int i=1; i<password.length(); i++){
                char prev = password.charAt(i-1);
                char cur = password.charAt(i);
                if(prev == cur){
                    if(cur != 'e' && cur != 'o'){
                        flag = false;
                        break;
                    }
                }
            }

            if(flag){
                sb.append("<").append(password).append("> is acceptable.\n");
            } else {
                sb.append("<").append(password).append("> is not acceptable.\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static boolean checkConsonant(char c){
        if(c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u'){
            return true;
        }
        return false;
    }

    public static boolean checkVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        return false;
    }
}
