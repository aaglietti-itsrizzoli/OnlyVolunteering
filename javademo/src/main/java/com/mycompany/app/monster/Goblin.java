package com.mycompany.app.monster;

import com.mycompany.app.equip.Material;
import com.mycompany.app.equip.Weapon;
import com.mycompany.app.equip.WeaponType;

/**
 * Class extended from {@link Monster} <br>
 *
* */


public class Goblin extends Monster {

	String type;
	/**
	 * Special constructor to create a melee goblin or a ranged one
	* @param type
	* */
	public Goblin(String type) {
		this.type = type;

		if(type.equalsIgnoreCase("melee")){
			setDescription("A melee goblin");
			setDex(1);
			setStr(1);
			setHealth(7);
			setWis(0);
			setSpeed(10);
			setWeapon( new Weapon("Dagger", 1,1,0,0, Material.WOOD,"Simple dagger", WeaponType.DAGGER));
		}else if(type.equalsIgnoreCase("ranged")) {
			setDescription("A ranged goblin");
			setDex(1);
			setStr(1);
			setHealth(8);
			setWis(1);
			setWeapon(new Weapon("Bow", 1,1,1,1, Material.WOOD,"Simple bow", WeaponType.BOW));
		}
		setModifier();
	}

	public void setType(String type) {
		this.type = type;
	}
}
