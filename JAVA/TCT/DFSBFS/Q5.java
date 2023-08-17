package JAVA.TCT.DFSBFS;

import java.util.*;

// 연산자 끼워넣기
public class Q5 {
    public static List<Integer> new_values;
    public static int[] new_operands;
    public static int min_value = (int)1e9;
    public static int max_value = -(int)1e9;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> values = new ArrayList<>();
        for(int i=0; i<n; i++){
            values.add(sc.nextInt());
        }
        int[] operands = new int[4];
        for(int i=0; i<4; i++){
            operands[i] = sc.nextInt();
        }

        new_values = values;
        new_operands = operands;
        find(1, new_values.get(0));

        System.out.println(max_value);
        System.out.println(min_value);
    }
    public static void find(int index, int result){
        if(index == new_values.size()){
            max_value = Math.max(max_value, result);
            min_value = Math.min(min_value, result);
            return;
        }
        int now = new_values.get(index);
        for(int i=0; i<4; i++){
            if(new_operands[i] > 0){
                int original = result;
                new_operands[i] -= 1;
                // +
                if(i == 0){
                    result += now;
                    find(index+1, result);
                }
                // -
                if(i == 1){
                    result -= now;
                    find(index+1, result);
                }
                // x
                if(i == 2){
                    result *= now;
                    find(index+1, result);
                }
                // /
                if(i == 3){
                    if(result < 0){
                        result *= -1;
                        result /= now;
                        result *= -1;
                        find(index+1, result);
                    }
                    else{
                        result /= now;
                        find(index+1, result);
                    }
                }
                new_operands[i] += 1;
                result = original;
            }
        }
    }
}
