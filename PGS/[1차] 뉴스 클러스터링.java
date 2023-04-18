import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        
        for(int i=0; i<str1.length()-1; i++){
            char a = str1.charAt(i);
            char b = str1.charAt(i+1);
            
            if(a >= 'a' && a <= 'z' && b >= 'a' && b <= 'z'){
                list1.add(String.valueOf(a) + String.valueOf(b));
            }

        }
        
        for(int i=0; i<str2.length()-1; i++){
            char a = str2.charAt(i);
            char b = str2.charAt(i+1);
            
            if(a >= 'a' && a <= 'z' && b >= 'a' && b <= 'z'){
                list2.add(String.valueOf(a) + String.valueOf(b));
            }
        }
        
        int count = 0;
        for(String str : list1){
            if(list2.remove(str)){
                count++;
            }
            union.add(str);
        }
        
        union.addAll(list2);
        
        if(union.size() == 0) return 65536;
        return (int) (((double) count / (double) union.size()) * 65536);
    }
}