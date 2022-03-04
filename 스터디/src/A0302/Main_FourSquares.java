package A0302;

import java.io.*;
import java.util.*;

public class Main_FourSquares {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// 각 수의 최소 제곱 수 (idx*idx) 저장할 배열
		//square[i] = square[i-j*j] + sqaure[j*j]
		int[] square = new int[N+1];
		square[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			// 그냥 제곱수가 아닌 최소 제곱수를 구하여야 함
			int min = Integer.MAX_VALUE;
			// i보다 작거나 같은 제곱수를 찾는다.
			for (int j = 1; j * j <= i; j++) {
				min = Math.min(min, square[i - j * j]);
			}
			square[i] = min + 1;
		}
		
		System.out.println(square[N]);

	}

}