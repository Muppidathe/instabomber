package instabombers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import instamessanger.java;

public class instabomber {
	static WebDriver driver;
	public int no;
	public static String message,url;
	public static Set<Cookie> cookies ;




	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		instabomber ib=new instabomber();
		

		ib.usrinput();
		System.setProperty(
				"webdriver.chrome.driver",
				"C:/Users/91950/eclipse-workspace/letcod/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);
		ib.login();
		ib.sendmsg(url);
		
		//driver.quit();
		
	}

	public void login() throws IOException, ClassNotFoundException {
		
		if(des()==true) {
			System.out.println("777" + cookies);
		}   
		else {
			
		driver.get("https://www.instagram.com/direct/t/107015897366629/");
		driver.findElement(By.xpath("//input[@name='username' and @type='text']")).sendKeys("muppidathi._");
		driver.findElement(By.xpath("//input[@name='password' and @type='password']")).sendKeys("€urious");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//div[text()='Not now']")).click();
		driver.findElement(By.xpath("//button[text()='Not Now']")).click();
		cookies = driver.manage().getCookies();
		System.out.println(cookies);
		ser();
		
		}
	}	
		public static void ser() throws IOException{
			
			FileOutputStream fileOut =new FileOutputStream("sample.txt");
			         ObjectOutputStream out = new ObjectOutputStream(fileOut);
			         cookies = driver.manage().getCookies();
			         for(Cookie cook:cookies) {
			        	 
			         out.writeObject(cook);
			         }
			         //out.writeObject(new endclass());
			         out.close();
			         fileOut.close();
		}
		
		
		
		
		
		
		
		public static Boolean des() throws ClassNotFoundException, IOException {
			Object obj;
			Cookie cook = null;
			try {
			FileInputStream fileIn = new FileInputStream("sample.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			
			while((obj=in.readObject())instanceof endclass==false) {
				
				cook=(Cookie) obj;
				try {
				driver.manage().addCookie(cook);
				}catch(Exception e){
					System.out.println(e);
					System.out.println(cook);
					 return false;
				}
				
			}
			in.close();
			fileIn.close();
			}catch(Exception e){
				
				System.out.println(e);
			 return false;	
			}
			return true;
		}
	void usrinput() {
		Scanner sobj=new Scanner(System.in);
		System.out.println("enter the url");
		url=sobj.nextLine();
		url="https://www.instagram.com/direct/t/107015897366629/";
		System.out.println("enter the message");
		message=sobj.nextLine();
		System.out.println("enter the loop count");
		no=sobj.nextInt();
		
	}
	public void sendmsg(String url) {
		driver.get("https://www.instagram.com/direct/t/107015897366629/");
		try {
			WebDriverWait mywait=new WebDriverWait(driver,40);
			for(int i=0;i<no;i++) {
			driver.findElement(By.xpath("//*[text()='Message...']//preceding::p")).sendKeys(message);
		
			WebElement element = driver.findElement(By.xpath("//div[text()='Send']"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click()", element);
			}
			System.out.println("success");
		}
		catch(Exception e) {
			System.out.println(e);	
			
		}
	}
	

}
class endclass implements java.io.Serializable {
	
}	
