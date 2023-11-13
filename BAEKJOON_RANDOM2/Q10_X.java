package BAEKJOON_RANDOM2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q10_X {
    public static int m;
    static class Room{
        public int min_value;
        public int max_value;
        public List<String> list = new ArrayList<>();
        public boolean isAvialbe = true;
        public int count = 0;

        public Room(String value){
            int num = Integer.parseInt(value.split(" ")[0]);
            this.max_value = num+10;
            this.min_value = num-10;
            this.list.add(value);
            this.count += 1;
            if(count == m){
                isAvialbe = false;
            }
        }
        List<String> getList(){
            return list;
        }
        boolean enter(String value){
            int num = Integer.parseInt(value.split(" ")[0]);
            if(num <= max_value && num >= min_value){
                count += 1;
                list.add(value);
                if(count == m){
                    isAvialbe = false;
                }
                return true;
            }
            return false;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String value = br.readLine();
        int n = Integer.parseInt(value.split(" ")[0]);
        m = Integer.parseInt(value.split(" ")[1]);
        List<Room> rooms = new ArrayList<>();
        List<List<String>> answer = new ArrayList<>();
        for(int i=0; i<n; i++){
            value = br.readLine();
            if(rooms.size() == 0){
                rooms.add(new Room(value));
                continue;
            }
            boolean success = false;
            for(Room room : rooms){
                if(room.isAvialbe == false){
                    continue;
                }
                boolean result = room.enter(value);
                if(result){
                    success = true;
                    break;
                }
            }
            if(!success){
                rooms.add(new Room(value));
            }
        }
        for(Room room : rooms){
            answer.add(new ArrayList<>(room.getList()));
        }
        for(List<String> a : answer){
            Collections.sort(a, Comparator.comparing(arr -> arr.split(" ")[1]));
            if(a.size() < m){
                System.out.println("Wating!");
                for (String c : a){
                    System.out.println(c);
                }
                continue;
            }
            System.out.println("Started!");
            for(String c : a){
                System.out.println(c);
            }
        }
    }
}
