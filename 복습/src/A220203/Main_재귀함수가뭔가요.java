package A220203;

import java.io.*;
import java.util.*;

public class Main_재귀함수가뭔가요 {

	static StringBuilder sb = new StringBuilder();
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		//횟수 입력 받기
		N = sc.nextInt();
		
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		
		Recursive(0, "");
		
		System.out.println(sb);
	}

	//반복 횟수를 알 수 있게끔 현재 횟수 입력 받기 + "____"를 추가할 수 있게끔 String underbar도 입력받기
	static void Recursive(int cnt, String ub) {
		
		//반복횟수를 모두 채웠으면 마지막 호출 문장들 출력 후 재귀 종료
		if(cnt == N) {
			sb.append(ub + "\"재귀함수가 뭔가요?\"\n");
			sb.append(ub + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			sb.append(ub + "라고 답변하였지.\n");
			
			return;
		}
		
		// 반복 구문
		sb.append(ub + "\"재귀함수가 뭔가요?\"\n");
		sb.append(ub + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
		sb.append(ub + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
		sb.append(ub + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		
		//위 문장 출력 후 다음 회차의 재귀 호출 + "____" 추가
		Recursive(cnt+1,ub + "____");
		
		sb.append(ub + "라고 답변하였지.\n");
	}
}
