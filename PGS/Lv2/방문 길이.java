import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<Point> visit = new HashSet<>();

        int x = 0, y = 0;
        for(int i=0; i<dirs.length(); i++){
            char d = dirs.charAt(i);
            int[] dir = dir(d);
            
            int nx = x + dir[0];
            int ny = y + dir[1];
            
            if(checkArea(nx, ny)) {
                visit.add(Point.of(d, x, y, nx, ny));
                x = nx;
                y = ny;
            }
        }
        
        return visit.size();
    }
    
    public int[] dir(char dir){
        switch (dir) {
            case 'U': return new int[] {0, 1};
            case 'D': return new int[] {0, -1};
            case 'L': return new int[] {-1, 0};
            case 'R': return new int[] {1, 0};
        }
        throw new IllegalArgumentException("dir : " + dir);
    }
    
    public boolean checkArea(int x, int y){
        if(x >= -5 && x <= 5 && y >= -5 && y <= 5){
            return true;
        }
        return false;
    }
}

class Point{
    int x1, y1;
    int x2, y2;

    public Point(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    static Point of(char dir, int x, int y, int nx, int ny) {
        switch(dir) {
            case 'U':
            case 'R':
                return new Point(x, y, nx, ny);
            case 'D':
            case 'L':
                return new Point(nx, ny, x, y);
        }
        throw new IllegalArgumentException("dir : " + dir);
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(!(obj instanceof Point)) return false;
        Point that = (Point) obj;

        return x1 == that.x1 && y1 == that.y1 && x2 == that.x2 && y2 == that.y2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, y1, x2, y2);
    }
}