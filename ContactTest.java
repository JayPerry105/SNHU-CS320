package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import task.Task;

class ContactTest {

	@Test
	void testContactClass() {
		Contact contactClass = new Contact("1234", "Jacob", "Perry", "5555555555", "10 Main Street");
		assertTrue(contactClass.getID().equals("1234"));
		assertTrue(contactClass.getFirstName().equals("Jacob"));
		assertTrue(contactClass.getLastName().equals("Perry"));
		assertTrue(contactClass.getPhone().equals("5555555555"));
		assertTrue(contactClass.getAddress().equals("10 Main Street"));
	}
	
	@Test
	void testContactClassTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678910", "Jacob", "Perry", "5555555555", "10 Main Street");
		});     }
	
	@Test
	void testFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789", "JacobTooLong", "Perry", "5555555555", "10 Main Street");
		});     }
	
	@Test
	void testLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789", "Jacob", "PerryTooLong", "5555555555", "10 Main Street");
		});     }
	
	@Test
	void testPhoneNot10Digits() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789", "Jacob", "Perry", "555555555500", "10 Main Street");
		});     }
	
	@Test
	void testAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789", "Jacob", "Perry", "5555555555", "This address is now too long but I hope the test passes!");
		});     }
	
	@Test
	void testValidInput() {
		Assertions.assertAll(() -> {
			new Contact("123456789", "Jacob", "Perry", "5555555555", "10 Main Street");
		});     }
	
	}



