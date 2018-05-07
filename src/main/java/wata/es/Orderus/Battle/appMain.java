package wata.es.Orderus.Battle;

import wata.es.Orderus.Characters.*;
import wata.es.Orderus.Skills.GodMode;
import wata.es.Orderus.Skills.InvulnerableSkill;

public class appMain {
	public static void main(String[] args) {

		Orderus orderus = new Orderus();
		orderus.addDefendSkill(new InvulnerableSkill());
		orderus.addAttackSkill(new GodMode());

		SuperMonster ElMonstruo = new SuperMonster();
		Battle battle = new Battle(orderus, ElMonstruo);

		orderus.generateStates();
		ElMonstruo.generateStates();

		int result = battle.fight();
	}

}
