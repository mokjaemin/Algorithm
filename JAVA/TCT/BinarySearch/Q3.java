package JAVA.TCT.BinarySearch;

import java.util.*;

// 공유기 설치
public class Q3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 집의 수
        int n = sc.nextInt();

        // 공유기 수
        int c = sc.nextInt();

        // 집 위치 입력 받기
        List<Integer> houses = new ArrayList<>();
        for(int i=0; i<n; i++){
            houses.add(sc.nextInt());
        }

        // 집 정렬
        Collections.sort(houses);

        // 공유기 설치 간격
        // 최소 : 1, 최대 : 구하기
        int start = 1;
        int end = houses.get(n-1)-houses.get(0);
        int result = 0;

        while(start <= end){
            // mid : 현재 공유기 설치 간격
            int mid = (start+end)/2;
            // 공유기 설치 시작점
            int value = houses.get(0);
            // 공유기 설치 수
            int count = 1;
            // 공유기 설치
            for(int i=1; i<n; i++){
                // 집이 기준 집+지정한 공유기 설치간격보다 넓다면
                // 해당 집에 공유기 설치 후 기준 집 수정
                if(houses.get(i) >= value+mid){
                    value = houses.get(i);
                    count += 1;
                }
            }
            // 설치된 공유기 수가 입력받은 공유기 수보다 크다면 설치 가능
            // 따라서 간격을 늘려서 다시 이분탐색
            if(count >= c){
                start = mid+1;
                result = mid;
            }
            // 입력받은 공유기 수보다 작다면 설치 불가능
            // 따라서 간격을 줄여서 다시 이분탐색
            else{
                end = mid-1;
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}
