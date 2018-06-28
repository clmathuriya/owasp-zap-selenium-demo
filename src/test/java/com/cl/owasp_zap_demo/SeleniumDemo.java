package com.cl.owasp_zap_demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumDemo {

	
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		//java -jar selenium-server-standalone-3.13.0.jar -role node -hub http://localhost:4444/grid/register -Dwebdriver.gecko.driver=/Users/chhagan/Documents/workspace/owasp-zap-demo/geckodriver
		String PROXY = "localhost:8090";
		System.setProperty("webdriver.gecko.driver", "geckodriver");

		org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
		proxy.setHttpProxy(PROXY)
		     .setFtpProxy(PROXY)
		     .setSslProxy(PROXY);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.PROXY, proxy);
		capabilities.setCapability("marionette", true);

		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		driver.get("http://localhost:8080/login?from=%2F");
		SimpleZAPExample.main(args);

	}

}
