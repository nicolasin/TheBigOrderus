package wata.es.Orderus.Characters;

public final class WildBeast extends Monster{
	public WildBeast(String name) {
		super(name);
	}
	public WildBeast() {
		super("");
		this.name = this.getClass().getSimpleName();
	}
	public void generateStates() {
		super.health = getRandomAtributeBetween(60,90);
		super.strength = getRandomAtributeBetween(60, 90);
		super.defense = getRandomAtributeBetween(40, 60);
		super.speed = getRandomAtributeBetween(40, 60);
		super.luck = getRandomAtributeBetween(25, 40);
	}
}
