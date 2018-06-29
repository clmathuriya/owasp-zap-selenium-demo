package com.cl.owasp_zap_demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class BasicTest {
  @Test
  public void f() throws MalformedURLException {

		// TODO Auto-generated method stub
		String PROXY = "localhost:8090";
		System.setProperty("webdriver.gecko.driver", "geckodriver_linux");

		org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
		proxy.setHttpProxy(PROXY)
		     .setFtpProxy(PROXY)
		     .setSslProxy(PROXY);
		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability(CapabilityType.PROXY, proxy);
		capabilities.setCapability("marionette", true);

		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		driver.get("http://localhost:8080/login?from=%2F");
		SimpleZAPExample.main(null);
  }
}
