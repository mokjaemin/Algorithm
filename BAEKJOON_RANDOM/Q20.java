package BAEKJOON_RANDOM;


import java.util.*;

// 영단어 암기는 어려워
public class Q20 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashSet<String> values = new HashSet<>();
        HashMap<String, Integer> count = new HashMap<>();
        for(int i=0; i<n; i++){
            String value = sc.next();
            if(value.length() < m){
                continue;
            }
            count.put(value, count.getOrDefault(value, 0)+1);
            values.add(value);
        }
        List<List<Integer>> check = new ArrayList<>();
        List<String> new_values = new ArrayList<>(values);
        for(int i=0; i<new_values.size(); i++){
            String value = new_values.get(i);
            check.add(Arrays.asList(i, count.get(value), value.length()));
        }
        Collections.sort(check, Comparator.comparing((List<Integer> arr) -> -arr.get(1))
                                        .thenComparing(arr -> -arr.get(2))
                                        .thenComparing(arr -> new_values.get(arr.get(0))));
        for(List<Integer> c : check){
            System.out.println(new_values.get(c.get(0)));
        }
    }
}
