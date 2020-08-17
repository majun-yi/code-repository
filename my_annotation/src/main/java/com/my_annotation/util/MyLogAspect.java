package com.my_annotation.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
/**
 * @Description TODO
 * @Author Administrator
 * @Date 2020/8/17 8:19
 */
@Aspect
@Component
public class MyLogAspect {
    /**
     * 定义切点位置
     */
    @Pointcut(value = "@annotation(com.my_annotation.util.MyLog)") //切点
    private void pointcut() {

    }

    /**
     * 在方法执行 前后（Around） 执行的内容：可以做为bean的加强器
     */
    @Around(value = "pointcut()&&@annotation(myLog)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint,MyLog myLog){
        System.out.println("---------执行了 around（）方法---------");
        String requestUrl = myLog.requestUrl();
        //拦截的类名
        Class clazz = proceedingJoinPoint.getTarget().getClass();
        String name = proceedingJoinPoint.getSignature().getName();
        System.out.println("执行了： " + clazz +"类=="+name+"方法==="+requestUrl);
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return throwable.getMessage();
        }
    }

    /**
     * 方法执行后--后置通知
     */
    @AfterReturning(value = "pointcut() && @annotation(myLog)", returning = "result")
    public Object afterReturning(JoinPoint joinPoint,MyLog myLog,Object result){
        System.out.println("======执行了afterReturning方法============");
        System.out.println("result:"+ result);
        return result;
    }

    /**
     * 异常后执行的 方法
     */
    @AfterThrowing(value = "pointcut()&& @annotation(myLog)",throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint,MyLog myLog,Exception exception){
        System.out.println("====执行了afterThrowing方法====");
        System.out.println("请求:"+myLog.requestUrl()+"出现异常");
    }
}
