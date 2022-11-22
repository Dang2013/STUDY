package BACKJOON.A221122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_등수매기기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 불만도
		int complain = 0;
		
		// 중복된 등수 저장
		List<Integer> list = new ArrayList<>();
		
		// 해당 등수에 이미 사람이 배당되어 있는지 체크
		boolean[] isIn = new boolean[N+1];
		
		// N만큼의 희망 등수 입력받기
		for (int i = 1; i <= N; i++) {
			int rank = Integer.parseInt(br.readLine());
			
			// 희망 등수에 이미 있을 경우
			if(isIn[rank]) {
				list.add(rank);
			// 아닌 경우엔 등수에 배정
			} else {				
				isIn[rank] = true;
			}
		}
		
		// 희망 등수 중복된 사람 배정
		for (int i = 0; i < list.size(); i++) {
			int cur = list.get(i);
			
			// 위아래 체크
			for (int j = 1; j <= N; j++) {
				int up = cur + j;
				int down = cur - j;
				
				// 위아래 둘다 체크 가능
				if(up <= N && down > 0) {
					if(!isIn[up] || !isIn[down]) {
						isIn[up] = true;
						complain += j;
						break;
					}
				}
				// 위만 체크 가능
				else if(up <= N && down < 1) {
					if(!isIn[up]) {
						isIn[up] = true;
						complain += j;
						break;
					}
				}
				// 아래만 체크 가능
				else if(down > 0 && up > N) {
					if(!isIn[down]) {
						isIn[down] = true;
						complain += j;
						break;
					}
				}
			}
			
		}
		
		System.out.println(complain);
		
	}

}
