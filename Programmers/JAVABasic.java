package Programmers;

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {

        int[] answer = new int[0];

        // 초기값 없이 리스트 생성
        String[] answerString = new String[prices.length];
        Integer[] answerInt = new Integer[prices.length];

        // 초기값 설정해 리스트 생성
        String[] arrayString = {"a", "b", "c", "a"};
        Integer[] arrayInt = {1, 2, 3, 4, 5}; 

        // 해시
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("key", 1); // 삽입 or 수정
        map1.get("key"); // 로드
        Set<String> keys = map1.keySet(); // 키 로드
        for(String key : keys){ // 키 점검
            if (map1.get(key) == null){
                System.out.println(key);
            }
        }
        // 특정 리스트에서 해시를 이용해 해당 키의 수 세기
        for(String s : arrayString){
            map1.put(s, map1.getOrDefault(s, 0)+1);
        }
        HashMap<Integer, Integer> mapInt = new HashMap<>(); 
        for(Integer i : arrayInt){
            mapInt.put(i, mapInt.getOrDefault(i, 0)+1);
        }




        return answer;
    }
}