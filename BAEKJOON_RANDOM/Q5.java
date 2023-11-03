package BAEKJOON_RANDOM;

import java.util.*;

// 단어 공부
public class Q5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String value = sc.next();
        HashMap<Character, Integer> dic = new HashMap<>();
        for(char v : value.toCharArray()){
            v = Character.toUpperCase(v);
            dic.put(v, dic.getOrDefault(v, 0)+1);
        }
        List<Integer> count = new ArrayList<>();
        for(char key : dic.keySet()){
            count.add(dic.get(key));
        }
        Collections.sort(count, Comparator.comparing(arr -> -arr));
        if(count.size() >= 2 && count.get(0).equals(count.get(1))){
            System.out.println("?");
            return;
        }
        for(char key : dic.keySet()){
            if(dic.get(key) == count.get(0)){
                System.out.println(key);
                break;
            }
        }
    }
}
