package doc_repository_automation;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Scvp_Test_Scenarios {
	Scvp_Modular_Framework_Functions call_scenarios;

	@BeforeTest
	public void connect_driver_class() throws IOException {
		call_scenarios = new Scvp_Modular_Framework_Functions();
		call_scenarios = call_scenarios.return_class_context();
		call_scenarios.connect_chrome_driver();
	}

	@Test(priority = 0)
	private void user_login_scenario() {
		call_scenarios.user_login();
	}

	@Test(priority = 1)
	private void verify_Database() {
		call_scenarios.click_on_tab();	
	}
		
	@Test(priority = 4)
	private void verify_Daterange() {
		call_scenarios.verify_fromDate_toDate();
	}
	
	@Test(priority = 7)
	private void verify_Documenttype() {
		call_scenarios.verify_documentType();
	}
	
	@Test(priority = 3)
	private void  verify_Status() {
		call_scenarios.verify_status();
	}
	
	@Test(priority = 8)
	private void  verify_AckStatus() {
		call_scenarios.verify_ackStatus();
	}
	
	@Test(priority = 6)
	private void  verify_SenderType() {
		call_scenarios.verify_senderType();
	}
	
	
	@Test(priority = 2)
	private void  verify_ReceiverType() {
		call_scenarios.verify_receiverType();
	}
	
	@Test(priority = 5)
	private void  verify_SelectType() {
		call_scenarios.verify_selectType();
	}
	
	@Test(priority = 9)
	private void  searchByDocumentType() {
		call_scenarios.searchBy_documentType();
	}
	
	
	

	@Test(priority = 10)
	private void user_sign_out() throws InterruptedException {
		call_scenarios.user_signout();
	}

}
 