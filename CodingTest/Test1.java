package CodingTest;

import javax.print.attribute.standard.DialogOwner;

public class Test1 {
    public static void main(String[] args) {
        int width = 2;
        int height = 2;
        int[][] diagonals = {{1, 1}, {2, 2}};
        int sum_length = 0;

        int[][] map = new int[width+1][height+1];
        for(int x=0; x<width+1; x++){
            for(int y=0; y<height+1; y++){
                if(x == 0 | y == 0){
                    map[x][y] = 1;
                    continue;
                }
                map[x][y] = map[x-1][y] + map[x][y-1];
            }
        }

        for(int[] lines : diagonals){
            int[] point1 = {lines[0]-1, lines[1]};
            int[] point2 = {lines[0], lines[1]-1};
            int value1 = map[point1[0]][point1[1]];
            int value2 = map[point2[0]][point2[1]];
            int[][] new_map1 = new int[width-point1[0]+1][height-point1[1]+1];
            int[][] new_map2 = new int[width-point2[0]+1][height-point2[1]+1];
            for(int x=0; x<width-point1[0]+1; x++){
                for(int y=0; y<height-point1[1]+1; y++){
                    if(x == 0 | y == 0){
                        new_map1[x][y] = 1;
                        continue;
                    }
                    new_map1[x][y] = new_map1[x-1][y] + new_map1[x][y-1];
                }
            }
            for(int x=0; x<width-point2[0]+1; x++){
                for(int y=0; y<height-point2[1]+1; y++){
                    if(x == 0 | y == 0){
                        new_map2[x][y] = 1;
                        continue;
                    }
                    new_map2[x][y] = new_map2[x-1][y] + new_map2[x][y-1];
                }
            }
            sum_length += value1*new_map2[width-point2[0]][height-point2[1]];
            sum_length += value2*new_map1[width-point1[0]][height-point1[1]];
        }
        System.out.println(sum_length);
    }
}
