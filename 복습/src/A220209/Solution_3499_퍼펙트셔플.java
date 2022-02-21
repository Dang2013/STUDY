package A220209;

import java.io.*;
import java.util.*;

public class Solution_3499_퍼펙트셔플 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			// 카드 입력
			String[] deck = new String[N];
			for (int i = 0; i < N; i++) {
				deck[i] = sc.next();
			}
			
			sb.append("#"+tc+" ");
			
			// 카드 수가 짝수이면
			if(N % 2 == 0) {
				int idx = 0;
				int cnt = 0;
				while(cnt < N) {
					sb.append(deck[idx]+" ");
					// 짝수 순번엔
					if(cnt % 2 == 0) {
						// 다음 인덱스가 카드 수의 절반만큼 증가
						idx += (N/2);
					}
					// 홀수 순번엔
					else {
						// 다음 인덱스가 (카드 수의 절반 - 1)만큼 감소 
						idx -= ((N/2)-1);
					}
					// 다음 순번으로
					cnt++;
				}
				sb.append("\n");
			}
			// 카드 수가 홀수이면
			else {
				int idx = 0;
				int cnt = 0;
				while(cnt < N) {
					sb.append(deck[idx]+" ");
					// 짝수 순번엔
					if(cnt % 2 ==0 ) {
						// 다음 인덱스가 (카드 수의 절반 + 1)만큼 증가
						idx += (N/2)+1;
					}
					// 홀수 순번엔
					else {
						// 다음 인덱스가 카드 수의 절반만큼 감소
						idx -= (N/2);
					}
					// 다음 순번으로
					cnt++;
				}
				sb.append("\n");
			}
		}
		
		System.out.print(sb);

	}

}
