
package cn.yr.datasources.demodatasources.jta;

import cn.yr.datasources.demodatasources.jta.atomikos.DBConfig2;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

//@Configuration
// basePackages 最好分开配置 如果放在同一个文件夹可能会报错
//@MapperScan(basePackages = "cn.yr.datasources.demodatasources.interface2", sqlSessionTemplateRef = "test2SqlSessionTemplate")
public class TestMyBatisConfig2 {

	// 配置数据源
	@Bean(name = "test2DataSource")
	public DataSource testDataSource(DBConfig2 testConfig) throws SQLException {
		MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
		mysqlXaDataSource.setUrl(testConfig.getJdbcurl());
	//	mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
		mysqlXaDataSource.setPassword(testConfig.getPassword());
		mysqlXaDataSource.setUser(testConfig.getUsername());
		//mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

		AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
		xaDataSource.setXaDataSource(mysqlXaDataSource);
		xaDataSource.setUniqueResourceName("test2DataSource");

		/*OracleXADataSource oracleXADataSource = new OracleXADataSource();
		oracleXADataSource.setURL(testConfig.getJdbcurl());
		//	mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
		oracleXADataSource.setPassword(testConfig.getPassword());
		oracleXADataSource.setUser(testConfig.getUsername());
		//	mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

		org.springframework.boot.jta.atomikos.AtomikosDataSourceBean xaDataSource = new org.springframework.boot.jta.atomikos.AtomikosDataSourceBean();
		xaDataSource.setXaDataSource(oracleXADataSource);
		xaDataSource.setUniqueResourceName("test2DataSource");*/

//		xaDataSource.setMinPoolSize(testConfig.getMinPoolSize());
//		xaDataSource.setMaxPoolSize(testConfig.getMaxPoolSize());
//		xaDataSource.setMaxLifetime(testConfig.getMaxLifetime());
//		xaDataSource.setBorrowConnectionTimeout(testConfig.getBorrowConnectionTimeout());
//		xaDataSource.setLoginTimeout(testConfig.getLoginTimeout());
//		xaDataSource.setMaintenanceInterval(testConfig.getMaintenanceInterval());
//		xaDataSource.setMaxIdleTime(testConfig.getMaxIdleTime());
//		xaDataSource.setTestQuery(testConfig.getTestQuery());
		return xaDataSource;
	}

	@Bean(name = "test2SqlSessionFactory")
	public SqlSessionFactory testSqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath:mapper2/*.xml"));
		return bean.getObject();
	}

	@Bean(name = "test2SqlSessionTemplate")
	public SqlSessionTemplate testSqlSessionTemplate(
			@Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
