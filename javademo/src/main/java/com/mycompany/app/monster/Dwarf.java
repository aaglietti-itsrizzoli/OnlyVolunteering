package com.mycompany.app.monster;

import com.mycompany.app.equip.Material;
import com.mycompany.app.equip.Weapon;
import com.mycompany.app.equip.WeaponType;

public class Dwarf extends Monster {
	public Dwarf(){
		setDex(1);
		setStr(2);
		setHealth(15);
		setWis(0);
		setSpeed(5);
		setWeapon(new Weapon("Hammer",
				2,
				1,
				2,
				2,
				Material.STEEL,
				"A common axe",
				WeaponType.HAMMER ));
		setDescription("A Dwarf with a hammer");
		setModifier();

	}
}
