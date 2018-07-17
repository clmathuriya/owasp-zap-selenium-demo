package com.cl.owasp_zap_demo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class BasicTest {
  @Test
  public void demo() throws MalformedURLException {

		// TODO Auto-generated method stub
		String PROXY = "localhost:8090";
		System.setProperty("webdriver.gecko.driver", new File("geckodriver").getAbsolutePath());
		System.setProperty("webdriver.chrome.driver", new File("chromedriver_linux").getAbsolutePath());

		org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
		proxy.setHttpProxy(PROXY)
		     .setFtpProxy(PROXY)
		     .setSslProxy(PROXY);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.PROXY, proxy);
		//capabilities.setCapability("marionette", true);
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");

		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		driver.get("http://localhost:8080/login?from=%2F");
		//SimpleZAPExample.main(null);
  }
}
