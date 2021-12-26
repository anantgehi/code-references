package com.tester;

import java.util.HashMap;
import java.util.Scanner;

import com.app.players.Player;
import static com.app.utils.DeSerIOUtil.*;
public class DeserializeTeamList 
{
	public static void main(String[] args) 
	{
		try(Scanner sc = new Scanner(System.in))
		{
			System.out.println("Enter File Path: ");
			HashMap<String,Player> teamList = deserializeData(sc.next());
			teamList.values().forEach(System.out::println);
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
}
