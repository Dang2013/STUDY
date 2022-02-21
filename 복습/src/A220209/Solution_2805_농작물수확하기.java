package A220209;

import java.io.*;
import java.util.*;

public class Solution_2805_농작물수확하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			// 농장 입력
			int[][] farm = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					farm[i][j] = str.charAt(j) - '0';
				}
			}
			
			// 중앙값
			int center = N / 2;
			// 수확 불가 지역
			int blank = N / 2;
			// 수확량
			int sum = 0;
			
			for (int i = 0; i < N; i++) {
				// 수확 가능 지역 = 전체 길이 - (수확 불가 지역 * 2)
				int harvest = N - (blank * 2);
				// 수확 불가 지역 다음 부터 수확 가능 지역만큼
				for (int j = blank; j < (blank + harvest); j++) {
					//수확량 구하기
					sum += farm[i][j];
				}
				// 중앙을 넘기 전까진 
				if(i < center) {
					// 수확 불가 지역이 줄어들고
					blank--;
				// 중앙을 넘으면
				}else {
					// 수확 불가 지역이 늘어난다.
					blank++;
				}
			}
			
			sb.append("#"+tc+" "+sum+"\n");
			
		}
		
		System.out.println(sb);

	}

}
