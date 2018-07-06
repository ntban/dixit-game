package loser.zon2008.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Card implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6070990636439137410L;
	
	private String image;
	private Player owner;
	private ArrayList<Player> choosers;
	
	public Card(){}
	

	
	public Card(String image) {
		super();
		this.image = image;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Player getOwner() {
		return owner;
	}
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	public ArrayList<Player> getChoosers() {
		return choosers;
	}
	public void setChoosers(ArrayList<Player> choosers) {
		this.choosers = choosers;
	}

}
