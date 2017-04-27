package app.sinc.dao.impl;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import app.sinc.bean.BeanConfiguracion;
import app.sinc.dao.ConfiguracionDAO;

/**
 * @author mnieves
 *
 */
public class ConfiguracionDAOImpl implements ConfiguracionDAO{
	private SqlSessionFactory sqlSessionFactory = null;
	 
    public ConfiguracionDAOImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
 
    /**
     * Returns the list of all Person instances from the database.
     * @return the list of all Person instances from the database.
     */
    public  List<BeanConfiguracion> selectAll(){
        List<BeanConfiguracion> list = null;
        SqlSession session = sqlSessionFactory.openSession();
 
        try {
            list = session.selectList("Configuracion.selectAll");
        } finally {
            session.close();
        }
        System.out.println("selectAll() --> "+list);
        return list;
 
    }
    /**
     * Select instance of Person from the database.
     * @param person the instance to be persisted.
     */
   public BeanConfiguracion selectById(int id){
	   	BeanConfiguracion config = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
        	config = session.selectOne("Configuracion.selectById", id);
 
        } finally {
            session.close();
        }
        System.out.println("selectById("+id+") --> "+config);
        return config;
    } 
    /**
     * Insert an instance of Person into the database.
     * @param person the instance to be persisted.
     */
   public int insert(BeanConfiguracion config){
       int id = -1;
        SqlSession session = sqlSessionFactory.openSession();
 
        try {
            id = session.insert("Configuracion.insert", config);
        } finally {
            session.commit();
            session.close();
        }
        System.out.println("insert("+config+") --> "+config.getId_tabla_config());
        return id;
    }
    /**
   * Update an instance of Person into the database.
   * @param person the instance to be persisted.
   */
    public void update(BeanConfiguracion config){
       SqlSession session = sqlSessionFactory.openSession();
 
      try {
          session.update("Configuracion.update", config);
 
      } finally {
          session.commit();
          session.close();
      }
      System.out.println("update("+config+") --> updated");
  }
 
    /**
     * Delete an instance of Person from the database.
     * @param id value of the instance to be deleted.
     */
    public void delete(int id){
 
        SqlSession session = sqlSessionFactory.openSession();
 
        try {
            session.delete("Configuracion.delete", id);
        } finally {
            session.commit();
            session.close();
        }
        System.out.println("delete("+id+")");
 
    }
}
