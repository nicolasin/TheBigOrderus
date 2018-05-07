package wata.es.Orderus.Skills;

public final class InvulnerableSkill extends DefendSkill{
	public InvulnerableSkill() {
		this.incrementDefense = 100;
		this.incrementLife = 0;
		this.incrementLuck = 0;
		this.probability = 20;
	}
	@Override
	public int incrementLife(int currentHealth) {
		return currentHealth+ incrementLife;
	}
	@Override
	public int incrementDefense(int currentDefense) {
		return currentDefense*incrementDefense;
	}
	@Override
	public int incrementLuck(int currentLuck) {
		return currentLuck+incrementLuck;
	}
		

}
