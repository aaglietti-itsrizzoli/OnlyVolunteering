package com.mycompany.app.general;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.mycompany.app.equip.Armor;
import com.mycompany.app.equip.ArmorType;
import com.mycompany.app.equip.Material;
import com.mycompany.app.equip.Spell;
import com.mycompany.app.equip.Weapon;
import com.mycompany.app.equip.WeaponType;
import com.mycompany.app.game.Main;

/**
 * Generic class with utility method for {@link Player} creation and plot device
 * */
public class Utils {
	public static void printAll(){
		for(Player p : Main.characters){
			System.out.printf(String.valueOf(p));
		}
	}

	/**
	 * Method to create a new character<br>
	 * Automatically calls {@link Utils#armorBuilder()}, {@link Utils#weaponBuilder()} and {@link Utils#spellBuilder()}
	 * @return {@link Player}
	* */
	public static Player charBuilder(){
		Scanner sc = new Scanner(System.in);
		boolean exit= true;
		String name = null;
		while(exit){
			try {
				System.out.println("Insert the name of the character");
				name = sc.nextLine();
				exit =false;
			} catch(NoSuchElementException e) {
				System.out.printf("Insert a name");
			}
		}
		exit = true;
		int health = 0;
		while(exit){
			try {
				System.out.println("Insert the health of the character");
				health = sc.nextInt();
				exit =false;
			} catch(InputMismatchException e) {
				System.out.printf("Insert a number");
			}
		}
		exit = true;

		int strength = 0;
		while(exit){
			try {
				System.out.println("Insert the strength of the character");
				strength = sc.nextInt();
				exit = false;
			} catch(InputMismatchException e) {
				System.out.printf("Insert a number");
			}
		}
		exit = true;


		int dex = 0;
		while(exit){
			try {
				System.out.println("Insert the dex of the character");
				dex = sc.nextInt();
				exit = false;
			} catch(InputMismatchException e) {
				System.out.printf("Insert a number");
			}
		}
		exit = true;

		int wisdom = 0;
		while(exit){
			try {
				System.out.println("Insert the wisdom of the character");
				wisdom = sc.nextInt();
				exit = false;
			} catch(InputMismatchException e) {
				System.out.printf("Insert a number");
			}
		}
		exit = true;

		int speed = 0;
		while(exit) {
			try {
				System.out.println("Insert the speed of the character");
				speed = sc.nextInt();
				exit = false;
			} catch(InputMismatchException e) {
				System.out.printf("Insert a number");
			}
		}
		exit = true;

		System.out.println("Does it have an armor? [Y/n]");
		Armor armor;
		sc.nextLine();
		if(sc.nextLine().equalsIgnoreCase("y")) {
			armor = armorBuilder();
		}else{
			armor = null;
		}
		System.out.println("Does it have a weapon? [Y/n]");
		Weapon weapon;
		if(sc.nextLine().equalsIgnoreCase("y")) {
			weapon = weaponBuilder();
		}else{
			weapon = null;
		}

		Player p = new Player(name,health,speed,strength,wisdom,dex,armor, weapon);

		System.out.println("Does it have spells? [Y/n]");
		int i =4;
		Spell spell;
		if(sc.nextLine().equalsIgnoreCase("y")) {
			while(i != 1) {

				System.out.printf("Add spell number %d\n", 5 - i);
				spell = spellBuilder();

				System.out.printf("Added spell: %s\n", spell);
				p.addSpells(spell);
				i--;
			}

		}else {
			System.out.printf("Spells not added\n");
			spell = null;

	}
		return p;
	}
	/**
	 * Method to create a new {@link Spell}
	 * @return {@link Spell}
	 * */
	static Spell spellBuilder(){
		Scanner sc = new Scanner(System.in);
		boolean exit = true;
		String name = null;
		while(exit){
			try {
				System.out.println("Insert the name of the spell");
				name = sc.nextLine();
				exit = false;
			} catch(Exception e) {
				System.out.printf("Insert a name");
			}
		}
		exit = true;

		int damage = 0;
		while(exit){
			try {
				System.out.println("Insert the damage of the spell");
				damage = sc.nextInt();
				exit = false;
			} catch(InputMismatchException e) {
				System.out.printf("Insert a number");
			}
		}
		exit =  true;
		int cooldown = 0;
		while(exit){
			try {
				System.out.println("Insert the cooldown of the spell");
				cooldown = sc.nextInt();
				exit = false;
			} catch(InputMismatchException e) {
				System.out.printf("Insert a number");
			}
		}
		exit = true;

		String description = null;
		while(exit){
			try {
				System.out.println("Insert the description of the spell");
				sc.nextLine();
				description = sc.nextLine();
				exit = false;
			} catch(Exception e) {
				System.out.printf("Insert a description");
			}
		}

		Spell spell = new Spell(name, damage,description,cooldown);
		return spell;
	}
	/**
	 * Method to create a new {@link Armor} from {@link Equip.Material} and {@link Equip.ArmorType}
	 * @return {@link Armor}
	 * */
	static Armor armorBuilder(){
		Scanner sc = new Scanner(System.in);
		ArmorType armorType1 = null;
		int tempHpModifier = 0;
		int tempSpeedModifier = 0;
		System.out.printf("You choose to add a new armor \n");
		System.out.print("""
				===============================================================================================
				What type of armor would you like to add?\

				    Type \t HP \t SPEED\

				[1] Heavy \t +3 \t  -1\

				[2] Medium \t +2 \t   0\

				[3] Light \t +1 \t  +1
				================================================================================================
				Insert the word
				""");
		boolean exit = true;
		while(exit){
			try {
				switch(sc.nextLine()) {

				case "1", "HEAVY", "Heavy":
					armorType1 = ArmorType.HEAVY;
					exit = false;
					break;
				case "2", "MEDIUM", "Medium":
					armorType1 = ArmorType.MEDIUM;
					exit = false;
					break;
				case "3", "LIGHT", "Light":
					armorType1 = ArmorType.LIGHT;
					exit = false;
					break;
				default:
					throw new IllegalArgumentException("Invalid armor type");
				}
			} catch(IllegalArgumentException e) {
				System.out.printf(e.toString());
			}
		}


		System.out.print("Choose the material of your armor\n");
		switch(armorType1){
		case HEAVY:
			System.out.print("""
					============================================================================================
					    Material \tHP   SPEED\
					
					[1] Adamantite  +5\t  -2\
					
					[2] Mithral     +4\t  -1\
					
					[3] Steel       +3\t   0
					============================================================================================
					""");
			break;

		case MEDIUM:
			System.out.print("""
		
				================================================================================================
				    Material   HP    SPEED\
			
				[1] Bronze     +3\t  -2\
			
				[2] Iron	   +3 \t   0\
			
				[3] Silver	   +2\t  +1
				================================================================================================
			""");
			break;
		case LIGHT:
			System.out.print("""
				================================================================================================
				    Material   HP    SPEED\
			
				[1] Leather    +1\t   0\
			
				[2] Wood       +2\t  -1\
			
				[3] Chainmail  +3\t   0
				===============================================================================================
			""");
			break;
		}
		exit = true;
		Material material2 = null;
		while(exit){
			try {
				String material = sc.nextLine();
				material2 = Material.valueOf(material.toUpperCase());
				exit = false;
			} catch(IllegalArgumentException e) {
				System.out.printf("Wrong input\n");
			}
		}
		System.out.printf("Choose the name of your armor\n");
		String name = sc.nextLine();
		System.out.printf("Type the description of your armor (Do not press enter to go next line)\n");
		String description = sc.nextLine();


		return new Armor(armorType1, name,description,material2);

	}

