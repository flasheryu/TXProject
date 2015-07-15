package org.openqa.selenium.txsample;

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

public class selenium2Example  {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
    	System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        
        // open 我的淘宝  page
        driver.get("http://i.taobao.com/my_taobao.htm");
        driver.findElement(By.id("J_SubmitQuick")).click(); //go to login page

//        driver.findElement(By.id("J_Quick2Static")).click(); //go to login page
      
        // username and password, this should be protected and read from some config file
//        WebElement usr = driver.findElement(By.id("TPL_username_1"));
//        usr.sendKeys("username");
//        WebElement pw = driver.findElement(By.id("TPL_password_1"));
//        pw.sendKeys("password");
//        pw.submit();

//        new WebDriverWait(driver, 10).until (new ExpectedCondition<Boolean>() {  
//        	@Override  
//    	    public Boolean apply(WebDriver driver) {  
//    	        Boolean result = false;  
//    	        try {  
//    	            driver.findElement(By.id("caipiao"));  
//    	            result = true;  
//    	        } catch(Exception e){         
//    	        }  
//    	        return result;  
//    	    }  
//    	});  

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
      
//      new WebDriverWait(driver, 10).until (new ExpectedCondition<Boolean>() {  
//  	    @Override  
//  	    public Boolean apply(WebDriver driver) {  
//  	        Boolean result = false;  
//  	        try {  
//  	            driver.findElement(By.id("J_myLottery"));  
//  	            result = true;  
//  	        } catch(Exception e){         
//  	        }  
//  	        return result;  
//  	    }  
//  	  });  
   
 /*     
      driver.findElement(By.linkText("足球单场")).click();

      try {
		Thread.sleep(1000);
      } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
      }
      for (String handle : driver.getWindowHandles()) {
	    driver.switchTo().window(handle);
      }
	
      //try to click 负 of the first game
      //	driver.findElement(By.xpath("//body/section/article/div/table/tbody/tr/td/ul/li[last()]")).click();
	
      //try to click 负 of the first game
      driver.findElement(By.xpath("//tr//td//ul//li[@data-matchindex='16'][last()]")).click();//第五场负
      driver.findElement(By.xpath("//tr//td//ul//li[@data-matchindex='17'][1]")).click(); //第一场胜
      driver.findElement(By.xpath("//tr//td//ul//li[@data-matchindex='15'][2]")).click(); //第三场平

//    	driver.findElement(By.linkText("2串1")).click();
      driver.findElement(By.xpath("//input[@value='2串1']")).click();
      driver.findElement(By.xpath("//input[@value='3串1']")).click();

      WebElement times = driver.findElement(By.id("multiple"));
      times.clear();
      times.sendKeys("4000");
      driver.findElement(By.linkText("发起合买")).click();
    
      WebElement brokerage = driver.findElement(By.xpath("//input[@name='brokerage']"));
      brokerage.sendKeys("4"); //4%佣金
    
      WebElement splitnum = driver.findElement(By.xpath("//input[@name='splitnum']"));
      splitnum.sendKeys("32000"); //32000份，每份1元
    
      WebElement buynum = driver.findElement(By.xpath("//input[@name='buynum']"));
      buynum.sendKeys("1843"); //购买2843份
    
      driver.findElement(By.xpath("//input[@value='2']")).click(); //完全保密
      driver.findElement(By.linkText("立即投注(电话委托)")).click();

*/
      
//      test elements
//      List<WebElement> games = driver.findElements(By.xpath("//tr//td//ul//li[@data-matchindex='4']"));
//      String test = games.toString();
//      System.out.print(test);
	
//      driver.quit();
      
//		TODO: 刷新我的彩票页面，点击付款按钮，进入付款，选择代付，  wait 10 秒钟 手动输入验证码，提交
      
      //点击付款进入收银台 and switch to new window
      driver.findElement(By.xpath("//tbody//tr//td//span//a//img")).click();
    		 
//	  try {
//			Thread.sleep(1000);
//	  } catch (InterruptedException e) {
//		  // TODO Auto-generated catch block
//		  e.printStackTrace();
//	  }
	  for (String handle : driver.getWindowHandles()) {
		  driver.switchTo().window(handle);
	  }   

      //wait till entering 付款界面
//      new WebDriverWait(driver, 20).until (new ExpectedCondition<Boolean>() {  
//	    @Override  
//	    public Boolean apply(WebDriver driver) {  
//	        Boolean result = false;  
//	        try {  
//	            driver.findElement(By.id("J-tabcnt-accountDetail"));  
//	            result = true;  
//	        } catch(Exception e){         
//	        }  
//	        return result;  
//	    }  
//      });  
	  
	  
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
      
//	  try {
//			Thread.sleep(5000);
//	  } catch (InterruptedException e) {
//		  // TODO Auto-generated catch block
//		  e.printStackTrace();
//	  }
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
	  //skip the example part
//	  <area href="#" coords="270,0,308,35" title="关闭演示，立�?�体验" shape="rect" class="guide-end">
      driver.findElement(By.xpath("//area[@title='关闭演示，立即体验']")).click();
   
//	  try {
//			Thread.sleep(2000);
//	  } catch (InterruptedException e) {
//		  // TODO Auto-generated catch block
//		  e.printStackTrace();
//	  }
	
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
//      <input value="" data-editing="off" ui-form-explain="" smartracker="on" seed="applyForm-FShowname" id="F-showname" class="ui-input" placeholder="支付�?账户/淘�?账户(昵称)" tabindex="1" autocomplete="off" type="text">
      WebElement placeholder = driver.findElement(By.xpath("//input[@id='F-showname']"));
      placeholder.sendKeys("18858144973"+Keys.TAB); //代付人
      
//      driver.findElement(By.xpath("//div[@class='message-fieldset ui-form-item']")).click();
//	  try {
//			Thread.sleep(1000);
//	  } catch (InterruptedException e) {
//		  // TODO Auto-generated catch block
//		  e.printStackTrace();
//	  }
	 
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
      
      driver.findElement(By.linkText("亲情永恒")).click(); //江湖告急，甜蜜撒娇，亲情永恒，威逼利诱，generate randomly? TODO:
	  
  
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
      try {
			Thread.sleep(15000);
	  } catch (InterruptedException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
	  }     
	  
      driver.findElement(By.xpath("//input[@value='请他付款']")).click();
    }
}