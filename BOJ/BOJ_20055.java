import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20055 {

    static int N, K, stage;
    static boolean flag;
    static int[] belt;
    static boolean[] robots;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belt = new int[2*N];
        robots = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2*N; i++){
            belt[i] = Integer.parseInt(st.nextToken());
        }

        while(!flag){
            stage++;
            start();
        }

        System.out.println(stage);

    } 
    public static void start(){

        //1. 벨트가 로봇과 함께 회전
        //1-1. 벨트 회전
        int temp = belt[2*N-1];
        for(int i=2*N-2; i>=0; i--){
            belt[i+1] = belt[i];
        }
        belt[0] = temp;

        //1-2. 로봇 이동
        for(int i=N-2; i>=0; i--){
            robots[i+1] = robots[i];
        }
        robots[0] = false;
        robots[N-1] = false; //내리는 위치에 도달하면 그 즉시 내린다.

        //2. 벨트가 회전하는 방향으로 로봇 한 칸 이동
        for(int i=N-2; i>=0; i--){
            if(robots[i] && belt[i+1] > 0 && !robots[i+1]){
                robots[i+1] = robots[i];
                robots[i] = false;
                belt[i+1]--;
            }
        }
        robots[N-1] = false;

        //3. 올리는 위치에 로봇 올리기
        if(belt[0] > 0){
            robots[0] = true;
            belt[0]--;
        }

        //4. 내구도 0인 칸 K개 이상인지 검사
        int count = 0;
        for(int i=0; i<2*N; i++){
            if(belt[i] == 0) count++;
            if(count >= K) {
                flag = true;
                break;
            }
        }
    }
}