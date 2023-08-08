package JAVA.TCT.Greedy;

import java.util.*;

// 큰 수 만들기
public class Practice1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String values1 = scanner.nextLine();
        String[] value1 = values1.split(" ");
        int n = Integer.valueOf(value1[0]);
        int m = Integer.valueOf(value1[1]);
        int k = Integer.valueOf(value1[2]);
        String values2 = scanner.nextLine();
        String[] value2 = values2.split(" ");
        int[] list = new int[value2.length];
        for(int i=0; i<n; i++){
            list[i] = Integer.valueOf(value2[i]);
        }
        
        // 정렬
        Arrays.sort(list);

        // 로직 1
        int result = 0;
        int new_k = k;
        for(int i=m; i>0; i--){
            if(new_k == 0){
                result += list[list.length-2];
                new_k = k;
                continue;
            }
            result += list[list.length-1];
            new_k -= 1;
        }
        System.out.println(result);
    }
}
