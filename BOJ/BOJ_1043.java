import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1043 {
    static int N, M, count;
    static int[][] partyPeople;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 파티마다 오는 사람들
        partyPeople = new int[51][51];

        HashSet<Integer> knowPeople = new HashSet<>();
        
        // 진실을 아는 사람들
        st = new StringTokenizer(br.readLine());
        int knowNum = Integer.parseInt(st.nextToken());
        if(knowNum > 0){
            for(int i=0; i<knowNum; i++){
                knowPeople.add(Integer.parseInt(st.nextToken()));
            }
        }

        // 진실을 아는 사람이 있는 파티번호 key에 저장
        HashSet<Integer> key = new HashSet<>();
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int pnum = Integer.parseInt(st.nextToken());
            for(int j=1; j<=pnum; j++){
                partyPeople[i][j] = Integer.parseInt(st.nextToken());
                if(knowPeople.contains(partyPeople[i][j])){
                    key.add(i);
                }
            }
        }

        // 진실을 아는 사람이 있는 파티의 모든 사람 knowPeople에 저장
        for(int i=1; i<=M; i++){
            if(key.contains(i)){
                for(int j=1; j<=partyPeople[i].length-1; j++){
                    if(partyPeople[i][j] != 0){
                        knowPeople.add(partyPeople[i][j]);
                    }
                }
            }
        }

        // 진실을 아는 사람이 있는 파티 탐색 반복
        while(true){
            boolean flag = false;
            for(int i=1; i<=M; i++){
                // key에 저장되어 있지 않은 파티 중 진실을 아는 사람이 있으면 key에 저장
                if(!key.contains(i)){
                    for(int j=1; j<=partyPeople[i].length-1; j++){
                        if(knowPeople.contains(partyPeople[i][j])){
                            flag = true;
                            key.add(i);
                        }
                    }
                }
            }
            // key에 저장된 파티의 모든 사람 knowPeople에 저장
            for(int i=1; i<=M; i++){
                if(key.contains(i)){
                    for(int j=1; j<=partyPeople[i].length-1; j++){
                        if(partyPeople[i][j] != 0){
                            knowPeople.add(partyPeople[i][j]);
                        }
                    }
                }
            }
            // key에 저장되어 있지 않은 파티 중 진실을 아는 사람이 없으면 break;
            if(!flag) break;
        }

        // key에 저장되어 있지 않은 파티는 진실을 아는 사람이 없음.
        for(int i=1; i<=M; i++){
            if(!key.contains(i)) count++;
        }

        System.out.println(count);
    }
}
