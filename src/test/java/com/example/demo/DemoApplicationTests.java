package com.example.demo;

import com.example.demo.employee.EmployeeService;
import com.example.demo.employee.JsonFromLink;
import com.example.demo.employee.UploadFileWithRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	JsonFromLink jsonFromLink = new JsonFromLink();
	UploadFileWithRequest uploadFileWithRequest = new UploadFileWithRequest();

	@Test
	void contextLoads() {
		jsonFromLink.getJsonFromHttpRequest();
	}

	@Test
	void testUploadFile() {
		//String urlString = "http://example.com/upload";
		String urlString = "https://ufile.io/depv42tn";
		//String filePath = "/path/to/your/file.txt";
		String filePath = "C:/Users/mila.dodeva/Desktop/test.vsdx";
		uploadFileWithRequest.uploadFile(urlString, filePath);
	}

}
