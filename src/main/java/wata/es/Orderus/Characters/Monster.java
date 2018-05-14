package wata.es.Orderus.Characters;

public abstract class Monster extends FantasyCharacter {
	protected Monster(String name) {
		super(name);
	}
	@Override
	public int attack(FantasyCharacter defender) {
		defender.defend(strength);
		return strength;
	}
	@Override
	protected void defend(int attackStrength) {
		if(!isLucky()) {
			int damage = calculateDamage(attackStrength);
			System.out.println("\n"+this.getName()+ " receive "+damage+" damage points");
			this.setHealth(health - damage);
		}
		else {
			System.out.println("\n"+this.getName()+ " is deflect the attack");
		}
	}

}
