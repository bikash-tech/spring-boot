/*package in.utrust;

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

import in.utrust.service.EnquiryService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EnquiryService userService;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void signIn() throws Exception {
		String uri = "/api/v1/user/login";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
				.content(createUserInJson(12, "wew", "wdfedsdf", "WEB"))).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
	@Test
	public void getAccessToken() throws Exception {
		String uri = "/api/v1/user/access-token";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
				.header("refresh_token",
						"a9844884-303b-40bb-a2c5-d802322cc62381554786380092").header("uctdmsId", 12)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
	private static String createUserInJson(Integer uctdmsId, String password, String deviceId, String platform) {
		return "{ \"uctdmsId\": \"" + uctdmsId + "\", " + "\"deviceId\":\"" + deviceId + "\"," + "\"platform\":\""
				+ platform + "\""+ "}";
	}
}
*/