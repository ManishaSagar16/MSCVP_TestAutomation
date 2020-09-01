package doc_repository_automation;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scvp_Modular_Framework_Functions {
	WebDriver driver = null;
	Scvp_POM_Functions objLogin;
	Properties load_configuration_details;

	public Scvp_Modular_Framework_Functions return_class_context() {
		// Create Login Page object
		return this;
	}

	protected WebDriver connect_chrome_driver() throws IOException {

		load_configuration_details = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/application.properties");
		load_configuration_details.load(file);
		WebDriverManager.chromedriver().driverVersion("85.0.4183.83").setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("enable-automation");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation");
		options.addArguments("--disable-gpu");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(load_configuration_details.getProperty("Url"));
		this.objLogin = new Scvp_POM_Functions(driver);
		return driver;
	}

	public Scvp_Modular_Framework_Functions user_login() {
		// Verify login page title
		objLogin.implicit_wait(50)
				.setUserName(load_configuration_details.getProperty("username"),
						load_configuration_details.getProperty("username_xpath"))
				.implicit_wait(50)
				.setPassword(load_configuration_details.getProperty("password"),
						load_configuration_details.getProperty("password_xpath"))
				.click_button_by_xpath(load_configuration_details.getProperty("login_button_xpath"))
				.implicit_wait(5000);
		// objLogin.close_driver(driver);
		return this;
	}

	public Scvp_Modular_Framework_Functions click_on_tab() {
		objLogin.verify_page_title(load_configuration_details.getProperty("verify_title")).implicit_wait(50)
				.click_button_by_xpath(load_configuration_details.getProperty("doc_repository_tab_xpath"))
				.implicit_wait(50)
				.click_button_by_xpath(load_configuration_details.getProperty("database_radio_button_xpath"))
				.implicit_wait(50);
		return this;
	}


	public Scvp_Modular_Framework_Functions verify_fromDate_toDate() {
		this.objLogin.get_fromDate_toDate(load_configuration_details.getProperty("from_date_to_date_cssSelector"));
		return this;
		
	}

	public Scvp_Modular_Framework_Functions verify_documentType() {
//		this.objLogin.select_dropdown(load_configuration_details.getProperty("documentType_value"), load_configuration_details.getProperty("documentType_xpath"));
		this.objLogin.click_button_by_xpath(load_configuration_details.getProperty("documentType_select_xpath"));
		this.objLogin.click_button_by_xpath(load_configuration_details.getProperty("documentType_xpath"));
		return this;
	}
	
	public Scvp_Modular_Framework_Functions searchBy_documentType() {
		verify_documentType();
		this.objLogin.click_button_by_xpath(load_configuration_details.getProperty("search_button_xpath"));
		// ---validate the data here---
		this.objLogin.click_button_by_xpath(load_configuration_details.getProperty("reset_button_xpath"));
		return this;
	}

	public Scvp_Modular_Framework_Functions verify_status()  {
		this.objLogin.click_button_by_xpath(load_configuration_details.getProperty("status_select_xpath"));
		this.objLogin.click_button_by_xpath(load_configuration_details.getProperty("status_xpath"));
		
		return this;
		
	}
	
	public Scvp_Modular_Framework_Functions verify_ackStatus() {
		this.objLogin.click_button_by_xpath(load_configuration_details.getProperty("ackStatus_select_xpath"));
		this.objLogin.click_button_by_xpath(load_configuration_details.getProperty("ackStatus_xpath"));
		
		return this;
	}
	
	public Scvp_Modular_Framework_Functions verify_senderType() {
		this.objLogin.click_button_by_xpath(load_configuration_details.getProperty("senderType_select_xpath"));
		this.objLogin.click_button_by_xpath(load_configuration_details.getProperty("senderType_xpath"));
		
		return this;
		
	}
	
	public Scvp_Modular_Framework_Functions verify_receiverType() {
		this.objLogin.click_button_by_xpath(load_configuration_details.getProperty("receiverType_select_xpath"));
		this.objLogin.click_button_by_xpath(load_configuration_details.getProperty("receiverType_xpath"));
		return this;
	}
	
	public Scvp_Modular_Framework_Functions verify_selectType() {
		this.objLogin.click_button_by_xpath(load_configuration_details.getProperty("selectType_select_xpath"));
		this.objLogin.click_button_by_xpath(load_configuration_details.getProperty("selectType_xpath"));
		return this;
	}
	
	
	
	
	
	public Scvp_Modular_Framework_Functions user_signout() throws InterruptedException {
		Thread.sleep(2000);
		objLogin.click_logo(load_configuration_details.getProperty("user_logo_xpath")).implicit_wait(10)
				.click_button_by_xpath(load_configuration_details.getProperty("user_logout_button"))
				.close_driver(driver);
		return this;
	}
}
