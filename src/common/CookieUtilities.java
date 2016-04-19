package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CookieUtilities {
	protected static WebDriver driver = BaseTest.driver;
	
	public static String getCookie(String key) throws Exception{
		
		String cookieData = "";
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		cookieData = (String)js.executeScript(
			"function getCookie("+key+") {"+
			"    var name = "+key+" + \"=\";"+
			"    var ca = document.cookie.split(';');"+
			"    for(var i=0; i<ca.length; i++) {"+
			"        var c = ca[i];"+
			"        while (c.charAt(0)==' ') c = c.substring(1);"+
			"        if (c.indexOf(name) == 0) return c.substring(name.length, c.length);"+
			"    }"+
			"    return \"\";"+
			"}"
		);
		
		return cookieData;	
	}

	
}
