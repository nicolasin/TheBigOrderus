package wata.es.Orderus.Skills;

public final class MagicShield extends DefendSkill{
	public MagicShield() {
		this.incrementDefense = 0;
		this.incrementLife = 0;
		this.incrementLuck = 0;
		this.probability = 20;
	}
	@Override
	public int incrementLife(int currentHealth) {
		return currentHealth;
	}
	@Override
	public int incrementDefense(int currentDefense) {
		return currentDefense*2;
	}
	@Override
	public int incrementLuck(int currentLuck) {
		return currentLuck;
	}
}
