package BACKJOON;

import java.io.*;
import java.util.*;

public class Main_10870_피보나치수5 {

	static int N, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		// 0이거나 1일 경우 그냥 0, 1 출력
		if(N == 0) {
			ans = 0;
		}else if(N == 1){
			ans =1;
		}else {
			// 0, 1부터 시작하며 번호는 2번부터
			recursive(0, 1, 2);
		}
		
		System.out.println(ans);
	}

	private static void recursive(int first, int second, int cnt) {
		// cnt번째 수는 first + second
		int me = first + second;
		
		// 원하는 번호일 경우
		if(cnt == N){
			// 답을 출력하고 재귀 종료
			ans = me;
			return;
		}
		
		// second를 first수로, 자신을 second로 하여 다음 번호로 이동
		recursive(second, me, cnt+1);
	}

}
