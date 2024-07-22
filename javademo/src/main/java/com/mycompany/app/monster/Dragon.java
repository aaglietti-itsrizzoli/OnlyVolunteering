package com.mycompany.app.monster;

import com.mycompany.app.equip.Armor;
import com.mycompany.app.equip.ArmorType;
import com.mycompany.app.equip.Material;

public class Dragon extends Monster {
	Armor armor = new Armor(ArmorType.HEAVY,"Scale", "", Material.ADAMANTITE, 10, 10 );
	public Dragon(){
		setDex(7);
		setStr(7);
		setHealth(30);
		setWis(7);
		setSpeed(10);

		setDescription("The biggest dragon you have ever seen, the trees around hims looks like toothpick compared to him. On his head two large horns stands out, which are pointed backward their wings. A thick smell of sulfur and smoke come from him.\nThe heat rising from his body makes his silhouette blurred ");
		setModifier();
	}

}
