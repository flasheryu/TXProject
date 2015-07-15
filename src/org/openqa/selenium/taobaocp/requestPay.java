package org.openqa.selenium.taobaocp;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

import org.openqa.selenium.config.cpConfig;

public class requestPay  {
//  	public static void main(String[] args) {
  	public static void pay(String configFile, int numOrder) {
    	
//		String configFile = "config/cncbConfig.pty";
//		String configFile = "config/ccbConfig.pty";
//		String configFile = "config/cmbConfig.pty";
//		String configFile = "config/icbcConfig.pty";
		Properties configPty = cpConfig.readPty(configFile);			
		
		String payer = configPty.getProperty("payer");

        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
//    	System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox");
    	System.setProperty("webdriver.firefox.bin", "//Applications///Google Chrome.app//Contents//MacOS//Google Chrome");
    	WebDriver driver = new FirefoxDriver();
        
        // open 我的淘宝  page
        driver.get("http://i.taobao.com/my_taobao.htm");
        driver.findElement(By.id("J_SubmitQuick")).click(); //go to login page
        
        // username and password, this should be protected and read from some config file
//        driver.findElement(By.id("J_Quick2Static")).click(); //go to login page
//        WebElement usr = driver.findElement(By.id("TPL_username_1"));
//        usr.sendKeys("username");
//        WebElement pw = driver.findElement(By.id("TPL_password_1"));
//        pw.sendKeys("password");
//        pw.submit();

        new WebDriverWait(driver, 10).until (new ExpectedCondition<Boolean>() {  
        	@Override  
    	    public Boolean apply(WebDriver driver) {  
    	        Boolean result = false;  
    	        try {  
    	            driver.findElement(By.linkText("我的彩票"));  
    	            result = true;  
    	        } catch(Exception e){         
    	        }  
    	        return result;  
    	    }  
    	});          
        driver.findElement(By.linkText("我的彩票")).click();
 
        new WebDriverWait(driver, 10).until (new ExpectedCondition<Boolean>() {  
    	    @Override  
    	    public Boolean apply(WebDriver driver) {  
    	        Boolean result = false;  
    	        try {  
    	            driver.findElement(By.linkText("足球单场"));  
    	            result = true;  
    	        } catch(Exception e){         
    	        }  
    	        return result;  
    	    }  
        }); 
        //点击付款进入收银台 and switch to new window
//        driver.findElement(By.xpath("(//tbody//tr//td//span//a//img)[2]")).click();
        driver.findElement(By.xpath("(//tbody//tr//td//span//a//img)["+numOrder+"]")).click();
      
  	  	for (String handle : driver.getWindowHandles()) {
  	  		driver.switchTo().window(handle);
  	  	}   	  
        new WebDriverWait(driver, 20).until (new ExpectedCondition<Boolean>() {  
    	    @Override  
    	    public Boolean apply(WebDriver driver) {  
    	        Boolean result = false;  
    	        try {  
    	            driver.findElement(By.linkText("找人代付"));  
    	            result = true;  
    	        } catch(Exception e){         
    	        }  
    	        return result;  
    	    }  
        });  	  
        driver.findElement(By.linkText("找人代付")).click();
        

  	  	for (String handle : driver.getWindowHandles()) {
  	  		driver.switchTo().window(handle);
  	  	}   
        new WebDriverWait(driver, 20).until (new ExpectedCondition<Boolean>() {  
      	    @Override  
      	    public Boolean apply(WebDriver driver) {  
      	        Boolean result = false;  
      	        try {  
      	            driver.findElement(By.xpath("//area[@title='关闭演示，立即体验']"));  
      	            result = true;  
      	        } catch(Exception e){         
      	        }  
      	        return result;  
      	    }  
          });  	  	  
        driver.findElement(By.xpath("//area[@title='关闭演示，立即体验']")).click();
     
        new WebDriverWait(driver, 20).until (new ExpectedCondition<Boolean>() {  
    	    @Override  
    	    public Boolean apply(WebDriver driver) {  
    	        Boolean result = false;  
    	        try {  
    	            driver.findElement(By.xpath("//input[@id='F-showname']"));  
    	            result = true;  
    	        } catch(Exception e){         
    	        }  
    	        return result;  
    	    }  
        });  	  
//        <input value="" data-editing="off" ui-form-explain="" smartracker="on" seed="applyForm-FShowname" id="F-showname" class="ui-input" placeholder="支付�?账户/淘�?账户(昵称)" tabindex="1" autocomplete="off" type="text">
        WebElement placeholder = driver.findElement(By.xpath("//input[@id='F-showname']"));
        placeholder.sendKeys(payer+Keys.TAB); //代付人:payer: 
        
        new WebDriverWait(driver, 20).until (new ExpectedCondition<Boolean>() {  
      	    @Override  
      	    public Boolean apply(WebDriver driver) {  
      	        Boolean result = false;  
      	        try {  
      	            driver.findElement(By.linkText("亲情永恒"));  
      	            result = true;  
      	        } catch(Exception e){         
      	        }  
      	        return result;  
      	    }  
          });  	        
        
        int reason=randomInt.randomAddon(0, 3);
        System.out.println("In requestPay:pay(String configFile, int numOrder):: request pay reason="+reason);
        switch (reason){
        	case 0:	driver.findElement(By.linkText("江湖告急")).click();	break;
        	case 1:	driver.findElement(By.linkText("甜蜜撒娇")).click();	break;
        	case 2:	driver.findElement(By.linkText("亲情永恒")).click();	break;
        	case 3:	driver.findElement(By.linkText("威逼利诱")).click();	break;
        }
//        driver.findElement(By.linkText("亲情永恒")).click(); //江湖告急，甜蜜撒娇，亲情永恒，威逼利诱，generate randomly? :
    
        new WebDriverWait(driver, 20).until (new ExpectedCondition<Boolean>() {  
    	    @Override  
    	    public Boolean apply(WebDriver driver) {  
    	        Boolean result = false;  
    	        try {  
    	            driver.findElement(By.xpath("//input[@value='请他付款']"));  
    	            result = true;  
    	        } catch(Exception e){         
    	        }  
    	        return result;  
    	    }  
        });  		  
        
  ///////!!!!!!!!!!  WAIT 15 seconds FOR MANUAL INPUT !!!!!!!!!////////////////////////////////////////////////////////////////////////
//        try {
//  			Thread.sleep(10000);
//  	  	} catch (InterruptedException e) {
//  	  		// TODO Auto-generated catch block
//  	  		e.printStackTrace();
//  	  	}       
        
//        driver.findElement(By.xpath("//input[@value='请他付款']")).click();
  	  	
  	  	
  	  	// once detected a new page is generated, which means 代付申请成功， then close the driver
        new WebDriverWait(driver, 20).until (new ExpectedCondition<Boolean>() {  
    	    @Override  
    	    public Boolean apply(WebDriver driver) {  
    	        Boolean result = false;  
    	        try {  
    	            driver.findElement(By.xpath("//div[@class='ui-tipbox ui-tipbox-success']"));  
    	            result = true;  
    	        } catch(Exception e){         
    	        }  
    	        return result;  
    	    }  
        });  	
        
        try {
        	Thread.sleep(500);
        } catch (InterruptedException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        }
        driver.quit();
    }
  	
  	
  	// default click the first 付款 img
  	public static void pay(String configFile) {
  	  	pay(configFile, 1);
  	}
}