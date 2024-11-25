package az.azure.manage.util;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Az
 * @date 2023/6/20
 */
@Component
@Aspect
@Order
public class LogInfo {
    //@Pointcut 注解定义什么时机进行拦截，要拦截的是什么东西，一个是使用 execution()，另一个是使用 annotation()。
    //annotation() 方式是针对某个注解来定义切点,execution指明哪些类或包或方法被执行的表达式
    //表明什么时机进行切入，本例中是被getmapping注解到的方法被调用时（参数是一个注解，表示被该注解标注的方法调用时进行切入）
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void pointCut(){}
    public long t1 ;
    public long t2;

    //指定的方法在切面切入目标方法之前执行，注入后做什么动作，参数是切点方法
    @Before("pointCut()")
    public void logAdvice(JoinPoint joinPoint){

        // 获取签名
        Signature signature = joinPoint.getSignature();
        // 获取切入的包名
        String declaringTypeName = signature.getDeclaringTypeName();
        // 获取即将执行的方法名
        String funcName = signature.getName();
        System.out.println("执行前开始记录");
        System.out.print("执行前开始记录,");
        if (StringUtils.isNotEmpty(funcName)) {
            System.out.print("执行方法为：" + funcName);
            System.out.println();
        }
        t1 = System.currentTimeMillis();
    }

    //指定的方法在切面切入目标方法之后执行
//    @After("pointCut()")
    public void logAdvice1(JoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String name =(String) args[0];
        System.out.println("结束记录1"+name);
        t2=System.currentTimeMillis();
        System.out.println("执行时间"+(t2-t1));
    }
    //自由选择增强动作与目标方法的执行顺序
//    @Around("pointCut()")
    //方法参数必须是ProceedingJoinPoint，而不能是JoinPoint
    public Object logAdvice2(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取请求参数
        Object[] args = joinPoint.getArgs();
        String name =(String) args[0];
        System.out.println("结束记录2"+name);
        t2=System.currentTimeMillis();
        System.out.println("执行时间1"+(t2-t1));
        //修改参数
        args[0]="王五";
        joinPoint.proceed(args);
        //修改返回值
        return "hello ,zhangsan";
    }

    /**
     * 在上面定义的切面方法返回后执行该方法，可以捕获返回对象或者对返回对象进行增强
     * @param joinPoint joinPoint
     * @param result result
     * 属性 returning 的值必须要和参数保持一致
     */
//    @AfterReturning(pointcut = "pointCut()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, Object result) {

        Signature signature = joinPoint.getSignature();
        String classMethod = signature.getName();
        System.out.println((String.format("方法%s执行完毕",classMethod)));
        System.out.println(result);
        // 实际项目中可以根据业务做具体的返回值增强
        System.out.println("对返回参数进行业务上的增强：{}"+result + "增强版");
    }
    /**
     * 在上面定义的切面方法执行抛异常时，执行该方法
     * @param joinPoint jointPoint
     * @param ex ex
     */
//    @AfterThrowing(pointcut = "pointCut()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        Signature signature = joinPoint.getSignature();
        String method = signature.getName();
        // 处理异常的逻辑
        System.out.println((String) (String.format("执行方法{}出错，异常为：{}", method, ex)));
    }
}
