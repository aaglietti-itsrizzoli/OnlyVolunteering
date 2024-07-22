package com.mycompany.app.monster;

import com.mycompany.app.equip.Weapon;
import com.mycompany.app.general.Action;
import com.mycompany.app.general.Player;

/**
 * This abstract class serve as blueprint for creating different type of monster. <br>
 * Defines the method setModifier for automatically calculate the weapon and armor modifiers <br>
 * Implements Action interface and need the playing character to be passed <br>
 * @see General.Action
 * */

public abstract class Monster implements Action{
	private int health;
	private int wis;
	private int speed;
	private int dex;
	private int str;
	private String description;

	boolean skipTurn = false;
	boolean potionUsed = false;

	int cdSpecial;
	Weapon weapon = new Weapon();

	public Monster(int health,  int wis, int speed, int dex, int str, Weapon weapon) {
		this.health = health;
		this.wis = wis;
		this.speed = speed;
		this.dex = dex;
		this.str = str;
		this.weapon = weapon;
	}

	public Monster() {
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return super.toString();
	}
	/**
	 * Void function to automatically set the weapon modifier
	 * @see Player#setModifier()
	 * */
	public void setModifier(){
		if(weapon != null){
			str = str + weapon.getStrModifier();
			speed = speed + weapon.getSpModifier();
			wis = wis + weapon.getWisModifier();
			dex = dex + weapon.getDexModifier();
		}

	}

	/**
	* Method implemented from {@link Action} for doing the light attack
	 * @return damage
	 *
	* */
	@Override
	public int attackLight() {
		if(this.str > this.dex) {
			return str + weapon.getStrModifier();
		}
		return dex + weapon.getDexModifier();
	}

	/**
	 * Method implemented from {@link Action} for doing the heavy attack
	 * @return damage
	 *
	 * */
	@Override
	public int attackHeavy() {
		skipTurn = true;

		if(this.str > this.dex){
			return 2 * str + weapon.getStrModifier();
		}
		return 2 * dex + weapon.getDexModifier();
	}

	/**
	 * Method implemented from {@link Action} for doing the special attack
	 * @return damage
	 *
	 * */
	@Override
	public int attackSpecial() {
		cdSpecial = Action.CD_SPECIAL;
		return str + wis + dex;
	}



	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getWis() {
		return wis;
	}

	public void setWis(int wis) {
		this.wis = wis;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
}
