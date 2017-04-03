package rope;

import java.util.Random;

public abstract class Monster {
	private String name;
	private int atk;
	private int def;
	private int hp;

	public Monster(String name, int atk, int def, int hp) {
		this.name = name;
		this.atk = atk;
		this.def = def;
		this.hp = hp;
	}

	public String getName() {
		return this.name;
	}

	public int getAtk() {
		return this.atk;
	}

	public int getDef() {
		return this.def;
	}

	public int getHP() {
		return this.hp;
	}

	public void setHP(int newHP) {
		this.hp = newHP;
	}

	public abstract int attack(int dodge, int defense);
}

class GiantBat extends Monster {

	public GiantBat() {
		super("Giant Bat", 4, 3, 20);
	}

	/**
	 * Vihollisen hyökkäys
	 */
	public int attack(int dodge, int defense) {
		Random die = new Random();
		int d6 = die.nextInt(6) + 1;
		int evade = dodge / 2 + 1;
		int dodgeResult = evade - d6;
		if (dodgeResult >= 1) {
			System.out.println("Dodge roll: " + evade + " - " + d6 + " = " + dodgeResult + " *DODGE SUCCESS*");
			System.out.println("****");
			return 0;
		} else {
			int damage = this.getAtk();
			int dx = die.nextInt(defense / 2 + 1) + 1;
			int dmgResult = damage - dx;
			System.out.println("Dodge roll: " + evade + " - " + d6 + " = " + dodgeResult + " *DODGE FAILED*");
			System.out.println("Defense roll: " + damage + " - " + dx + " = " + dmgResult);
			System.out.println("****");
			if (dmgResult >= 1) {
				return dmgResult;
			} else {
				return 99;
			}
		}
	}
}

class RottingWarrior extends Monster {

	public RottingWarrior() {
		super("Rotting Warrior", 5, 4, 24);
	}

	/**
	 * Vihollisen hyökkäys
	 */
	public int attack(int dodge, int defense) {
		Random die = new Random();
		int d6 = die.nextInt(6) + 1;
		int evade = dodge / 2 + 1;
		int dodgeResult = evade - d6;
		if (dodgeResult >= 1) {
			System.out.println("Dodge roll: " + evade + " - " + d6 + " = " + dodgeResult + " *DODGE SUCCESS*");
			System.out.println("****");
			return 0;
		} else {
			int damage = this.getAtk();
			int dx = die.nextInt(defense / 2 + 1) + 1;
			int dmgResult = damage - dx;
			System.out.println("Dodge roll: " + evade + " - " + d6 + " = " + dodgeResult + " *DODGE FAILED*");
			System.out.println("Defense roll: " + damage + " - " + dx + " = " + dmgResult);
			System.out.println("****");
			if (dmgResult >= 1) {
				return dmgResult;
			} else {
				return 99;
			}
		}
	}
}

class OgreBasher extends Monster {

	public OgreBasher() {
		super("Ogre Basher", 6, 6, 28);
	}

	/**
	 * Vihollisen hyökkäys
	 */
	public int attack(int dodge, int defense) {
		Random die = new Random();
		int d6 = die.nextInt(6) + 1;
		int evade = dodge / 2 + 1;
		int dodgeResult = evade - d6;
		if (dodgeResult >= 1) {
			System.out.println("Dodge roll: " + evade + " - " + d6 + " = " + dodgeResult + " *DODGE SUCCESS*");
			System.out.println("****");
			return 0;
		} else {
			int damage = this.getAtk();
			int dx = die.nextInt(defense / 2 + 1) + 1;
			int dmgResult = damage - dx;
			System.out.println("Dodge roll: " + evade + " - " + d6 + " = " + dodgeResult + " *DODGE FAILED*");
			System.out.println("Defense roll: " + damage + " - " + dx + " = " + dmgResult);
			System.out.println("****");
			if (dmgResult >= 1) {
				return dmgResult;
			} else {
				return 99;
			}
		}
	}
}