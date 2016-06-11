package com.madhusudhan.jh.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@ContextConfiguration({"classpath:META-INF/spring/validation/validation-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerTest {
	/*private static Validator validator;*/
	
	@Autowired
	private LocalValidatorFactoryBean factory;

	/*@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}*/

	@Test
	public void customerIsValid() {
	    Validator validator = factory.getValidator();
	    User user = new User("James", "Bond");
	    user.setUserName(null);
	    Set<ConstraintViolation<User>> violations = validator.validate(user);
	    for(ConstraintViolation<User> violation : violations) {
	        System.out.println("Custom Message:- " + violation.getMessage());
	    }

	}
}
