package wata.es.Orderus.Skills;

public abstract class AttackSkill extends Skill {
	protected int numAttacks;
	protected int strenght;


	public abstract int getNumAttacks();
	public abstract int getStrenght(int currentStrenght);
		
}
