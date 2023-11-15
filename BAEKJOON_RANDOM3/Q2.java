package BAEKJOON_RANDOM3;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 탑
public class Q2 {
    static class Tower{
        int height;
        int index;
        public Tower(int height, int index){
            this.height= height;
            this.index = index;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Tower> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            int height = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()){
                Tower before = stack.peek();
                if(before.height > height){
                    System.out.print(before.index + " ");
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty()){
                System.out.print(0 + " ");
            }
            stack.push(new Tower(height, i+1));
        }
    }
}
