package com.dchikitsa.dhph;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DHPProtocolBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("direct:ack").setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200))
				.setHeader(Exchange.CONTENT_TYPE, constant("application/json")).setBody()
				.constant("{\"message\":{\"ack\":{\"status\":\"ACK\"}}}");

		// >> From GATEWAY to Template >>

		from("jetty://{{url}}/search").wireTap("direct:search").to("direct:ack");
		from("jetty://{{url}}/select").wireTap("direct:select").to("direct:ack");
		from("jetty://{{url}}/init").wireTap("direct:init").to("direct:ack");
		from("jetty://{{url}}/confirm").wireTap("direct:confirm").to("direct:ack");
		from("jetty://{{url}}/status").wireTap("direct:status").to("direct:ack");

		// >> From Template to Hospital/Doctor Services >>

		from("direct:search").choice().when(method(SignVerify.class, "isVerified")).unmarshal().json()
				.to("velocity:searchTemplate.vm?contentCache=true")
				.log(">>from searchVelocity to queueSearch>> ${body}").to("activemq:{{queueSearch}}").otherwise()
				.log("unverifyed");

		from("direct:select").choice().when(method(SignVerify.class, "isVerified")).unmarshal().json().to("velocity:selectTemplate.vm?contentCache=true")
		.log(">>from selectVelocity to queueSelect>> ${body}").to("activemq:{{queueSelect}}");

		from("direct:init").choice().when(method(SignVerify.class, "isVerified")).unmarshal().json().to("velocity:initTemplate.vm?contentCache=true")
				.log(">>from initVelocity to queueInit>> ${body}").to("activemq:{{queueInit}}");

		from("direct:confirm").choice().when(method(SignVerify.class, "isVerified")).unmarshal().json().to("velocity:confirmTemplate.vm?contentCache=true")
				.log(">>from confirmVelocity to queueConfirm>> ${body}").to("activemq:{{queueConfirm}}");

		from("direct:status").choice().when(method(SignVerify.class, "isVerified")).unmarshal().json().to("velocity:statusTemplate.vm?contentCache=true")
				.log(">>from statusVelocity to queueStatus>> ${body}").to("activemq:{{queueStatus}}");

		// >> Back to GATEWAY >>

		from("activemq:{{queueOnSearch}}").unmarshal().json().log(">>from queueOnSearch to velocity>> ${body}")
				.to("velocity:initTemplate.vm?contentCache=true")
				.log(">>from onSearchVelocity to gateway on_search>> ${body}");

		// >> Back to EUI >>

		from("activemq:{{queueOnSelect}}").unmarshal().json().log(">>from queueOnSelect to velocity>> ${body}")
				.to("velocity:initTemplate4.vm?contentCache=true")
				.log(">>from onSelectVelocity to EUA on_select>> ${body}");

		from("activemq:{{queueOnConfirm}}").log(">>from queueOnConfirm to velocity>> ${body}")
				.to("velocity:onConfirmTemplate.vm?contentCache=true")
				.log(">>from onConfirmVelocity to EUA on_confirm>> ${body}");

		from("activemq:{{queueOnStatus}}").log(">>from queueOnStatus to velocity>> ${body}")
				.to("velocity:onStatusTemplate.vm?contentCache=true")
				.log(">>from onStatusVelocity to EUA on_status>> ${body}");

	}

}