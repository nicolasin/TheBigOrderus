package wata.es.Orderus.Characters;

import java.util.Random;

public abstract class FantasyCharacter {

	protected String name;
	protected int health = 0;
	protected int strength = 0;
	protected int defense = 0;
	protected int speed = 0;
	protected int luck = 0;
	protected boolean isAtacked = true;

	protected FantasyCharacter(String name) {
		this.name = name;
	}
	public abstract void generateStates();

	public abstract int attack(FantasyCharacter defender);

	protected abstract void defend(int damage);

	protected int getRandomAtributeBetween(int min, int max) {
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}

	public boolean isAttack() {
		return this.isAtacked;
	}

	public int getSpeed() {
		return speed;
	}

	public int getLuck() {
		return luck;
	}

	public int getHealth() {
		return health;
	}

	public String getName() {
		return name;
	}

	public void attackTurn() {
		this.isAtacked = true;
	}

	public void defendTurn() {
		this.isAtacked = false;
	}

	protected void setHealth(int health) {
		this.health = health;
		if (this.health < 0) {
			this.health = 0;
		}
	}
	protected int calculateDamage(int attackStrength) {
		int damage = attackStrength - defense;
		if (damage < 0) {
			damage = 0;
		}
		return damage;

	}
	@Override
	public String toString() {
		return name + " [health=" + health + ", strength=" + strength + ", defense=" + defense + ", speed=" + speed
				+ ", luck=" + luck + "]";
	}

	protected boolean isLucky() {
		if (getRandomAtributeBetween(0, 100) < luck) {
			return true;
		}
		return false;
	}

}
