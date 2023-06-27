import java.util.*;
class Solution {
    String[] userId, bannedId;
    HashSet<HashSet<String>> result = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        
        userId = user_id;
        bannedId = banned_id;
        
        dfs(new HashSet<>(), 0);
        
        return result.size();
    }
    
    public void dfs(HashSet<String> set, int depth){
        if(bannedId.length == depth){
            result.add(set);
            return;
        }
        
        for(int i=0; i<userId.length; i++){
            if(set.contains(userId[i])) continue;
            
            if(check(userId[i], bannedId[depth])){
                set.add(userId[i]);
                dfs(new HashSet<>(set), depth + 1);
                set.remove(userId[i]);
            }
        }
    }
    
    public boolean check(String userId, String bannedId){
        if(userId.length() != bannedId.length()){
            return false;
        }
        
        for(int i=0; i<userId.length(); i++){
            if(bannedId.charAt(i) == '*') continue;
            if(userId.charAt(i) != bannedId.charAt(i)){
                return false;
            }
        }
        
        return true;
    }
    
}