package org.openqa.selenium.taobaocp;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;
import org.openqa.selenium.config.cpConfig;

public class createOrder  {
	public static void main(String[] args) {
//	public static void order(String configFile) {

//		String configFile = "config/cncbConfig.pty";
//		String configFile = "config/ccbConfig.pty";
//		String configFile = "config/cmbConfig.pty";
		String configFile = "config/icbcConfig.pty";
		Properties configPty = cpConfig.readPty(configFile);		
		
		final String banknum = configPty.getProperty("banknum");
		int numbank = Integer.parseInt(banknum);
		
		String brokerage = configPty.getProperty("brokerage");
		String multiple = configPty.getProperty("multiple");
		String splitnum = configPty.getProperty("splitnum");
		String basicbuynum = configPty.getProperty("basicbuynum");
		String addonbuynum = configPty.getProperty("addonbuynum");
		String matchnum = configPty.getProperty("matchnum");
		int nummatch = Integer.parseInt(matchnum);
		final String[] match = new String[100];
		
		for (int i=0;i<nummatch;i++){
			String num = String.valueOf(i+1);
			match[i] = configPty.getProperty("match"+num); 
			System.out.print(num+" "+match[i]+'\n');
		}
		
		// basicbuynum + addonbuynum = 2000(广发，招行) / 1000(中信) / 5000(建行)
		int abnum = Integer.parseInt(addonbuynum);
    	int addon = randomInt.randomAddon(0, abnum);
        System.out.println(addon);
        int bbnum = Integer.parseInt(basicbuynum);
    	String buynum = String.valueOf(bbnum+addon);
		
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
    	
//    	System.setProperty("webdriver.firefox.bin", "//Applications//Firefox.app//Contents//MacOS//firefox");
    	System.setProperty("webdriver.chrome.driver", "//Applications///Google Chrome.app//Contents//MacOS//Google Chrome");
    	WebDriver driver = new ChromeDriver();
        
        // open 我的淘宝  page
        driver.get("http://i.taobao.com/my_taobao.htm");
//        driver.findElement(By.id("J_SubmitQuick")).click(); //go to login page
        
        // username and password, this should be protected and read from some config file
//        driver.findElement(By.id("J_Quick2Static")).click(); //go to login page
        WebElement usr = driver.findElement(By.id("TPL_username_1"));
        usr.sendKeys("username");
        WebElement pw = driver.findElement(By.id("TPL_password_1"));
        pw.sendKeys("password");
        pw.submit();

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
        driver.findElement(By.linkText("足球单场")).click();

        for (String handle : driver.getWindowHandles()) {
        	driver.switchTo().window(handle);
        }  
        new WebDriverWait(driver, 10).until (new ExpectedCondition<Boolean>() {  
        	@Override  
        	public Boolean apply(WebDriver driver) {  
        		Boolean result = false;  
        		try {  
        	        driver.findElement(By.xpath("//tr//td//ul//li[@data-matchindex='"+match[0]+"']"));//
        	        result = true;  
        		} catch(Exception e){   
        	        System.out.println("yet another time not found!\n");
        	        System.out.println("The match has expired/finished or it does not exist at all!!\n");
        		}  
        		return result;  
        	}  
        });  	
      	
      //TODO:Here is a work around to drag the window down-word
        driver.findElement(By.xpath("//td[@num-matchindex='"+match[0]+"']")).click(); 
		
        for (int i=0;i<nummatch;i++){
	    	int result = randomInt.randomAddon(1, 3);	//generate the result, randomly	1=胜，2=平，3=负	
	        System.out.println(result);
			driver.findElement(By.xpath("//tr//td//ul//li[@data-matchindex='"+match[i]+"']["+result+"]")).click();
//			driver.findElement(By.xpath("//tr//td//ul//li[@data-matchindex='55'][2]")).click(); //第55场平
			
			if ( numbank==3 && i!=2){ //for 建设银行，need to select more
				if(result!=3)	result+=1;	else result=randomInt.randomAddon(1, 2); //select 胜平/平负; otherwise, select负&random
		        System.out.println(result);
				driver.findElement(By.xpath("//tr//td//ul//li[@data-matchindex='"+match[i]+"']["+result+"]")).click();//
			}
		}
        driver.findElement(By.xpath("//input[@value='2串1']")).click();
        driver.findElement(By.xpath("//input[@value='3串1']")).click();

        WebElement times = driver.findElement(By.id("multiple"));
        times.clear();
        times.sendKeys(multiple);
        driver.findElement(By.linkText("发起合买")).click();
 
        WebElement brokeRage = driver.findElement(By.xpath("//input[@name='brokerage']"));
        brokeRage.sendKeys(brokerage); //brokerage%佣金   
        WebElement splitNum = driver.findElement(By.xpath("//input[@name='splitnum']"));
        splitNum.sendKeys(splitnum); //分为splitnum份，每份1元
        WebElement buyNum = driver.findElement(By.xpath("//input[@name='buynum']"));
        buyNum.sendKeys(buynum); //购买buynum份   
        driver.findElement(By.xpath("//input[@value='2']")).click(); //完全保密
        
        //Submit order!!!!
        driver.findElement(By.linkText("立即投注(电话委托)")).click();
	
        try {
        	Thread.sleep(3000);
        } catch (InterruptedException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        }
        driver.quit();
    }
}