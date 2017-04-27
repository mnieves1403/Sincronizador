package app.sinc.dao;

import java.util.List;

import app.sinc.bean.BeanConfiguracion;

/**
 *@author mnieves 
 */
public interface ConfiguracionDAO {
	public  List<BeanConfiguracion> selectAll();
	public BeanConfiguracion selectById(int id);
	public int insert(BeanConfiguracion config);
	public void update(BeanConfiguracion config);
	public void delete(int id);
}
