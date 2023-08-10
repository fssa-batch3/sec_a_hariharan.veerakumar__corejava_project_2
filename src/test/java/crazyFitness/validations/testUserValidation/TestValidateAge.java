package crazyFitness.validations.testUserValidation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import crazyFitness.validation.UserValidator;
import crazyFitness.validation.exceptions.InvalidUserException;

 class TestValidateAge {
@Test
 void testValidAge(){
	try {
		assertTrue(UserValidator.validateAge(19));
	} catch (InvalidUserException e) {
		e.printStackTrace();
		fail();
	}
	}
 
@Test
 void testExpectInvalidUserException(){
	try{
		UserValidator.validateAge(-19);
	Throwable exception = assertThrows(InvalidUserException.class, () -> {
	});
	assertEquals("Invalid Age",exception.getMessage());
	} catch(InvalidUserException e) {
		e.printStackTrace();
	}
}

}
 