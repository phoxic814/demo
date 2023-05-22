package org.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component
@Aspect
public class TransactionalAspect {

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void transactionalMethod() {
    }

    @Around("transactionalMethod()")
    public Object manageTransaction(ProceedingJoinPoint pjp) throws Throwable {
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        definition.setName(pjp.getSignature().getName());
        definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus status = transactionManager.getTransaction(definition);
        try {
            Object result = pjp.proceed();
            transactionManager.commit(status);
            return result;
        } catch (Throwable t) {
            transactionManager.rollback(status);
            throw t;
        }
    }

}
