package com.mycompany.app.general;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.mycompany.app.equip.Material;
import com.mycompany.app.equip.Spell;
import com.mycompany.app.equip.Weapon;
import com.mycompany.app.equip.WeaponType;
import com.mycompany.app.game.Main;
import com.mycompany.app.monster.Dragon;
import com.mycompany.app.monster.Dwarf;
import com.mycompany.app.monster.Goblin;
import com.mycompany.app.monster.Monster;

/**
 * Main class for running the game
 */

public class Game {
	Random rand = new Random();
	Player player;

	public Game(Player player1) {
		this.player = player1;
	}

	/**
	 * Start of the game
	 * 
	 * @param player
	 * @throws InterruptedException
	 */
	public void start(Player player) throws InterruptedException {
		Utils.printForest();
		TimeUnit.SECONDS.sleep(3);
		System.out.println(
				"You find yourself at the entrance of a thick pine forest, the trees are so tall and dense that the sun barely lights the path that you barely recognized at first glance");
		TimeUnit.SECONDS.sleep(4);
		System.out.println("You decide to venture inside the forest following the narrow trail bordered by thorns");
		TimeUnit.SECONDS.sleep(3);
		System.out.println(
				"While walking through the forest you feel being observed from the darkness but you quickly get over it thinking that the absence of light is making you paranoid");
		TimeUnit.SECONDS.sleep(3);
		System.out.println(
				"You already lost track of time since you went inside the woods, suddenly you hear someone moving between the trees at your left. You stop and try to focus to spot the creature");
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Two goblins pop out from the darkness with their weapons unleashed ready to fight you");
		TimeUnit.SECONDS.sleep(3);
		Goblin goblin1 = new Goblin("Melee");
		Goblin goblin2 = new Goblin("ranged");
		Utils.printGoblin();
		TimeUnit.SECONDS.sleep(1);
		Utils.printGoblin();
		System.out.println(goblin1.getDescription());
		System.out.println(goblin1.getDescription());
		while ((goblin1.getHealth() > 0 || goblin2.getHealth() > 0) && (player.getHealth() > 0)) {
			encounter(player, goblin1, goblin2);
		}

		TimeUnit.SECONDS.sleep(3);
		if (player.getHealth() > 0) {
			System.out.printf("After a bloody battle with two goblins you came out victorious\n");
			TimeUnit.SECONDS.sleep(1);
			System.out.printf(
					"Lying at the feet of the defeated goblin there are simple wood weapon that don't interest you\n");
			player.resetStats();
		} else {
			System.out.println("Sadly you couldn't overcome the sheer force of two goblins");
			System.out.println("GAME OVER");
			return;
		}

		System.out.println(
				"You proceed in the depth of the forest keeping aware of your surroundings waiting for another ambush...");
		TimeUnit.SECONDS.sleep(2);
		System.out.println(
				"As time passes you start to notice that the forest is slowly thinning away and after some metres you notice the path branching in two different ways");
		TimeUnit.SECONDS.sleep(3);
		System.out.printf("The right path seems to going in a clearing without trees\n");
		System.out.printf("The left path lead to an entrance of a cave\n");

		System.out.printf("Which would you take? [L/R]\n");
		boolean exit = true;
		while (exit) {
			String input = Main.scanner.nextLine();
			if (input.equals("L") || input.equals("Left") || input.equals("left")) {
				exit = false;
				cavePath();
			} else if (input.equals("R") || input.equals("Right") || input.equals("right")) {
				exit = false;
				clearingPath();
			} else {
				System.out.printf("Wrong input\n");
			}
		}

	}

