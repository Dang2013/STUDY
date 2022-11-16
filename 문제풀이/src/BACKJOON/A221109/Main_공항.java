package BACKJOON.A221109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_공항 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		
		int[] airport = new int[G+1];
		
		for (int i = 0; i < P; i++) {
			int planes = Integer.parseInt(br.readLine());
			boolean isAvailable = false;
			for (int j = 0; j < planes; j++) {
				if(airport[planes-j] == 0) {
					airport[planes-j] = i + 1;
					isAvailable = true;
					break;
				}
			}
			if(!isAvailable) {
				break;
			}
		}
		
		int count = 0;
		
		for (int i = 1; i <= G; i++) {
			if(airport[i] != 0) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}

}
