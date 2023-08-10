package crazyFitness.validations.testUserValidation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import crazyFitness.validation.UserValidator;
import crazyFitness.validation.exceptions.InvalidUserException;

 class TestValidateName {
		Throwable exception;
@Test
 void testValidName() {

	try {
		assertTrue(UserValidator.validateName("Hariharan"));
	} catch (InvalidUserException e) {
		e.printStackTrace();
		fail();
	}
}
@Test 
 void testInValidNameUsingNumbersExpectValidation() {
	try {
		UserValidator.validateName("123456");
		 exception = assertThrows(InvalidUserException.class, () -> {
		});
		assertEquals("Invalid name", exception.getMessage());
	} catch (InvalidUserException e) {
		e.printStackTrace();
	
	}

}
@Test
 void testInValidNameLesserLengthExpectValidation() {
	try {
	UserValidator.validateName("Ha");
		 exception = assertThrows(InvalidUserException.class, () -> {
		});
		assertEquals("Invalid name", exception.getMessage());
	} catch (InvalidUserException e) {
		e.printStackTrace();
		
	}
}
@Test
 void testInValidNameGreaterLengthExpectValidation() {

	try {
		UserValidator.validateName("Hariharanvhariharanvhariharanv");
			 exception = assertThrows(InvalidUserException.class, () -> {
			});
			assertEquals("Invalid name", exception.getMessage());
		} catch (InvalidUserException e) {
			e.printStackTrace();
			
		}
} 
}
