class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        new_id = new_id.toLowerCase();
        
        String id = "";
        for(int i=0; i<new_id.length(); i++){
            char c = new_id.charAt(i);
            
            if(c >= 'a' && c <= 'z'){
                id += String.valueOf(c);
            } else if(c >= '0' && c <= '9'){
                id += String.valueOf(c);
            } else if(c == '-' || c == '_' || c == '.'){
                id += String.valueOf(c);
            }
        }
        
        for(int i=0; i<id.length(); i++){
            char c = id.charAt(i);
            
            if(c == '.'){
                int j = i+1;
                String dot = ".";
                
                while(j < id.length() && id.charAt(j) == '.'){
                    j++;
                    dot += ".";                    
                }
                id = id.replace(dot, ".");
            }
        }
        
        if(id.length() > 0){
            if(id.charAt(0) == '.'){
                id = id.substring(1, id.length());
            }
        }
        if(id.length() > 0){
            if(id.charAt(id.length()-1) == '.'){
                id = id.substring(0, id.length()-1);
            }
        }
        
        
        if(id.equals("")){
            id += "a";
        }
        
        if(id.length() >= 16){
            id = id.substring(0, 15);
            
            if(id.charAt(id.length()-1) == '.'){
                id = id.substring(0, id.length()-1);
            }
        }
        
        
        if(id.length() <= 2){
            while(id.length() < 3){
                id += id.charAt(id.length()-1);
            }
        }
        
        answer = id;
        return answer;
    }
}