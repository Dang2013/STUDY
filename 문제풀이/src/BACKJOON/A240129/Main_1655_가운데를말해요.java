package BACKJOON.A240129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1655_가운데를말해요 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			minHeap.offer(Integer.parseInt(st.nextToken()));
			
			boolean isEven = (minHeap.size() % 2) == 0;
			
			int mid = minHeap.size() / 2;
			
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
