package app.sinc.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author mnieves
 *
 */
public class Utilitario {

	private static Properties prop = null;
	
	public static Properties readProperties(String ruta){
		
		prop = new Properties();
        try {
			prop.load(new FileInputStream(ruta));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}
	
}
