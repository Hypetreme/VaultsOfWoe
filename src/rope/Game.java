package rope;

import java.awt.EventQueue;

import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JEditorPane;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Random;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.Timer;
import javax.swing.UIManager;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

/**
 * Vuoropohjainen taistelupeli jossa taistellaan eri vihollisia vastaan. Peli
 * arpoo t‰ll‰ hetkell‰ kolmesta eri vihollisesta yhden. Peli loppuu kun
 * vihollinen tai pelaaja kuolee. Peli‰ voisi kehitt‰‰ jatkossa eteenp‰in monin
 * eri tavoin esim. tekem‰ll‰ tarinaa ja grafiikkaa.
 * 
 * Pelin t‰m‰n hetkinen grafiikka on lˆydetty sivuilta jotka jakavat kuvia
 * vapaaseen k‰yttˆˆn. Kuvia on myˆs muokattu hiukan sopiviksi. ƒ‰niefektit ovat
 * myˆs sivuilta jotka jakavat ‰‰ni‰ vapaaseen k‰yttˆˆn. Pelin taustamusiikki ja
 * logo on itse tehty.
 * 
 * 
 * @author Janne Karppinen
 * @version 1.0
 */

public class Game {

	Monster monster;
	static Char hero;
	JLabel[] inventory = new JLabel[6];
	private Random rand = new Random();
	final JFXPanel fxPanel = new JFXPanel();
	private static UI ui;
	static boolean death = false;

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					createUI();
					updateStats();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		hero = new Char(null, 0, 0, 0, 0, 0, 0, 0, 0, 200);
		hero = new Game().statRoll();
		playMidi("main_theme.mid");
	}

	/**
	 * Kehyksen ja p‰‰ikkunan luonti
	 */
	private static void createUI() {
		ui = new UI();
		ui.createFrame();
		ui.createMenu();
	}

	/**
	 * Kykypisteiden jatkuva p‰ivitys joka toimii toisessa s‰ikeess‰
	 */
	private static void updateStats() {
		Thread thread = new Thread();
		thread = new Thread() {
			public void run() {
				while (death == false) {

					try {

						ui.vitalityValue.setText(Integer.toString(hero.getVitality()));
						ui.strengthValue.setText(Integer.toString(hero.getStrength()));
						ui.wisdomValue.setText(Integer.toString(hero.getWisdom()));
						ui.dexterityValue.setText(Integer.toString(hero.getDexterity()));

						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread.start();
	}

	/**
	 * Soittaa pelin taustamusiikin
	 * 
	 * @param filename ƒ‰nitiedoston
	 *            nimi
	 */
	public static void playMidi(String filename) {
		try {

			Sequence sequence = MidiSystem.getSequence(new File(filename));
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.setSequence(sequence);
			sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
			sequencer.start();

		} catch (MalformedURLException e) {
		} catch (IOException e) {
		} catch (MidiUnavailableException e) {
		} catch (InvalidMidiDataException e) {
		}
	}

	/**
	 * Soittaa pelin ‰‰nitehosteet
	 * 
	 * @param filename ƒ‰nitiedoston
	 *            nimi
	 */
	public void playAudio(String filename) {
		File file = new File(filename);
		Media Sounds = new Media(file.toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(Sounds);
		mediaPlayer.play();
	}

	/**
	 * Hahmon kykypisteiden arvonta
	 * 
	 * @return Uusi hahmo arvotuilla kykypisteill‰
	 */
	public Char statRoll() {

		int rollVitality = rand.nextInt(10) + 1;

		int rollStrength = rand.nextInt(10) + 1;

		int rollWisdom = rand.nextInt(10) + 1;

		int rollDexterity = rand.nextInt(10) + 1;

		Char player = new Char("Unknown", rollVitality, rollStrength, rollWisdom, rollDexterity, rollVitality * 2 + 2,
				rollWisdom + 10, rollVitality * 2 + 2, rollWisdom + 10, 500);

		System.out.println(" ");
		System.out.println("Vitality has been set to " + player.getVitality());
		System.out.println("Strength has been set to " + player.getStrength());
		System.out.println("Wisdom has been set to " + player.getWisdom());
		System.out.println("Dexterity has been set to " + player.getDexterity());
		System.out.println("Health has been set to " + player.getHP());
		System.out.println("Magic has been set to " + player.getMP());
		return player;
	}

	/**
	 * Vihollisen hyˆkk‰ys
	 */
	public void monsterAttack(Monster enemy, Char hero, JEditorPane box, JButton attackbutton, JButton spellbutton,
			JTextPane health, final int maximumHealth, JProgressBar HPBar) {

		if (enemy.getHP() >= 1 && hero.getHP() >= 1) {
			int enemyAttack = enemy.attack(hero.getDexterity(), hero.getStrength());
			String enemyDamage = Integer.toString(enemyAttack);
			Timer enemyAction = new Timer(2200, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					attackbutton.setEnabled(true);
					spellbutton.setEnabled(true);
					if (enemyAttack <= 0 && enemy.getHP() >= 1 && hero.getHP() >= 1) {
						box.setText(box.getText() + "\n" + enemy.getName() + " misses!");
						playAudio("miss.wav");
					} else if (enemyAttack == 99 && enemy.getHP() >= 1 && hero.getHP() >= 1) {
						box.setText(box.getText() + "\n" + enemy.getName() + "'s " + "hit is absorbed by "
								+ hero.getName() + "'s" + " armor.");
						playAudio("block.mp3");

					} else if (enemy.getHP() >= 1) {
						box.setText(box.getText() + "\n" + enemy.getName() + " hits " + hero.getName() + " for "
								+ enemyDamage + " damage.");

						hero.setHP(hero.getHP() - enemyAttack);
						String SubstractHP = Integer.toString(hero.getHP());
						health.setText(SubstractHP);
						System.out.println("Health left: " + hero.getHP());
						HPBar.setValue(hero.getHP() * 100 / maximumHealth);
						if (hero.getHP() >= 1) {
							playAudio("pain.mp3");
						}
					}
					if (enemy.getHP() <= 0) {
						box.setText(box.getText() + "\n" + enemy.getName() + " is DEAD!");
						attackbutton.setEnabled(false);
						spellbutton.setEnabled(false);
						playAudio("down.mp3");

					}
					if (hero.getHP() <= 0) {
						box.setText(box.getText() + "\n" + hero.getName() + " was slain by " + enemy.getName() + "!");
						attackbutton.setEnabled(false);
						spellbutton.setEnabled(false);
						playAudio("death.wav");
						death = true;
					}

				}

			});
			enemyAction.restart();
			enemyAction.setRepeats(false);
		}
	}

	/**
	 * Normaali hyˆkk‰ys
	 */
	public void normalAttack(Monster enemy, Char hero, JEditorPane box, JButton attackbutton, JButton spellbutton) {

		if (enemy.getHP() >= 1 && hero.getHP() >= 1) {
			int heroAttack = hero.attack(enemy.getDef());
			String heroDamage = Integer.toString(heroAttack);

			Timer heroAction = new Timer(1100, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					if (heroAttack <= 0) {
						box.setText(box.getText() + "\n" + hero.getName() + " misses!");
						playAudio("miss.wav");

					} else if (heroAttack == 99) {
						box.setText(
								box.getText() + "\n" + hero.getName() + " hits " + enemy.getName() + " for no damage!");
						playAudio("block.mp3");

					} else {
						box.setText(box.getText() + "\n" + hero.getName() + " hits " + enemy.getName() + " for "
								+ heroDamage + " damage.");
						enemy.setHP(enemy.getHP() - heroAttack);
						playAudio("hit.mp3");

						System.out.println(enemy.getName() + "'s HP: " + enemy.getHP());
					}
				}

			});
			heroAction.restart();
			heroAction.setRepeats(false);

		}
	}

	/**
	 * Tulipallo hyˆkk‰ys
	 */
	public void fireballAttack(Monster enemy, Char hero, JEditorPane box, JButton attackbutton, JButton spellbutton,
			JTextPane mana, final int maximumMana, JProgressBar MPBar) {

		if (enemy.getHP() >= 1 && hero.getHP() >= 1) {
			hero.setMP(hero.getMP() - 3);
			String SubstractMP = Integer.toString(hero.getMP());
			mana.setText(SubstractMP);
			System.out.println("Mana left: " + hero.getMP() * 100 / maximumMana + " %");
			MPBar.setValue(hero.getMP() * 100 / maximumMana);

			int heroAttack = hero.fireball();
			String heroDamage = Integer.toString(heroAttack);

			Timer heroAction = new Timer(1100, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					// Pelaajan toiminnot
					if (heroAttack <= 0) {
						box.setText(box.getText() + "\n" + hero.getName() + "'s Fireball misses!");
						playAudio("spellmiss.mp3");

					} else if (heroAttack == 99) {
						box.setText(box.getText() + "\n" + hero.getName() + "'s Fireball hits " + enemy.getName()
								+ " for no damage!");
						playAudio("block.mp3");

					} else {
						box.setText(box.getText() + "\n" + hero.getName() + "'s Fireball hits " + enemy.getName()
								+ " for " + heroDamage + " damage.");
						enemy.setHP(enemy.getHP() - heroAttack);
						playAudio("spellhit.mp3");

						System.out.println(enemy.getName() + "'s HP: " + enemy.getHP());
					}
				}

			});
			heroAction.restart();
			heroAction.setRepeats(false);

		}
	}

	/**
	 * Parannustaika
	 */
	public void heal(Monster enemy, Char hero, JEditorPane box, JButton attackbutton, JButton spellbutton,
			JTextPane health, JTextPane mana, final int maximumHealth, final int maximumMana, JProgressBar HPBar,
			JProgressBar MPBar) {

		if (enemy.getHP() >= 1 && hero.getHP() >= 1) {
			hero.setMP(hero.getMP() - 5);
			String SubstractMP = Integer.toString(hero.getMP());
			mana.setText(SubstractMP);
			System.out.println("Mana left: " + hero.getMP() * 100 / maximumMana + " %");
			MPBar.setValue(hero.getMP() * 100 / maximumMana);

			int heroHeal = hero.heal();
			String heroHealAmount = Integer.toString(heroHeal);

			Timer heroAction = new Timer(1100, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					box.setText(box.getText() + "\n" + hero.getName() + " heals for " + heroHealAmount + " health.");
					playAudio("heal.mp3");
					if (hero.getHP() + heroHeal > hero.getMaxHP()) {
						hero.setHP(hero.getMaxHP());
					} else {
						hero.setHP(hero.getHP() + heroHeal);
					}
					String addHP = Integer.toString(hero.getHP());
					health.setText(addHP);
					System.out.println(
							hero.getName() + "'s health percentage: " + hero.getHP() * 100 / maximumHealth + " %");
					HPBar.setValue(hero.getHP() * 100 / maximumHealth);
				}

			});
			heroAction.restart();
			heroAction.setRepeats(false);

		}
	}

	/**
	 * 
	 * Vihollisen arvonta
	 * 
	 * @return Palauttaa arvotun vihollisen
	 */
	public Monster spawnMonster() {
		Random enemyChooser = new Random();
		int nextMonster = enemyChooser.nextInt(3);
		Monster newMonster;
		if (nextMonster == 0) {
			newMonster = new GiantBat();
		} else if (nextMonster == 1) {
			newMonster = new RottingWarrior();
		} else {
			newMonster = new OgreBasher();
		}
		return newMonster;
	}

	/**
	 * Tavaran asettaminen inventory-ruutuun
	 * 
	 * @param inv Inventory
	 * @param itemName Tavaran
	 *            nimi
	 * @param imgName Kuvakkeen
	 *            nimi
	 * @param amount M‰‰r‰
	 */
	public void setItem(JLabel[] inv, String itemName, String imgName, int amount) {

		if (!itemName.equals("Gold")) {
			for (int i = 0; i < inv.length; i++) {
				if (inv[i].getName() == null) {
					inv[i].setIcon(new ImageIcon(imgName));
					inv[i].setName(itemName);
					System.out.println("Slot " + (i + 1) + " now has " + itemName);
					break;
				}
			}
		} else
			for (int i = 0; i < inv.length; i++) {
				if (inv[i].getName() == null || inv[i].getName().equals("Gold")) {
					inv[i].setIcon(new ImageIcon(imgName));
					inv[i].setName(itemName);
					String newAmount = Integer.toString(hero.getGold() + amount);
					inv[i].setText(newAmount);
					hero.setGold(hero.getGold() + amount);
					System.out.println("Slot " + (i + 1) + " now has " + hero.getGold() + " " + itemName);
					break;
				}
			}

	}

	/**
	 * Tavaran k‰ytt‰m‰minen invetorysta
	 * 
	 */
	public void useItem(JLabel[] inv, int invSlot, Char hero, JEditorPane box, JTextPane health, JTextPane mana,
			final int maximumHealth, final int maximumMana, JProgressBar HPBar, JProgressBar MPBar,
			JButton attackbutton) {

		if (attackbutton.isEnabled()) {
			if (inv[invSlot].getName() == "Health Potion") {
				System.out.println("Used Health Potion");

				box.setText(box.getText() + "\n" + hero.getName() + " heals for " + "10" + " health.");
				playAudio("heal.mp3");
				if (hero.getHP() + 10 > hero.getMaxHP()) {
					hero.setHP(hero.getMaxHP());
				} else {
					hero.setHP(hero.getHP() + 10);
				}
				String addHP = Integer.toString(hero.getHP());
				health.setText(addHP);
				System.out
						.println(hero.getName() + "'s health percentage: " + hero.getHP() * 100 / maximumHealth + " %");
				HPBar.setValue(hero.getHP() * 100 / maximumHealth);
			}

			if (inv[invSlot].getName() == "Mana Potion") {
				System.out.println("Used Mana Potion");

				box.setText(box.getText() + "\n" + hero.getName() + " heals for " + "10" + " mana.");
				playAudio("heal.mp3");
				if (hero.getMP() + 10 > hero.getMaxMP()) {
					hero.setMP(hero.getMaxMP());
				} else {
					hero.setMP(hero.getMP() + 10);
				}
				String addMP = Integer.toString(hero.getMP());
				mana.setText(addMP);
				System.out.println(hero.getName() + "'s health percentage: " + hero.getMP() * 100 / maximumMana + " %");
				MPBar.setValue(hero.getMP() * 100 / maximumMana);
			}

			inv[invSlot].setName(null);
			inv[invSlot].setIcon(null);
		}
	}

	/**
	 * Inventoryn j‰rjestyksen p‰ivitys
	 * 
	 */
	public void sortInventory(JLabel[] inv, int i) {

		for (int j = 0; j < inv.length; j++) {

			if (i == inv.length) {
				i = inv.length - 1;
			}
			if (j < inv.length && inv[i].getName() == null) {

				if (i + 1 < inv.length) {
					inv[i].setName(inv[i + 1].getName());
					inv[i].setText(inv[i + 1].getText());
					inv[i].setIcon(inv[i + 1].getIcon());
					inv[i + 1].setName(null);
					inv[i + 1].setText(null);
					inv[i + 1].setIcon(null);
				}
			}
			i++;
		}
	}
}