package edu.xalead.xatu.model;

public class SpeedUpThing extends RoadThing {
	public SpeedUpThing(int id, int distance, int left, int width, int height,Road road) {
		super(id, distance, left, width, height,road);
		// TODO Auto-generated constructor stub
	}
	private int howmany;
	private int duration;
	public int getHowmany() {
		return howmany;
	}
	public void setHowmany(int howmany) {
		this.howmany = howmany;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
}
