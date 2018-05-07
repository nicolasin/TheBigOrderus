package wata.es.Orderus.Skills;

public final class RapidStrike extends AttackSkill{
	public RapidStrike() {
		this.probability = 10;
		this.numAttacks = 2;
		this.strenght = 0;
	}
	public int getNumAttacks() {
		return numAttacks;
	}
	@Override
	public int getStrenght(int currentStrenght) {
		// TODO Auto-generated method stub
		return currentStrenght+this.strenght;
	}
	 
}
