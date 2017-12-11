package mywork;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.abc.springmvc.controller.DefaultController;

@RunWith(MockitoJUnitRunner.class)
public class DefaultControllerTest {
	
	@InjectMocks
	DefaultController controller;
	
	@Test
	public void shouldReturnTestPage(){
		String res = controller.testPage();
		assertThat(res, is(notNullValue()));
		assertThat(res, equalTo("manageStudents"));
	}

}
