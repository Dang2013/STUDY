package BACKJOON.A221124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_평범한배낭 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] W = new int[N+1];
		int[] C = new int[N+1];
		
		int[][] dp = new int[N+1][K+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			W[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int k = 1; k <= K; k++) {
			for (int i = 1; i <= N; i++) {
				dp[i][k] = dp[i-1][k];
				if(k - W[i] >= 0) {
					dp[i][k] = Math.max(dp[i-1][k], C[i] + dp[i-1][k-W[i]]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
		
	}

}
