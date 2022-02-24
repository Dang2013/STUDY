package BACKJOON;

import java.io.*;
import java.util.*;

public class Main_일곱_난쟁이 {

	static int[] input, result;
	static boolean[] visited;
	static int height;
	
	//조합으로 풀기
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		input = new int[9];
		visited = new boolean[9];
		result = new int[7];
		
		height = 0;
		
		//9명의 키 입력받기
		for(int i = 0; i < 9; i++){
			input[i] = sc.nextInt();
		}
		
		Arrays.sort(input);
		
		comb(0, 0);
		
	}
	
	static void comb(int cnt, int start) {
		if(cnt == 7) {
			for(int i = 0; i < 7; i++) {
				height += result[i];
			}
			
			if(height == 100) {
				for(int i = 0; i < 7; i++) {
					System.out.println(result[i]);
				}
			}
			
			height = 0;
			return;
		}
		
		for(int i = start; i < 9; i++) {
			result[cnt] = input[i];
			comb(cnt+1,i+1);
		}
		
	}

}
