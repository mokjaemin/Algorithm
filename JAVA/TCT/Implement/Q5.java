package JAVA.TCT.Implement;
import java.util.*;

public class Q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        int[][] map = new int[n][n];
        int k = Integer.valueOf(scanner.nextLine());
        for(int i=0; i<k; i++){
            String[] values = scanner.nextLine().split(" ");
            map[Integer.valueOf(values[0])-1][Integer.valueOf(values[1])-1] = 1;
        }
        int l = Integer.valueOf(scanner.nextLine());
        List<List<Integer>> moves = new ArrayList<>();
        for(int i=0; i<l; i++){
            String[] values = scanner.nextLine().split(" ");
            List<Integer> now = new ArrayList<>();
            now.add(Integer.valueOf(values[0]));
            if(values[1].equals("D")){
                now.add(0);
            }
            else{
                now.add(1);
            }
            moves.add(now);
        }
        Collections.sort(moves, Comparator.comparing(arr ->arr.get(0)));


        int[] head = {0, 0};
        List<List<Integer>> tails = new ArrayList<>();
        tails.add(Arrays.asList(0, 0));
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int dir = 0;
        int time = 1;

        while(true){
            head[0] += dx[dir];
            head[1] += dy[dir];
            if(tails.contains(Arrays.asList(head[0], head[1]))){
                System.out.println(time);
                break;
            }
            if(head[0] < 0 | head[1] < 0 | head[0] >= n | head[1] >= n){
                System.out.println(time);
                break;
            }
            if(map[head[0]][head[1]] == 1){
                tails.add(Arrays.asList(head[0]-dx[dir], head[1]-dy[dir]));
                map[head[0]][head[1]] -= 1;
            }
            else{
                if(tails.size() > 0){
                    tails.remove(0);
                    tails.add(Arrays.asList(head[0], head[1]));
                }
            }
            if(moves.size() > 0){
                if(moves.get(0).get(0) == time){
                    List<Integer> now = moves.remove(0);
                    if(now.get(1) == 0){
                        dir += 1;
                        if(dir >= n){
                            dir = 0;
                        }
                    }
                    else{
                        dir -= 1;
                        if(dir < 0){
                            dir = 0;
                        }
                    }
                }
            }
            time += 1;
        }
    }
    
}