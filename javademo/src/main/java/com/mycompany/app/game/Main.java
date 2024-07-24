package com.mycompany.app.game;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.app.general.CharacterList;
import com.mycompany.app.general.Game;
import com.mycompany.app.general.Player;
import com.mycompany.app.general.Utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Main {
	static Player selected;
	public static ArrayList<Player> characters = new ArrayList<>();
	public static Scanner scanner;

	public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
		ObjectMapper objectMapper = new ObjectMapper();
		Player person;

		ClassLoader classloader = Thread.currentThread().getContextClassLoader();

		InputStream is = classloader.getResourceAsStream("characters/index.json");

		CharacterList characterList = objectMapper.readValue(is, CharacterList.class);
		System.out.println("CharacterList.characters: " + Arrays.toString(characterList.getCharacters()));

		for (String s : characterList.getCharacters()) {
				String character = String.format("characters/%s.json", s);
				System.out.println("Reading " + character);
				is = classloader.getResourceAsStream(character);
				person = objectMapper.readValue(is, Player.class);
				characters.add(person);
		}
		Main.scanner = new Scanner(System.in);
		

		boolean exit = false;
		System.out.print("Welcome to SECRETS OF THE FOREST\n");
		while(!exit){
			System.out.print("---------------------------------------------------------------------------------------------------------------\n");
			System.out.print("What do you want to do?\n");
			System.out.println("[1] Choose the character to start");
			System.out.println("[2] Add a new character");
			System.out.println("[3] Remove a character");
			System.out.println("[4] Start the game");
			System.out.println("[5] Exit");
			System.out.print("---------------------------------------------------------------------------------------------------------------\n");


			int choice = scanner.nextInt();


			switch(choice) {
			case 1:
				String nameChoice;
				Utils.printAll();
				System.out.println("\nWho do you wanna play with?");
				scanner.nextLine();
				nameChoice = scanner.nextLine();
				boolean found = false;
				for(Player p : characters) {
					if(p == null){
						break;
					}
					if(p.getName().equals(nameChoice)) {
						selected = p;
						System.out.printf("You have selected %s\n", selected.getName());
						found = true;

					}
				}
				if(!found){
					System.out.println("Character not found");
					break;
				}
				Game game = new Game(selected);
				game.start(selected);

				break;
			case 2:
				System.out.println("Do you a json file to load [Y/n]?");
				scanner.nextLine();
				if(scanner.nextLine().equalsIgnoreCase("y")) {
					System.out.println("Insert the file path");

					String path = scanner.nextLine();
					try {
						characters.add(objectMapper.readValue(new File("C:\\UFS04\\JavaExam\\src\\" + path + ".json"), Player.class));
					} catch(IOException e) {
						throw new RuntimeException(e);
					}
				}else {
					System.out.println("Manually add all the information");
					person = Utils.charBuilder();
					characters.add(person);
				}
				break;
			case 3:
				 System.out.println("Insert the name of the character you would like to remove");
				 scanner.nextLine();
				 nameChoice = scanner.nextLine();
				 for(Player p : characters) {
					 if(p.getName().equalsIgnoreCase(nameChoice)){
						 System.out.printf("You want to remove %s? [Y/n]\n", p.getName());
						 if(scanner.nextLine().equalsIgnoreCase("y")) {
							 characters.remove(p);
							 System.out.printf("You have removed %s\n", nameChoice);
							 break;
						 }else {
							 System.out.printf("Operation cancelled");
							 break;
						 }
					 }
				 }
				 break;
			case 4:
				 System.out.println("Who do you wanna play with?");
				 scanner.nextLine();
				 nameChoice = scanner.nextLine();
				 for(Player p : characters) {
					 if(p == null){
						 break;
					 }
					 if(p.getName().equals(nameChoice)) {
						 selected = p;
						 System.out.printf("You have selected %s \n", selected.getName());
					 }
				 }
				 Game game2 = new Game(selected);
				 game2.start(selected);
			case 5:
				System.out.println("Arrivedorci");
				exit = true;
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}

	}
	}
}

//TODO javadoc
//TODO README