package wata.es.Orderustests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import wata.es.Orderus.Characters.FantasyCharacter;
import wata.es.Orderus.Characters.Monster;
import wata.es.Orderus.Characters.Orderus;
import wata.es.Orderus.Characters.WildBeast;
import wata.es.Orderus.Skills.InvulnerableSkill;

class OrderusTest {

	@Test
	@DisplayName("test Attack values from Orderus")
	void testAttackValues() {
		Orderus Orderus = new Orderus();
		Monster monster = new WildBeast();
		for (int i = 0; i < 10000; i++) {
			Orderus.generateStates();
			int hit = Orderus.attack(monster);
			boolean isNormalAttack = hit >= 70 && hit <= 80;
			boolean isCriticalAttack = hit >= 140 && hit <= 160;
			assertTrue(isNormalAttack || isCriticalAttack);

		}

	}

	@Test
	@DisplayName("Speed values from her power hit")
	void testSpeedValue() {
		Orderus Orderus = new Orderus();
		assertTrue(Orderus.getSpeed() >= 40 && Orderus.getSpeed() <= 50);
	}

	@Test
	@DisplayName("Luck values from her power hit")
	void testLuckValue() {
		Orderus Orderus = new Orderus("Best 1");
		assertTrue(Orderus.getLuck() >= 10 && Orderus.getLuck() <= 30);
	}

	@Test
	@DisplayName("test for constructor with or not with name")
	void testgetName() {
		Orderus Orderus1 = new Orderus("Dark Orderus");
		Orderus Orderus2 = new Orderus();
		assertEquals("Dark Orderus", Orderus1.getName());
		assertEquals(Orderus2.getClass().getSimpleName(), Orderus2.getName());
	}

	@Test
	@DisplayName("test from change character from attacking to defending")
	void testChangedFightPosition() {
		Orderus Orderus1 = new Orderus();
		Orderus1.attackTurn();
		assertTrue(Orderus1.isAttack());
		Orderus1.defendTurn();
		assertTrue(!Orderus1.isAttack());
	}

	@Test
	@DisplayName("testing the metod generate states")
	void testToGenerateNewStates() {
		Orderus Orderus1 = new Orderus();
		int health = Orderus1.getHealth();
		boolean isChanged = false;
		for (int i = 0; i < 100; i++) {
			if (health != Orderus1.getHealth()) {
				isChanged = true;
			}
			Orderus1.generateStates();
		}
		assertTrue(isChanged);
	}

	@Test
	@DisplayName("testing Attack Skill Rapid Strike")
	void testAttackSkill() {
		Orderus Orderus1 = new Orderus();
		FantasyCharacter monster = new WildBeast();
		int numIteration = 1000;
		boolean OrderusIsUsedAttackSkill = false;
		for (int i = 0; i < numIteration; i++) {
			
			if (Orderus1.attack(monster) >= 140 && Orderus1.attack(monster) <= 160) {
				OrderusIsUsedAttackSkill = true;
			}
		}
		assertTrue(OrderusIsUsedAttackSkill);
	}

}
