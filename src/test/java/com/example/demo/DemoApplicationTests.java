package com.example.demo;

import com.azure.messaging.eventhubs.EventData;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testSendEvent(){
		//List<EventData> allEvents = Arrays.asList(new EventData("Foo"), new EventData("Bar"));
		EventService es = new EventService();
		List<EventPayload> payloads = new ArrayList<>();
		EventPayload ep = new EventPayload();
		ep.setId("1");
		ep.setName("Name1");
		payloads.add(ep);
		es.sentEvent(payloads);
	}

}