	/**
	 * Method to create a new {@link Equip.Weapon} from {@link Equip.Material} and {@link Equip.WeaponType}
	 * @return {@link Weapon}
	 * */
	static Weapon weaponBuilder() {
		Scanner sc = new Scanner(System.in);

		int tempStrModifier = 0;
		int tempSpeedModifier = 0;
		int tempDexModifier = 0;
		int tempWisModifier = 0;
		boolean exit = true;
		String type = "";
		// Switch type
		while(exit) {
			System.out.printf("You choose to add a new weapon \n");
			System.out.printf("""
					==================================================================================
					What type of weapon would you like to add?\

					[1] Sword\t\t\t\t [8] Hammer\
					
					[2] Axe\t\t\t\t\t [9] Gauntlet\
					
					[3] Spear\t\t\t\t [10] Scythe\
									
					[4] Club\t\t\t\t [11] Fan\
									
					[5] Bow\t\t\t\t\t [12] Tonfa\
									
					[6] Crossbow\t\t\t [13] Dagger\
									
					[7] Two handed sword\t [14] Flail
					================================================================================
					Insert the name
					""");
			type = sc.nextLine();
			try {
				WeaponType.valueOf(type.toUpperCase());
				exit = false;

			} catch(IllegalArgumentException e) {
				System.out.printf(e.toString());
			}

		}

		String weaponMat = "";

		exit = true;
		// Switch Equip.Material
		while(exit){
			System.out.printf("Choose the material\n");

			System.out.printf("""
====================================================================================
	Material \tStrength   Speed\t Dexterity\t Wisdom

[1] WOOD\t\t +1\t\t\t+1\t\t\t+2\t\t\t+1\

[2] LEATHER\t\t +1\t\t\t+1\t\t\t+1\t\t\t+2\

[3] BRONZE\t\t +2\t\t\t-1\t\t\t+3\t\t\t+1\

[4] SILVER\t\t +2\t\t\t+2\t\t\t+2\t\t\t+2\

[5] IRON\t\t +3\t\t\t-1\t\t\t+2\t\t\t+2\

[6] STEEL\t\t +4\t\t\t-1\t\t\t+3\t\t\t+2
=====================================================================================
      						""");


			weaponMat = sc.nextLine();
			try {
				Material.valueOf(weaponMat.toUpperCase());
				exit = false;
			}catch(IllegalArgumentException e){
				System.out.printf("Insert the name\n");
			}
		}
		switch(Material.valueOf(weaponMat.toUpperCase())){
			case WOOD:
				tempStrModifier = tempStrModifier + 1;
				tempWisModifier = tempWisModifier + 1;
				tempDexModifier = tempDexModifier + 2;
				tempSpeedModifier = tempSpeedModifier + 1;
				break;
			case LEATHER:
				tempDexModifier = tempDexModifier + 1;
				tempStrModifier = tempStrModifier + 1;
				tempSpeedModifier = tempSpeedModifier + 1;
				tempWisModifier = tempWisModifier + 2;
				break;
			case BRONZE:
				tempDexModifier = tempDexModifier + 3;
				tempStrModifier = tempStrModifier + 2;
				tempSpeedModifier = tempSpeedModifier - 1;
				tempWisModifier = tempWisModifier + 1;
				break;
			case SILVER:
				tempDexModifier = tempDexModifier + 2;
				tempStrModifier = tempStrModifier + 2;
				tempSpeedModifier = tempSpeedModifier + 2;
				tempWisModifier = tempWisModifier + 2;
				break;
			case IRON:
				tempDexModifier = tempDexModifier + 2;
				tempStrModifier = tempStrModifier + 3;
				tempSpeedModifier = tempSpeedModifier - 1;
				tempWisModifier = tempWisModifier + 2;
				break;
			case STEEL:
				tempDexModifier = tempDexModifier + 3;
				tempStrModifier = tempStrModifier + 4;
				tempSpeedModifier = tempSpeedModifier - 1;
				tempWisModifier = tempWisModifier + 2;
				break;
			}
		System.out.printf("Choose the name of your weapon\n");
		String name = sc.nextLine();
		System.out.printf("Type the description of your armor (Do not press enter to go next line)\n");
		String description = sc.nextLine();

		return new Weapon(name, tempStrModifier, tempSpeedModifier, tempDexModifier, tempWisModifier, Material.valueOf(weaponMat.toUpperCase()), description, WeaponType.valueOf(type.toUpperCase()));
	}

