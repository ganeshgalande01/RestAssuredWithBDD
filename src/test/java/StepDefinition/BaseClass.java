package StepDefinition;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pageObjects.AddcustomerPage;
import pageObjects.Login_pge1;
import pageObjects.SearchCustomerPage;

public class BaseClass {

	public WebDriver driver;
	public Login_pge1 lp1;
	public AddcustomerPage addcust;
	public SearchCustomerPage searchcust;
	public Properties configprop;
	public Logger logger;
	
	protected String server1 = "https://gorest.co.in";
	protected static  RequestSpecification req_spec1 = null;
	protected static Response resp1 = null;
	protected String token = "748b6d7e9c8ed5900d9942cafc44a5b208b35990ca53792be17b20d9f27e809b";
	
	
	
	
	public static String Randomstring()
	{
		 String randomStr = RandomStringUtils.randomAlphabetic(5);
		 return (randomStr);
	}
	
	
	
}
