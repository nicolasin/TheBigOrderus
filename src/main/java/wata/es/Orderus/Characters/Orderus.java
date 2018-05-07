package wata.es.Orderus.Characters;

import wata.es.Orderus.Skills.*;

public final class Orderus extends Hero {

	public Orderus(String name) {
		super(name, new RapidStrike(), new MagicShield());
		generateStates();
	}

	public Orderus() {
		super("Orderus", new RapidStrike(), new MagicShield());
		generateStates();
	}

	public void generateStates() {
		super.health = getRandomAtributeBetween(70, 100);
		super.strength = getRandomAtributeBetween(70, 80);
		super.defense = getRandomAtributeBetween(45, 55);
		super.speed = getRandomAtributeBetween(40, 50);
		super.luck = getRandomAtributeBetween(10, 30);
	}

	

}
