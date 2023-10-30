package SofteerPractice;


import java.util.*;

// 3. 강의실 배정 - 정렬
public class Practice3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // ~10만
        int n = sc.nextInt();
        List<List<Integer>> times = new ArrayList<>();
        for(int i=0; i<n; i++){
            // 값은 1억 이하
            int start = sc.nextInt();
            int end = sc.nextInt();
            times.add(Arrays.asList(start, end));
        }
        // 시간복잡도 : 1600만
        Collections.sort(times, Comparator.comparing(arr -> arr.get(0)));
        int end = times.get(0).get(1);
        int answer = 1;
        for(int i=1; i<n; i++){
            int now_start = times.get(i).get(0);
            int now_end = times.get(i).get(1);
            if(now_start >= end){
                answer += 1;
                end = now_end;
            }
            else{
                end = Math.min(end, now_end);
            }
        }
        System.out.println(answer);
    }
}
