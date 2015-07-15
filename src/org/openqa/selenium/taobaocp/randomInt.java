package org.openqa.selenium.taobaocp;
import java.util.Random;

public class randomInt {
    public static void main(String[] args) {
        int max=300;
        int min=0;
        Random random = new Random();

        int s = random.nextInt(max)%(max-min+1) + min;
        System.out.println(s);
    }
    
    public static int randomAddon(int min, int max){   	
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
//        System.out.println(s);
    	return s;	
    }
}