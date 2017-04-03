package rope;

import java.util.Random;

public class Char {
	private String Name;
	// Vaikuttaa siihen paljonko pelaajalla on energiaa
	private int Vitality;
	// Vaikuttaa siihen paljonko pelaaja tekee vahinkoa ja paljonko vihollisen
	// vahingosta leikataan pois
	private int Strength;
	// Vaikuttaa siihen paljonko pelaajalla on taikapisteitä
	private int Wisdom;
	// Vaikuttaa siihen miten usein pelaaja osuu hyökkäyksillä ja siihen miten
	// usein niitä väistetään
	private int Dexterity;

	private int HP;
	private int MP;
	private final int MaxHP;
	private final int MaxMP;
	// Kullalla ei ole käyttöä tässä pelissä. Se on vain luotu kokeilumielessä.
	private int Gold;

	public Char(String Name, int Vitality, int Strength, int Wisdom, int Dexterity, int HP, int MP, final int MaxHP,
			final int MaxMP, int Gold) {
		this.Name = Name;
		this.Vitality = Vitality;
		this.Strength = Strength;
		this.Wisdom = Wisdom;
		this.Dexterity = Dexterity;
		this.HP = HP;
		this.MP = MP;
		this.MaxHP = HP;
		this.MaxMP = MP;
		this.Gold = Gold;
	}

	// Setterit
	public void setName(String newName) {
		Name = newName;

	}

	public void setVitality(int newVitality) {
		Vitality = newVitality;

	}

	public void setStrength(int newStrength) {
		Strength = newStrength;

	}

	public void setWisdom(int newWisdom) {
		Wisdom = newWisdom;

	}

	public void setDexterity(int newDexterity) {
		Dexterity = newDexterity;
	}

	public void setHP(int newHP) {
		HP = newHP;
	}

	public void setMP(int newMP) {
		MP = newMP;
	}

	public void setGold(int newGold) {
		Gold = newGold;
	}

	// Getterit
	public String getName() {
		return Name;
	}

	public int getVitality() {
		return Vitality;
	}

	public int getStrength() {
		return Strength;
	}

	public int getWisdom() {
		return Wisdom;
	}

	public int getDexterity() {
		return Dexterity;
	}

	public int getHP() {
		return HP;
	}

	public int getMP() {
		return MP;
	}

	public int getMaxHP() {
		return MaxHP;
	}

	public int getMaxMP() {
		return MaxMP;
	}

	public int getGold() {
		return Gold;
	}

	/**
	 * Pelaajan perushyökkäys
	 * 
	 * @param defense Vihollisen panssari
	 * @return Vahingon määrä
	 */
	public int attack(int defense) {

		Random die = new Random();
		int d6 = die.nextInt(6) + 1;
		int accuracy = Dexterity / 2 + 1;
		int hitResult = accuracy - d6;
		if (hitResult <= 0) {
			System.out.println("Accuracy roll: " + accuracy + " - " + d6 + " = " + hitResult + " *MISS*");
			System.out.println("****");
			return 0;
		} else {
			int damage = Strength / 2 + 1;
			int dx = die.nextInt(defense) + 1;
			int dmgResult = damage - dx;
			System.out.println("Accuracy roll: " + accuracy + " - " + d6 + " = " + hitResult + " *HIT*");
			System.out.println("Attack roll: " + damage + " - " + dx + " = " + dmgResult);
			System.out.println("****");
			if (dmgResult >= 1) {
				return dmgResult;
			} else {
				return 99;
			}
		}
	}

	/**
	 * Tulipallotaika
	 * 
	 * @return Vahingon määrä
	 */
	public int fireball() {

		Random die = new Random();
		int d6 = die.nextInt(6) + 1;
		int accuracy = Wisdom / 2 + 1;
		int hitResult = accuracy - d6;
		if (hitResult <= 0) {
			System.out.println("Spell Accuracy roll: " + accuracy + " - " + d6 + " = " + hitResult + " *MISS*");
			System.out.println("****");
			return 0;
		} else {
			die = new Random();
			int d6Spell = die.nextInt(6) + 1;
			int damage = Wisdom + 1;
			int dmgResult = damage - d6;
			System.out.println("Spell Accuracy roll: " + accuracy + " - " + d6 + " = " + hitResult + " *HIT*");
			System.out.println("Spell roll: " + damage + " - " + d6Spell + " = " + dmgResult);
			System.out.println("****");
			if (dmgResult >= 1) {
				return dmgResult;
			} else {
				return 99;
			}
		}
	}

	/**
	 * Parannustaika
	 * 
	 * @return Parannettu määrä
	 */
	public int heal() {

		Random die = new Random();
		int d6 = die.nextInt(6) + 1;
		int heal = Wisdom + 1 + 2;
		int healResult = heal - d6;
		if (healResult <= 0) {
			healResult = 1;
			return healResult;
		} else {
			return healResult;
		}
	}
}
