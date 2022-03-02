package A0302;

import java.io.*;
import java.util.*;

public class Main_FourSquares {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		// 각 수의 최소 제곱 수 저장할 배열
		int[] square = new int[N+1];
		
		square[1] = 1;
		
		// 최소 제곱 수 = (최대 제곱의 수 + 자신을 최대 제곱으로 뺀 나머지 수의 최소 제곱수)
		for (int i = 2; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			// 최소 제곱 수 구하기
			for (int j = 1; j * j <= i; j++) {
				min = Math.min(min, square[i - j * j]);
			}
			square[i] = min + 1;
		}
		
		System.out.println(square[N]);

	}

}
