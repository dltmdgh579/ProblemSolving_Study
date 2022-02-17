import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ_6416 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int cases = 0;

        ArrayList<int[]> list = new ArrayList<>(); // 간선 정보
        HashMap<Integer, Integer> check = new HashMap<>(); // 노드 체크

        while(true){

            // 입력
            int u = sc.nextInt();
            int v = sc.nextInt();

            // 두 개의 음의 정수 입력 시 종료
            if(u < 0 && v < 0) break;

            // 간선 정보 저장
            list.add(new int[] {u, v});

            // hashmap으로 각 노드 정보 저장
            check.put(u, 0);
            check.put(v, 0);

            // 두 개의 0 입력될 경우 트리 분석
            if(u == 0 && v == 0){
                int root = 0;
                boolean flag = true;
                cases++;

                // 전체 노드 검사
                for(Integer i : check.keySet()){
                    int count = 0;
                    // 하나의 노드마다 간선 정보 비교
                    for(int[] li : list){
                        if(li[1] == i) count++;
                    }
                    // 들어오는 간선이 없을 경우 루트 노드
                    if(count == 0){
                        root++;
                    }
                    // 들어오는 간선이 두개 이상일 경우
                    if(count > 1){
                        System.out.println("Case " + cases + " is not a tree.");
                        flag = false;
                        break;
                    }
                }
                // 입력이 하나(0, 0)가 아니면서 루트가 하나가 아닌 경우
                if(root != 1 && list.size() != 1){
                    System.out.println("Case " + cases + " is not a tree.");
                    flag = false;
                }
                // 그 외 true
                if(flag) System.out.println("Case " + cases + " is a tree.");
                
                // 리스트, 해시맵 초기화
                list = new ArrayList<>();
                check = new HashMap<>();
            }
        }
    }
}
