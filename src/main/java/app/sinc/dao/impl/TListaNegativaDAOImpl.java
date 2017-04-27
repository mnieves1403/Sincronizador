package app.sinc.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import app.sinc.bean.BeanTListaNegativa;
import app.sinc.dao.TListaNegativaDAO;

/**
 * @author mnieves
 *
 */
public class TListaNegativaDAOImpl implements TListaNegativaDAO {

	private SqlSessionFactory sqlSessionFactory = null;
	 
    public TListaNegativaDAOImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
	
	public int insert(BeanTListaNegativa tlistanegativa) {
		int id = -1;
        SqlSession session = sqlSessionFactory.openSession();
 
        try {
            id = session.insert("TListaNegativa.insert", tlistanegativa);
        } finally {
            session.commit();
            session.close();
        }
        System.out.println("insert("+tlistanegativa+") --> "+tlistanegativa.getNombre_persona());
        return id;
	}

}
