package edu.xalead.xatu.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import edu.xalead.xatu.view.MyCavas;
import edu.xalead.xatu.vo.RoadVO;

public class Road {
	private int ac = 0;// 和距离对冲，让车距离增加时不要跑出界面的对冲值
	private int width;
	private int roadLength;
	private BufferedImage roadImg = null;
	public static final int ROAD_LEFT = 50;// 跑道边界
	public static final int ROAD_WIDTH = 140;// 每条跑道的宽度
	private CarNetGame game;
	private ArrayList<RoadThing> roadThings = new ArrayList<RoadThing>();

	public Road(int length, CarNetGame game) {
		this.roadLength = length;
		this.game = game;
		init();
	}

	private void init() {
		this.width = 700;

		// 初始化跑道的背景图片
		try {
			this.roadImg = ImageIO.read(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("edu/xalead/xatu/model/bg_sky.jpg"));

			Graphics2D g2d = (Graphics2D) this.roadImg.getGraphics();

			g2d.setColor(Color.WHITE);
			int linewidth = 5;
			g2d.setStroke(new BasicStroke(linewidth));

			g2d.drawLine(ROAD_LEFT, 0, ROAD_LEFT, MyCavas.GAME_HEIGHT);
			for (int i = 1; i <= 4; i++) {
				g2d.setStroke(new BasicStroke(linewidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1F,
						new float[] { 21, 9, 3, 9 }, 0f));

				g2d.drawLine(ROAD_LEFT + ROAD_WIDTH * i, 0, ROAD_LEFT + ROAD_WIDTH * i, MyCavas.GAME_HEIGHT);
			}
			g2d.setStroke(new BasicStroke(5));
			g2d.drawLine(MyCavas.GAME_WIDTH - ROAD_LEFT, 0, MyCavas.GAME_WIDTH - ROAD_LEFT, MyCavas.GAME_HEIGHT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Road(RoadVO road, CarNetGame game) {
		this.roadLength = road.getLength();
		this.game = game;
		init();
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getRoadLength() {
		return roadLength;
	}

	public void setRoadLength(int roadLength) {
		this.roadLength = roadLength;
	}

	public CarNetGame getGame() {
		return game;
	}

	public void setGame(CarNetGame game) {
		this.game = game;
	}

	public ArrayList<RoadThing> getRoadThings() {
		return roadThings;
	}

	public void setRoadThings(ArrayList<RoadThing> roadThings) {
		this.roadThings = roadThings;
	}

	public void draw(Graphics g) {
		g.drawImage(roadImg, 0, this.ac % MyCavas.GAME_HEIGHT - MyCavas.GAME_HEIGHT, null);

		g.drawImage(roadImg, 0, this.ac % MyCavas.GAME_HEIGHT, null);
	}

	public int getAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}
}
