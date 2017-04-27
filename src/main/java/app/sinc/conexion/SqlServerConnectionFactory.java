package app.sinc.conexion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import app.sinc.util.Utilitario;

/**
 * @author mnieves
 *
 */
public class SqlServerConnectionFactory {
	private static SqlSessionFactory sqlSessionFactory;
	public static Properties prop = null;
	 
    static {
        try {
 
            String resource = "app/sinc/config/configSqlServer.xml";
            Reader reader = Resources.getResourceAsReader(resource);
 
            prop = Utilitario.readProperties("C:\\workspace_neon\\properties\\sincronizador\\sqlserverConection.properties");
            
            if (sqlSessionFactory == null) {
//                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            	sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,prop);
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
