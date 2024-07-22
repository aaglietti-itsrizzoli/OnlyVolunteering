package com.mycompany.app.equip;

/**
 * Class to define weapon type<br>
 * Uses {@link Material} and {@link WeaponType}
* */

public class Weapon  {

	private String name;
	private int strModifier;
	private int  spModifier;
	private int dexModifier;
	private int wisModifier;
	private Material material;
	private String description;
	private WeaponType weaponType;

	public Weapon(String name, int strModifier, int spModifier, int dexModifier, int wisModifier,
				  Material material, String description, WeaponType weaponType) {
		this.name = name;
		this.strModifier = strModifier;
		this.spModifier = spModifier;
		this.dexModifier = dexModifier;
		this.wisModifier = wisModifier;
		this.material = material;
		this.description = description;
		this.weaponType = weaponType;
	}

	public Weapon(){}

	public void setName(String name) {
		this.name = name;
	}

	public void setStrModifier(int strModifier) {
		this.strModifier = strModifier;
	}

	public void setSpModifier(int spModifier) {
		this.spModifier = spModifier;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setWeaponType(WeaponType weaponType) {
		this.weaponType = weaponType;
	}

	public int getDexModifier() {
		return dexModifier;
	}

	public void setDexModifier(int dexModifier) {
		this.dexModifier = dexModifier;
	}

	public int getWisModifier() {
		return wisModifier;
	}

	public void setWisModifier(int wisModifier) {
		this.wisModifier = wisModifier;
	}

	public String getName() {
		return name;
	}

	public int getStrModifier() {
		return strModifier;
	}

	public int getSpModifier() {
		return spModifier;
	}

	public Material getMaterial() {
		return material;
	}

	public String getDescription() {
		return description;
	}

	public WeaponType getWeaponType() {
		return weaponType;
	}

	@Override
	public String toString() {
		return "Weapon:" +
				"weaponType=" + weaponType +
				", description='" + description + '\'' +
				", material=" + material +
				", wisModifier=" + wisModifier +
				", dexModifier=" + dexModifier +
				", spModifier=" + spModifier +
				", strModifier=" + strModifier +
				", name='" + name + '\'';
	}
}
