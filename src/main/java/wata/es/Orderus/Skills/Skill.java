package wata.es.Orderus.Skills;

import java.util.Random;

public abstract class Skill {
	protected int probability;
	
	public boolean isUsed() {
		return getRandomPorcent() <= probability;
	}
	private int getRandomPorcent() {
		int min = 0;
		int max = 100;
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}

}
