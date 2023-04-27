import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        int baseTime = fees[0];
        int baseFee = fees[1];
        int chargeHour = fees[2];
        int unitCharge = fees[3];
        
        Map<String, Integer> mapRecord = new HashMap<>();
        Map<String, Integer> mapTotalRate = new TreeMap<>();
        
        for(int i=0; i<records.length; i++){
            String[] record = records[i].split(" ");
            
            String[] strTime = record[0].split(":");
            int time = Integer.parseInt(strTime[0]) * 60 + Integer.parseInt(strTime[1]);
            String carNumber = record[1];
            String details = record[2];

            if(details.equals("IN")){
                mapRecord.put(carNumber, time);
            }
            
            if(details.equals("OUT")){
                mapTotalRate.put(carNumber, mapTotalRate.getOrDefault(carNumber, 0) + time - mapRecord.get(carNumber));
                mapRecord.remove(carNumber);
            }
        }
        
        if(mapRecord.size() > 0){
            for(String carNumber : mapRecord.keySet()){
                mapTotalRate.put(carNumber, mapTotalRate.getOrDefault(carNumber, 0) + 1439 - mapRecord.get(carNumber));
            }
        }
        
        answer = new int[mapTotalRate.size()];
        
        int idx = 0;
        for(int pTime : mapTotalRate.values()){
            if(pTime <= baseTime){
                answer[idx++] = baseFee;
            } else {
                answer[idx++] = baseFee + (int) Math.ceil((double) (pTime - baseTime)/chargeHour) * unitCharge;
            }
        }
        
        return answer;
    }
}