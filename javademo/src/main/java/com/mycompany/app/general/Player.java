package com.mycompany.app.general;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import com.mycompany.app.equip.Armor;
import com.mycompany.app.equip.Spell;
import com.mycompany.app.equip.Weapon;
import com.mycompany.app.monster.Monster;

/**
* Define the structure of class <code>Player</code> that implements {@link Action} <br>
 * Inherit the {@link Action#attackLight()},{@link Action#attackHeavy()},{@link Action#attackSpecial()}
 *
 */

public class Player implements Action{
	private String name;
	private int health;
	private int speed;
	private int str;
	private int wis;
	private int dex;

	private int defSpeed = speed;
	private int defStr = str;
	private int defWis = wis;
	private int defDex = dex;


	Random rand = new Random();
	Armor armor;
	Weapon weapon;
	Spell[] spells = new Spell[MAX_SPELL];

	int cdSpecial = 0;

	boolean skipTurn = false;
	boolean potionUsed = false;

	public Player(String name, int health, int speed, int str, int wis, int dex) {
		this(name,health,speed,str,wis,dex,null,null);
	}

	public Player(String name,int dex, int wis, int str, int speed, int health, Armor armor, Weapon weapon ) {
		this.name = name;
		this.dex = dex;
		this.wis = wis;
		this.str = str;
		this.speed = speed;
		this.health = health;
		this.armor = armor;
		this.weapon = weapon;
		setModifier();
		this.defSpeed = speed;
		this.defStr = str;
		this.defWis = wis;
		this.defDex = dex;

	}

	public Player() {
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public void setWeapon(Weapon weapon){
		this.weapon = weapon;
	}
	/**
	 * Void function to automatically set the weapon modifier
	 * @see Monster#setModifier()
	 * */
	public void setModifier(){
		if(weapon != null){
			str = this.str + weapon.getStrModifier();
			speed = speed + weapon.getSpModifier();
			wis = wis + weapon.getWisModifier();
			dex = dex + weapon.getDexModifier();
		}

		if(armor != null){
				health = health + armor.getHpModifier();
				speed = speed + armor.getSpeedModifier();
		}
	}
	/**
	 * Method for choosing the player action
	 * */

	public static void action(){
		int damage;
		System.out.print("""
				What action do you want to do?
				
				[1] Light Attack
				
				[2] Heavy Attack
				
				[3] Special attack 
				
				[4] Throw a spell
				
				[5] Run away
				""");
	}
	/**
	 * Method implemented from {@link Action} for doing the light attack
	 * @return damage
	 *
	 * */
	@Override
	public int attackLight() {
		if(this.str > this.wis) {
			return this.str;
		}else{
			return this.wis;
		}
	}
	/**
	 * Method implemented from {@link Action} for doing the heavy attack
	 * @return damage
	 *
	 * */
	@Override
	public int attackHeavy() {
		skipTurn = true;

		if(this.str > this.dex) {
			return this.str;
		}else{
			return this.dex;
		}
	}
	/**
	 * Method implemented from {@link Action} for doing the special attack
	 * @return damage
	 *
	 * */
	@Override
	public int attackSpecial() {
		this.cdSpecial = CD_SPECIAL;
		return this.str  + this.dex + this.wis;
	}

	/**
	 * Method for doing the spell attack if exists
	 * @return damage
	 *
	 * */
	public int attackSpell(Spell spell) {
		return this.wis + spell.getDamage();
	}

	/**
	 * Method for escaping enemies
	 * @return result
	 *
	 * */
	public boolean run(Monster monster) {
		boolean result = false;

		if(this.speed * this.dex > monster.getSpeed() * monster.getDex()) {
			return rand.nextBoolean();
		}else {
			return rand.nextInt() > 2;
		}
	}

	/**
	* Method to add up to four {@link Spell} to the character
	 * @param spell
	* */
	void addSpells(Spell spell){
		boolean full = true;
		for(Spell value : spells) {
			if(value == null){
				full = false;
				break;
			}
		}
		String response;

		int i = 0;
		while(spells[i] != null){
			i++;
		}
		spells[i] = spell;
	}


	/**
	 * Method to reset the stats after every encounter
	 */
	void resetStats(){
		this.speed =this.defSpeed;
		this.str = this.defStr;
		this.wis = this.defWis;
		this.dex = this.defDex;
	}

	@Override
	public String toString() {

		return this.name  + "\n" +
				"\thealth\t" + this.health +
				"\n\tspeed\t" + this.speed +
				"\n\tstr\t\t" + this.str +
				"\n\twis\t\t" + this.wis +
				"\n\tdex\t\t" + this.dex +
				"\n\tarmor\t" + (this.armor != null ? this.armor.toString() : "Not Present") +
				"\n\tweapon\t" + (this.weapon != null ? this.weapon.toString() : "Not Present") +
				//TODO class Spells implement to String
				"\n\tspells\t" + Arrays.toString(spells) +"\n";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public int getWis() {
		return wis;
	}

	public void setWis(int wis) {
		this.wis = wis;
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public int getCdSpecial() {
		return cdSpecial;
	}

	public void setCdSpecial(int cdSpecial) {
		this.cdSpecial = cdSpecial;
	}

	public boolean isSkipTurn() {
		return skipTurn;
	}

	public void setSkipTurn(boolean skipTurn) {
		this.skipTurn = skipTurn;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public Spell[] getSpells() {
		return spells;
	}

	public void setSpells(Spell[] spells) {
		this.spells = spells;
	}
}

