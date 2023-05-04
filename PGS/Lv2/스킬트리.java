class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i=0; i<skill_trees.length; i++){
            
            int idx = 0;
            boolean flag = true;
            
            for(int j=0; j<skill_trees[i].length(); j++){
                char c = skill_trees[i].charAt(j);
                
                for(int k=0; k<skill.length(); k++){
                    if(skill.charAt(k) == c && k == idx){
                        idx++;
                    } else if(skill.charAt(k) == c && k != idx) {
                        flag = false;
                        break;
                    }
                }
                
                if(!flag) break;
                
            }
            
            if(flag) answer++;
        }
        
        return answer;
    }
}