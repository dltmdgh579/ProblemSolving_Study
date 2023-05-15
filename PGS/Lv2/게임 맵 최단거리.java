import java.util.*;
class Solution {
    static int answer = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        
        boolean[][] visited = new boolean[maps.length][maps[0].length]; 
        
        bfs(maps, visited); 
        
        if(answer == Integer.MAX_VALUE) answer = -1; 
        return answer;  
    }
    
    public void bfs(int[][] maps, boolean[][] visited){
        
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1));
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            Point p = q.poll();
            
            if(p.x == maps.length-1 && p.y == maps[0].length-1){
                answer = Math.min(answer, p.cnt);
            }
            
            for(int d=0; d<4; d++){
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                
                if(nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length){
                    if(maps[nx][ny] == 1 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny, p.cnt + 1));
                    }
                }
            }
        }
    }
    
    public class Point{
        int x, y, cnt;
        
        public Point(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}