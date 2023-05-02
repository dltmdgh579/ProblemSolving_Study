import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        
        Map<String, String> nickNameMap = new HashMap<>();
        ArrayList<String[]> actionList = new ArrayList<>();
        
        int changeCount = 0;
        
        for(int i=0; i<record.length; i++){
            String[] recordStr = record[i].split(" ");
            
            String act = recordStr[0];
            String uid = recordStr[1];
            
            if(recordStr.length > 2){
                String nickName = recordStr[2];
                
                nickNameMap.put(uid, nickName);
            }
            
            if(act.equals("Change")) changeCount++;
            actionList.add(new String[] {uid, act});
        }
        
        answer = new String[actionList.size() - changeCount];
        
        int idx = 0;
        for(int i=0; i<actionList.size(); i++){
            if(actionList.get(i)[1].equals("Enter")){
                answer[idx++] = nickNameMap.get(actionList.get(i)[0]) + "님이 들어왔습니다.";
            }
            
            if(actionList.get(i)[1].equals("Leave")){
                answer[idx++] = nickNameMap.get(actionList.get(i)[0]) + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}