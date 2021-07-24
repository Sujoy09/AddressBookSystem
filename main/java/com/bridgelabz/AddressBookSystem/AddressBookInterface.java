package com.bridgelabz.AddressBookSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookInterface {
	ArrayList<ContactData> records = new ArrayList<ContactData>();

	public int fileCheck(String bookName) {
		File directory = new File("C:\\Users\\roysu\\eclipse-workspace\\AddressBookSystem\\src\\main\\resources");
		if (!directory.exists()) {
			return -1;
		} else {
			String fileName = bookName;
			File myTxtFile = new File(directory, fileName);
			if (myTxtFile.exists()) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public void createBookTxtFile(String bookName) {
		try {
			File directory = new File("C:\\Users\\roysu\\eclipse-workspace\\AddressBookSystem\\src\\main\\resources");
			if (!directory.exists()) {
				directory.mkdir();
			}
			String fileName = bookName;
			File myTxtFile = new File(directory, fileName + ".txt");
			if (!myTxtFile.exists()) {
				myTxtFile.createNewFile();
				System.out.println("New address book is created with name: " + myTxtFile.getName());
			} else {
				System.out.println("Address book with name " + myTxtFile.getName() + "already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public void writeBookTxtFile(String bookName, ContactData person) {
		try {
			File directory = new File("C:\\Users\\roysu\\eclipse-workspace\\AddressBookSystem\\src\\main\\resources");
			if (!directory.exists()) {
				System.out.println("Specified directory does not exists.");
			} else {
				String fileName = bookName;
				File myTxtFile = new File(directory, fileName + ".txt");
				if (myTxtFile.exists()) {
					FileWriter myWriter = new FileWriter(myTxtFile, true);
					BufferedWriter myBuffer = new BufferedWriter(myWriter);
					myBuffer.write(person.toString());
					myBuffer.close();
					System.out.println("Data successfully wrote to the file.");
				} else {
					System.out.println("Address book with name " + myTxtFile.getName() + " does not exists.");
				}
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public void addPersonToTxtFile(String firstName, String lastName, String address, String city, String state,
			String zip, String phoneNumber, String email, String addressBookName) {
		ContactData personObj = new ContactData(firstName, lastName, address, city, state, zip, phoneNumber, email);
		int result = personObj.findPhoneNumber(records, phoneNumber);
		if (result != -1) {
			System.out.println("The address book already has details with " + phoneNumber);
		} else {
			records.add(personObj);
			writeBookTxtFile(addressBookName, personObj);
			System.out.println();
			System.out.println("Information added successfully.\n");
		}
	}

	public void showBookFiles() {
		File directory = new File("C:\\Users\\iamat\\eclipse-workspace\\java-address-book-file-IO\\resources");
		if (directory.exists()) {
			File filesList[] = directory.listFiles();
			System.out.println("List of files in the specified directory (./resources):");
			for (File file : filesList) {
				System.out.println("File name: " + file.getName());
				System.out.println();
			}
		} else {
			System.out.println("Specified directory does not exists.");
		}
	}

	public void getBookTxtFile(String bookName) throws FileNotFoundException {
		File directory = new File("C:\\Users\\iamat\\eclipse-workspace\\java-address-book-file-IO\\resources");
		String fileName = bookName;
		File myTxtFile = new File(directory, fileName + ".txt");
		if (myTxtFile.exists()) {
			Scanner myReader = new Scanner(myTxtFile);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		} else {
			System.out.println("Address book with name " + myTxtFile.getName() + "does not exists.");
		}
	}
}
