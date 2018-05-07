package wata.es.Orderus.Battle;

import wata.es.Orderus.Characters.FantasyCharacter;

public class Battle {
	private FantasyCharacter character1, character2;
	private int rounds = 20;

	public Battle(FantasyCharacter c1, FantasyCharacter c2) {
		this.character1 = c1;
		this.character2 = c2;

	}

	public int fight() {
		System.out.println(character1.toString());
		System.out.println(character2.toString());
		assignPositionsToFight();
		int numOfStatesCombat = 2;
		int countNumberOfStatesfromFight = 0; // 2 States by round
		do {
			printRoundsAndOrdersForAttack(countNumberOfStatesfromFight);
			whoIsfighter().attack(whoIsDefender());
			printLifePointsfromCharacters();
			changeCombatStatus();
			countNumberOfStatesfromFight++;
		} while (character1.getHealth() > 0 && character2.getHealth() > 0
				&& countNumberOfStatesfromFight <= rounds * numOfStatesCombat);
		return printTheWinner();
	}
	private void assignPositionsToFight() {
		if (character1 == whoAttackFirst()) {
			character1.attackTurn();
			character2.defendTurn();
		} else {
			character2.attackTurn();
			character1.defendTurn();
		}
	}

	private void printRoundsAndOrdersForAttack(int count) {
		printRound(count);
		printNameWhoIsAttack();
	}

	private void printRound(int count) {
		if (count % 2 == 0) {
			System.out.println("-----------ROUND: " + ((count / 2) + 1) + "----------");
		}
	}

	private void printNameWhoIsAttack() {
		if (character1.isAttack() && !character2.isAttack()) {
			System.out.print(character1.getName() + " is Attacking");
		} else {
			System.out.print(character2.getName() + " is Attacking");
		}
	}

	private void printLifePointsfromCharacters() {
		System.out.println("->" + character1.getName() + ": " + character1.getHealth() + " LifesPoints");
		System.out.println("->" + character2.getName() + ": " + character2.getHealth() + " LifesPoints");
	}

	private int printTheWinner() {
		int winner = 0;
		System.out.println("------------------------------------------------------");
		if (character1.getHealth() > 0 && character2.getHealth() > 0) {
			System.out.println("	Draw between " + character1.getName() + " and " + character2.getName());
		} else if (character1.getHealth() == 0) {
			System.out.println("	" + character2.getName().toUpperCase() + " is the Winner");
			winner = 2;
		} else {
			System.out.println("	" + character1.getName().toUpperCase() + " is the Winner");
			winner = 1;
		}
		return winner;
	}

	private FantasyCharacter whoAttackFirst() {
		if (isMoreSpeedCharacter1ThanCharacter2()) {
			return character1;
		} else if (isSameSpeedCharacter1AndCharacter2() && isMoreLuckCharacter1ThanCharacter2()) {
			return character1;
		}
		return character2;
	}

	private boolean isMoreSpeedCharacter1ThanCharacter2() {
		return character1.getSpeed() > character2.getSpeed();
	}

	private boolean isMoreLuckCharacter1ThanCharacter2() {
		return character1.getLuck() > character2.getLuck();
	}

	private boolean isSameSpeedCharacter1AndCharacter2() {
		return character1.getSpeed() == character2.getSpeed();
	}

	private FantasyCharacter whoIsfighter() {
		if (character1.isAttack()) {
			return character1;
		}
		return character2;
	}

	private FantasyCharacter whoIsDefender() {
		if (!character1.isAttack()) {
			return character1;
		}
		return character2;
	}

	private void changeCombatStatus() {
		if (character1.isAttack()) {
			character1.defendTurn();
			character2.attackTurn();
		} else {
			character2.defendTurn();
			character1.attackTurn();
		}
	}
}