	public static void printGoblin(){
		System.out.printf("""
					         ,      ,
				            /(.-""-.)\\
				        |\\  \\/      \\/  /|
				        | \\ / =.  .= \\ / |
				        \\( \\   o\\/o   / )/
				         \\_, '-/  \\-' ,_/
				           /   \\__/   \\
				           \\ \\__/\\__/ /
				         ___\\ \\|--|/ /___
				       /`    \\      /    `\\
				      /       '----'       \\
				""");
	}

	public static void printDragon(){
		System.out.printf("""
				                                                                                ____________
				                                                          (`-..________....---''  ____..._.-`
				                                                           \\\\`._______.._,.---'''     ,'
				                                                           ; )`.      __..-'`-.      /
				                                                          / /     _.-' _,.;;._ `-._,'
				                                                         / /   ,-' _.-'  //   ``--._``._
				                                                       ,','_.-' ,-' _.- (( =-    -. `-._`-._____
				                                                     ,;.''__..-'   _..--.\\\\.--'````--.._``-.`-._`.
				                                      _          |\\,' .-''        ```-'`---'`-...__,._  ``-.`-.`-.`.
				                           _     _.-,'(__)\\__)\\-'' `     ___  .          `     \\      `--._
				                         ,',)---' /|)          `     `      ``-.   `     /     /     `     `-.
				                         \\_____--.  '`  `               __..-.  \\     . (   < _...-----..._   `.
				                          \\_,--..__. \\\\ .-`.\\----'';``,..-.__ \\  \\      ,`_. `.,-'`--'`---''`.  )
				                                    `.\\`.\\  `_.-..' ,'   _,-..'  /..,-''(, ,' ; ( _______`___..'__
				                                            ((,(,__(    ((,(,__,'  ``'-- `'`.(\\  `.,..______
				                                                                               ``--------..._``--.__
				""");
	}

