package com.mycompany.app.monster;

import com.mycompany.app.equip.Material;
import com.mycompany.app.equip.Weapon;
import com.mycompany.app.equip.WeaponType;

public class Elf extends Monster {
	public Elf() {
		setDex(3);
		setStr(2);
		setHealth(7);
		setWis(4);
		setSpeed(15);
		setWeapon(new Weapon("Bow",
				2,
				1,
				2,
				2,
				Material.SILVER,
				"A common axe",
				WeaponType.BOW ));
		setDescription("An elf with a bow");
		setModifier();

	}
}
