package loser.zon2008.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8050488540340421989L;

	private String name;
	private int marks;
	private String hint;
	private Card choose;
	private ArrayList<Card> havings;

	public Player() {
	}

	public Player(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Card> getHavings() {
		return havings;
	}

	public void setHavings(ArrayList<Card> havings) {
		this.havings = havings;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	public Card getChoose() {
		return choose;
	}

	public void setChoose(Card choose) {
		this.choose = choose;
	}

}
