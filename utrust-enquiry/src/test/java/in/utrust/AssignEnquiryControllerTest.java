package in.utrust;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test; 
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import in.utrust.service.EnquiryServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AssignEnquiryControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EnquiryServiceImpl userService;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void assignEnquiry() throws Exception {
		String uri = "/api/v1/seller/assign-enquery";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.header("uctdmsId", 567910)
				.content(assignEnquiryReq(123, "ENQ_0912"))).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	private static String assignEnquiryReq(Integer assigenedTo, String enquiryNumber) {
		return "{ \"assigenedTo\": \"" + assigenedTo + "\", " + "\"enquiryNumber\":\"" + enquiryNumber+"\""+
				"}";
	}
} 
