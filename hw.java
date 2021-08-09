package com.koreait.crawling;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class hw {

	public static void main(String[] args) {
		String DRIVER_ID = "webdriver.chrome.driver";
	      String DRIVER_PATH = "C:/build_path/chromedriver.exe";
	      System.setProperty(DRIVER_ID, DRIVER_PATH);
	      WebDriver driver = new ChromeDriver();
	      String base_url = "https://www.banapresso.com/store";
	      
	      
	      try {
	         driver.get(base_url);
	         
	         System.out.println("1페이지");
	         List<WebElement> element = driver.findElements(By.className("store_name_map"));
	         for (WebElement el : element) {
				System.out.println("지점명 : "+ el.findElement(By.tagName("i")).getText());
				System.out.println("주소 : "+ el.findElement(By.tagName("span")).getText());
	         }
	         
	        
	         int pageNum = 2;
	         for(int i=2; i<=5; i++) {
	        	 System.out.println("+pageNum+");
	        	 try {
	        		 WebElement Nextpage = driver.findElement(By.cssSelector("div.pagination > ul > li:nth-child("+i+") > a"));
	        		 Nextpage.click();
		        	 List<WebElement> elements = driver.findElements(By.className("store_name_map"));
			         for (WebElement el : elements) {
						System.out.println("지점명 : "+el.findElement(By.tagName("i")).getText());
						System.out.println("주소 : "+el.findElement(By.tagName("span")).getText());
			         }
			         pageNum ++;
			       
			         
			         if(pageNum == 6) {
			        	 driver.findElement(By.cssSelector("span.btn_page_next > a")).click();
			        	 System.out.println("+pageNum+");
				         List<WebElement> element6 = driver.findElements(By.className("store_name_map"));
				         for (WebElement el : element6) {
							System.out.println("지점명 : "+el.findElement(By.tagName("i")).getText());
							System.out.println("주소 : "+el.findElement(By.tagName("span")).getText());
				         }
			        	 i=1;
			        	 pageNum++;
			         }
	        	 }catch (Exception e) {
	        		 e.printStackTrace();
	        		 break;
	        	 }
	         }
	      }catch (Exception e) {
			e.printStackTrace();
	      }
	}
}
