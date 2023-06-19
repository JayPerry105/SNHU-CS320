package test;

import java.util.ArrayList;	// to allow arrayList functionality

public class ContactService {
	
	public static String publicId;
	public String publicFirstName;
	public String publicLastName;
	public String publicPhone;
	public String publicAddress;
	
	static ArrayList<Contact> contactList = new ArrayList<Contact>(0);
	
	public static String generateUniqueId() {
		String uniqueId;
		// start with a base ID if array is empty
		if (contactList.isEmpty()) {
			publicId = "1000000001";
		}
		//gets the highest value in list when populated
		else {
			int arraySize = contactList.size();
			publicId = contactList.get(arraySize - 1).getID();
		}
		
		//convert ID to int, increment, and convert back to string
		int pHolder = Integer.valueOf(publicId);
		pHolder += 1;
		uniqueId = Integer.toString(pHolder);
		return uniqueId;
	}
	
	public static void addContact(String firstName, String lastName, String phone, String address) {
		String ID = generateUniqueId();
		Contact Contact1 = new Contact(ID, firstName, lastName, phone, address);
		contactList.add(Contact1);
	}
	// contact integration for unit tests 
	public static void addContact(Contact newContact) {
		String tempId = newContact.getID();
		for (int i = 0; i < contactList.size(); i++) {
			if (tempId.equals(contactList.get(i).getID())) {
				throw new IllegalArgumentException("Contact ID Must Be Unique");
			}
		}
		contactList.add(newContact);
	}
	
	public static void updateFirstName(String uniqueId, String publicFirstName) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getID()) == 0) {
			contactList.get(i).setFirstName(publicFirstName);
			}
		}
	}
	public static void updateLastName(String uniqueId, String publicLastName) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getID()) == 0) {
			contactList.get(i).setLastName(publicLastName);
			}
		}
	}
	public static void updatePhone(String uniqueId, String publicPhone) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getID()) == 0) {
			contactList.get(i).setPhone(publicPhone);
			}
		}
	}
	public static void updateAddress(String uniqueId, String publicAddress) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getID()) == 0) {
			contactList.get(i).setAddress(publicAddress);
			}
		}
	}
	
	public static void deleteContact(String uniqueId) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getID()) == 0) {
				int loca = i;
				contactList.remove(loca);
			}
		}
	}
	
	
	public static int searchContact(String uniqueId) {
		int endID = 0;
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getID()) == 0) {
				endID = 1;
			}
			else {
				endID = 2;
			}
		}
		return endID;
	}

	public static int findIndex(String idNo) {
		int ind = 0;
		for (int i = 0; i < contactList.size(); i++) {
			if (idNo.compareTo(contactList.get(i).getID()) == 0) {
				ind = i;
			}
		}
		return ind;
	}
		
}
