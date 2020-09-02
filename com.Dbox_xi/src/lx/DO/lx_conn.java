package lx.DO;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.Mapper.playerMapper;

import lx.POJO.MCplayer;

public class lx_conn {
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost:6688/mclx";
	
	static final String USER="root";
	static final String PASS="dbx666";
	
	String resource = "res/mybaits/Mybaits_LxConfig.xml";
	
	SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void before()throws IOException {//开始前加载
		InputStream inputStream=
				Resources.getResourceAsStream(resource);
		sqlSessionFactory= 
				new SqlSessionFactoryBuilder()
				.build(inputStream);
	}
	
	public void player_findall(Integer id) throws IOException{
		if(id<=0||id==null) {
			throw new NumberFormatException("id不能为空");
		}
		SqlSession session=sqlSessionFactory.openSession();
		playerMapper pm=session.getMapper(playerMapper.class);
		MCplayer mplayer=pm.findall(id);
		System.out.println(mplayer);
		
		session.close();
	}
	
}
