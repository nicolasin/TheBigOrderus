package wata.es.Orderus.Characters;


import wata.es.Orderus.Skills.InvulnerableSkill;
import wata.es.Orderus.Skills.RapidStrike;

public class SuperMonster extends Hero{

	public SuperMonster() {
		super("SuperMonster", new RapidStrike(), new InvulnerableSkill());
	}

	@Override
	public void generateStates() {
		super.health = getRandomAtributeBetween(200,400);
		super.strength = getRandomAtributeBetween(60, 90);
		super.defense = getRandomAtributeBetween(40, 60);
		super.speed = getRandomAtributeBetween(40, 60);
		super.luck = getRandomAtributeBetween(25, 35);
		
	}
	
}
