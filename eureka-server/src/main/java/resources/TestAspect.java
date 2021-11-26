package resources;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TestAspect {

    @Pointcut("execution(* resources.A.*(..))")
    public void classA() {
    }

    @Around("classA()")
    public Object inter(ProceedingJoinPoint pjp)  throws Throwable{
        return "proxy " + pjp.proceed();
    }

}
