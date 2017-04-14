/*
 *    Copyright 2010 The myBatis Team
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.spring.mapper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.LoaderClassPath;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * BeanFactory that enables injection of MyBatis mapper interfaces. It can be
 * set up with a SqlSessionFactory or a pre-configured SqlSessionTemplate.
 * <p>
 * Sample configuration:
 * 
 * <pre class="code">
 * {@code
 *   <bean id="baseMapper" class="org.mybatis.spring.mapper.MapperFactoryBean" abstract="true" lazy-init="true">
 *     <property name="sqlSessionFactory" ref="sqlSessionFactory" />
 *   </bean>
 * 
 *   <bean id="oneMapper" parent="baseMapper">
 *     <property name="mapperInterface" value="my.package.MyMapperInterface" />
 *   </bean>
 * 
 *   <bean id="anotherMapper" parent="baseMapper">
 *     <property name="mapperInterface" value="my.package.MyAnotherMapperInterface" />
 *   </bean>
 * }
 * </pre>
 * <p>
 * Note that this factory can only inject <em>interfaces</em>, not concrete
 * classes.
 * 
 * @see SqlSessionTemplate
 * @version $Id: MapperFactoryBean.java 3195 2010-11-16 21:04:57Z simone.tripodi
 *          $
 */
public class MapperFactoryBean<T> implements FactoryBean<T>, InitializingBean {

	private Class<T> mapperInterface;

	private boolean addToConfig = true;

	private SqlSession sqlSession;

	private boolean externalSqlSession;

	@Autowired(required = false) public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		if (!this.externalSqlSession) {
			this.sqlSession = new SqlSessionTemplate(sqlSessionFactory);
		}
	}

	@Autowired(required = false) public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSession = sqlSessionTemplate;
		this.externalSqlSession = true;
	}

	public void setMapperInterface(Class<T> mapperInterface) {
		this.mapperInterface = mapperInterface;
	}

	public void setAddToConfig(boolean addToConfig) {
		this.addToConfig = addToConfig;
	}

	/**
	 * {@inheritDoc}
	 */
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(this.sqlSession, "Property 'sqlSessionFactory' or 'sqlSessionTemplate' are required");
		Assert.notNull(this.mapperInterface, "Property 'mapperInterface' is required");

		Configuration configuration = this.sqlSession.getConfiguration();
		if (this.addToConfig && !configuration.hasMapper(this.mapperInterface)) {
			configuration.addMapper(this.mapperInterface);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public T getObject() throws Exception {
		return this.sqlSession.getMapper(this.mapperInterface);
	}

	/**
	 * {@inheritDoc}
	 */
	public Class<T> getObjectType() {
		return this.mapperInterface;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isSingleton() {
		return true;
	}

	private static Map<String, Class> loadedClasses = new ConcurrentHashMap<String, Class>();
	private static ClassPool pool = ClassPool.getDefault();
	static {
		// javassit不会主动去找/WEB-INF/classes下面的类，设定classpath
		pool.appendClassPath(new LoaderClassPath(Thread.currentThread().getContextClassLoader()));
	}

	// 默认universal mapper 的类名
	private String genericMapperInterface = "com.fuhj.itower.dao.GenericMapper";

	public void setGenericMapperInterface(String universalMapperInterface) {
		this.genericMapperInterface = genericMapperInterface;
	}

	/**
	 * 生成一个接口继承universalMapperInterface，接口名为sqlMapper.xml的namespace 用来调用相关的sql语句
	 * 
	 * @param mapperNameSpace sqlMap.xml的NameSpace
	 */
	@SuppressWarnings("unchecked") public void setMapperNamespace(String mapperNamespace) {
		mapperInterface = loadedClasses.get(mapperNamespace);
		if (mapperInterface != null) {
			return;
		}
		try {
			CtClass universalMapperInterface = pool.get(this.genericMapperInterface);
			CtClass cc = pool.makeInterface(mapperNamespace);
			cc.addInterface(universalMapperInterface);
			mapperInterface = cc.toClass();
			loadedClasses.put(mapperNamespace, mapperInterface);
			cc.detach(); // avoid large memory consumption
		} catch (Exception e) {
			mapperInterface = null;
			e.printStackTrace();
		}
	}
}