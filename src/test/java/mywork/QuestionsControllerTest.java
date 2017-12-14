package mywork;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.abc.springmvc.configuration.MyAppConfiguration;
import com.abc.springmvc.controller.QuestionsController;
import com.abc.springmvc.dao.QuestionsDaoImpl;
import com.abc.springmvc.model.IQQuestions;
import com.abc.springmvc.service.QuestionsServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes=MyAppConfiguration.class)
public class QuestionsControllerTest {

	@InjectMocks
	QuestionsController controller;

	private MockMvc mockMvc;

	@Spy
	QuestionsServiceImpl questionsService;
	
	@Spy
	QuestionsDaoImpl questionsDao;

	@Mock
	SessionFactory sessionFactory;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Ignore
	@Test
	public void shouldGetAllQuestions() throws Exception {
		List<IQQuestions> iqList = new ArrayList<>();
		when(sessionFactory.getCurrentSession()).thenReturn(mock(Session.class));
		when(questionsDao.findAllQuestions()).thenReturn(iqList);
		mockMvc.perform(get("/getAllQuestions")).andExpect(MockMvcResultMatchers.status().isOk());
	}

}
