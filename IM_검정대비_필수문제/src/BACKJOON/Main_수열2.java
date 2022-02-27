package BACKJOON;

import java.io.*;
import java.util.*;

public class Main_수열2 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] temperature = new int[N];
		
		for (int i = 0; i < N; i++) {
			temperature[i] = sc.nextInt();
		}
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i <= N-K; i++) {
			int sum = 0;
			for (int j = i; j < i+K; j++) {
				sum += temperature[j];
			}
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}

}
