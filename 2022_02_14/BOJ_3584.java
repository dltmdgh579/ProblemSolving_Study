import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3584{
    static int[] parentSearch;
    static int A, B, N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            N = Integer.parseInt(br.readLine());

            parentSearch = new int[N+1]; // 부모를 저장해 놓는 배열
            
            for(int i = 0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                
                if(i==N-1){ // 마지막 부분은 공통 조상을 구할 두 노드 입력
                    A = parent; 
                    B = child;
                    break;
                }

                parentSearch[child] = parent; // 자식 노드번호 인덱스에 부모 저장
            }

            // 노드의 depth 구하기
            int ADepth = getDepth(A);
            int BDepth = getDepth(B);

            int result = lca(A, ADepth, B, BDepth);
            System.out.println(result);

        }
    }

    // 공통 조상 구하는 과정
    public static int lca(int a, int aDepth, int b, int bDepth) {
        // 두 노드의 depth를 맞추는 과정
        if(aDepth > bDepth){
            while(aDepth != bDepth){
                aDepth--;
                a = parentSearch[a];
            }
        } else if(aDepth < bDepth){
            while(aDepth != bDepth){
                bDepth--;
                b = parentSearch[b];
            }
        }

        // 높이를 맞춘 후 공통 조상이 나올 때 까지 각자 부모로 이동
        while(a != b){
            a = parentSearch[a];
            b = parentSearch[b];
        }
        return a;
    }

    // depth 구하기
    public static int getDepth(int x) {
        int depth = 0;
        int cur = x;
        // 루트 노드까지 이동
        while(cur != 0){
            depth++;
            cur = parentSearch[cur];
        }
        return depth;
    }
}