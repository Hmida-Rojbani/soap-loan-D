package de.tekup.loan.soap.service;

import java.util.List;

import org.springframework.stereotype.Service;

import de.tekup.loan.soap.ws.loaneligebilty.CustomerRequest;
import de.tekup.loan.soap.ws.loaneligebilty.WsResponse;

@Service
public class LoanEligebleService {
	
	public WsResponse checkLoanEligibilty(CustomerRequest customerRequest) {
		WsResponse wsResponse = new WsResponse();
		
		List<String> mismatchCriteria = wsResponse.getCriteriaMismatch();
		
		if (!(customerRequest.getAge()>=30 && customerRequest.getAge() < 50)) {
			mismatchCriteria.add("Client age must be between 30 and 50");
		}
		if (!(customerRequest.getYearlyIncome() > 20000 )) {
			mismatchCriteria.add("Client minimum income must be over 20000");
		}
		if (!(customerRequest.getCibilScore() > 500)) {
			mismatchCriteria.add("Client cibil score must be over 500");
		}
		if(mismatchCriteria.size()>0) {
			wsResponse.setApprovedAmount(0);
			wsResponse.setIsEligeble(false);
		}
		else {
			wsResponse.setApprovedAmount(15000);
			wsResponse.setIsEligeble(true);
		}
		
		return wsResponse; 
		
		
	}

}
