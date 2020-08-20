package com.example.demo.aop;

import com.example.demo.annotation.ParamCheck;
import com.example.demo.entity.ResponeEntity;
import com.example.demo.errorException.ParamIsNullException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Component
@Aspect
public class ParamCheckAop {

    /**
     * 定义有一个切入点，范围为web包下的类
     */
    @Pointcut("execution(public * com.example.demo.controller..*.*(..)) ")
    public void checkParam() {
    }

    @Before("checkParam()")
    public void doBefore(JoinPoint joinPoint) {
    }

    /**
     * 检查参数是否为空
     */
    @Around("checkParam()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        try {
            System.out.println("ParamCheckAop doAround is call.....");
            MethodSignature signature = ((MethodSignature) pjp.getSignature());
            //得到拦截的方法
            Method method = signature.getMethod();
            //获取方法参数注解，返回二维数组是因为某些参数可能存在多个注解
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            if (parameterAnnotations == null || parameterAnnotations.length == 0) {
                //当没有参数时候执行这个方法
                //
                //这个ResponseEntity可以替换成  pjp.proceed() 直接执行
                ResponeEntity responeEntity = ResponeEntity.buildSuccess(pjp.proceed());
                System.out.println("没有参数"+responeEntity);
                return responeEntity;
            }
            //获取方法参数名
            String[] paramNames = signature.getParameterNames();
            //获取参数值
            Object[] paranValues = pjp.getArgs();
            //获取方法参数类型
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int i = 0; i < parameterAnnotations.length; i++) {
                //当输入参数时候执行这个方法
                //
                //
                System.out.println("输入的参数值为"+paranValues[i]);
                for (int j = 0; j < parameterAnnotations[i].length; j++) {
                    //如果该参数前面的注解是ParamCheck的实例，并且notNull()=true,则进行非空校验
                    if (parameterAnnotations[i][j] != null && parameterAnnotations[i][j] instanceof ParamCheck && ((ParamCheck) parameterAnnotations[i][j]).notNull()) {
                        paramIsNull(paramNames[i], paranValues[i], parameterTypes[i] == null ? null : parameterTypes[i].getName());
                        break;
                    }
                }
            }
            //这个ResponseEntity可以替换成  pjp.proceed() 直接执行
            ResponeEntity responeEntity = ResponeEntity.buildSuccess(pjp.proceed());
            //执行方法之后的行为
            //
            //
            int i=1;
            System.out.println("有参方法:-------------------");
            System.out.println("第"+i+++"次    "+responeEntity);
           return responeEntity;
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
            System.out.println("异常:***********************");
            return ResponeEntity.buildFail(ex.toString());
        }
    }

    /**
     * 在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
     *
     * @param joinPoint
     */
    @AfterReturning("checkParam()")
    public void doAfterReturning(JoinPoint joinPoint) {

    }

    /**
     * 参数非空校验，如果参数为空，则抛出ParamIsNullException异常
     * @param paramName
     * @param value
     * @param parameterType
     */
    private void paramIsNull(String paramName, Object value, String parameterType) {
        if (value == null || "".equals(value.toString().trim())) {
            throw new ParamIsNullException(paramName, parameterType);
        }
    }

}