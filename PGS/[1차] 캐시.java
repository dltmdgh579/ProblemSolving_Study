import java.util.*;

class Solution {
    
    static final int CACHE_HIT = 1;
    static final int CACHE_MISS = 5;
    
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0) return 5 * cities.length;
        
        LinkedList<String> cache = new LinkedList<>();
        
        for(int i=0; i<cities.length; i++){ 
            String city = cities[i].toUpperCase();
            
            if(cache.remove(city)){
                cache.addFirst(city);
                answer += CACHE_HIT;
            } else {
                if(cache.size() == cacheSize){ 
                    cache.pollLast();
                }
                
                cache.addFirst(city);
                answer += CACHE_MISS;
            }
        }
        
        return answer;
    }
}