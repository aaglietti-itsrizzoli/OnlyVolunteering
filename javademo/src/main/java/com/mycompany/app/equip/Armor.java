package com.mycompany.app.equip;

import java.util.Scanner;
/**
 * Class to define armor
 * Uses {@link Material} and {@link ArmorType}
 */



public class Armor {
	Scanner armorScan = new Scanner(System.in);

	private ArmorType armorType;
	private String name;
	private String description;
	private Material material;
	private int hpModifier;
	private int speedModifier;


	public Armor(ArmorType armorType, String name, String description, Material material) {
		this.armorType = armorType;
		this.name = name;
		this.description = description;
		this.material = material;
		this.hpModifier = 0;
		this.speedModifier = 0;

	}

	public Armor(ArmorType armorType, String name, String description, Material material, int hpModifier, int speedModifier) {
		this.armorType = armorType;
		this.name = name;
		this.description = description;
		this.material = material;

	}

	public Armor(){

	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public void setArmorType(ArmorType armorType) {
		this.armorType = armorType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public void setHpModifier(int hpModifier) {
		this.hpModifier = hpModifier;
	}

	public void setSpeedModifier(int speedModifier) {
		this.speedModifier = speedModifier;
	}

	@Override
	public String toString() {
		return "Armor:" +
				"armorType=" + armorType +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", material=" + material +
				", hpModifier=" + hpModifier +
				", speedModifier=" + speedModifier ;
	}

	public ArmorType getArmorType() {
		return armorType;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Material getMaterial() {
		return material;
	}

	public int getHpModifier() {
		return hpModifier;
	}

	public int getSpeedModifier() {
		return speedModifier;
	}
}