	public static void printDwarf(){
		System.out.printf("""
				⠀⠀⠀⠀⠀⠀⠀⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠀⠀⠀⠀⠀⠀⠀
				⠀⠀⠀⠀⠀⠀⣼⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⣧⠀⠀⠀⠀⠀⠀
				⠀⠀⠀⠀⠀⢸⣿⣿⣷⡀⠀⠀⠀⠀⣀⣀⠀⠀⠀⠀⢀⣾⣿⣿⡇⠀⠀⠀⠀⠀
				⠀⠀⠀⠀⠀⠈⢿⣿⣿⣿⣷⠀⣠⣾⣿⣿⣷⣄⠀⣾⣿⣿⣿⡿⠁⠀⠀⠀⠀⠀
				⠀⠀⠀⠀⠀⠀⠀⠈⠛⠿⠁⣼⣿⣿⣿⣿⣿⣿⣧⠈⠿⠛⠁⠀⠀⠀⠀⠀⠀⠀
				⠀⠀⠀⠀⠀⠀⠀⠀⢀⡀⠘⠛⠛⠛⠛⠛⠛⠛⠛⠃⢀⡀⠀⠀⠀⠀⠀⠀⠀⠀
				⠀⠀⠀⠀⠀⠀⠀⠀⣼⠏⠀⠿⣿⣶⣶⣶⣶⣿⠿⠀⠹⣷⠀⠀⠀⠀⠀⠀⠀⠀
				⠀⠀⠀⠀⠀⠀⠀⢰⡟⠀⣴⡄⠀⣈⣹⣏⣁⡀⢠⣦⠀⢻⣇⠀⠀⠀⠀⠀⠀⠀
				⠀⠀⠀⠀⠀⠀⠀⠈⠀⠐⢿⣿⠿⠿⠿⠿⠿⠿⣿⡿⠂⠀⠙⠀⠀⠀⠀⠀⠀⠀
				⠀⠀⠀⠀⠀⠀⢀⣴⣿⣷⣄⠉⢠⣶⠒⠒⣶⡄⠉⣠⣾⣿⣦⡀⠀⠀⠀⠀⠀⠀
				⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣾⣿⣿⣿⣿⣿⣦⡀⠀⠀⠀⠀
				⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀
				⠀⠀⠀⠀⠀⠀⠚⠛⠛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠛⠛⠓⠀⠀⠀⠀⠀⠀
				⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⢿⣿⣿⡿⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
				⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
				""");
	}

