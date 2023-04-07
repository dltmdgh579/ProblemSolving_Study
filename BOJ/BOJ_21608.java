import java.util.*;
import java.io.*;
public class BOJ_21608 {
    
    static int N, sum;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] students;
    static int[][] classroom;
    static Map<Integer, Set<Integer>> friends;
    
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      N = Integer.parseInt(br.readLine());
      
      classroom = new int[N+1][N+1];
      friends = new HashMap<>();
      students = new int[N*N];
      
      for(int i=0; i<N*N; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          
          int myself = Integer.parseInt(st.nextToken());

          students[i] = myself;
          
          friends.put(myself, new HashSet<>());
          for(int j=0; j<4; j++){
            friends.get(myself).add(Integer.parseInt(st.nextToken()));
          }
      }
      
      placement();

      System.out.println(sum);

    }
    
    public static void placement(){

        for(int i=0; i<students.length; i++){
            Seat seat = findSeat(students[i]);
            classroom[seat.x][seat.y] = students[i];
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                int count = getStudentSum(i, j, classroom[i][j]);
                if(count > 0){
                    sum += (int) Math.pow(10, count-1);
                }
            }
        }
        
    }
    
    public static Seat findSeat(int student){
        Seat seat = null;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(classroom[i][j] > 0) continue;

                Seat cur = new Seat(i, j, getStudentSum(i, j, student), getEmptySum(i, j));

                if(seat == null){
                    seat = cur;
                    continue;
                }

                if(seat.compareTo(cur) > 0){
                    seat = cur;
                }
            }
        }
        return seat;
    }
    
    public static int getStudentSum(int x , int y, int student){
        int count = 0;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 1 && nx <= N && ny >= 1 && ny <= N){
                if(friends.get(student).contains(classroom[nx][ny])){
                    count++;
                }
            }
        }
        return count;
    }

    public static int getEmptySum(int x, int y){
        int count = 0;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 1 && nx <= N && ny >= 1 && ny <= N){
                if(classroom[nx][ny] == 0){
                    count++;
                }
            }
        }
        return count;
    }

    static class Seat implements Comparable<Seat>{
        int x, y, studentSum, emptySum;

        public Seat(int x, int y, int studentSum, int emptySum){
            this.x = x;
            this.y = y;
            this.studentSum = studentSum;
            this.emptySum = emptySum;
        }

        @Override
        public int compareTo(Seat o) {

            if(studentSum != o.studentSum){
                return o.studentSum - studentSum;
            }

            if(emptySum != o.emptySum){
                return o.emptySum - emptySum;
            }

            if(x != o.x){
                return x - o.x;
            }

            return y - o.y;
        }
    }
}