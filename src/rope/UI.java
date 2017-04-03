package rope;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.Point;
import java.awt.ComponentOrientation;

public class UI extends JFrame {

	private static final long serialVersionUID = 1L;
	private Game game = new Game();
	private JFrame mainWindow;
	private JPanel mainPanel;
	private JPanel startPanel;
	private JLabel logo;
	private JTextPane nameText;
	private JTextField nameValue;
	private JTextPane textVitality;
	public JTextPane vitalityValue;
	private JTextPane textStrength;
	public JTextPane strengthValue;
	private JTextPane textWisdom;
	public JTextPane wisdomValue;
	private JTextPane textDexterity;
	public JTextPane dexterityValue;
	private JPanel battlePanel;
	private JPanel inventoryPanel;
	private JLabel slot1;
	private JLabel slot2;
	private JLabel slot3;
	private JLabel slot4;
	private JLabel slot5;
	private JLabel slot6;
	private JTextPane textVIT;
	public JTextPane VIT;
	private JTextPane textSTR;
	public JTextPane STR;
	private JTextPane textWIS;
	public JTextPane WIS;
	private JTextPane textDEX;
	public JTextPane DEX;
	private JTextPane textHP;
	private JTextPane HP;
	private JTextPane textMP;
	private JTextPane MP;
	private JScrollPane scrollPane;
	private JEditorPane info;
	private JProgressBar healthBar;
	private JProgressBar magicBar;
	private JButton rollBtn;
	private JButton spellsBtn;
	private JButton attackBtn;
	private JButton addHPBtn;
	private JButton addMPBtn;
	private JButton addGoldBtn;
	private JLabel lblFireball;
	private JLabel lblHeal;
	private JLabel menuBG;
	private JLabel combatBG;
	private JButton startBtn;

	/**
	 * Ikkunan kehys
	 */
	public void createFrame() {

		mainWindow = new JFrame();
		mainWindow.setSize(848, 480);
		mainWindow.setMinimumSize(new Dimension(848, 480));
		mainWindow.setMaximumSize(new Dimension(848, 480));
		mainWindow.setResizable(false);
		mainWindow.setTitle("Vaults of Woe");
		mainWindow.setBounds(500, 250, 848, 480);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.getContentPane().setLayout(null);

		mainWindow.setVisible(true);
	}

	/**
	 * Päänäkymä
	 */
	public void createMenu() {

		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 842, 452);
		mainPanel.setBackground(new Color(50, 205, 50));
		mainPanel.setLayout(new CardLayout(0, 0));
		mainWindow.getContentPane().add(mainPanel);

		startPanel = new JPanel();
		mainPanel.add(startPanel);
		startPanel.setBackground(SystemColor.controlHighlight);
		startPanel.setLayout(null);

		nameText = new JTextPane();
		nameText.setForeground(Color.WHITE);
		nameText.setOpaque(false);
		nameText.setBounds(452, 11, 141, 33);
		startPanel.add(nameText);
		nameText.setText("Name thyself:");
		nameText.setFont(new Font("Poor Richard", Font.BOLD, 20));
		nameText.setEditable(false);
		nameText.setBackground(SystemColor.controlHighlight);

		nameValue = new JTextField();
		nameValue.setBounds(589, 11, 229, 33);
		startPanel.add(nameValue);
		nameValue.setText("Unknown");
		nameValue.setHorizontalAlignment(SwingConstants.CENTER);
		nameValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameValue.setColumns(10);

		textVitality = new JTextPane();
		textVitality.setForeground(Color.WHITE);
		textVitality.setOpaque(false);
		textVitality.setBounds(579, 114, 105, 33);
		startPanel.add(textVitality);
		textVitality.setToolTipText("Value that determines your health.");
		textVitality.setText("Vitality:");
		textVitality.setFont(new Font("Poor Richard", Font.BOLD, 20));
		textVitality.setEditable(false);
		textVitality.setBackground(SystemColor.controlHighlight);

		vitalityValue = new JTextPane();
		vitalityValue.setForeground(Color.WHITE);
		vitalityValue.setOpaque(false);
		vitalityValue.setBounds(694, 114, 38, 33);
		startPanel.add(vitalityValue);
		vitalityValue.setToolTipText("Determines how much life you will have.");
		vitalityValue.setText(Integer.toString(Game.hero.getVitality()));
		vitalityValue.setFont(new Font("Source Code Pro", Font.BOLD, 18));
		vitalityValue.setEditable(false);
		vitalityValue.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		vitalityValue.setBackground(SystemColor.menu);

