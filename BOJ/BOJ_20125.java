import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20125 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] board = new char[N+1][N+1];
        int[] rowCount = new int[N+1];

        for(int i=1; i<=N; i++){
            String str = br.readLine();
            for(int j=1; j<=N; j++){
                board[i][j] = str.charAt(j-1);
            }
        }
        
        for(int i=1; i<=N; i++){
            int count = 0;
            for(int j=1; j<=N; j++){
                if(board[i][j] == '*'){
                    count++;
                }
            }
            rowCount[i] = count;
        }

        int[] heart = new int[2];
        int legsStartRow = 0;
        boolean headCheck = false, armsCheck = false, legsCheck = false;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(heart[1] == 0 && board[i][j] == '*'){
                    heart[1] = j;
                    headCheck = true;
                }
                
                if(headCheck && heart[0] == 0 && rowCount[i] > 1){
                    heart[0] = i;
                    armsCheck = true;
                    break;
                }

                if(!legsCheck && armsCheck && rowCount[i] > 1){
                    legsStartRow = i;
                    legsCheck = true;
                }
            }
        }

        int leftArm = 0, rightArm = 0, waist = 0, leftLeg = 0, rightLeg = 0;
        for(int i=1; i<=N; i++){
            if(board[heart[0]][i] == '*' && i < heart[1]){
                leftArm++;
            } else if (board[heart[0]][i] == '*' && i > heart[1]){
                rightArm++;
            }
        }

        waist = legsStartRow - heart[0] - 1;

        for(int i=legsStartRow; i<=N; i++){
            if(board[i][heart[1] - 1] == '*'){
                leftLeg++;
            }
            if(board[i][heart[1] + 1] == '*'){
                rightLeg++;
            }
        }

        System.out.println(heart[0] + " " + heart[1]);
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }
    
}
