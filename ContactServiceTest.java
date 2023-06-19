package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

	// this creates contacts with a unique ID using the ContactService addContact method
	@Test
	void testContactServiceClass() {
		ContactService.addContact("Jacob", "Perry", "5550005555", "10 Main Street");
		//System.out.println(ContactService.contactList.get(0).getFirstName());  used for debugging while writing tests
		assertTrue(ContactService.contactList.get(0).getID().equals("1000000002"));
		assertTrue(ContactService.contactList.get(0).getFirstName().equals("Jacob"));
		assertTrue(ContactService.contactList.get(0).getLastName().equals("Perry"));
		assertTrue(ContactService.contactList.get(0).getPhone().equals("5550005555"));
		assertTrue(ContactService.contactList.get(0).getAddress().equals("10 Main Street"));
	}
	
	// confirm deletion of a contact
	@Test
	void testContactServiceDelete() {
		ContactService.addContact("Jacob", "Perry", "5550005555", "10 Main Street");
		ContactService.deleteContact("1000000003");
		assertTrue(ContactService.searchContact("1000000003") == 2);
	}
	
	// testing first name update
	@Test
	void testContactServiceUpdateFirstName() {
		ContactService.addContact("Johnny", "Begood", "5558675309", "Valens Lane");
		int size = ContactService.contactList.size();
		System.out.println(ContactService.contactList.get(size - 1).getID());
		System.out.println(ContactService.contactList.get(size - 1).getFirstName());
		ContactService.updateFirstName("1000000003", "Aaron");
		System.out.println(ContactService.contactList.get(size - 1).getFirstName());
		assertTrue(ContactService.contactList.get(size - 1).getFirstName().equals("Aaron"));
	}

	// testing last name update
	@Test
	void testContactServiceUpdateLastName() {
		int size = ContactService.contactList.size();
		ContactService.updateLastName("1000000003", "McSharon");
		assertTrue(ContactService.contactList.get(size - 1).getLastName().equals("McSharon"));
	}
	
	// testing phone update
	@Test
	void testContactServiceUpdatePhone() {
		int target = 0;
		target = ContactService.findIndex("1000000003");
		ContactService.updatePhone("1000000003", "0987654321");
		assertTrue(ContactService.contactList.get(target).getPhone().equals("0987654321"));
	}
	
	// test address update
	@Test
	void testContactServiceUpdateAddress() {
		int target = 0;
		target = ContactService.findIndex("1000000003");
		ContactService.updateAddress("1000000003", "400 North Pole Ave");
		assertTrue(ContactService.contactList.get(target).getAddress().equals("400 North Pole Ave"));
	}
	
	// test to verify ID is unique
	@Test
	void testContactServiceUniqueId() {
		Contact newContact = new Contact("54321", "Yikes", "Scoob", "8880008888", "5 Main Street");
		ContactService.addContact(newContact);
		Contact duplicateId = new Contact("54321", "Yikes", "Scoob", "8880008888", "5 Main Street");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.addContact(duplicateId);
		});
	}

}
