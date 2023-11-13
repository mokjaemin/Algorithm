package BAEKJOON_RANDOM2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q11_X {
    static class Node{
        Node left;
        Node right;
        char value;
        boolean dead = false;
        Node(Node left, Node right, char value){
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }
    static class Cursor{
        Node left;
        Node right;
        Cursor(Node left, Node right){
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String value = br.readLine();
        List<Node> list = new ArrayList<>();
        for(int i=0; i<value.length(); i++){
            if(i == 0){
                list.add(new Node(null, null, value.charAt(i)));
                continue;
            }
            Node now = new Node(list.get(i-1), null, value.charAt(i));
            list.add(now);
            list.get(i-1).right = now;
        }
        int n = Integer.parseInt(br.readLine());
        Cursor cursor = new Cursor(list.get(list.size()-1), null);
        for(int i=0; i<n; i++){
            String now = br.readLine();
            // L, D, B
            if(now.length() == 1){
                if(now.equals("L")){
                    if(cursor.left == null){
                        continue;
                    }
                    cursor.right = cursor.left;
                    cursor.left = cursor.left.left;
                }
                if(now.equals("D")){
                    if(cursor.right == null){
                        continue;
                    }
                    cursor.left = cursor.right;
                    cursor.right = cursor.right.right;
                }
                if(now.equals("B")){
                    if(cursor.left == null){
                        continue;
                    }
                    if(cursor.right != null){
                        cursor.right.left = cursor.left.left;
                    }
                    cursor.left.dead = true;
                    if(cursor.left.left != null){
                        cursor.left.left = cursor.right;
                    }
                    cursor.left = cursor.left.left;
                }
            }
            // P
            else{
                char next = now.split(" ")[1].charAt(0);
                Node new_node = new Node(cursor.left, cursor.right, next);
                list.add(new_node);
                if(cursor.left != null){
                    cursor.left.right = new_node;
                }
                if(cursor.right != null){
                    cursor.right.left = new_node;
                }
                cursor.left = new_node;
            }
            StringBuilder sb = new StringBuilder();
            for(Node next : list){
                if(next.left == null){
                    if(next.dead){
                        continue;
                    }
                    sb.append(next.value);
                    while(next.right != null){
                        next = next.right;
                        if(next.dead){
                            continue;
                        }
                        sb.append(next.value);
                    }
                    break;
                }
            }
            System.out.println(sb.toString());
        }
    }
}
