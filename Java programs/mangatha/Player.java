package websites;

public class Player {
	
	public String name;
	public Card card;
	public String bet;
	public Player(String name, Card card, String bet)
	{
		this.name=name;
		this.card=card;
		this.bet=bet;
	}
	public String makeBet() {
		return name+"\n"+"\n"+bet;
	}
}
