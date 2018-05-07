package wata.es.Orderustests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import wata.es.Orderus.Characters.Orderus;
import wata.es.Orderus.Characters.WildBeast;

class WildBeastTest {

	@Test
	@DisplayName("Attack values from her power hit")
	void testAttackValues() {
		WildBeast wildBeast = new WildBeast("Best 1");
		WildBeast wildBeast2 = new WildBeast();
		for(int i = 0; i < 1000; i++) {
			wildBeast.generateStates();
			assertTrue(wildBeast.attack(wildBeast2)>= 60 && wildBeast.attack(wildBeast2) <=90);
		}
		
		
	}
	@Test
	@DisplayName("Speed values from her power hit")
	void testSpeedValue() {
		WildBeast wildBeast = new WildBeast("Best 1");
		assertTrue(wildBeast.getSpeed()>= 40 && wildBeast.getSpeed() <=60);
	}
	@Test
	@DisplayName("Luck values from her power hit")
	void testLuckValue() {
		WildBeast wildBeast = new WildBeast("Best 1");
		assertTrue(wildBeast.getLuck()>= 25 && wildBeast.getLuck() <=40);
	}
	@Test
	@DisplayName("test for constructor with or not with name")
	void testgetName() {
		WildBeast wildBeast1 = new WildBeast("Beast 1");
		WildBeast wildBeast2 = new WildBeast();
		assertEquals("Beast 1", wildBeast1.getName());
		assertEquals("WildBeast", wildBeast2.getName());
	}
	@Test
	@DisplayName("test from change character from attacking to defending")
	void testChangedFightPosition() {
		WildBeast wildBeast1 = new WildBeast();
		wildBeast1.attackTurn();
		assertTrue(wildBeast1.isAttack());
		wildBeast1.defendTurn();
		assertTrue(!wildBeast1.isAttack());
	}
	@Test
	@DisplayName("testing the metod generate states")
	void testToGenerateNewStates() {
		WildBeast wildBeast1 = new WildBeast();
		int health = wildBeast1.getHealth();
		boolean isChanged = false;
		for(int i = 0; i < 100; i++) {
			if(health!=wildBeast1.getHealth()) {
				isChanged = true;
			}
			wildBeast1.generateStates();
		}
		assertTrue(isChanged);
	}
	

}
