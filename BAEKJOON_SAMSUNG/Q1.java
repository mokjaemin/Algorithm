package BAEKJOON_SAMSUNG;


import java.util.*;

// 구슬 탈출 2
public class Q1 {
    public static boolean[][] visitedRed;
    public static boolean[][] visitedBlue;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int answer = 11;
    public static int n;
    public static int m;
    public static char[][] map;
    public static int[] end = new int[2];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new char[n][m];
        visitedRed = new boolean[n][m];
        visitedBlue = new boolean[n][m];
        int[] red = new int[2];
        int[] blue = new int[2];
        for(int i=0; i<n; i++){
            String value = sc.next();
            for(int j=0; j<m; j++){
                map[i][j] = value.charAt(j);
                if(map[i][j] == 'R'){
                    red[0] = i;
                    red[1] = j;
                }
                if(map[i][j] == 'B'){
                    blue[0] = i;
                    blue[1] = j;
                }
                if(map[i][j] == 'O'){
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        dfs(red[0], red[1], blue[0], blue[1], 0);
        if(answer >= 11){
            System.out.println(-1);
        }
        else{
            System.out.println(answer);
        }
    }
    public static void dfs(int redX, int redY, int blueX, int blueY, int count){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(map[i][j]);
                System.out.print(" ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
        // 이미 방문한 지점
        if(visitedRed[redX][redY] && visitedBlue[blueX][blueY]){
            return;
        }
        // 방문 처리
        visitedRed[redX][redY] = true;
        visitedBlue[blueX][blueY] = true;
        // 10번 넘으면 종료
        if(count > 10){
            return;
        }
        // 단계 :
        // 1. 구슬1 이동
        // 2. 구슬1 맵 변경
        // 3. 구슬2 이동
        // 4. 구슬2 맵 변경
        // 5. DFS
        // 6. 맵 다시 원상 복귀
        for(int i=0; i<4; i++){
            int redNextX = redX + dx[i];
            int redNextY = redY + dy[i];
            int blueNextX = blueX + dx[i];
            int blueNextY = blueY + dy[i];
            // 북
            if(i == 0){
                System.out.println("북 이동");
                // red 먼저 움직임
                if(redX < blueX){
                    // red 이동
                    while(true){
                        if(map[redNextX][redNextY] == 'O'){
                            answer = Math.min(answer, count+1);
                            return;
                        }
                        if(map[redNextX][redNextY] == '#'){
                            redNextX -= dx[i];
                            redNextY -= dy[i];
                            break;
                        }
                        redNextX += dx[i];
                        redNextY += dy[i];
                    }
                    // 맵 변경
                    map[redX][redY] = '.';
                    map[redNextX][redNextY] = 'R';
                    // blue 이동
                    while(true){
                        if(map[blueNextX][blueNextY] == 'O'){
                            map[redX][redY] = 'R';
                            map[redNextX][redNextY] = '.';
                            return;
                        }
                        if(map[blueNextX][blueNextY] == '#'){
                            blueNextX -= dx[i];
                            blueNextY -= dy[i];
                            break;
                        }
                        if(map[blueNextX][blueNextY] == 'R'){
                            blueNextX -= dx[i];
                            blueNextY -= dy[i];
                            break;
                        }
                        blueNextX += dx[i];
                        blueNextY += dy[i];
                    }
                    // 맵 변경
                    map[blueX][blueY] = '.';
                    map[blueNextX][blueNextY] = 'B';
                }
                // blue 먼저 움직임
                else{
                    // blue 이동
                    while(true){
                        if(map[blueNextX][blueNextY] == 'O'){
                            return;
                        }
                        if(map[blueNextX][blueNextY] == '#'){
                            blueNextX -= dx[i];
                            blueNextY -= dy[i];
                            break;
                        }
                        blueNextX += dx[i];
                        blueNextY += dy[i];
                    }
                    // 맵 변경
                    map[blueX][blueY] = '.';
                    map[blueNextX][blueNextY] = 'B';
                    // red 이동
                    while(true){
                        if(map[redNextX][redNextY] == 'O'){
                            answer = Math.min(answer, count+1);
                            map[blueX][blueY] = 'B';
                            map[blueNextX][blueNextY] = '.';
                            return;
                        }
                        if(map[redNextX][redNextY] == '#'){
                            redNextX -= dx[i];
                            redNextY -= dy[i];
                            break;
                        }
                        if(map[redNextX][redNextY] == 'B'){
                            redNextX -= dx[i];
                            redNextY -= dy[i];
                            break;
                        }
                        redNextX += dx[i];
                        redNextY += dy[i];
                    }
                    // 맵 변경
                    map[redX][redY] = '.';
                    map[redNextX][redNextY] = 'R';
                }
                // DFS
                dfs(redNextX, redNextY, blueNextX, blueNextY, count+1);
                // 원상복귀
                map[redNextX][redNextY] = '.';
                map[redX][redY] = 'R';
                map[blueNextX][blueNextY] = '.';
                map[blueX][blueY] = 'B';
            }
            // 서
            if(i == 1){
                System.out.println("서 이동");
                // red 먼저 움직임
                if(redY < blueY){
                    // red 이동
                    while(true){
                        if(map[redNextX][redNextY] == 'O'){
                            answer = Math.min(answer, count+1);
                            return;
                        }
                        if(map[redNextX][redNextY] == '#'){
                            redNextX -= dx[i];
                            redNextY -= dy[i];
                            break;
                        }
                        redNextX += dx[i];
                        redNextY += dy[i];
                    }
                    // 맵 변경
                    map[redX][redY] = '.';
                    map[redNextX][redNextY] = 'R';
                    // blue 이동
                    while(true){
                        if(map[blueNextX][blueNextY] == 'O'){
                            map[redX][redY] = 'R';
                            map[redNextX][redNextY] = '.';
                            return;
                        }
                        if(map[blueNextX][blueNextY] == '#'){
                            blueNextX -= dx[i];
                            blueNextY -= dy[i];
                            break;
                        }
                        if(map[blueNextX][blueNextY] == 'R'){
                            blueNextX -= dx[i];
                            blueNextY -= dy[i];
                            break;
                        }
                        blueNextX += dx[i];
                        blueNextY += dy[i];
                    }
                    // 맵 변경
                    map[blueX][blueY] = '.';
                    map[blueNextX][blueNextY] = 'B';
                }
                // blue 먼저 움직임
                else{
                    // blue 이동
                    while(true){
                        if(map[blueNextX][blueNextY] == 'O'){
                            return;
                        }
                        if(map[blueNextX][blueNextY] == '#'){
                            blueNextX -= dx[i];
                            blueNextY -= dy[i];
                            break;
                        }
                        blueNextX += dx[i];
                        blueNextY += dy[i];
                    }
                    // 맵 변경
                    map[blueX][blueY] = '.';
                    map[blueNextX][blueNextY] = 'B';
                    // red 이동
                    while(true){
                        if(map[redNextX][redNextY] == 'O'){
                            map[blueX][blueY] = 'B';
                            map[blueNextX][blueNextY] = '.';
                            return;
                        }
                        if(map[redNextX][redNextY] == '#'){
                            redNextX -= dx[i];
                            redNextY -= dy[i];
                            break;
                        }
                        if(map[redNextX][redNextY] == 'B'){
                            redNextX -= dx[i];
                            redNextY -= dy[i];
                            break;
                        }
                        redNextX += dx[i];
                        redNextY += dy[i];
                    }
                    // 맵 변경
                    map[redX][redY] = '.';
                    map[redNextX][redNextY] = 'R';
                }
                // DFS
                dfs(redNextX, redNextY, blueNextX, blueNextY, count+1);
                // 원상복귀
                map[redNextX][redNextY] = '.';
                map[redX][redY] = 'R';
                map[blueNextX][blueNextY] = '.';
                map[blueX][blueY] = 'B';
            }
            // 남
            if(i == 2){
                System.out.println("남 이동");
                // blue 먼저 움직임
                if(redX < blueX){
                    // blue 이동
                    while(true){
                        if(map[blueNextX][blueNextY] == 'O'){
                            return;
                        }
                        if(map[blueNextX][blueNextY] == '#'){
                            blueNextX -= dx[i];
                            blueNextY -= dy[i];
                            break;
                        }
                        blueNextX += dx[i];
                        blueNextY += dy[i];
                    }
                    // 맵 변경
                    map[blueX][blueY] = '.';
                    map[blueNextX][blueNextY] = 'B';
                    // red 이동
                    while(true){
                        if(map[redNextX][redNextY] == 'O'){
                            answer = Math.min(answer, count+1);
                            map[blueX][blueY] = 'B';
                            map[blueNextX][blueNextY] = '.';
                            return;
                        }
                        if(map[redNextX][redNextY] == '#'){
                            redNextX -= dx[i];
                            redNextY -= dy[i];
                            break;
                        }
                        if(map[redNextX][redNextY] == 'B'){
                            redNextX -= dx[i];
                            redNextY -= dy[i];
                            break;
                        }
                        redNextX += dx[i];
                        redNextY += dy[i];
                    }
                    // 맵 변경
                    map[redX][redY] = '.';
                    map[redNextX][redNextY] = 'R';
                }
                // red 먼저 움직임
                else{
                    // red 이동
                    while(true){
                        if(map[redNextX][redNextY] == 'O'){
                            answer = Math.min(answer, count+1);
                            return;
                        }
                        if(map[redNextX][redNextY] == '#'){
                            redNextX -= dx[i];
                            redNextY -= dy[i];
                            break;
                        }
                        redNextX += dx[i];
                        redNextY += dy[i];
                    }
                    // 맵 변경
                    map[redX][redY] = '.';
                    map[redNextX][redNextY] = 'R';
                    // blue 이동
                    while(true){
                        if(map[blueNextX][blueNextY] == 'O'){
                            map[redX][redY] = 'R';
                            map[redNextX][redNextY] = '.';
                            return;
                        }
                        if(map[blueNextX][blueNextY] == '#'){
                            blueNextX -= dx[i];
                            blueNextY -= dy[i];
                            break;
                        }
                        if(map[blueNextX][blueNextY] == 'R'){
                            blueNextX -= dx[i];
                            blueNextY -= dy[i];
                            break;
                        }
                        blueNextX += dx[i];
                        blueNextY += dy[i];
                    }
                    // 맵 변경
                    map[blueX][blueY] = '.';
                    map[blueNextX][blueNextY] = 'B';
                }
                // DFS
                dfs(redNextX, redNextY, blueNextX, blueNextY, count+1);
                // 원상복귀
                map[redNextX][redNextY] = '.';
                map[redX][redY] = 'R';
                map[blueNextX][blueNextY] = '.';
                map[blueX][blueY] = 'B';
            }
            // 동
            if(i == 3){
                System.out.println("동 이동");
                // blue 먼저 움직임
                if(redY < blueY){
                    // blue 이동
                    while(true){
                        if(map[blueNextX][blueNextY] == 'O'){
                            return;
                        }
                        if(map[blueNextX][blueNextY] == '#'){
                            blueNextX -= dx[i];
                            blueNextY -= dy[i];
                            break;
                        }
                        blueNextX += dx[i];
                        blueNextY += dy[i];
                    }
                    // 맵 변경
                    map[blueX][blueX] = '.';
                    map[blueNextX][blueNextX] = 'B';
                    // red 이동
                    while(true){
                        if(map[redNextX][redNextY] == 'O'){
                            answer = Math.min(answer, count+1);
                            map[blueX][blueX] = 'B';
                            map[blueNextX][blueNextX] = '.';
                            return;
                        }
                        if(map[redNextX][redNextY] == '#'){
                            redNextX -= dx[i];
                            redNextY -= dy[i];
                            break;
                        }
                        if(map[redNextX][redNextY] == 'B'){
                            redNextX -= dx[i];
                            redNextY -= dy[i];
                            break;
                        }
                        redNextX += dx[i];
                        redNextY += dy[i];
                    }
                    // 맵 변경
                    map[redX][redY] = '.';
                    map[redNextX][redNextY] = 'R';
                }
                // red 먼저 움직임
                else{
                    // red 이동
                    while(true){
                        if(map[redNextX][redNextY] == 'O'){
                            answer = Math.min(answer, count+1);
                            return;
                        }
                        if(map[redNextX][redNextY] == '#'){
                            redNextX -= dx[i];
                            redNextY -= dy[i];
                            break;
                        }
                        redNextX += dx[i];
                        redNextY += dy[i];
                    }
                    // 맵 변경
                    map[redX][redY] = '.';
                    map[redNextX][redNextY] = 'R';
                    // blue 이동
                    while(true){
                        if(map[blueNextX][blueNextY] == 'O'){
                            map[redX][redY] = 'R';
                            map[redNextX][redNextY] = '.';
                            return;
                        }
                        if(map[blueNextX][blueNextY] == '#'){
                            blueNextX -= dx[i];
                            blueNextY -= dy[i];
                            break;
                        }
                        if(map[blueNextX][blueNextY] == 'R'){
                            blueNextX -= dx[i];
                            blueNextY -= dy[i];
                            break;
                        }
                        blueNextX += dx[i];
                        blueNextY += dy[i];
                    }
                    // 맵 변경
                    map[blueX][blueY] = '.';
                    map[blueNextX][blueNextY] = 'B';
                }
                // DFS
                dfs(redNextX, redNextY, blueNextX, blueNextY, count+1);
                // 원상복귀
                map[redNextX][redNextY] = '.';
                map[redX][redY] = 'R';
                map[blueNextX][blueNextY] = '.';
                map[blueX][blueY] = 'B';
            }
        }
    }
}
