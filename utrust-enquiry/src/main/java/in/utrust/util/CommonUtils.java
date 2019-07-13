package in.utrust.util;

import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
 public class CommonUtils {
	
	public static String createToken() 
	{
		return   UUID.randomUUID().toString()+System.currentTimeMillis();
 	}

}
