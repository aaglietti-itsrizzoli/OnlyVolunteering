package com.mycompany.app.monster;

import com.mycompany.app.equip.Material;
import com.mycompany.app.equip.Weapon;
import com.mycompany.app.equip.WeaponType;

public class Gnome extends Monster {
	public Gnome(){
		setDex(1);
		setStr(1);
		setHealth(5);
		setWis(0);
		setSpeed(10);
		setWeapon(new Weapon("Axe",
				2,
				1,
				0,
				0,
				Material.IRON,
				"A common axe",
				WeaponType.AXE ));
		setDescription("A gnome with an axe");
		setModifier();

	}
}
