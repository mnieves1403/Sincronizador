package app.sinc.dao.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import app.sinc.bean.BeanTListaNegativa;
import app.sinc.dao.PersonaNegDAO;

/**
 * @author mnieves
 *
 */
public class PersonaNegDAOImpl implements PersonaNegDAO{

	private SqlSessionFactory sqlSessionFactory = null;
	 
    public PersonaNegDAOImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
	
	public List<BeanTListaNegativa> selectAll() {
		List<BeanTListaNegativa> list = null;
        SqlSession session = sqlSessionFactory.openSession();
 
        try {
            list = session.selectList("M_Persona_Neg.selectAll");
        } finally {
            session.close();
        }
        System.out.println("selectAll() --> "+list);
        return list;
	}

}
