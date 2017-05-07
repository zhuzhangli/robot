package org.xjtusicd3.database.logic;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.xjtusicd3.database.mapper.AdvisePersistenceMapper;
import org.xjtusicd3.database.mapper.AnswerPersistenceMapper;
import org.xjtusicd3.database.mapper.ClassifyPersistenceMapper;
import org.xjtusicd3.database.mapper.ConfigureHistoryPersistenceMapper;
import org.xjtusicd3.database.mapper.ConfigurePersistenceMapper;
import org.xjtusicd3.database.mapper.DriversPersistenceMapper;
import org.xjtusicd3.database.mapper.EquipmentPersistenceMapper;
import org.xjtusicd3.database.mapper.QuestionPersistenceMapper;
import org.xjtusicd3.database.mapper.PatchPersistenceMapper;
import org.xjtusicd3.database.mapper.RobotPersistenceMapper;
import org.xjtusicd3.database.mapper.SoftPersistenceMapper;
import org.xjtusicd3.database.mapper.UserPersistenceMapper;




public class SqlSessionManager {
	private static SqlSessionFactory bizSqlSessionFactory;
	public static SqlSessionFactory getSqlSessionFactory()  {
		if (bizSqlSessionFactory==null) {
			try {
				bizSqlSessionFactory = convertSqlSession(new Dbconfig("/databaseconfig.properties"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bizSqlSessionFactory;
	}
	
	private static SqlSessionFactory convertSqlSession(Dbconfig dbConfig) throws Exception { 
		
			DataSource dataSource = ConnectionManager.getProxoolDataSource(dbConfig.getDriver(), dbConfig.getUrl(), dbConfig.getUsername(),
					dbConfig.getPassword(), dbConfig.getAlias(), dbConfig.getMaxConnection(), dbConfig.getMinConnection(),
					dbConfig.getSimultaneousBuildThrottle());
			TransactionFactory transactionFactory = new JdbcTransactionFactory();
			Environment environment = new Environment("development", transactionFactory, dataSource);
			Configuration configuration = new Configuration(environment);
			configuration.addMapper(IBaseDao.class);
			configuration.addMapper(UserPersistenceMapper.class);
			configuration.addMapper(ConfigurePersistenceMapper.class);
			configuration.addMapper(ConfigureHistoryPersistenceMapper.class);
			configuration.addMapper(SoftPersistenceMapper.class);
			configuration.addMapper(DriversPersistenceMapper.class);
			configuration.addMapper(PatchPersistenceMapper.class);
			configuration.addMapper(QuestionPersistenceMapper.class);
			configuration.addMapper(AnswerPersistenceMapper.class);
			configuration.addMapper(ClassifyPersistenceMapper.class);
			configuration.addMapper(RobotPersistenceMapper.class);
			configuration.addMapper(AdvisePersistenceMapper.class);
			configuration.addMapper(EquipmentPersistenceMapper.class);
			configuration.addInterceptor(new BasePlugin());
			bizSqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		return bizSqlSessionFactory;
	}
}
