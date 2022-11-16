package BACKJOON.A221115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_걷기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long X = Integer.parseInt(st.nextToken());
		long Y = Integer.parseInt(st.nextToken());
		
		// 일직선 시간
		long W = Integer.parseInt(st.nextToken());
		// 대각선 시간
		long S = Integer.parseInt(st.nextToken());
		
		// 1. 일직선만 이용
		long res1 = (X+Y) * W;
		// 2-1. X+Y가 짝수인 경우 = 대각선만으로 이동
		long res2 = 0;
		if((X+Y) % 2 == 0) {
			res2 = Math.max(X, Y) * S;
		}
		// 2-2. X+Y가 홀수인 경우 = 대각선으로 이동 후 일직선 + 1
		else {
			res2 = ((Math.max(X, Y) - 1) * S) + W;
		}
		// 3. 대각선으로 최대한 이동 + 일직선
		long res3 = Math.min(X, Y) * S + Math.abs(X - Y) * W;
		
		long result = Math.min(res1, Math.min(res2, res3));
		
		System.out.println(result);
	}

}
