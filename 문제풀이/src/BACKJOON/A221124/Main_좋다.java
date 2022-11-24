package BACKJOON.A221124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_좋다 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			int left = 0;
			int right = N - 1;
			
			while(true) {
				if(i == left) {
					left++;
				} else if(i == right) {
					right--;
				}
				
				if(left >= right) {
					break;
				}
				
				if(nums[i] > nums[left] + nums[right]) {
					left++;
				} else if(nums[i] < nums[left] + nums[right]) {
					right--;
				} else {
					result++;
					break;
				}				
			}
		}
		
		System.out.println(result);
		
	}

}
