package wata.es.Orderus.Battle;

import wata.es.Orderus.Characters.*;
import wata.es.Orderus.Skills.GodMode;
import wata.es.Orderus.Skills.InvulnerableSkill;

public class appMain {
	public static void main(String[] args) {

		Orderus orderus = new Orderus();
		orderus.addDefendSkill(new InvulnerableSkill());
		orderus.addAttackSkill(new GodMode());
		WildBeast wildBeast = new WildBeast();
		int[] counts = new int[]{0,0,0};
		SuperMonster ElMonstruo = new SuperMonster();
		
		Battle battle = new Battle(orderus, ElMonstruo);
		for(int i = 0; i < 1; i++) {
			orderus.generateStates();
			ElMonstruo.generateStates();
			int result = battle.fight();
			counts[result]++;			
		}
		for(int i = 0; i < 3; i++) {
			System.out.println((i+1)+"->"+counts[i]);
		}
		
	}

}
