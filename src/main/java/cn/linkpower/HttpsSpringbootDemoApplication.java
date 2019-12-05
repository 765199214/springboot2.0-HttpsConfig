package cn.linkpower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@SpringBootApplication
@RestController
public class HttpsSpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HttpsSpringbootDemoApplication.class, args);
	}
	
	@RequestMapping("/")
	public Object test(){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", 200);
		jsonObject.put("msg", "ok");
		jsonObject.put("data", "66666");
		return jsonObject;
	}

}
