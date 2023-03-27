import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10973 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int N = Integer.parseInt(br.readLine());

        int[] perArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            perArr[i] = Integer.parseInt(st.nextToken());
        }

        int n = perArr.length - 1;

        while(n > 0 && perArr[n-1] <= perArr[n]){
            n -= 1;
        }

        if(n <= 0){
            System.out.println(-1);
        } else {
            int m = perArr.length - 1;
            while(perArr[m] >= perArr[n-1]){
                m -= 1;
            }

            swap(perArr, n-1, m);

            m = perArr.length - 1;
            while(n < m){
                swap(perArr, n, m);
                n += 1;
                m -= 1;
            }

            for(int i=0; i<N; i++){
                System.out.print(perArr[i] + " ");
            }
        }

    }

    public static void swap(int[] perArr, int n, int m){
        int tmp = perArr[n];
        perArr[n] = perArr[m];
        perArr[m] = tmp;
    }
}
