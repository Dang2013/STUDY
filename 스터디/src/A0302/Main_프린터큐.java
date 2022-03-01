package A0302;

import java.io.*;
import java.util.*;

public class Main_프린터큐 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			LinkedList<int[]> q = new LinkedList<>();
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int cnt = 0;
			
			// 초기 위치와 중요도 입력
			for (int i = 0; i < N; i++) {
				q.offer(new int[] {i, sc.nextInt()});				
			}
			
			while(!q.isEmpty()) {
				// 현재 문서 중요도가 가장 큰지 여부
				boolean isMax = true;
				int[] current = q.poll();
				
				// 현재 문서와 큐에 남아있는 문서 비교
				for (int i = 0; i < q.size(); i++) {
					// 현재 문서보다 중요도가 큰 문서를 만나면
					if(current[1] < q.get(i)[1]) {
						// 현재 문서 이전의 문서들 큐의 뒤에 입력
						q.offer(current);
						for (int j = 0; j < i; j++) {
							q.offer(q.poll());
						}
						// 현재 문서가 가장 중요한 문서가 아니다. 체크 후 탐색 종료
						isMax = false;
						break;
					}
				}
				
				// 가장 중요한 문서라면 출력 수 + 1
				if(isMax) {
					cnt++;
				}
				// 아니라면 다음 탐색으로
				else {
					continue;
				}
				
				// 현재 문서가 찾고자 하는 문서라면 종료
				if(current[0] == M) {
					break;
				}
			}
			
			sb.append(cnt+"\n");
			
		}
		
		System.out.println(sb);
		
	}

}
