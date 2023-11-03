package BAEKJOON_RANDOM;


import java.util.*;

// 줄세우기
public class Q8 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            int test = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            List<Integer> sortedList = new ArrayList<>();
            for(int j=0; j<20; j++){
                int value = sc.nextInt();
                list.add(value);
                sortedList.add(value);
            }
            Collections.sort(sortedList);
            int answer = 0;
            while(true){
                for(int x=1; x<20; x++){
                    int value = list.get(x);
                    for(int y=0; y<x; y++){
                        if(list.get(y) > value){
                            answer += x-y;
                            list.remove(x);
                            list.add(y, value);
                            break;
                        }
                    }
                }
                if(list.equals(sortedList)){
                    break;
                }
            }
            result.add(Arrays.asList(test, answer));
        }
        for(List<Integer> now : result){
            System.out.print(now.get(0));
            System.out.print(" ");
            System.out.println(now.get(1));
        }
    }
}
