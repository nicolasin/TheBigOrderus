package wata.es.Orderus.Skills;

public class GodMode extends AttackSkill {
	public GodMode() {
		this.numAttacks = 10;
		this.probability = 25;
		this.strenght = 35;
	}
	@Override
	public int getNumAttacks() {
		return numAttacks;
	}

	@Override
	public int getStrenght(int currentStrenght) {

		return currentStrenght+strenght;
	}

}
