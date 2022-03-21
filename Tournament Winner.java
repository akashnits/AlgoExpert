import java.util.*;

class Program {

  public String tournamentWinner(
      ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
    // Write your code here.
		int n = results.size();
		int max_score = 0;
		String result= "";
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0; i< n; i++){
			String winningTeamName;
			ArrayList<String> competition = competitions.get(i);
			if(results.get(i) == 0){
				// away team won
				winningTeamName = competition.get(1);
			}else{
				// home team won
				winningTeamName = competition.get(0);
			}
			
			int score = map.getOrDefault(winningTeamName, 0);
			score = score+3;
			map.put(winningTeamName, score);
			if(score > max_score){
				// this team is leading
				max_score = score;
				result = winningTeamName;
			}
			
		}
    return result;
  }
}
