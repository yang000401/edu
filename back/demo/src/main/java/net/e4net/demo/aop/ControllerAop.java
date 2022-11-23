package net.e4net.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class ControllerAop {

    @Around("execution(* net.e4net.demo.controller..*(..))")//rest
    /*@Around("execution(* net.e4net.demo.reatcontroller.*(..))") 이거는 레스트컨트롤러만*/
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        }
        finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " +joinPoint.toString() + " " + timeMs + "ms");

        }
    }
}
