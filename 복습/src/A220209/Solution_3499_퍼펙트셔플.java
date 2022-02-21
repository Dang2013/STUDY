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
			
			String[] deck = new String[N];
			
			for (int i = 0; i < N; i++) {
				deck[i] = sc.next();
			}
			
			sb.append("#"+tc+" ");
			
			if(N % 2 == 0) {
				int idx = 0;
				int cnt = 0;
				while(cnt < N) {
					sb.append(deck[idx]+" ");
					if(cnt % 2 == 0) {
						idx += (N/2);
					}
					else {
						idx -= ((N/2)-1);
					}
					cnt++;
				}
				sb.append("\n");
			}
			else {
				int idx = 0;
				int cnt = 0;
				while(cnt < N) {
					sb.append(deck[idx]+" ");
					if(cnt % 2 ==0 ) {
						idx += (N/2)+1;
					}
					else {
						idx -= (N/2);
					}
					cnt++;
				}
				sb.append("\n");
			}
		}
		
		System.out.print(sb);

	}

}
