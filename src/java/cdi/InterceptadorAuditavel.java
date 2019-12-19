package cdi;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Auditavel
@Priority(Interceptor.Priority.APPLICATION - 2)
public class InterceptadorAuditavel {
    
    @AroundInvoke
    public Object loggando(InvocationContext ctx) throws Exception{
        System.out.println("Antes do método");
        Object res = ctx.proceed();
        System.out.println("Depois do método");
        return res;
    }
}
