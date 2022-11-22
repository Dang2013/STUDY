package BACKJOON.A221116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_종이접기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int T = 0; T < tc; T++) {
			String str = br.readLine();
			
			
			if(str.length()==1) {
				sb.append("YES" + "\n");
				continue;
			}
			
			int len = str.length();
			int idx = len/2;
			boolean stop = false;
			
			while(idx!=0) {
				int j = len - 1;
				for (int i = 0; i < idx; i++) {
					if(str.charAt(i) == str.charAt(j)) {
						stop = true;
						break;
					}
					j--;
				}
				
				if(stop) {
					break;
				}
				
				len /= 2;
				idx /= 2;
				
			}
			
			if(stop) {
				sb.append("NO" + "\n");
			} else {
				sb.append("YES" + "\n");
			}
			
		}
		
		System.out.println(sb);
		
	}

}
