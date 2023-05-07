package CodingTest;
import java.util.*;

public class Test2 {

    private static List<List<List<Integer>>> lines = new ArrayList<>();
    public static void main(String[] args){
        // int n1 = 6;
        // int[][] connect1 = {{1, 2}, {3, 5}, {4, 2}, {5, 6}};
        // int[][] lines1 = {{3, 2, 10}, {5, 4, 15}};
        int n1 = 4;
        int[][] connect1 = {{1, 2}};
        int[][] lines1 = {{2, 3, 10}, {3, 1, 12}};


        // 0. 인접리스트 생성
        List<List<Integer>> map1 = new ArrayList<>();
        for(int i=0; i<n1+1; i++){
            List<Integer> now = new ArrayList<>();
            map1.add(now);
        }
        for(int[] connect : connect1){
            map1.get(connect[0]).add(connect[1]);
            map1.get(connect[1]).add(connect[0]);
        }


        // 1. 라인 뽑기
        Boolean[] visited1 = new Boolean[lines1.length];
        Arrays.fill(visited1, false);
        for(int i=1; i<lines1.length+1; i++){
            List<List<Integer>> temp = new ArrayList<>();
            combinations(lines1, temp, i, visited1);
        }

        // 2. 라인 정렬
        List<Integer> value = new ArrayList<>();
        List<List<Integer>> value_index = new ArrayList<>();
        for(int i=0; i<lines.size(); i++){
            int sum = 0;
            for(int j=0; j<lines.get(i).size(); j++){
                sum += lines.get(i).get(j).get(2);
            }
            value.add(sum);
            List<Integer> now_check = new ArrayList<>();
            now_check.add(i);
            now_check.add(sum);
            value_index.add(now_check);
        }

        // 3. 정렬한 대로 연결여부 판단, 전체 연결시 종료
        Collections.sort(value);
        for(int i=0; i<value.size(); i++){
            int new_index = 0;
            for(int j=0; j<value.size(); j++){
                if(value_index.get(j).get(1) == value.get(i)){
                    new_index = value_index.get(j).get(0);
                    break;
                }
            }
            for(List<Integer> line : lines.get(new_index)){
                map1.get(line.get(0)).add(line.get(1));
                map1.get(line.get(1)).add(line.get(0));
            }

            Boolean[] visited2 = new Boolean[n1+1];
            Arrays.fill(visited2, false);
            visited2[0] = true;
            List<Integer> queue2 = new ArrayList<>();
            queue2.add(1);
            while(queue2.size() > 0){
                int now = queue2.remove(0);
                visited2[now] = true;
                for(int k : map1.get(now)){
                    if(visited2[k] == false){
                        queue2.add(k);
                    }
                }
            }

            int count2 = 0;
            for(Boolean  b : visited2){
                if(!b){
                    break;
                }
                count2 += 1;
            }
            if(count2 == n1+1){
                System.out.println(value.get(new_index));
                break;
            }
            for(List<Integer> line : lines.get(new_index)){
                map1.get(line.get(0)).remove(line.get(1));
                map1.get(line.get(1)).remove(line.get(0));
            }
        }
        System.out.println("-1");
    }
    public static void combinations(
        int[][] lines1, List<List<Integer>> temp, int count, Boolean[] visited1){
        if(temp.size() == count){
            lines.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i<lines1.length; i++){
            if(visited1[i] == false){
                List<Integer> now = new ArrayList<>();
                for(int j=0; j<lines1[i].length; j++){
                    now.add(lines1[i][j]);
                }
                temp.add(new ArrayList<>(now));
                visited1[i] = true;
                combinations(lines1, temp, count, visited1);
                temp.remove(temp.size()-1);
                visited1[i] = false;
            }
        }
    }
}