	public static void printForest(){
		System.out.printf("""
				          ///\\///\\\\\\     ///////\\\\\\               ///////\\\\\\
				          ///\\///\\\\\\     ///////\\\\\\/\\             ///////\\\\\\
				          //\\////\\\\\\\\       ////\\\\//\\\\           ////////\\\\\\
				          //\\\\///\\\\\\\\\\     /////\\///\\\\\\                 ||
				         ///\\\\\\//\\\\\\\\\\\\    /////\\///\\\\\\
				     /\\  ///\\\\\\ ||         /////\\///\\\\\\
				    //\\\\////\\\\/\\               ||///\\\\\\                 /\\
				   ///\\\\\\///\\//\\\\               ////\\\\\\\\               //\\\\
				   ///\\\\\\///\\//\\\\/\\         /\\  ////\\\\\\\\         /\\    //\\\\
				  ////\\\\\\\\/////\\//\\\\       //\\\\ ////\\\\\\\\        //\\\\   //\\\\
				  ////\\\\\\\\////////\\\\\\     /\\/\\\\  /\\||          ///\\\\\\  //\\\\
				 /////\\\\\\\\\\///////\\\\\\\\   //\\\\\\\\ //\\\\           ///\\\\\\ ///\\\\\\
				 /////\\\\\\\\\\///////\\\\\\\\   //\\\\\\\\ //\\\\          ////\\\\\\\\///\\\\\\
				 /////\\\\\\\\////////\\\\\\\\  ///\\\\\\\\ //\\\\        /\\////\\\\\\\\///\\\\\\
				     ||  /////////\\\\\\\\ ////\\\\\\\\\\//\\\\       //\\\\///\\\\\\\\\\//\\\\\\
				              ////\\\\\\\\/////\\\\\\\\///\\\\\\      //\\\\///\\\\\\\\\\\\||
				             /////\\\\\\//////\\\\\\\\///\\\\\\     ///\\\\\\//\\\\\\\\\\\\
				                 || ///////\\\\\\////\\\\\\\\   ////\\//\\||
				                    ///////\\\\/////\\\\\\\\\\ ////////\\\\
				                          ||     ||    /////////\\\\\\
				                                       /////////\\\\\\
				                                      //////////\\\\\\\\
				                                          //////\\\\\\\\
				                            /\\           ///////\\\\\\\\\\
				                           //\\\\          ///////\\\\\\\\\\\\
				   /\\                     ///\\\\\\        ////////\\\\\\\\\\\\\\
				  //\\\\                   ////\\\\\\\\             |||
				 ///\\\\\\                 /////\\\\\\\\\\
				 ///\\\\\\\\             /\\//////\\\\\\\\\\\\    /\\
				 ///\\\\\\\\\\           //\\\\/////\\\\\\\\\\\\\\  //\\\\
				 ///\\\\\\\\\\\\         ///\\\\\\////\\\\\\\\\\\\\\ /\\/\\\\
				 ///\\\\\\\\\\\\        ////\\\\\\\\///\\\\\\\\\\\\\\//\\\\\\\\
				 ///\\\\\\\\\\\\\\      /////\\\\\\\\\\ ||     ///\\\\\\\\
				 ///\\\\\\\\\\\\\\     //////\\\\\\\\\\\\      ////\\\\\\\\
				   ||   /\\ /\\   //////\\\\\\\\\\\\      ////\\\\\\\\
				       //\\//\\\\  //////\\\\\\\\\\\\     /////\\\\\\\\\\         /\\
				      ///\\//\\\\ ///////\\\\\\\\\\\\\\   //////\\\\\\\\\\\\       //\\\\
				     ///////\\\\\\      ||         //////\\\\\\\\\\\\       //\\\\
				     ///////\\\\\\\\               ///////\\\\\\\\\\\\\\     ///\\\\\\
				    /////\\//\\\\\\\\                     ||    /\\    ////\\\\\\\\
				    /////\\\\/\\\\\\\\                          //\\\\   ////\\\\\\\\
				    //////\\/\\\\\\\\                          //\\\\  /////\\\\\\\\\\
				    //////\\\\\\\\\\\\                          //\\\\  /////\\\\\\\\\\
				       ///\\\\|                            ///\\\\\\//////\\\\/\\\\\\
				      ////\\\\\\                           ////\\\\\\\\    ||//\\\\
				      ////\\\\\\\\                          ////\\\\\\\\     ///\\\\\\
				     /////\\\\\\\\                         /////\\\\\\\\\\   ////\\\\\\\\
				     /////\\\\\\\\                        //////\\\\\\\\\\\\  ////\\\\\\\\
				     /////\\\\\\\\\\                     /\\     ||       ////\\\\\\\\
				    //////\\\\\\\\\\\\                   //\\\\             ////\\\\\\\\
				         ||                        //\\\\             ////\\\\\\\\
				                                  ///\\\\\\           /////\\\\\\\\
				                                 ////\\\\\\\\              ||
				                                /////\\\\\\\\\\
				                               //////\\\\\\\\\\\\
				                              ///////\\\\\\\\\\\\\\
				                             ////////\\\\\\\\\\\\\\\\
				                                    ||
				""");
	}

