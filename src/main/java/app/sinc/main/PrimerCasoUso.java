package app.sinc.main;

import java.util.List;

import org.apache.log4j.Logger;

import app.sinc.bean.BeanConfiguracion;
import app.sinc.bean.BeanTListaNegativa;
import app.sinc.conexion.MySqlConnectionFactory;
import app.sinc.conexion.SqlServerConnectionFactory;
import app.sinc.dao.ConfiguracionDAO;
import app.sinc.dao.PersonaNegDAO;
import app.sinc.dao.TListaNegativaDAO;
import app.sinc.dao.impl.ConfiguracionDAOImpl;
import app.sinc.dao.impl.PersonaNegDAOImpl;
import app.sinc.dao.impl.TListaNegativaDAOImpl;

public class PrimerCasoUso {

	final static Logger logger = Logger.getLogger(PrimerCasoUso.class);
	
//	public static Properties prop = null;
//	
//	private static void readPropertiesExternal(){
//		try {
//			prop = new Properties();
//			prop.load(new FileInputStream("C:\\workspace_neon\\properties\\sincronizador\\sincronizador.properties"));
//			
//			logger.info("Lectura de Properties: "+prop.getProperty("driver"));
//			logger.info("Lectura de Properties: "+prop.getProperty("url"));
//			logger.info("Lectura de Properties: "+prop.getProperty("username"));
//			logger.info("Lectura de Properties: "+prop.getProperty("password"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public static void main(String[] args) {
		
		if(logger.isDebugEnabled()){
		    logger.debug("This is debug");
		}
		
		logger.info("This is info");
		logger.debug("This is debug");
		logger.warn("This is warn");
		logger.error("This is error");
		
//		proceso_test();
		obtenerLstPersonaNegativa();
	}
	
	private static void obtenerLstPersonaNegativa(){
		PersonaNegDAO perNegDao = new PersonaNegDAOImpl(SqlServerConnectionFactory.getSqlSessionFactory());
		TListaNegativaDAO tListaNegDAO = new TListaNegativaDAOImpl(MySqlConnectionFactory.getSqlSessionFactory());
		
		List<BeanTListaNegativa> lstNegativa = perNegDao.selectAll();
		
		BeanTListaNegativa bean = new BeanTListaNegativa();
		
		for (int i = 0; i < lstNegativa.size(); i++) {
			bean = lstNegativa.get(i);
			
			tListaNegDAO.insert(bean);
		}
		
	}
	
	private static void proceso_test(){
//		logger.info("RUTA: "+System.getProperty("user.dir"));
//		logger.info(new File (".").getAbsolutePath ());
		
//		readPropertiesExternal();
		
		// Laod spring-config.xml file
		// ApplicationContext ctx = new
		// ClassPathXmlApplicationContext("com/hmkcode/config/spring-config.xml");

		// get jdbcTemplatePersonDAO
		ConfiguracionDAO configMySqlDAO = new ConfiguracionDAOImpl(MySqlConnectionFactory.getSqlSessionFactory());
		ConfiguracionDAO configSqlServerDAO = new ConfiguracionDAOImpl(SqlServerConnectionFactory.getSqlSessionFactory());

		// create person bean to insert
		BeanConfiguracion config = new BeanConfiguracion();
		config.setId_tabla_config("IDTESTAPP");
		config.setCod_config("CDTESTAPP");
		config.setDsc_valor("DSCTESTEO");
		config.setUsr_ult_mod("USRTESTAPP");

		// ( 1 ) insert person
		configMySqlDAO.insert(config);
		configSqlServerDAO.insert(config);

		// **set name of person
		// person.setName("Person 2");
		// ** insert another person
		// int id = personDAO.insert(person);

		// ( 2 ) select persons by id
		// personDAO.selectById(id);

		configMySqlDAO.selectAll();
		configSqlServerDAO.selectAll();

		// **set name of all persons
		// for(int i = 0; i < persons.size(); i++){
		// persons.get(i).setName("Person Name "+i);
		// //( 4 ) update person
		// personDAO.update(persons.get(i));
		// }

		// **check update
//		configs = configMySqlDAO.selectAll();
//		configs = configSqlServerDAO.selectAll();
	}

}
