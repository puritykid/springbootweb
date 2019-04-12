package com.example.demo.aop;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

@Aspect
@Configuration
public class TransactionAdviceConfig {
	
	 // 设置事务失效时间，如果超过5秒，则回滚事务
     private static final int TX_METHOD_TIMEOUT = 5;
     
     private static final String AOP_POINTCUT_EXPRESSION = "execution (* com.example.demo.service.*.*(..))";

        @Autowired
        private PlatformTransactionManager transactionManager;

        @Bean
        public TransactionInterceptor txAdvice() {
            
            // 定义事物传播规则，只读事物
            RuleBasedTransactionAttribute txAttr_REQUIRED = new RuleBasedTransactionAttribute();
            txAttr_REQUIRED.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
            txAttr_REQUIRED.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
            txAttr_REQUIRED.setTimeout(TX_METHOD_TIMEOUT);
            
            // 定义事物传播规则，以非事物方式运行
        	RuleBasedTransactionAttribute txAttr_READONLY_SUPPORTED = new RuleBasedTransactionAttribute();
        	txAttr_READONLY_SUPPORTED.setReadOnly(true);
        	txAttr_READONLY_SUPPORTED.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);

            // 事务管理规则，申明具备事物管理的方法名
            NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
            Map<String, TransactionAttribute> sourceMap = new HashMap<String, TransactionAttribute>();
            sourceMap.put("add*", txAttr_REQUIRED);
            sourceMap.put("save*", txAttr_REQUIRED);
            sourceMap.put("delete*", txAttr_REQUIRED);
            sourceMap.put("update*", txAttr_REQUIRED);
            sourceMap.put("execute*", txAttr_REQUIRED);
            sourceMap.put("get*", txAttr_READONLY_SUPPORTED);
            sourceMap.put("query*", txAttr_READONLY_SUPPORTED);
            sourceMap.put("find*", txAttr_READONLY_SUPPORTED);
            sourceMap.put("list*", txAttr_READONLY_SUPPORTED);
            sourceMap.put("count*", txAttr_READONLY_SUPPORTED);
            sourceMap.put("is*", txAttr_READONLY_SUPPORTED);
            source.setNameMap(sourceMap);
            return new TransactionInterceptor(transactionManager, source);
        }

        @Bean
        public Advisor txAdviceAdvisor() {
            AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
            pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
            return new DefaultPointcutAdvisor(pointcut, txAdvice());
        }
}

