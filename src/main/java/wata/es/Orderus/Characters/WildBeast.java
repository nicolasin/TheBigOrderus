package wata.es.Orderus.Characters;

public final class WildBeast extends Monster{
	public WildBeast(String name) {
		super(name);
		generateStates();
	}
	public WildBeast() {
		super("WildBeast");
		generateStates();
	}
	public void generateStates() {
		this.health = getRandomAtributeBetween(60,90);
		this.strength = getRandomAtributeBetween(60, 90);
		this.defense = getRandomAtributeBetween(40, 60);
		this.speed = getRandomAtributeBetween(40, 60);
		this.luck = getRandomAtributeBetween(25, 40);
	}
}
