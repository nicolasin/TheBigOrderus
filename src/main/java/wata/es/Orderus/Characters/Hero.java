package wata.es.Orderus.Characters;

import wata.es.Orderus.Skills.AttackSkill;
import wata.es.Orderus.Skills.DefendSkill;
import java.util.*;

public abstract class Hero extends FantasyCharacter {
	List<AttackSkill> attackSkills = new ArrayList<AttackSkill>();
	List<DefendSkill> defendSkills = new ArrayList<DefendSkill>();

	protected Hero(String name, AttackSkill attackSkill, DefendSkill defendSkill) {
		super(name);
		attackSkills.add(attackSkill);
		defendSkills.add(defendSkill);

	}

	public void addAttackSkill(AttackSkill attackSkill) {
		attackSkills.add(attackSkill);
	}

	public void addDefendSkill(DefendSkill defendSkill) {
		defendSkills.add(defendSkill);
	}

	public AttackSkill getRandomAtackSkill() {
		int randomIndex = this.getRandomAtributeBetween(0, attackSkills.size() - 1);
		return attackSkills.get(randomIndex);
	}

	public DefendSkill getRandomDefendSkill() {
		int randomIndex = this.getRandomAtributeBetween(0, defendSkills.size() - 1);
		return defendSkills.get(randomIndex);
	}

	@Override
	public int attack(FantasyCharacter defender) {
		AttackSkill currentAttack = getRandomAtackSkill();
		int numAttacks = 1;
		int previousStrength = this.strength;
		if (currentAttack.isUsed()) {
			System.out.println(
					"\n" + this.getName() + " use " + currentAttack.getClass().getSimpleName() + " Attack Skill");
			numAttacks = currentAttack.getNumAttacks();
			this.strength = currentAttack.getStrenght(this.strength);
		}
		for (int i = 0; i < numAttacks; i++) {
			defender.defend(this.strength);
		}
		int strengthToTesting = this.strength;
		this.strength = previousStrength;
		return strengthToTesting*numAttacks;
	}

	@Override
	protected void defend(int attackStrength) {
		DefendSkill defendSkill = getRandomDefendSkill();
		int previousLuck = this.luck;
		int previousDefense = this.defense;

		if (defendSkill.isUsed()) {
			System.out.println(
					"\n" + this.getName() + " use " + defendSkill.getClass().getSimpleName() + " defense Skill");
			applyDefensiveModifiers(defendSkill);
		}
		if (!isLucky()) {
			int damage = calculateDamage(attackStrength);
			System.out.println("\n" + this.getName() + " receive " + damage + " damage points");
			setHealth(health - damage);
		} else {

			System.out.println("\n" + this.getName() + " is deflect the attack");

		}
		takeDefensePreviousAtributes(previousLuck, previousDefense);
	}

	private void takeDefensePreviousAtributes(int previousLuck, int previousDefense) {
		this.luck = previousLuck;
		this.defense = previousDefense;
	}

	private void applyDefensiveModifiers(DefendSkill defendSkill) {

		this.luck = defendSkill.incrementLuck(this.luck);
		this.health = defendSkill.incrementLife(this.health);
		this.defense = defendSkill.incrementDefense(this.defense);

	}

}
