package BAEKJOON_RANDOM2;


import java.io.BufferedReader;
import java.io.InputStreamReader;

// 볼 모으기
public class Q19 {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String value = br.readLine();
        int answer = (int)1e9;
        // B 왼쪽 시작
        int bLeft = 0;
        boolean check = false;
        for(int i=0; i<n; i++){
            if(value.charAt(i) == 'B' && !check){
                continue;
            }
            if(value.charAt(i) == 'R'){
                check = true;
                continue;
            }
            bLeft += 1;
        }
        answer = Math.min(answer, bLeft);
        // B 오른쪽 시작
        int bRight = 0;
        check = false;
        for(int i=n-1; i>=0; i--){
            if(value.charAt(i) == 'B' && !check){
                continue;
            }
            if(value.charAt(i) == 'R'){
                check = true;
                continue;
            }
            bRight += 1;
        }
        answer = Math.min(answer, bRight);
        // R 왼쪽 시작
        int rLeft = 0;
        check = false;
        for(int i=0; i<n; i++){
            if(value.charAt(i) == 'R' && !check){
                continue;
            }
            if(value.charAt(i) == 'B'){
                check = true;
                continue;
            }
            rLeft += 1;
        }
        answer = Math.min(answer, rLeft);
        // B 오른쪽 시작
        int rRight = 0;
        check = false;
        for(int i=n-1; i>=0; i--){
            if(value.charAt(i) == 'R' && !check){
                continue;
            }
            if(value.charAt(i) == 'B'){
                check = true;
                continue;
            }
            rRight += 1;
        }
        answer = Math.min(answer, rRight);
        System.out.println(answer);
    }
}
