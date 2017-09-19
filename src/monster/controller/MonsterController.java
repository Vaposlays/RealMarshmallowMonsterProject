package monster.controller;

import java.util.Scanner;

import monster.model.MarshmallowMonster;

public class MonsterController
{
	public void start()
	{
		MarshmallowMonster sample = new MarshmallowMonster();
		System.out.println(sample);
		MarshmallowMonster realMonster = new MarshmallowMonster("Josh", 2, 2, 3, false);
		
		System.out.println(realMonster);;
		System.out.println("Mason is hungry, so he is going to eat Josh's arms");
		realMonster.setTentacleAmount(0);
		System.out.println(realMonster);
		
		interactWithTheMonster(realMonster);
	}
	
	private void interactWithTheMonster(MarshmallowMonster currentMonster)
	{
		System.out.println(currentMonster.getName() + " wants to know what to eat next");
		System.out.println(currentMonster.getName() + " suggests arms, they have " + currentMonster.getArmCount());
		System.out.println("How many do you want to eat?");
		Scanner myScanner = new Scanner(System.in);
		int consumed = myScanner.nextInt();
		currentMonster.setArmCount(currentMonster.getArmCount() - consumed);
		System.out.println("Ok, now " + currentMonster.getName() + " has " + currentMonster.getArmCount() + " arms left.");
		
		if(consumed < 0)
		{
			System.out.println("You cannot eat a negative amount silly human");
			consumed = 0;
		}
		else if(consumed == 0)
		{
			System.out.println("Not that hungry are you?");
		}
		else if(consumed > currentMonster.getArmCount())
		{
			System.out.println("This is impossible - I only have " + currentMonster.getArmCount() + " arms!!!");
		}
		else
		{
			currentMonster.setArmCount(currentMonster.getArmCount() - consumed);
			System.out.println("Thank you so much! I only have this many arms now: " + currentMonster.getArmCount());
		}
		
		if(consumed < 0)
		{
			System.out.println("You can't eat something that isnt there you idiot.");
			consumed = 0;
		}
		else if(consumed == 0)
		{
			System.out.println("You must not be that hungry, thats too bad.");
		}
		else if(consumed > currentMonster.getEyeCount())
		{
			System.out.println("This is impossible - I only have " + currentMonster.getEyeCount() + " eyes!!!");
		}
		else
		{
			currentMonster.setEyeCount(currentMonster.getEyeCount() - consumed);
			System.out.println("Hey thanks man! Thanks to you now I only have " + currentMonster.getEyeCount() + " eyes now.");
		}
	}
}
