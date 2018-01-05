package com.znsd.circuit.plugins;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;


@Intercepts(value = { @Signature(args = { Connection.class }, method = "prepare", type = StatementHandler.class) })
public class MyInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation arg0) throws Throwable {
		StatementHandler sh = (StatementHandler) arg0.getTarget();
		BoundSql bs = sh.getBoundSql();
		String sql = bs.getSql();
		Object params = bs.getParameterObject();
		System.out.println("sql:"+sql);
		System.out.println("parms:"+params);
		return arg0.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties arg0) {
	}


}
