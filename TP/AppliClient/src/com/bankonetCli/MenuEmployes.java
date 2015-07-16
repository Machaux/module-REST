package com.bankonetCli;

import java.util.Scanner;

import com.bankonet.Service.EmployeService;


public class MenuEmployes {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int esc = 1;
		
		
		while (esc !=0)
		{
			System.out.println("0. arr�ter le programme");
			System.out.println("1. Lister les employ�s");
			System.out.println("2. Rechercher un employ� par ID");
			
			int choice = sc.nextInt();
			
			switch (choice) {
			
			case 0:
				System.out.println("fermeture du programme");
				return;
			
			case 1:
				System.out.println(EmployeService.getEmploye());
				System.out.println("tata");
				break;
				
			case 2:
				System.out.println("employ� par ID");
				return;
				
			default:
				break;
			}
		}
	}

}
