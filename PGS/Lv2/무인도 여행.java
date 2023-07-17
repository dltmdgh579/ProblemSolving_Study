import java.util.*;
class Solution {
    static int max;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Integer> list;
    static boolean[][] visited;
    public int[] solution(String[] maps) {
        int[] answer = {};
        
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        list = new ArrayList<>();
        
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                if(visited[i][j] || map[i][j] == 'X') continue;
                dfs(i, j, map[i][j] - '0');
                list.add(max);
                max = 0;
            }
        }
        
        Collections.sort(list);
        if(list.size() == 0) return new int[] {-1};
        answer = new int[list.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public void dfs(int r, int c, int food){
        max += food;
        visited[r][c] = true;
        
        for(int i=0; i<4; i++){
            int nx = r + dx[i];
            int ny = c + dy[i];

            if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length){
                if(visited[nx][ny] || map[nx][ny] == 'X') continue;
                dfs(nx, ny, map[nx][ny] - '0');
            }
        }
    }
}