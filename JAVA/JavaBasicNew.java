package JAVA;

import java.util.*;
import java.util.function.Supplier;
import java.lang.Math;
import java.util.stream.Collectors; //프로그래머스에서 Stream 사용시

import javax.naming.LinkException;

public class JavaBasicNew {



    // (클래스의 전역 변수)
    private static int resultAll1 = 0;




    public int[] solution(int[] num_list) {
        Supplier<String> dictinary = () -> "Hello World";



        int[] answer = {};

        // (무한대)
        int inf1 = (int)1e9;
        int inf2 = (int)-1e9;


        // (숫자 - 알파벳)
        int test = 65;
        System.out.println((char) test); // A


        // (형변환) int -> char
        int num = 6;
        char ch = (char)(num + '0');

        // (형변환) char -> int
        char c1 = '1';
        char testA = 65; // A
        int new_int1 = (int)c1 - 48;
        int new_int2 = Character.getNumericValue(c1); // 문자형 숫자를 숫자로

        // (형변환) String -> char[]
        String result10 = "abc";
        char[] result10_char = result10.toCharArray();

        // (형변환) char[] -> String
        char[] c2 = {'a', 'b', 'c'};
        String c2_String = new String(c2);

        // (형변환) int -> String
        String new_string1 = String.valueOf(0);

        // (형변환) String -> int
        Integer new_int10 = Integer.parseInt(new_string1);

        // (형변환) long -> String
        Long new_long = Long.parseLong(new_string1);

        // (형변환) List<Character> -> String
        List<Character> charList = Arrays.asList('H', 'e', 'l', 'l', 'o');
        StringBuilder sb = new StringBuilder();
        for (char c : charList) {
            sb.append(c);
        }
        String str = sb.toString();

        // (형변환) Double -> Integer
        Double doubleValue = 0.98;
        Integer result = doubleValue.intValue();


        
        // 10진수를 다른 진수로 변환
        String binaryString = Integer.toBinaryString(5); //2진수
        String octalString = Integer.toOctalString(5); //8진수
        String hexString = Integer.toHexString(5); // 16진수
        
        // 다시 10진수로 변환
        int new_binary1 = Integer.parseInt(binaryString, 2);
        long new_binary2 = Long.parseLong(binaryString, 2);




        // (Math) 제곱
        Math.pow(2, 3); // 2의 3승

        // (Math) 최대값, 최솟값
        Math.min(1, 0);
        // Math.max(1, 0);

        // (Math) 올림, 내림, 반올림
        Math.ceil(3.1);
        Math.floor(3.1);
        Math.round(3.1);

        // (Math) 올림을 사용하고 싶은 경우
        // (int)/(int) 인 경우, 분모가 (double)이여야 소수점까지 구해줌
        int left = 10;
        int speed = 10;
        // System.out.println(Math.ceil(left/(double)speed));

        // 절대값
        Math.abs(1-2);





        // (정적 리스트) 1. 생성
        int[] check = new int[10];
        String[] check_String = new String[10];
        char[] check_char = new char[10];

        // (정적 리스트) 2. 정렬
        Arrays.sort(check);
        
        // (정적 리스트) 3. 값 포함 여부
        // for문 사용

        // (정적 리스트) 4. 뒤집기
        Collections.reverse(Arrays.asList(check));

        // (정적 리스트) 5. 길이
        System.out.println(check_String.length);

        // (정적 리스트) 6. 인덱스 삭제
        // for 문 이용

        // (정적 리스트) 7. 값 삭제
        // for문 사용

        // (정적 리스트) 값 변경
        check_String[0] = "1";

        // (정적 리스트) 채우기
        Boolean[] used = new Boolean[5];
        Arrays.fill(used, false);

        // (정적 리스트) 2차원 채우기
        // Arrays.fill + for문

        // (정적 리스트) 복사 (대상, 길이)
        Boolean[] new_used = Arrays.copyOf(used, 2*used.length);

        // 슬라이싱
        int[] subArray = Arrays.copyOfRange(check, 1, 4);






        // (문자열) 1. 생성, 분리
        String str1 = "Hello World";
        String[] arrOfStr = str.split(" ");
        String[] arrOfStr1 = str.split("\\.");

        // (문자열) 2. 정렬
        char[] s = str.toCharArray();
        Arrays.sort(s);

        // (문자열) 3. 특정값 포함 여부
        
        // (문자열) 특정 문자열 포함 여부
        String reversed = "ss";
        System.out.println(reversed.contains("s"));
        
        // (문자열) 특정 문자 포함 여부, 포함 안할시 -1
        reversed.indexOf('c');
        
        // 특정 문자로 시작하는지 여부
        String[] phone_book = {"123", "456"};
        System.out.println(phone_book[0].startsWith(phone_book[1]));
        
        // (문자열) 비교
        String b = "abc";
        b.equals(b);
        
        // (문자열) 대체, 삭제
        String my_string = "abcde";
        String result2 = my_string.replace(String.valueOf("a"), "");
        String result1 = my_string.replace(String.valueOf("aeuoi"), "");
        
        // (문자열) 문자열에 char 추가
        String check4 = "";
        Character s1 = '1';
        check4 += s1;

        // (문자열) 인덱싱
        check4.substring(0, 2);

        // (문자열) 4. 뒤집기(String - Char - String), 삽입
        StringBuffer sb1 = new StringBuffer(my_string);
        String reversed1 = sb.reverse().toString();
        // 메서드
        sb.append('a');
        sb.insert(0, 'a');
        sb.length();
        sb.reverse();
        // sb.toString();


        // (문자열) 5. 길이
        String a = "abc";
        System.out.println(a.length());
        System.out.println(check_String.length);

        // (문자열) 6. 인덱스로 접근
        b.charAt(0);



        // (문자) 해당 문자가 알파벳인지
        char c = 'a';
        boolean result24 = Character.isLetter(c);

        // (문자) 해당 문자가 숫자인지 확인
        Character.isDigit('1');

        // (문자) 대소문자 변환
        Character.isUpperCase(my_string.charAt(0));
        Character.toUpperCase('c');
        Character.isLowerCase(my_string.charAt(0));
        Character.toLowerCase('c');

        // (문자열) 대소문자 변환
        String test10 = "AB";
        test10.toLowerCase();
        test10.toUpperCase();
        
    






        // (동적 리스트) 1. 생성
        List<String> check1 = new ArrayList<>();
        List<Character> check1_char = new ArrayList<>();

        // (동적 리스트) 정적 리스트를 동적리스트로 변환
        String[] check2_String = {"a", "b"};
        List<String> check2 = Arrays.asList(check2_String);

        // (동적 리스트) 정적 리스트를 동적리스트로 변환
        int[] check3_int = {1, 2, 3, 4};
        List<Integer> check3 = new ArrayList<>();
        for (int i : check3_int){
            check3.add(i);
        }

        // (동적리스트) 삽입
        List<List<Integer>> now = new ArrayList<>();
        now.add(Arrays.asList(1, 2));


        // (동적 리스트) 포함 여부
        List<Integer> test1 = new ArrayList<>();
        test1.add(1);
        test1.add(2);
        List<Integer> test2 = new ArrayList<>();
        test2.add(1);
        test2.add(2);
        test2.add(3);
        if(test2.containsAll(test1)){
            System.out.println("포함");
        }


        // (동적 리스트) 2. 정렬, 역정렬
        Collections.sort(check3);
        Collections.sort(check3, Collections.reverseOrder());
        Collections.sort(now, Comparator.comparing(arr -> arr.get(1)));
        Collections.sort(now, Comparator
                         .comparing((List<Integer> list) -> -list.get(1))
                        .thenComparing(list -> list.get(0)));

        // (동적 리스트) 3. 특정 값 포한 여부
        check3.contains(1);

        // (동적 리스트) 4. List 뒤집기
        Collections.reverse(check3);

        // (동적 리스트) 5. 길이
        check3.size();

        // (동적 리스트) 6. 특정 인덱스 삭제
        check3.remove(0);

        // (동적 리스트) 7. 특정 값 삭제
        check3.remove(Integer.valueOf(3));
        check2.remove(String.valueOf("a"));
        check2.remove(Character.valueOf('a'));

        // (동적 리스트) 8. 인덱스로 값 불러오기
        check3.get(0);

        // (동적 리스트) 9. 값으로 인덱스 불러오기
        check3.indexOf("a");

        // (동적 리스트) 10. 값 변경
        check3.set(0, 10);

        // (동적 리스트) 최대값 구하기
        Collections.max(check3);

        // (동적 리스트) 문자열로 변환
        check3.toString();

        // (동적 리스트) 비었는지 확인
        check3.isEmpty();

        // (동적 리스트) 비우기
        check3.clear();

        // (동적 리스트) 복사
        List<Integer> now_check = new ArrayList<Integer>(check3);

        // (동적 리스트) 인접 리스트
        // 인접 행렬은 보통 정적 처리
        int n = 1;
        int[][] wires = {};
        List<List<Integer>> connected = new ArrayList<>();
        for(int i=0; i<=n; i++){
            List<Integer> now1 = new ArrayList<>();
            connected.add(now1);
        }

        for(int[] wire : wires){
            connected.get(wire[0]).add(wire[1]);
        }

        // (동적 리스트) 변경
        // check3.set(0, 1);




        // (해시) 키-값 설정
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        map1.put("a", 1);
        map1.get("a");

        // (해시) 키 불러오기
        Set<String> keys = map1.keySet();

        // (해시) 해당 키가 있는지 여부
        map1.containsKey("a");

        // (해시) 특정 리스트에서 해시를 이용해 해당 키의 수 세기
        for(String s2 : check2){
            map1.put(s2, map1.getOrDefault(s, 0)+1);
        }



        // 우선순위 큐 (최소힙)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<int[]> minHeap1 = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        PriorityQueue<List<Integer>> queue 
            = new PriorityQueue<>(Comparator.comparingInt(list -> list.get(0)));
        minHeap.add(1); // 추가
        minHeap.peek(); // 최솟값 출력
        minHeap.poll(); // 최솟값 제거
        minHeap.remove(1);


        // 우선순위 큐 (최대힙)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(1);
        maxHeap.peek();
        maxHeap.poll();
        maxHeap.remove(1);


        // 큐
        Queue<Integer> check10 = new LinkedList<>();
        check10.poll();
        check10.peek();

        // 스택
        Stack<Integer> check11 = new Stack<>();
        check11.pop();
        check11.peek();

        return answer;
    }


    // 조합 (Combinations)
    private static void combinations(
        List<List<Integer>> lists, List<List<Integer>> result, 
        List<Integer> temp, int start, int r) {
        if (temp.size() == r) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < lists.size(); i++) {
            temp.add(lists.get(i).get(0));
            temp.add(lists.get(i).get(1));
            combinations(lists, result, temp, i + 1, r);
            temp.remove(temp.size() - 1);
            temp.remove(temp.size() - 1);
        }
    }

    // 순열 (Permutations)
    public void permutations(
        List<Integer> nums, List<List<Integer>> result, 
        List<Integer> temp, Boolean[] used, int n) {
        if(temp.size() == n) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.size(); i++) {
            if(!used[i]) {
                temp.add(nums.get(i));
                used[i] = true;
                permutations(nums, result, temp, used, n);
                temp.remove(nums.get(i));
                used[i] = false;
            }
        }
    }
}