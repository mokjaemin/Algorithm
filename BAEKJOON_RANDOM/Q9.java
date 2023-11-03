package BAEKJOON_RANDOM;


import java.util.*;

// 올림픽
public class Q9 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(Arrays.asList(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(list, Comparator.comparing((List<Integer> arr) -> -arr.get(1))
                                        .thenComparing(arr -> -arr.get(2))
                                        .thenComparing(arr -> -arr.get(3)));
        int last_num = list.get(0).get(0);
        if(last_num == k){
            System.out.println(1);
            return;
        }
        int last_gold = list.get(0).get(1);
        int last_silver = list.get(0).get(2);
        int last_dong = list.get(0).get(3);
        int rank = 1;
        int count = 1;
        for(int i=1; i<n; i++){
            List<Integer> country = list.get(i);
            int num = country.get(0);
            int gold = country.get(1);
            int silver = country.get(2);
            int dong = country.get(3);
            if(num == k){
                if(last_gold == gold && last_silver == silver && last_dong == dong){
                    System.out.println(rank);
                }
                else{
                    count += 1;
                    System.out.println(count);
                }
                break;
            }
            count += 1;
            if(last_gold != gold | last_silver != silver | last_dong != dong){
                last_gold = gold;
                last_silver = silver;
                last_dong = dong;
                rank = count;
            }
        }
    }
}