	/**
	 * Method to manage combat during the game
	 * 
	 * @param p
	 * @param monsters
	 * @throws InterruptedException
	 */
	public boolean encounter(Player p, Monster... monsters) throws InterruptedException {
		int damage = 0;
		boolean exit = true;
		boolean valid = true;
		String target = "";
		if (!player.isSkipTurn()) {
			if (monsters.length > 1) {
				while (valid) {
					System.out.printf("Choose the target (start from zero)\n");
					for (Monster m : monsters) {
						if (m.getHealth() < 1) {
							System.out.println(m.getDescription() + " is dead");
						}
					}
					target = Main.scanner.nextLine();
					if (Integer.parseInt(target) < monsters.length) {
						valid = false;
					} else {
						System.out.printf("Invalid target\n");
					}
				}
			}
			while (exit) {
				player.action();
				switch (Main.scanner.nextLine()) {
					case "1", "Light attack", "Light Attack", "light attack":
						damage = player.attackLight();
						System.out.printf("Light attack done: %d damage\n", damage);
						exit = false;
						break;
					case "2", "Heavy attack", "Heavy Attack", "heavy attack":
						damage = player.attackHeavy();
						System.out.printf("Heavy attack done: %d damage\n", damage);
						exit = false;
						break;
					case "3", "Special Attack", "Special attack", "special attack":
						if (player.getCdSpecial() > 0) {
							System.out.printf("Special attack in cooldown\n");
							break;
						}
						damage = player.attackSpecial();
						System.out.printf("Special attack done: %d damage\n", damage);
						exit = false;
						break;
					case "4", "spell", "spells":
						for (Spell spell : player.spells) {
							System.out.println(spell.toString());
						}
						String input = Main.scanner.nextLine();
						if (input.equalsIgnoreCase(player.spells[1].getName())) {
							damage = player.attackSpell(player.spells[1]);
							System.out.printf("Spell launched: %d damage\n", damage);
						} else if (input.equalsIgnoreCase(player.spells[2].getName())) {
							damage = player.attackSpell(player.spells[2]);
							System.out.printf("Spell launched: %d damage\n", damage);
						} else if (input.equalsIgnoreCase(player.spells[3].getName())) {
							damage = player.attackSpell(player.spells[3]);
							System.out.printf("Spell launched: %d damage\n", damage);
						} else if (input.equalsIgnoreCase(player.spells[4].getName())) {
							damage = player.attackSpell(player.spells[4]);
							System.out.printf("Spell launched: %d damage\n", damage);
						} else {
							System.out.println("Spell not found");
						}
						exit = false;
						break;
					case "5", "run", "Run":
						boolean escape = true;
						for (int i = 0; i < monsters.length && escape; i++) {
							Monster currentMonster = monsters[i];
							escape = player.run(currentMonster);
						}
						if (escape) {
							System.out.println("You run away from the monsters");
							return true;
						} else {
							System.out.println("You couldn't run away from the monsters");
						}
						exit = false;

					default:
						System.out.println("Invalid command");
				}
			}
			TimeUnit.SECONDS.sleep(1);
			int intTarget = 0;
			try {
				intTarget = Integer.parseInt(target);
			} catch (NumberFormatException e) {
				intTarget = 0;
			}
			monsters[intTarget].setHealth(monsters[intTarget].getHealth() - damage);
			System.out.println("Health of monster " + monsters[intTarget].getHealth());

		} else {
			System.out.printf("Turn Skipped\n");
			player.setSkipTurn(false);
		}
		int damageToPlayer = 0;
		if (monsters.length > 1) {
			for (Monster m : monsters) {
				if (m.getHealth() > 0) {
					switch (rand.nextInt(3)) {
						case 0:
							damageToPlayer = m.attackLight();
							System.out.printf("You received %d damage\n", damageToPlayer);
							break;
						case 1:
							damageToPlayer = m.attackHeavy();
							System.out.printf("You received %d damage\n", damageToPlayer);
							break;
						case 2:
							damageToPlayer = m.attackSpecial();
							System.out.printf("You received %d damage\n", damageToPlayer);
							break;
					}
					player.setHealth(player.getHealth() - damageToPlayer);
				}
			}
		} else {
			if (monsters[0].getHealth() > 0) {
				switch (rand.nextInt(3)) {
					case 0:
						damageToPlayer = monsters[0].attackLight();
						System.out.printf("You received %d damage\n", damageToPlayer);
						break;
					case 1:
						damageToPlayer = monsters[0].attackHeavy();
						System.out.printf("You received %d damage\n", damageToPlayer);
						break;
					case 2:
						damageToPlayer = monsters[0].attackSpecial();
						System.out.printf("You received %d damage\n", damageToPlayer);
						break;
				}
				player.setHealth(player.getHealth() - damageToPlayer);
			}
		}
		return false;
	}

