package org.openqa.selenium.taobaocp;

public class test {
	
    public static void createOrders() {
    	String configXml="config/ccbConfig.pty";
//    	for (int i=0; i<2; i++)
//    		createOrder.order("config/cncbConfig.pty");
//    	createOrder.order("config/cmbConfig.pty");
//    	createOrder.order("config/ccbConfig.pty");
//    	requestPay.pay(configXml); // default click the first 付款 img
    	
    	for (int i=0; i<4; i++)
    		requestPay.pay(configXml, i+1); //only the entry "payer" is required, i+1 specifies which [付款] img is to click
    }
    
    public static void main(String[] args) {
//    	String configXml="config/ccbConfig.pty";
//    	createOrder.order(configXml);
//    	requestPay.pay(configXml);
    	
    	createOrders();
    }
    

}
