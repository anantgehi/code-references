package com.tester;

import java.util.HashMap;
import java.util.Scanner;
import static com.app.utils.ValidationRules.*;
import static com.app.utils.PopulateUtils.*;
import static com.app.utils.SerIOUtil.*;
import com.app.players.Player;

public class IPLTeam 
{
	public static void main(String[] args) 
	{
		try(Scanner sc = new Scanner(System.in))
		{
			HashMap<String, Player> teamList = populateMap(populateList());
			boolean flag = true;
			while(flag) 
			{
				try
				{
					System.out.println("\n1. Add Player"
												+ "\n2. Display IPL team"
												+ "\n3. Remove the player by its id"
												+ "\n4. Exit\n");
					
					System.out.print("Enter valid choice: ");
					
					switch(sc.nextInt()) 
					{
						case 1:
							System.out.println("Enter Player's ID, Name, Ranking, Points: ");
							Player p = validateInput(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble(), teamList);
							teamList.put(p.getPlayerId(), p);
							System.out.println("Player Added Succesfully");
						break;
					
						case 2:
							if(teamList.size()>=5)
								for(Player p1 : teamList.values())
									System.out.println(p1);
							else
								System.out.println(( 5 - teamList.size())+": more players you need to add");
						break;
					
						case 3:
							System.out.print("Enter Player ID: ");
							removeById(sc.next(), teamList);
						break;
					
						default:
							System.out.print("Enter File Path: ");
							serializeData(sc.next(), teamList);
							System.out.println("THANK YOU!!");
							flag=false;
						break;
					}
				}
				catch(Exception e) 
				{
					System.out.println(e);
					sc.nextLine();
				}
			}
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
}
