package A221110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_촌수계산 {

	static int n, x, y, m, ans;
	static List<Integer>[] list;
	static boolean[] isChecked;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n+1];
		isChecked = new boolean[n+1];
		
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			
			list[parent].add(child);
			list[child].add(parent);
			
		}
		
		ans = -1;
		
		dfs(x, y, 0);
		
		System.out.println(ans);
		
	}

	private static void dfs(int start, int end, int cnt) {
		if(start == end) {
			ans = cnt;
			return;
		}
		
		isChecked[start] = true;
		
		for (int i = 0; i < list[start].size(); i++) {
			int next = list[start].get(i);
			if(!isChecked[next]) {
				dfs(next, end, cnt+1);
			}
		}
	}

}
