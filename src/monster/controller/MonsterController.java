package monster.controller;

import java.util.Scanner;

import monster.model.MarshmallowMonster;

import monster.view.MonsterDisplay;

import java.util.ArrayList;

import java.util.List;

public class MonsterController
{
	
	private MonsterDisplay popup;
	private List<MarshmallowMonster> monsterList;
	public MonsterController()
	{
		popup= new MonsterDisplay();
		//Conectors initialize data members
		monsterList = new ArrayList<MarshmallowMonster>();
	}
	
	
	//Help make sure my program doesn't crash and burn
	//Helper methods
	private boolean isValidInteger(String sample)
	{
		boolean valid = false;
		
		try
		{
			Integer.parseInt(sample);
			valid = true;
		}
		catch(NumberFormatException error)
		{
			popup.displayText("Only integer values are valid: " + sample + " is not.");
		}
		
		return valid;
	}
	
	private boolean isValidDouble(String sampleDouble)
	{
		boolean valid = false;
		
		try
		{
			Double.parseDouble(sampleDouble);
			valid = true;
		}
		catch(NumberFormatException error)
		{
			popup.displayText("Only double values are valid: " + sampleDouble + "is not.");
		}
		
		return valid;
	}
	
	private boolean isValidBoolean(String sampleBoolean)
	{
		boolean valid = false;
		
		try
		{
			Boolean.parseBoolean(sampleBoolean);
			valid = true;
		}
		catch(NumberFormatException error)
		{
			popup.displayText("Only boolean values are valid: " + sampleBoolean + "is not.");
		}
		
		return valid;
	}
	
	public void start()
	{
//		boolean finished = true;
//		int count = 0;
//		while(count < 100)	
//		{
//			popup.displayText("I am so neat");
//			count += 1;
//		}
//		
//		for(int loop = 0; loop < 15; loop +=1)
//		{
//			popup.displayText("I am looping " + (loop + 1) + " times out of 15");
//		}
		
		
		MarshmallowMonster sample = new MarshmallowMonster();
//		System.out.println(sample);
		popup.displayText(sample.toString());
		MarshmallowMonster realMonster = new MarshmallowMonster("Josh", 2, 2, 3, false);
		
//		System.out.println(realMonster);;
		popup.displayText(realMonster.toString());
//		System.out.println("Mason is hungry, so he is going to eat Josh's arms");
		popup.displayText("Mason is hungry, so he is going to eat Josh's arms");
		realMonster.setTentacleAmount(0);
//		System.out.println(realMonster);
		popup.displayText(realMonster.toString());
		monsterList.add(realMonster);
		monsterList.add(sample);
		testList();
		
		interactWithTheMonster(realMonster);
	}
	
	private void testList()
	{
		for(int index = 0; index < monsterList.size(); index++)
		{
			MarshmallowMonster currentMonster = monsterList.get(index);
			popup.displayText(currentMonster.getName());
			String newName = popup.getResponse("What should my new name be???");
			currentMonster.setName(newName);
			popup.displayText(currentMonster.getName());
		}
		
		for(MarshmallowMonster current : monsterList)
		{
			popup.displayText(current.getName());
			String newName = popup.getResponse("What should my new new name be???");
			current.setName(newName);
			popup.displayText(current.getName());
		}
	}
	
	private void interactWithTheMonster(MarshmallowMonster currentMonster)
	{
//		System.out.println(currentMonster.getName() + " wants to know what to eat next");
		popup.displayText(currentMonster.getName() + " wants to know what to eat next");
//		System.out.println(currentMonster.getName() + " suggests arms, they have " + currentMonster.getArmCount());
		popup.displayText(currentMonster.getName() + " suggests arms, they have " + currentMonster.getArmCount());
//		System.out.println("How many do you want to eat?");
		int specialAnswer;
		String unconverted = popup.getResponse("How many do you want to eat?");
		
		while(!isValidInteger(unconverted))
		{
			popup.displayText("Try again!");
			unconverted = popup.getResponse("How many arms?????");
		}
		
		if(isValidInteger(unconverted))
		{
			specialAnswer = Integer.parseInt(unconverted);
		}
		
		specialAnswer = Integer.parseInt(unconverted);
		
		Scanner myScanner = new Scanner(System.in);
		int consumed = 0;
		consumed = specialAnswer;
		
		currentMonster.setArmCount(currentMonster.getArmCount() - consumed);
		System.out.println("Ok, now " + currentMonster.getName() + " has " + currentMonster.getArmCount() + " arms left.");
		
		if(consumed < 0)
		{
//			System.out.println("You cannot eat a negative amount silly human");
			popup.displayText("You cannot eat a negative amount silly human");
			consumed = 0;
		}
		else if(consumed == 0)
		{
//			System.out.println("Not that hungry are you?");
			popup.displayText("Not that hungry are you?");
		}
		else if(consumed > currentMonster.getArmCount())
		{
//			System.out.println("This is impossible - I only have " + currentMonster.getArmCount() + " arms!!!");
			popup.displayText("This is impossible - I only have " + currentMonster.getArmCount() + " arms!!!");
		}
		else
		{
			currentMonster.setArmCount(currentMonster.getArmCount() - consumed);
//			System.out.println("Thank you so much! I only have this many arms now: " + currentMonster.getArmCount());
			popup.displayText("Thank you so much! I only have this many arms now: " + currentMonster.getArmCount());
		}
		
		if(consumed < 0)
		{
			System.out.println("You can't eat something that isnt there you idiot.");
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