	public static void printCave(){
		System.out.printf("""
				 ********************************************************************************
				*                    /   \\              /'\\       _                              *
				*\\_..           /'.,/     \\_         .,'   \\     / \\_                            *
				*    \\         /            \\      _/       \\_  /    \\     _                     *
				*     \\__,.   /              \\    /           \\/.,   _|  _/ \\                    *
				*          \\_/                \\  /',.,''\\      \\_ \\_/  \\/    \\                   *
				*                           _  \\/   /    ',../',.\\    _/      \\                  *
				*             /           _/m\\  \\  /    |         \\  /.,/'\\   _\\                 *
				*           _/           /MMmm\\  \\_     |          \\/      \\_/  \\                *
				*          /      \\     |MMMMmm|   \\__   \\          \\_       \\   \\_              *
				*                  \\   /MMMMMMm|      \\   \\           \\       \\    \\             *
				*                   \\  |MMMMMMmm\\      \\___            \\_      \\_   \\            *
				*                    \\|MMMMMMMMmm|____.'  /\\_            \\       \\   \\_          *
				*                    /'.,___________...,,'   \\            \\   \\        \\         *
				*                   /       \\          |      \\    |__     \\   \\_       \\        *
				*                 _/        |           \\      \\_     \\     \\    \\       \\_      *
				*                /                               \\     \\     \\_   \\        \\     *
				*                                                 \\     \\      \\   \\__      \\    *
				*                                                  \\     \\_     \\     \\      \\   *
				*                                                   |      \\     \\     \\      \\  *
				*                                                    \\ms          |            \\ *
				 ********************************************************************************
				""");
	}
}