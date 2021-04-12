package de.tekup.loan.soap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import de.tekup.loan.soap.service.LoanEligebleService;
import de.tekup.loan.soap.ws.loaneligebilty.CustomerRequest;
import de.tekup.loan.soap.ws.loaneligebilty.WsResponse;

@Endpoint
public class LoanEligebleEndPoint {
	
	public static final String nameSpace="http://www.tekup.de/loan/soap/ws/loanEligebilty";
	@Autowired
	LoanEligebleService service;
	
	@PayloadRoot(namespace = nameSpace, localPart = "CustomerRequest")
	@ResponsePayload
	public WsResponse getLoanStatus(@RequestPayload CustomerRequest customerRequest) {
		return service.checkLoanEligibilty(customerRequest);
	}

}
