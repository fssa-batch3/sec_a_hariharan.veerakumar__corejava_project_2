package crazyFitness.validations.testUserValidation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import crazyFitness.validation.UserValidator;
import crazyFitness.validation.exceptions.InvalidUserException;

class TestValidateEmail {
	Throwable exception;
	@Test
	void testValidEmail() {
		try {
			assertTrue(UserValidator.validateEmail("hari10haran@gmail.com"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
			fail();
		}

	}

	@Test
	void testInvalidEmailMissingAtExpectValidation() {
		try {
			UserValidator.validateEmail("harigmail.com");
			 exception = assertThrows(InvalidUserException.class, () -> {
			});
			assertEquals("Invalid Email", exception.getMessage());
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}

	}

	@Test
	void testInvalidEmailMissingPeriodExpectException() {
		try {
			UserValidator.validateEmail("hari@gmailcom");
			 exception = assertThrows(InvalidUserException.class, () -> {
			});
			assertEquals("Invalid Email", exception.getMessage());
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}

	}
}
