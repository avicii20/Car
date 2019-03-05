package edu.xalead.xatu.vo;

import java.util.ArrayList;
import java.util.List;

import edu.xalead.xatu.model.Road;


public class RoadVO {
	private int length;
	private List<RoadThingsVO> roadThings = new ArrayList<RoadThingsVO>();
	public RoadVO() {}
	public RoadVO(Road road) {
		this.length = road.getRoadLength();
		
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public List<RoadThingsVO> getRoadThings() {
		return roadThings;
	}
	public void setRoadThings(List<RoadThingsVO> roadThings) {
		this.roadThings = roadThings;
	}
}
