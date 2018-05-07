package wata.es.Orderus.Skills;

public abstract class DefendSkill extends Skill {
	protected int incrementLife;
	protected int incrementDefense;
	protected int incrementLuck;

	public abstract int incrementLife(int currentHealth);
	public abstract int incrementDefense(int currentDefense);
	public abstract int incrementLuck(int currentLuck);

	
}
