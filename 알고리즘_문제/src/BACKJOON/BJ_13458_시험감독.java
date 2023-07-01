package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13458_시험감독 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] map = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long ans = 0;
		
		for (int i = 0; i < N; i++) {
			// 총감독관 수 Count 후 계산 
			ans++;
			
			map[i] -= B;
			
			// 부감독관 수 Count
			if(map[i] > 0) {
				ans += map[i] / C;
				
				if(map[i] % C != 0) {
					ans++;
				}
			}
		}
		
		System.out.println(ans);
		
	}

}
