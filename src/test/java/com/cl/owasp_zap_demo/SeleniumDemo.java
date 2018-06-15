package com.cl.owasp_zap_demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SeleniumDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String PROXY = "localhost:8090";
		System.setProperty("webdriver.gecko.driver", "geckodriver");

		org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
		proxy.setHttpProxy(PROXY)
		     .setFtpProxy(PROXY)
		     .setSslProxy(PROXY);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.PROXY, proxy);
		capabilities.setCapability("marionette", true);

		WebDriver driver = new FirefoxDriver(capabilities);
		driver.get("http://localhost:8080/login?from=%2F");
		SimpleZAPExample.main(args);

	}

}
