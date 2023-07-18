import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Music> answer = new ArrayList<>();
        
        HashMap<String, Integer> genresMap = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            genresMap.put(genres[i], genresMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        ArrayList<String> genresOrder = new ArrayList<>();
        while(genresMap.size() > 0){
            int max = -1;
            String maxKey = "";
            for(String key : genresMap.keySet()){
                int tmp = genresMap.get(key);
                if(tmp > max){
                    max = tmp;
                    maxKey = key;
                }
            }
            genresOrder.add(maxKey);
            genresMap.remove(maxKey);
        }
        
        for(String key : genresOrder){
            ArrayList<Music> list = new ArrayList<>();
            for(int i=0; i<genres.length; i++){
                if(genres[i].equals(key)){
                    list.add(new Music(key, plays[i], i));
                }
            }
            
            Collections.sort(list, (o1, o2) -> o2.play - o1.play);
            answer.add(list.get(0));
            if(list.size() > 1){
                answer.add(list.get(1));
            }
        }
        int[] result = new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            result[i] = answer.get(i).idx;
        }
        
        return result;
    }
    
    public class Music{
        String genres;
        int play;
        int idx;
        
        public Music(String genres, int play, int idx){
            this.genres = genres;
            this.play = play;
            this.idx = idx;
        }
    }
}