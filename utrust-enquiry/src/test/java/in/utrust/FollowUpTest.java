package in.utrust;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import in.utrust.response.UtrustResponse;
import in.utrust.service.EnquiryServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class FollowUpTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EnquiryServiceImpl enquiryService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getUserFollowUpDetailsWithPoId() throws Exception {
		String uri = "/api/v1/seller/enquiry/1";
		UtrustResponse utrustResponse = Mockito.mock(UtrustResponse.class);
		Mockito.when(enquiryService.getUserFollowUpDetailsByPO(1, null)).thenReturn(utrustResponse);
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON)).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
	}
	
}
