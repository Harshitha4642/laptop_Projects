package trumpCards;
public class Card {
	
		public String name;
		public int matches;
		public int not_outs;
		public int runs;
		public int high_score;
		public int hundreds;
		public int fifties;
		public int acc_ranking;
		public double average;
		
		public Card()
		{
			
		}
		
		public Card(String name, int matches, int not_outs, int runs, int high_score,  int hundreds, int fifties, int acc_ranking, double average) {
			this.name = name;
			this.matches = matches;
			this.not_outs = not_outs;
			this.runs = runs;
			this.high_score = high_score;
			this.hundreds = hundreds;
			this.fifties = fifties;
			this.acc_ranking = acc_ranking;
			this.average = average;
		}	
}
