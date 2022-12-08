package SW.A221208;

public class 완벽한문자열 {

	public String solution(String sentence) {
        sentence = sentence.toLowerCase();
        sentence = sentence.replace(" ", "");
        String answer = "";

        boolean[] alp = new boolean[26];

        for(int i = 0; i < sentence.length(); i++){
            char ch = sentence.charAt(i);

            int idx = (int)ch - 97;

            if(idx < 0){
                continue;
            }

            alp[idx] = true;
        }

        for(int i = 0; i < 26; i++){
            if(!alp[i]){
                int idx = i + 97;
                char ch = (char)idx;
                answer = answer + ch;
            }
        }

        if(answer == ""){
            answer = "perfect";
        }

        return answer;
    }

}
