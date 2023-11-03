package BAEKJOON_RANDOM;


import java.util.*;

// 비밀번호 발음하기
public class Q11 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<String> result = new ArrayList<>();
        char[] check1 = {'a', 'e', 'i', 'o', 'u'};
        while(true){
            String value = sc.next();
            if(value.equals("end")){
                break;
            }
            // check1 : (a, e, i, o, u) 반드시 한개 포함 - 100
            HashSet<Character> set = new HashSet<>();
            for(char c : check1){
                for(char v : value.toCharArray()){
                    if(c == v){
                        set.add(c);
                    }
                }
            }
            if(set.size() < 1){
                result.add("<" + value + ">" + " is not acceptable.");
                continue;
            }

            // check2 : 모음, 자음 연속 3개 안됨
            boolean success = true;
            // 모음 연속 확인
            int count1 = 0;
            // 자음 연속 확인
            int count2 = 0;
            for(char v : value.toCharArray()){
                boolean check = false;
                for(char c : check1){
                    if(c == v){
                        check = true;
                        break;
                    }
                }
                // 모음인 경우
                if(check){
                    count1 += 1;
                    count2 = 0;
                }
                // 자음인 경우
                else{
                    count2 += 1;
                    count1 = 0;
                }
                if(count1 == 3 | count2 == 3){
                    success = false;
                    break;
                }
            }
            if(!success){
                result.add("<" + value + ">" + " is not acceptable.");
                continue;
            }

            // check3 : 같은 글자 연속으로 안된다.
            success = true;
            char now = value.charAt(0);
            int count = 0;
            if(now == 'e' | now == 'o'){
                count += 1;
            }
            for(int i=1; i<value.length(); i++){
                char next = value.charAt(i);
                if(now == next){
                    if(now == 'e' | now == 'o'){
                        count += 1;
                        if(count == 3){
                            success = false;
                            break;
                        }
                        continue;
                    }
                    success = false;
                    break;
                }
                else{
                    now = next;
                    if(now == 'e' | now == 'o'){
                        count = 1;
                    }
                }
            }
            if(!success){
                result.add("<" + value + ">" + " is not acceptable.");
                continue;
            }

            result.add("<" + value + ">" + " is acceptable.");
        }
        for(String answer : result){
            System.out.println(answer);
        }
    }
}
