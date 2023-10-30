package SofteerPractice;


import java.util.*;

// 7. 출퇴근길
public class Practice7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> routes = new ArrayList<>();
        for(int i=0; i<=n; i++){
            routes.add(new ArrayList<>());
        }
        // 길 정보
        for(int i=0; i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            routes.get(x).add(y);
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
    }
}
