import java.util.*;
import java.io.*;
public class BOJ_21608 {
    
    static int N, friendsScore;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] classroom;
    static ArrayList<Friends> friends;
    static ArrayList<int[]> maxFavoritePlace;
    
    static class Friends{
        int myself;
        int[] friendList;
        
        public Friends(int myself, int[] friendList){
            this.myself = myself;
            this.friendList = friendList;
        }
    }
    
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      N = Integer.parseInt(br.readLine());
      
      classroom = new int[N+1][N+1];
      friends = new ArrayList<>();
      maxFavoritePlace = new ArrayList<>();
      
      for(int i=0; i<N*N; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          
          int myself = Integer.parseInt(st.nextToken());
          int friend1 = Integer.parseInt(st.nextToken());
          int friend2 = Integer.parseInt(st.nextToken());
          int friend3 = Integer.parseInt(st.nextToken());
          int friend4 = Integer.parseInt(st.nextToken());
          
          friends.add(new Friends(myself, new int[] {friend1, friend2, friend3, friend4}));
      }
      
      placement();

    }
    
    public static void placement(){
        for(Friends student : friends){
            //1. 좋아하는 학생 체크
            favoriteFriends(student.myself);
            
            //2. 주변 비어있는 칸 체크
            if(maxFavoritePlace.size() > 1){
                emptyPlace();
            } else {
                classroom[maxFavoritePlace.get(0)[0]][maxFavoritePlace.get(0)[1]] = student.myself;
                continue;
            }
            
            //3. 행, 열 번호 작은 칸 체크
        }
        
    }
    
    public static void favoriteFriends(int myself){
        boolean[][] visited = new boolean[N+1][N+1];
        int[][] friendsScoreMap = new int[N+1][N+1];
        
        int count = 0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(classroom[i][j] == 0){
                    count = friendsCheck(friends.get(i), i, j, visited);
                }
                friendsScoreMap[i][j] = count;
                friendsScore = Math.max(friendsScore, count);
            }
        }
        
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(friendsScoreMap[i][j] == friendsScore) {
                    maxFavoritePlace.add(new int[] {i, j});
                }
            }
        }
    }
    
    public static int friendsCheck(Friends friends , int i, int j, boolean[][] visited){
        int tmpCount = 0;
        for(int d=0; d<4; d++){
            int nx = i + dx[d];
            int ny = j + dy[d];
            
            if(nx >= 1 && nx <= N && ny >= 1 && ny <= N){
                if(!visited[nx][ny]){
                    for(int n=0; n<4; n++){
                        if(classroom[nx][ny] == friends.friendList[n]){
                            tmpCount++;
                        }
                    }
                    visited[nx][ny] = true;
                }
            }
        }
        
        return tmpCount;
    }

    public static void emptyPlace(){
        
    }
}