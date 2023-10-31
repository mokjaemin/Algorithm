package SofteerPractice;


import java.util.*;

// 5. 사물인식 최소면적 산출 프로그램 - DFS
// -> 중간에 필요없는 연산 줄여 복잡도 해소
public class Practice5 {
    public static int k;
    public static int answer = 4000000;
    public static List<List<List<Integer>>> colors = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // 점의 개수 1~100
        int n = sc.nextInt();
        // 색의 개수 1~20
        k = sc.nextInt();
        // 색깔별 (x, y)
        for(int i=0; i<k+1; i++){
            colors.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int color = sc.nextInt();
            colors.get(color).add(Arrays.asList(x, y));
        }
        check(1, 1000, -1000, 1000, -1000);
        System.out.println(answer);
    }
    // DFS
    public static void check(int color, int min_x, int max_x, int min_y, int max_y){
        if(color == k+1){
            answer = Math.min(answer, Math.abs((max_x - min_x))*Math.abs((max_y - min_y)));
            return;
        }
        for(List<Integer> xy : colors.get(color)){

            int x = xy.get(0);
            int y = xy.get(1);

            int left_x = Math.min(min_x, x);
            int right_x = Math.max(max_x, x);
            int left_y = Math.min(min_y, y);
            int right_y = Math.max(max_y, y);

            int area = Math.abs((right_x - left_x))*Math.abs((right_y - left_y));
            if(area < answer){
                check(color+1, left_x, right_x, left_y, right_y);
            }
        }
    }
}
