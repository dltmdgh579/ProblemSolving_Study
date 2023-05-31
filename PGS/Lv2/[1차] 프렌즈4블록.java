class Solution {
    
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};
    static boolean[][] check;
    static StringBuilder sb;
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][] map = new char[m][n];
        for(int i=0; i<m; i++){
            map[i] = board[i].toCharArray();
        }
        
        while(true){
            int count = checkBlock(m, n, map);
            if(count == 0) break;
            answer += count;

            dropBlock(m, n, map);
            
        }
        
        return answer;
    }
    
    public void dropBlock(int m, int n, char[][] map){
        for(int c=0; c<n; c++){
            for(int r=m-1; r>=0; r--){
                if(map[r][c] == '#'){
                    for(int nr = r-1; nr >= 0; nr--){
                        if(map[nr][c] != '#'){
                            map[r][c] = map[nr][c];
                            map[nr][c] = '#';
                            break;
                        }
                    }
                }
            }
        }
    }
    
    public int checkBlock(int m, int n, char[][] map){
        int cnt = 0;
        check = new boolean[m][n];
        
        for(int i=0; i<m-1; i++){
            for(int j=0; j<n-1; j++){
                if(map[i][j] == '#') continue;
                bomb(i, j, map);
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(check[i][j]){
                    cnt++;
                    map[i][j] = '#';
                }
            }
        }
        return cnt;
    }
    
    public void bomb(int x, int y, char[][] map){
        char ch = map[x][y];
        
        for(int d=0; d<3; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(map[nx][ny] != ch) return;
        }
        
        for(int i=x; i<x+2; i++){
            for(int j=y; j<y+2; j++){
                check[i][j] = true;
            }
        }
    }
}