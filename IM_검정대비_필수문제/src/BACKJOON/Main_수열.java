package BACKJOON;

import java.io.*;
import java.util.*;

public class Main_수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// 증가 수
		int cntP = 1;
		int maxP = 1;
		// 이전 수
		int temp = nums[0];
		
		// 증가 수열 체크
		for (int i = 1; i < N; i++) {
			// 이전 수보다 크면
			if(nums[i] >= temp) {
				cntP++;
			}
			// 작아지면 증가 수열 체크 초기화 = 1
			else {
				cntP = 1;
			}			
			maxP = Math.max(maxP, cntP);
			temp = nums[i];
		}
		
		// 감소 수열 체크
		temp = nums[0];
		// 감소 수
		int cntM = 1;
		int maxM = 1;
		for (int i = 1; i < N; i++) {			
			// 이전 수보다 작으면
			if(nums[i] <= temp) {
				cntM++;
			}
			// 작아지면 증가 수열 체크 초기화 = 1
			else {
				cntM = 1;
			}
			maxM = Math.max(maxM, cntM);
			temp = nums[i];
		}
		
		System.out.println(Math.max(maxP, maxM));
	}

}
