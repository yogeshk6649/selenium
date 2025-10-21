package com.ecomapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Random;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://www.rahulshettyacademy.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.xpath("//div[@class='login-btn'][2]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("yogi@gmail.com");
        if(!driver.findElement(By.xpath("//input[@id='rememberMeCheckbox']")).isSelected()){
            driver.findElement(By.xpath("//input[@id='rememberMeCheckbox']")).click();
        }
        driver.findElement(By.xpath("//button[@id='otp-login-btn']")).click();
        String otpLength=
                driver.findElement(By.xpath("//input[@autocomplete='one-time-code']")).getAttribute("maxlength");
        System.out.println(otpLength);
//        Random random=new Random();
//        if(otpLength=="4"){
//                    driver.findElement(By.xpath("//input[@autocomplete='one-time-code'][1]")).sendKeys(String.valueOf(random.nextInt(10000)));
//        }
//        if(otpLength=="6"){
//           driver.findElement(By.xpath("//input[@autocomplete='one-time-code'][1]")).sendKeys(String.valueOf(random.nextInt(1000000)));
//        }
        Thread.sleep(2000);

        Random random=new Random();
        for(int i=0;i<Integer.parseInt(otpLength);i++){
            String otpXpath="//input[@data-testid='otp-input-"+i+"']";
            driver.findElement(By.xpath(otpXpath)).sendKeys(String.valueOf(random.nextInt(9)));
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@data-test='btn-code']")).click();
        Thread.sleep(10000);
        driver.close();
    }
}
