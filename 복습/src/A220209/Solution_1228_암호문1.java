package A220209;

import java.io.*;
import java.util.*;

public class Solution_1228_암호문1 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1228.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			// 원본 암호문의 길이
			int N = Integer.parseInt(br.readLine());
			
			// 암호문 저장할 List
			List<Integer> pw = new LinkedList<>();
			
			// 원본 암호문 저장
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				pw.add(i, Integer.parseInt(st.nextToken()));
			}
			
			// 명령어의 개수
			int op = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < op; i++) {
				// I 패스
				st.nextToken();
				
				// 새 암호문 삽입할 위치
				int x = Integer.parseInt(st.nextToken());
				
				// 새 암호문 길이
				int y = Integer.parseInt(st.nextToken());
				
				for (int j = 0; j < y; j++) {
					pw.add(x, Integer.parseInt(st.nextToken()));
					x++;
				}
			}
			
			sb.append("#"+tc+" ");
			for (int i = 0; i < 10; i++) {
				sb.append(pw.get(i)+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	}

}
