package BAEKJOON_RANDOM;


import java.util.*;

// 삼각형과 세 변
public class Q3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<String> result = new ArrayList<>();
        while(true){
            List<Integer> list = new ArrayList<>();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            list.add(x);
            list.add(y);
            list.add(z);
            if(x == 0){
                break;
            }
            Collections.sort(list);
            if(list.get(0) + list.get(1) <= list.get(2)){
                result.add("Invalid");
                continue;
            }
            HashSet<Integer> set = new HashSet<>(list);
            if(set.size() == 1){
                result.add("Equilateral");
                continue;
            }
            if(set.size() == 2){
                result.add("Isosceles");
                continue;
            }
            if(set.size() == 3){
                result.add("Scalene");
                continue;
            }
        }
        for(String answer : result){
            System.out.println(answer);
        }
    }
}
