package Programmers;
import java.util.HashMap;
import java.util.Set;

public class JAVAHash {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for(int i=0; i<participant.length; i++){
            if(map1.get(participant[i]) == null){
                map1.put(participant[i], 1);
            }
            else{
                map1.put(participant[i], map1.get(participant[i]) + 1);
            }
        }
        for(int i=0; i<completion.length; i++){
            if(map2.get(completion[i]) == null){
                map2.put(completion[i], 1);
            }
            else{
                map2.put(completion[i], map2.get(completion[i]) + 1);
            }
        }
        Set<String> keys = map1.keySet();
        for(String key : keys){
            if (!map1.get(key).equals(map2.get(key))){
                return key;
            }
        }
        
        return answer;
    }
}
