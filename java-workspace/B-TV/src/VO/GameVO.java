package VO;

public class GameVO {
	private String id;
	private int win;
	private int lose;
	private int bestScore;
	@Override
	public String toString() {
		return "GameVO [id=" + id + ", win=" + win + ", loss=" + lose + ", bestScore=" + bestScore + "]";
	}
	public GameVO() {super();}
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public int getWin() {return win;}
	public void setWin(int win) {this.win = win;}
	public int getLose() {return lose;}
	public void setLose(int lose) {this.lose = lose;}
	public int getBestScore() {return bestScore;}
	public void setBestScore(int bestScore) {this.bestScore = bestScore;}
	public GameVO(String id, int win, int lose, int bestScore) {
		super();
		this.id = id;
		this.win = win;
		this.lose = lose;
		this.bestScore = bestScore;
	}
}
