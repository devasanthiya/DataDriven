package Dataquest;

import java.io.IOException;

import org.openqa.selenium.By;

public class quest6 extends quest6Basic{

	public static void main(String[] args) throws IOException  {
		launch();
		max();
		url("https://www.facebook.com/");
		String data1 = data("E:\\Software\\eclipse-java-photon-R-win32-x86_64\\eclipse\\deva\\Datadriven\\XL sheets\\login.xlsx", "Empdata", 1, 0);
		String data2 = data("E:\\Software\\eclipse-java-photon-R-win32-x86_64\\eclipse\\deva\\Datadriven\\XL sheets\\login.xlsx", "Empdata", 1, 1);
		filling(driver.findElement(By.xpath("//input[@name=\"email\"]")), data1);
		filling(driver.findElement(By.xpath("//input[@name=\"pass\"]")), data2);
		pressing(driver.findElement(By.xpath("//button[@name=\"login\"]")));
		
	}
}
