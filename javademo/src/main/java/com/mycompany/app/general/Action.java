package com.mycompany.app.general;

public interface Action{
	/*Constant for monster and player*/
	int CD_SPECIAL = 3;
	int MAX_SPELL = 4;
	/**
	 * One of the method used during the {@link General.Game#encounter(Player, Monster...)} for doing a basic attack
	 * @return damage
	* */
	int attackLight();


	/**
	 * One of the method used during the {@link General.Game#encounter(Player, Monster...)} for doing a powerful attack
	 * @return damage
	 * */
	int attackHeavy();


	/**
	 * One of the method used during the {@link General.Game#encounter(Player, Monster...)} for doing the most powerful attack
	 * @return damage
	 * */
	int attackSpecial();
}
