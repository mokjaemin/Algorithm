package Programmers;

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {

        int[] answer = new int[0];

        // 형변환
        double a = 1;
        a = (int)a;
        int num = 123;
        String str = String.valueOf(num);
        String str1 = "123";
        Integer num1 = Integer.valueOf(str1);
        char c = 'a';
        int answer1 = (int)c - 48;




        // 문자열 처리
        StringBuilder sb = new StringBuilder();
        String my_string = "";
        int n = 2;
        for (char c1 : my_string.toCharArray()) {
            for (int i = 0; i < n; i++) {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());

        // 문자열의 길이
        String test = "aaa";
        test.length();

        // 문자열 인덱스로 접근, 값으로 접근
        test.charAt(0);
        test.indexOf("a");

        // 문자열 변경, 제거
        String result = test.replace(String.valueOf('a'), "");
        test.replaceAll("[aeiou]", "");


        // 문자열 뒤집기
        StringBuffer sb1 = new StringBuffer(result);
        String reversed = sb.reverse().toString();

        // 리스트 뒤집기
        int[] num_list = {1, 2, 3, 4, 5};
        for (int i = 0; i < num_list.length / 2; i++) {
            int temp = num_list[i];
            num_list[i] = num_list[num_list.length - i - 1];
            num_list[num_list.length - i - 1] = temp;
        }

        // 리스트 정렬
        Arrays.sort(num_list);

        // 초기값 없이 리스트 생성
        String[] answerString = new String[prices.length];
        Integer[] answerInt = new Integer[prices.length];
        List<Integer> list_new = new ArrayList<>();

        // 리스트 변경
        List<String> list1 = Arrays.asList(answerString);

        // 값을 갖고 있는지 확인
        if(list1.contains(test)){
            System.out.println(test);
        }

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