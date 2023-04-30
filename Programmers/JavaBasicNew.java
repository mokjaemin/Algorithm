package Programmers;

import java.util.*;
import java.lang.Math;

public class JavaBasicNew {
    public int[] solution(int[] num_list) {
        int[] answer = {};

        // (무한대)
        int inf1 = (int)1e9;
        int inf2 = (int)-1e9;

        // (형변환) int -> char
        int num = 6;
        char ch = (char)(num + '0');

        // (형변환) char -> int
        char c1 = '1';
        int new_int1 = (int)c1 - 48;

        // (형변환) String -> char
        String result10 = "abc";
        char[] result10_char = result10.toCharArray();

        // (형변환) char[] -> String
        char[] c2 = {'a', 'b', 'c'};
        String c2_String = new String(c2);

        // (형변환) int -> String
        String new_string1 = String.valueOf(0);

        // (형변환) String -> int
        Integer new_int10 = Integer.parseInt(new_string1);

        // (Math) 제곱
        Math.pow(2, 3); // 2의 3승

        // (Math) 최대값, 최솟값
        Math.min(1, 0);
        Math.max(1, 0);

        // (정적 리스트) 생성
        int[] check = new int[10];
        String[] check_String = new String[10];

        // (정적 리스트) 정렬
        Arrays.sort(check);

        // (문자열), (정적 리스트) 길이
        String a = "abc";
        System.out.println(a.length());
        System.out.println(check_String.length);

        // (문자열) 분리
        String str = "Hello World";
        String[] arrOfStr = str.split(" ");

        // (문자열) 특정 문자로 시작하는지 여부
        String[] phone_book = {"123", "456"};
        System.out.println(phone_book[0].startsWith(phone_book[1]));

        // (문자열) 비교
        String b = "abc";
        System.out.println(a.equals(b));

        // (문자열) 인덱스로 접근
        b.charAt(0);

        // (문자열) 대체
        String my_string = "abcde";
        String result = my_string.replace(String.valueOf("a"), "");
        String result1 = my_string.replace(String.valueOf("aeuoi"), "");
        
        // (문자열) 뒤집기(String - Char - String), 삽입
        StringBuffer sb = new StringBuffer(my_string);
        String reversed = sb.reverse().toString();
        sb.append('a');

        // (문자) 해당 문자가 알파벳인지
        char c = 'a';
        boolean result2 = Character.isLetter(c);

        // (문자열) 문자열의 특정 문자가 대문자인지 판단 및 변환
        Character.isUpperCase(my_string.charAt(0));
        Character.toUpperCase('c');
        Character.isLowerCase(my_string.charAt(0));
        Character.toLowerCase('c');

        // (문자열) 특정 문자열 포함 여부
        System.out.println(reversed.contains(result1));

        // (문자열) 특정 문자 포함 여부, 포함 안할시 -1
        reversed.indexOf('c');

        // (문자열) 문자열에 char 추가
        String check4 = "";
        Character s = '1';
        check4 += s;
        
        // (동적 리스트) 생성
        List<String> check1 = new ArrayList<>();
        List<Character> check1_char = new ArrayList<>();

        // (동적 리스트) Stirng 리스트를 동적리스트로 변환
        String[] check2_String = {"a", "b"};
        List<String> check2 = Arrays.asList(check2_String);

        // (동적 리스트) Integer 리스트를 동적리스트로 변환
        int[] check3_int = {1, 2, 3, 4};
        List<Integer> check3 = new ArrayList<>();
        for (int i : check3_int){
            check3.add(i);
        }

        // (동적 리스트) 특정 값 포한 여부
        check3.contains(1);

        // (동적 리스트) 정렬
        Collections.sort(check3);

        // (동적 리스트) List 뒤집기
        Collections.reverse(check3);

        // (동적 리스트) 문자열로 변환
        check3.toString();

        // (동적 리스트) 크기
        check3.size();

        // (동적 리스트) 특정 인덱스 삭제
        check3.remove(0);

        // (동적 리스트) 특정 값 삭제
        check3.remove(Integer.valueOf(3));
        check2.remove(String.valueOf("a"));
        check2.remove(Character.valueOf('a'));

        // (해시) 키-값 설정
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        map1.put("a", 1);
        map1.get("a");

        // (해시) 키 불러오기
        Set<String> keys = map1.keySet();

        // (해시) 특정 리스트에서 해시를 이용해 해당 키의 수 세기
        for(String s2 : check2){
            map1.put(s2, map1.getOrDefault(s, 0)+1);
        }





        return answer;
    }
}
