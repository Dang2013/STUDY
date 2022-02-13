package A220203;

import java.io.*;
import java.util.*;

public class Solution_1289_원재의메모리복구 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		// 테스트 케이스 입력
		int T = sc.nextInt();
		
		// 수정 횟수
		int cnt;
		
		for (int tc = 1; tc <= T; tc++) {
			cnt = 0;
			
			// 원본 메모리 입력받기
			String input = sc.next();
			
			// 원본 메모리 비트 단위로 쪼개 저장할 배열
			char[] bit = new char[input.length()];
			
			// 초기화된 메모리
			char[] initial = new char[input.length()];
			
			// 비트 단위로 나누어 입력된 원본 메모리 저장
			for (int i = 0; i < input.length(); i++) {
				bit[i] = input.charAt(i);
				initial[i] = '0';
			}
			
			// 초기화된 메모리 비트가 원본 메모리 비트와 다를 때 수정해야 한다.
			for (int i = 0; i < bit.length; i++) {
				// 다를 경우
				if(bit[i] != initial[i]) {
					// 초기화된 메모리의 해당 비트부터 쭉 수정 
					for (int j = i; j < initial.length; j++) {
						initial[j] = bit[i];
					}
					// 수정 횟수 + 1
					cnt++;
				}
			}
			
			// 출력
			System.out.println("#"+tc+" "+cnt);
		}
	}

}
