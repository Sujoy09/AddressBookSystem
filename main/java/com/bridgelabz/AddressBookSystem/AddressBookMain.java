package com.bridgelabz.AddressBookSystem;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain extends AddressBookInterface {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Welcome to the Address Book");
		AddressBookMain object = new AddressBookMain();
		object.displayOptions();
	}

	public void displayOptions() throws FileNotFoundException {
		HashMap<String, ArrayList<ContactData>> addressBook = new HashMap<String, ArrayList<ContactData>>();
		Scanner scanner = new Scanner(System.in);
		int option;
		int outerFlag = 0;
		while (outerFlag == 0) {
			System.out.println("Select from the following options:");
			System.out.println("1.Create new Address Book.");
			System.out.println("2.Display all Address Books.");
			System.out.println("3.Add person details in Address Book.");
			System.out.println("4.View details of an Address Book.");
			System.out.println("0.Exit");
			System.out.println("Enter your choice: ");
			option = scanner.nextInt();
			switch (option) {
			case 1:
				System.out.println("Creating a new Address Book...");
				System.out.println("Please provide the name for the Address Book: ");
				scanner.nextLine();
				String bookName = scanner.nextLine();
				createBookTxtFile(bookName);
				break;

			case 2:
				System.out.println("Displaying all Address Book(s) files in the specified directory..");
				showBookFiles();
				break;

			case 3:
				System.out.println("Editing records in the Address Book...");
				System.out.println("Displaying all Address Books");
				showBookFiles();
				System.out.println("Select from the Address Books list,");
				System.out.println("Name of Address Books you want to alter information in: ");
				scanner.nextLine();
				String addressBookName = scanner.nextLine();
				if (fileCheck(addressBookName) == 0) {
					System.out.println("Address book with name " + addressBookName + " does not exists.");
					break;
				} else if (fileCheck(addressBookName) == -1) {
					System.out.println("Specified directory does not exists.");
					break;
				}
				int choice;
				int innerflag = 0;
				while (innerflag == 0) {
					System.out.println("Select from the following options:");
					System.out.println("1.Add new person details in the address book");
					System.out.println("2.Display list of persons in address book");
					System.out.println("0.Exit");
					System.out.println("Enter your choice: ");
					choice = scanner.nextInt();
					switch (choice) {
					case 1:
						scanner.nextLine();
						System.out.println("Enter First Name: ");
						String var1 = scanner.nextLine();
						System.out.println("Enter Last Name: ");
						String var2 = scanner.nextLine();
						System.out.println("Enter Address: ");
						String var3 = scanner.nextLine();
						System.out.println("Enter City: ");
						String var4 = scanner.nextLine();
						System.out.println("Enter State: ");
						String var5 = scanner.nextLine();
						System.out.println("Enter Pin-Code: ");
						String var6 = scanner.nextLine();
						System.out.println("Enter Phone Number: ");
						String var7 = scanner.nextLine();
						System.out.println("Enter Email: ");
						String var8 = scanner.nextLine();
						addPersonToTxtFile(var1, var2, var3, var4, var5, var6, var7, var8, addressBookName);
						break;

					case 2:
						getBookTxtFile(addressBookName);
						break;

					case 0:
						innerflag = 1;
						break;

					default:
						System.out.println("Invalid choice.");
					}
				}
				break;

			case 4:
				System.out.println("Displaying all Address Books");
				showBookFiles();
				System.out.println("Select from the Address Books list,");
				System.out.println("Name of Address Books you want to alter information in: ");
				scanner.nextLine();
				String AddBookName = scanner.nextLine();
				getBookTxtFile(AddBookName);
				break;

			case 0:
				outerFlag = 1;
				break;

			default:
				System.out.println("Invalid choice.");
			}
		}
	}
}