		textStrength = new JTextPane();
		textStrength.setForeground(Color.WHITE);
		textStrength.setOpaque(false);
		textStrength.setBounds(579, 158, 105, 33);
		startPanel.add(textStrength);
		textStrength.setText("Strength:");
		textStrength.setFont(new Font("Poor Richard", Font.BOLD, 20));
		textStrength.setEditable(false);
		textStrength.setBackground(SystemColor.controlHighlight);

		strengthValue = new JTextPane();
		strengthValue.setForeground(Color.WHITE);
		strengthValue.setToolTipText("Determines your attack power and how much armor you will have.");
		strengthValue.setOpaque(false);
		strengthValue.setBounds(694, 158, 38, 33);
		startPanel.add(strengthValue);
		strengthValue.setText(Integer.toString(Game.hero.getStrength()));
		strengthValue.setFont(new Font("Source Code Pro", Font.BOLD, 18));
		strengthValue.setEditable(false);
		strengthValue.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		strengthValue.setBackground(SystemColor.menu);

		textWisdom = new JTextPane();
		textWisdom.setForeground(Color.WHITE);
		textWisdom.setOpaque(false);
		textWisdom.setBounds(579, 202, 95, 33);
		startPanel.add(textWisdom);
		textWisdom.setText("Wisdom:");
		textWisdom.setFont(new Font("Poor Richard", Font.BOLD, 20));
		textWisdom.setEditable(false);
		textWisdom.setBackground(SystemColor.controlHighlight);

		wisdomValue = new JTextPane();
		wisdomValue.setForeground(Color.WHITE);
		wisdomValue.setToolTipText("Determines how many magic points you will have and power of your spells.");
		wisdomValue.setOpaque(false);
		wisdomValue.setBounds(694, 202, 38, 33);
		startPanel.add(wisdomValue);
		wisdomValue.setText(Integer.toString(Game.hero.getWisdom()));
		wisdomValue.setFont(new Font("Source Code Pro", Font.BOLD, 18));
		wisdomValue.setEditable(false);
		wisdomValue.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		wisdomValue.setBackground(SystemColor.menu);

		textDexterity = new JTextPane();
		textDexterity.setForeground(Color.WHITE);
		textDexterity.setOpaque(false);
		textDexterity.setBounds(569, 246, 105, 33);
		startPanel.add(textDexterity);
		textDexterity.setText("Dexterity:");
		textDexterity.setFont(new Font("Poor Richard", Font.BOLD, 20));
		textDexterity.setEditable(false);
		textDexterity.setBackground(SystemColor.controlHighlight);

		dexterityValue = new JTextPane();
		dexterityValue.setForeground(Color.WHITE);
		dexterityValue.setToolTipText("Determines how well your attacks hit and your ability to dodge attacks.");
		dexterityValue.setOpaque(false);
		dexterityValue.setBounds(694, 246, 38, 33);
		startPanel.add(dexterityValue);
		dexterityValue.setText(Integer.toString(Game.hero.getDexterity()));
		dexterityValue.setFont(new Font("Source Code Pro", Font.BOLD, 18));
		dexterityValue.setEditable(false);
		dexterityValue.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		dexterityValue.setBackground(SystemColor.menu);

		logo = new JLabel();
		logo.setForeground(Color.BLACK);
		logo.setBounds(40, 20, 345, 295);
		logo.setIcon(new ImageIcon("vow.png"));
		logo.setMinimumSize(new Dimension(345, 295));
		logo.setPreferredSize(new Dimension(345, 295));
		logo.setMaximumSize(new Dimension(345, 295));
		startPanel.add(logo);

		rollBtn = new JButton("Roll");
		rollBtn.setIcon(new ImageIcon("btn.jpg"));
		rollBtn.setHorizontalTextPosition(SwingConstants.CENTER);

		rollBtn.setForeground(Color.WHITE);
		rollBtn.setFont(new Font("Poor Richard", Font.BOLD, 18));
		rollBtn.setBackground(new Color(184, 134, 11));
		rollBtn.setBounds(659, 301, 112, 58);
		startPanel.add(rollBtn);

		rollBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.playAudio("roll.mp3");

				Game.hero = game.statRoll();
				System.out.println(Game.hero.getHP());
			}
		});

		startBtn = new JButton("Start");
		startBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		startBtn.setIcon(new ImageIcon("btn.jpg"));
		startBtn.setForeground(Color.WHITE);
		startBtn.setFont(new Font("Poor Richard", Font.BOLD, 18));
		startBtn.setBackground(new Color(184, 134, 11));
		startBtn.setBounds(659, 370, 112, 58);
		startPanel.add(startBtn);

		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.monster = game.spawnMonster();
				if (!nameValue.getText().isEmpty()) {
					Game.hero.setName(nameValue.getText());
					createBattleUI();

				} else {
					System.out.println(" ");
					System.out.println("No name given!");
					JOptionPane.showMessageDialog(null, "Name thyself!");

				}
			}
		});

		menuBG = new JLabel("Background");
		menuBG.setIcon(new ImageIcon("wall.jpg"));
		menuBG.setHorizontalAlignment(SwingConstants.CENTER);
		menuBG.setDisplayedMnemonic(KeyEvent.VK_ENTER);
		menuBG.setBounds(0, 0, 842, 452);
		startPanel.add(menuBG);
	}

	/**
	 * Taistelunäkymä
	 */
	public void createBattleUI() {

		System.out.println(" ");
		System.out.println("Name has been set to " + Game.hero.getName());

		battlePanel = new JPanel();
		battlePanel.setBackground(SystemColor.controlHighlight);
		mainPanel.add(battlePanel);
		battlePanel.setLayout(null);
		battlePanel.setVisible(true);
		mainWindow.setContentPane(battlePanel);

		inventoryPanel = new JPanel();
		inventoryPanel.setBackground(Color.LIGHT_GRAY);
		inventoryPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		inventoryPanel.setBounds(13, 102, 154, 119);
		battlePanel.add(inventoryPanel);
		inventoryPanel.setLayout(new GridLayout(2, 5, 0, 0));

		slot1 = new JLabel();
		slot1.setForeground(Color.BLACK);
		slot1.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		slot1.setIcon(new ImageIcon("health_potion.jpg"));
		slot1.setName("Health Potion");
		slot1.setVerticalTextPosition(SwingConstants.TOP);
		slot1.setHorizontalAlignment(SwingConstants.CENTER);
		slot1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		slot1.setIconTextGap(-5);
		slot1.setMinimumSize(new Dimension(30, 30));
		slot1.setPreferredSize(new Dimension(30, 30));
		slot1.setMaximumSize(new Dimension(30, 30));
		slot1.setHorizontalTextPosition(SwingConstants.CENTER);
		inventoryPanel.add(slot1);

		slot1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				game.useItem(game.inventory, 0, Game.hero, info, HP, MP, Game.hero.getMaxHP(), Game.hero.getMaxMP(),
						healthBar, magicBar, attackBtn);
				game.sortInventory(game.inventory, 0);
				;
			}
		});

		slot2 = new JLabel();
		slot2.setForeground(Color.BLACK);
		slot2.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		slot2.setVerticalTextPosition(SwingConstants.TOP);
		slot2.setIcon(new ImageIcon("mana_potion.jpg"));
		slot2.setName("Mana Potion");
		slot2.setHorizontalTextPosition(SwingConstants.CENTER);
		slot2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		slot2.setIconTextGap(-5);
		slot2.setMinimumSize(new Dimension(30, 30));
		slot2.setPreferredSize(new Dimension(30, 30));
		slot2.setMaximumSize(new Dimension(30, 30));
		slot2.setHorizontalAlignment(SwingConstants.CENTER);
		slot2.setAlignmentX(Component.CENTER_ALIGNMENT);
		inventoryPanel.add(slot2);

		slot2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				game.useItem(game.inventory, 1, Game.hero, info, HP, MP, Game.hero.getMaxHP(), Game.hero.getMaxMP(),
						healthBar, magicBar, attackBtn);
				game.sortInventory(game.inventory, 1);
			}
		});

		slot3 = new JLabel();
		slot3.setText(Integer.toString(Game.hero.getGold()));
		slot3.setHorizontalTextPosition(SwingConstants.CENTER);
		slot3.setVerticalTextPosition(SwingConstants.TOP);
		slot3.setAlignmentX(Component.CENTER_ALIGNMENT);
		slot3.setIconTextGap(-5);
		slot3.setHorizontalAlignment(SwingConstants.CENTER);
		slot3.setIcon(new ImageIcon("gold.jpg"));
		slot3.setName("Gold");
		slot3.setForeground(Color.BLACK);
		slot3.setFont(new Font("Palatino Linotype", Font.BOLD, 12));

		slot3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		slot3.setMinimumSize(new Dimension(30, 30));
		slot3.setPreferredSize(new Dimension(30, 30));
		slot3.setMaximumSize(new Dimension(30, 30));
		inventoryPanel.add(slot3);

		slot3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				game.useItem(game.inventory, 2, Game.hero, info, HP, MP, Game.hero.getMaxHP(), Game.hero.getMaxMP(),
						healthBar, magicBar, attackBtn);
				game.sortInventory(game.inventory, 2);
			}
		});

		slot4 = new JLabel();
		slot4.setForeground(Color.BLACK);
		slot4.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		slot4.setVerticalTextPosition(SwingConstants.TOP);
		slot4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		slot4.setIconTextGap(-5);
		slot4.setHorizontalTextPosition(SwingConstants.CENTER);
		slot4.setMinimumSize(new Dimension(30, 30));
		slot4.setPreferredSize(new Dimension(30, 30));
		slot4.setMaximumSize(new Dimension(30, 30));
		slot4.setHorizontalAlignment(SwingConstants.CENTER);
		inventoryPanel.add(slot4);

		slot4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				game.useItem(game.inventory, 3, Game.hero, info, HP, MP, Game.hero.getMaxHP(), Game.hero.getMaxMP(),
						healthBar, magicBar, attackBtn);
				game.sortInventory(game.inventory, 3);
			}
		});

		slot5 = new JLabel();
		slot5.setForeground(Color.BLACK);
		slot5.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		slot5.setVerticalTextPosition(SwingConstants.TOP);
		slot5.setHorizontalTextPosition(SwingConstants.CENTER);
		slot5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		slot5.setIconTextGap(-5);
		slot5.setMinimumSize(new Dimension(30, 30));
		slot5.setPreferredSize(new Dimension(30, 30));
		slot5.setMaximumSize(new Dimension(30, 30));
		slot5.setHorizontalAlignment(SwingConstants.CENTER);
		inventoryPanel.add(slot5);

		slot5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				game.useItem(game.inventory, 4, Game.hero, info, HP, MP, Game.hero.getMaxHP(), Game.hero.getMaxMP(),
						healthBar, magicBar, attackBtn);
				game.sortInventory(game.inventory, 4);
			}
		});

		slot6 = new JLabel();
		slot6.setForeground(Color.BLACK);
		slot6.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		slot6.setVerticalTextPosition(SwingConstants.TOP);
		slot6.setHorizontalTextPosition(SwingConstants.CENTER);
		slot6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		slot6.setIconTextGap(-5);
		slot6.setMinimumSize(new Dimension(30, 30));
		slot6.setPreferredSize(new Dimension(30, 30));
		slot6.setMaximumSize(new Dimension(30, 30));
		slot6.setHorizontalAlignment(SwingConstants.CENTER);
		inventoryPanel.add(slot6);

		slot6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				game.useItem(game.inventory, 5, Game.hero, info, HP, MP, Game.hero.getMaxHP(), Game.hero.getMaxMP(),
						healthBar, magicBar, attackBtn);
				game.sortInventory(game.inventory, 5);
			}
		});
		game.inventory[0] = slot1;
		game.inventory[1] = slot2;
		game.inventory[2] = slot3;
		game.inventory[3] = slot4;
		game.inventory[4] = slot5;
		game.inventory[5] = slot6;

		textVIT = new JTextPane();
		textVIT.setForeground(Color.WHITE);
		textVIT.setToolTipText("Value that determines your health.");
		textVIT.setText("VIT");
		textVIT.setOpaque(false);
		textVIT.setFont(new Font("Source Code Pro", Font.BOLD, 16));
		textVIT.setEditable(false);
		textVIT.setBackground(SystemColor.controlHighlight);
		textVIT.setBounds(189, 11, 38, 27);
		battlePanel.add(textVIT);

		VIT = new JTextPane();
		VIT.setText(vitalityValue.getText());
		VIT.setForeground(Color.WHITE);
		VIT.setToolTipText("");
		VIT.setOpaque(false);
		VIT.setFont(new Font("Source Code Pro", Font.BOLD, 18));
		VIT.setEditable(false);
		VIT.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		VIT.setBackground(SystemColor.menu);
		VIT.setBounds(237, 11, 38, 33);
		battlePanel.add(VIT);

		textSTR = new JTextPane();
		textSTR.setForeground(Color.WHITE);
		textSTR.setToolTipText("Value that determines your health.");
		textSTR.setText("STR");
		textSTR.setOpaque(false);
		textSTR.setFont(new Font("Source Code Pro", Font.BOLD, 16));
		textSTR.setEditable(false);
		textSTR.setBackground(SystemColor.controlHighlight);
		textSTR.setBounds(285, 11, 38, 27);
		battlePanel.add(textSTR);

		STR = new JTextPane();
		STR.setText(strengthValue.getText());
		STR.setForeground(Color.WHITE);
		STR.setToolTipText("");
		STR.setOpaque(false);
		STR.setFont(new Font("Source Code Pro", Font.BOLD, 18));
		STR.setEditable(false);
		STR.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		STR.setBackground(SystemColor.menu);
		STR.setBounds(333, 11, 38, 33);
		battlePanel.add(STR);

		textWIS = new JTextPane();
		textWIS.setForeground(Color.WHITE);
		textWIS.setToolTipText("Value that determines your health.");
		textWIS.setText("WIS");
		textWIS.setOpaque(false);
		textWIS.setFont(new Font("Source Code Pro", Font.BOLD, 16));
		textWIS.setEditable(false);
		textWIS.setBackground(SystemColor.controlHighlight);
		textWIS.setBounds(381, 11, 38, 27);
		battlePanel.add(textWIS);

		WIS = new JTextPane();
		WIS.setText(wisdomValue.getText());
		WIS.setForeground(Color.WHITE);
		WIS.setToolTipText("");
		WIS.setOpaque(false);
		WIS.setFont(new Font("Source Code Pro", Font.BOLD, 18));
		WIS.setEditable(false);
		WIS.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		WIS.setBackground(SystemColor.menu);
		WIS.setBounds(429, 11, 38, 33);
		battlePanel.add(WIS);

		textDEX = new JTextPane();
		textDEX.setForeground(Color.WHITE);
		textDEX.setToolTipText("Value that determines your health.");
		textDEX.setText("DEX");
		textDEX.setOpaque(false);
		textDEX.setFont(new Font("Source Code Pro", Font.BOLD, 16));
		textDEX.setEditable(false);
		textDEX.setBackground(SystemColor.controlHighlight);
		textDEX.setBounds(477, 11, 38, 27);
		battlePanel.add(textDEX);

		DEX = new JTextPane();
		DEX.setText(dexterityValue.getText());
		DEX.setForeground(Color.WHITE);
		DEX.setToolTipText("");
		DEX.setOpaque(false);
		DEX.setFont(new Font("Source Code Pro", Font.BOLD, 18));
		DEX.setEditable(false);
		DEX.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		DEX.setBackground(SystemColor.menu);
		DEX.setBounds(525, 11, 38, 33);
		battlePanel.add(DEX);

		textHP = new JTextPane();
		textHP.setForeground(Color.PINK);
		textHP.setToolTipText("Value that determines your health.");
		textHP.setText("HP");
		textHP.setOpaque(false);
		textHP.setFont(new Font("Source Code Pro", Font.BOLD, 16));
		textHP.setEditable(false);
		textHP.setBackground(SystemColor.controlHighlight);
		textHP.setBounds(753, 49, 38, 27);
		battlePanel.add(textHP);

		HP = new JTextPane();
		HP.setForeground(Color.WHITE);
		HP.setToolTipText("");
		HP.setText(Integer.toString(Game.hero.getHP()));
		HP.setOpaque(false);
		HP.setFont(new Font("Source Code Pro", Font.BOLD, 18));
		HP.setEditable(false);
		HP.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		HP.setBackground(SystemColor.menu);
		HP.setBounds(753, 11, 38, 33);
		battlePanel.add(HP);

		textMP = new JTextPane();
		textMP.setForeground(Color.CYAN);
		textMP.setToolTipText("Value that determines your health.");
		textMP.setText("MP");
		textMP.setOpaque(false);
		textMP.setFont(new Font("Source Code Pro", Font.BOLD, 16));
		textMP.setEditable(false);
		textMP.setBackground(SystemColor.controlHighlight);
		textMP.setBounds(794, 49, 38, 27);
		battlePanel.add(textMP);

		MP = new JTextPane();
		MP.setForeground(Color.WHITE);
		MP.setToolTipText("");
		MP.setText(Integer.toString(Game.hero.getMP()));
		MP.setOpaque(false);
		MP.setFont(new Font("Source Code Pro", Font.BOLD, 18));
		MP.setEditable(false);
		MP.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		MP.setBackground(SystemColor.menu);
		MP.setBounds(794, 11, 38, 33);
		battlePanel.add(MP);

		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(189, 49, 564, 373);
		battlePanel.add(scrollPane);

		info = new JEditorPane();
		info.setText(game.monster.getName() + " approaches you." + "\n");
		info.setBackground(SystemColor.control);
		scrollPane.setViewportView(info);
		info.setFont(new Font("Sitka Text", Font.BOLD, 16));
		info.setEditable(false);

		healthBar = new JProgressBar();
		healthBar.setString(" ");
		healthBar.setValue(100);
		healthBar.setStringPainted(true);
		healthBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		healthBar.setAlignmentY(Component.TOP_ALIGNMENT);
		healthBar.setForeground(Color.RED);
		healthBar.setBackground(Color.DARK_GRAY);
		healthBar.setOrientation(SwingConstants.VERTICAL);
		healthBar.setBounds(763, 72, 16, 144);
		battlePanel.add(healthBar);

		magicBar = new JProgressBar();
		magicBar.setStringPainted(true);
		magicBar.setString(" ");
		magicBar.setValue(100);
		magicBar.setOrientation(SwingConstants.VERTICAL);
		magicBar.setForeground(Color.BLUE);
		magicBar.setBackground(Color.DARK_GRAY);
		magicBar.setAlignmentY(0.0f);
		magicBar.setAlignmentX(0.0f);
		magicBar.setBounds(804, 72, 16, 144);
		battlePanel.add(magicBar);

		spellsBtn = new JButton("Spellbook");
		spellsBtn.setIcon(new ImageIcon("btn.jpg"));
		spellsBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		spellsBtn.setForeground(Color.WHITE);
		spellsBtn.setFont(new Font("Poor Richard", Font.BOLD, 18));
		spellsBtn.setBackground(new Color(184, 134, 11));
		spellsBtn.setBounds(28, 301, 112, 58);
		battlePanel.add(spellsBtn);

		spellsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!spellsBtn.getText().equals("Close")) {
					if (Game.hero.getMP() >= 3) {
						lblFireball.setEnabled(true);

					}
					if (Game.hero.getMP() < 3) {
						lblFireball.setEnabled(false);

					}
					if (Game.hero.getMP() >= 5) {
						lblHeal.setEnabled(true);

					}
					if (Game.hero.getMP() < 5) {
						lblHeal.setEnabled(false);

					}
					lblFireball.setVisible(true);
					lblHeal.setVisible(true);
					attackBtn.setEnabled(false);
					inventoryPanel.setEnabled(false);
					spellsBtn.setText("Close");

				} else if (spellsBtn.getText().equals("Close")) {
					lblFireball.setEnabled(false);
					lblHeal.setVisible(false);
					lblFireball.setVisible(false);
					lblHeal.setVisible(false);
					attackBtn.setEnabled(true);
					inventoryPanel.setEnabled(true);
					spellsBtn.setText("Spellbook");
				}
			}
		});

		attackBtn = new JButton("Attack");
		attackBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		attackBtn.setIcon(new ImageIcon("btn.jpg"));
		attackBtn.setBounds(28, 370, 112, 58);
		battlePanel.add(attackBtn);
		attackBtn.setForeground(Color.WHITE);
		attackBtn.setFont(new Font("Poor Richard", Font.BOLD, 18));
		attackBtn.setBackground(new Color(184, 134, 11));

		attackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.normalAttack(game.monster, Game.hero, info, attackBtn, spellsBtn);
				game.monsterAttack(game.monster, Game.hero, info, attackBtn, spellsBtn, HP, Game.hero.getMaxHP(),
						healthBar);
				attackBtn.setEnabled(false);
				spellsBtn.setEnabled(false);
				inventoryPanel.setEnabled(false);
			}
		});

		addHPBtn = new JButton("Add HP Potion");
		addHPBtn.setVisible(false);
		addHPBtn.setPreferredSize(new Dimension(99, 23));
		addHPBtn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		addHPBtn.setBounds(34, 11, 110, 23);
		battlePanel.add(addHPBtn);

		addHPBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setItem(game.inventory, "Health Potion", "health_potion.jpg", 0);
			}
		});

		addMPBtn = new JButton("Add MP Potion");
		addMPBtn.setVisible(false);
		addMPBtn.setPreferredSize(new Dimension(99, 23));
		addMPBtn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		addMPBtn.setBounds(34, 41, 110, 23);
		battlePanel.add(addMPBtn);

		addMPBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setItem(game.inventory, "Mana Potion", "mana_potion.jpg", 0);
			}
		});

		addGoldBtn = new JButton("Add 100 Gold");
		addGoldBtn.setVisible(false);
		addGoldBtn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		addGoldBtn.setBounds(34, 70, 110, 23);
		battlePanel.add(addGoldBtn);

		addGoldBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.setItem(game.inventory, "Gold", "gold.jpg", 100);
			}
		});
		// Jos nimeksi laitetaan "Developer", päästään käsiksi nappeihin joilla
		// voidaan lisätä inventoryyn Potioneita tai kultaa.
		if (Game.hero.getName().equals("Developer")) {
			addHPBtn.setVisible(true);
			addMPBtn.setVisible(true);
			addGoldBtn.setVisible(true);
		}

		lblFireball = new JLabel("");
		lblFireball.setVisible(false);
		lblFireball.setEnabled(false);
		lblFireball.setIcon(new ImageIcon("fireball.jpg"));
		lblFireball.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblFireball.setForeground(Color.RED);
		lblFireball.setBounds(10, 232, 63, 58);
		battlePanel.add(lblFireball);

		lblFireball.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblFireball.isEnabled()) {
					System.out.println("");
					game.fireballAttack(game.monster, Game.hero, info, attackBtn, spellsBtn, MP, Game.hero.getMaxMP(),
							magicBar);
					game.monsterAttack(game.monster, Game.hero, info, attackBtn, spellsBtn, HP, Game.hero.getMaxHP(),
							healthBar);
					lblFireball.setEnabled(false);
					attackBtn.setEnabled(false);
					spellsBtn.setEnabled(false);
					inventoryPanel.setEnabled(false);
					spellsBtn.setText("Spellbook");
					lblFireball.setVisible(false);
					lblHeal.setVisible(false);
				}
			}

		});

		lblHeal = new JLabel("");
		lblHeal.setVisible(false);
		lblHeal.setEnabled(false);
		lblHeal.setIcon(new ImageIcon("heal.jpg"));
		lblHeal.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblHeal.setForeground(Color.RED);
		lblHeal.setBounds(88, 232, 63, 58);
		battlePanel.add(lblHeal);

		lblHeal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblHeal.isEnabled()) {
					System.out.println("");
					game.heal(game.monster, Game.hero, info, attackBtn, spellsBtn, HP, MP, Game.hero.getMaxHP(),
							Game.hero.getMaxMP(), healthBar, magicBar);
					game.monsterAttack(game.monster, Game.hero, info, attackBtn, spellsBtn, HP, Game.hero.getMaxHP(),
							healthBar);
					lblHeal.setEnabled(false);
					attackBtn.setEnabled(false);
					spellsBtn.setEnabled(false);
					inventoryPanel.setEnabled(false);
					spellsBtn.setText("Spellbook");
					lblFireball.setVisible(false);
					lblHeal.setVisible(false);
				}
			}
		});
		combatBG = new JLabel("Combat Background");
		combatBG.setDisplayedMnemonic(KeyEvent.VK_ENTER);
		combatBG.setHorizontalAlignment(SwingConstants.CENTER);
		combatBG.setIcon(new ImageIcon("wall.jpg"));
		combatBG.setBounds(0, 0, 842, 452);
		battlePanel.add(combatBG);
	}
}