	public void cavePath() throws InterruptedException {
		Utils.printCave();
		TimeUnit.SECONDS.sleep(3);
		System.out.println("You choose the left path leading to the cavern");
		TimeUnit.SECONDS.sleep(1);
		System.out.println(
				"As you approach the entrance of the cave you notice some mine tools abandoned on the wall of the cave. You soon notice that the cave is a mine and is not abandoned");
		System.out.println("You cautiously enter the cave keeping an eye on suspect movement");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("After some turn you enter a well lit chamber where two dwarf are chatting while working");
		TimeUnit.SECONDS.sleep(1);
		Utils.printDwarf();
		TimeUnit.SECONDS.sleep(2);
		Utils.printDwarf();
		System.out.println("Do you want to approach them in an hostile way? [Y/n]");
		boolean exit = true;
		String input = Main.scanner.nextLine();
		while (exit) {
			if (input.equalsIgnoreCase("Y")) {
				exit = false;
				System.out.println("You decide to sheathe your sword and approach them");
				System.out.println("As soon as they see you with your sword they stand up and attack you ");
				TimeUnit.SECONDS.sleep(1);
				Dwarf dwarf = new Dwarf();
				Dwarf dwarf2 = new Dwarf();
				while ((dwarf.getHealth() > 0 || dwarf2.getHealth() > 0) & (player.getHealth() > 0)) {
					encounter(player, dwarf, dwarf2);
				}
				player.resetStats();
			} else if (input.equalsIgnoreCase("N")) {
				exit = false;
				System.out.println("You decide to slowly walk towards them letting them notice you");
				TimeUnit.SECONDS.sleep(1);
				System.out.println("They don't seems to be hostile to you but more curious");
				System.out.println("They ask if you want to swap your weapon with one ot their steel's hammer");
				TimeUnit.SECONDS.sleep(1);
				Weapon hammer = new Weapon("Hammer Time", 5, -1, 4, 3, Material.STEEL,
						"Hand manifactured by the dwarves", WeaponType.HAMMER);
				System.out.printf((player.getWeapon() != null ? player.getWeapon().toString() : "Not Present\n"));
				System.out.println(hammer.toString());
				exit = true;
				while (exit) {
					System.out.println("Do you want to swap weapon? [Y/n]");
					if (Main.scanner.nextLine().equalsIgnoreCase("Y")) {
						player.setWeapon(hammer);
						System.out.println("Weapon swapped");
						exit = false;
						player.setModifier();
					} else if (Main.scanner.nextLine().equalsIgnoreCase("N")) {
						System.out.println("You declined the dwarves offer");
						exit = false;

					} else {
						System.out.println("Wrong input");
					}
				}
				System.out.println(
						"After thanking the dwarves for their offer you decide to head out of the cave and go back to the path fork");
				TimeUnit.SECONDS.sleep(3);
			} else {
				System.out.println("Wrong input");
			}
		}
		clearingPath();
	}

	public void clearingPath() throws InterruptedException {
		System.out.println(
				"You slowly walk towards the clearing, bathing, for the first time since entering the forest, in the sun filtering through the trees");
		TimeUnit.SECONDS.sleep(2);
		System.out.println("You arrive in the clearing but you quickly see that the forest hide a secret");
		TimeUnit.SECONDS.sleep(2);
		System.out.println("You find yourself at the edge of a crater where a red dragon lies at the center");
		TimeUnit.SECONDS.sleep(2);
		Utils.printDragon();
		TimeUnit.SECONDS.sleep(2);
		Dragon dragon = new Dragon();
		System.out.println(dragon.getDescription());
		TimeUnit.SECONDS.sleep(3);
		System.out.println(
				"Just the size of the dragon petrify you, you want to move, to run in the opposite direction but the legs won't move");
		TimeUnit.SECONDS.sleep(2);
		System.out.println(
				"Only the scream of the dragon wakes you up but it is already too late, he approach you angrily");
		TimeUnit.SECONDS.sleep(1);
		while ((dragon.getHealth() > 0) & (player.getHealth() > 0)) {
			if(encounter(player, dragon)){
			//se true scappa	
				break;			
			}
		}

		if (dragon.getHealth() < 1) {
			System.out.println(
					"The dragon lies dead at your feet. The air is almost unbreathable because of the fume emitted by his body");
			TimeUnit.SECONDS.sleep(3);
			System.out.println(
					"You stare at the dead body with sadness in your eyes for slaying such a beautiful creature but at the same time you know that it was necessary");
			TimeUnit.SECONDS.sleep(4);
			System.out.println("Thank you for playing");

		} else {
			System.out.println("Sadly you couldn't overcome the sheer force of the dragon");
			System.out.println("GAME OVER");
		}
		return;
	}

}
