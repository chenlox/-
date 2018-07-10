package com.baizhi.cmfz.Aspect;


import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



/**
 * 额外功能类
 */
@Aspect
public class MyAdvice {

    /**
     * 声明切入点表达式
     */
    @Pointcut("execution(* com.baizhi.cmfz.service.impl.*.modify*(..)) || execution(* com.baizhi.cmfz.service.impl.*.remove*(..)) || execution(* com.baizhi.cmfz.service.impl.*.add*(..))")
    public void pc(){}


    /**
     * 前置通知
     */
    @Around("pc()")//标志当前的前置通知使用pc方法上声明的切入点表达式
    public Object around(ProceedingJoinPoint pjp) throws Throwable {


        //获取操作源类型
        String tarName = pjp.getTarget().getClass().getName();
        System.out.println(tarName);
        tarName=tarName.substring(tarName.lastIndexOf(".")+1);
        tarName=tarName.substring(0,tarName.indexOf("ServiceImpl"));
        if(tarName.equals("Log")){
            return pjp.proceed();
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        Log log=new Log();
        //获取session中存储的管理员对象
        Manager manager=(Manager)session.getAttribute("manager");
        if(manager!=null){
            log.setManagerName(manager.getManagerName());//操作者
        }else{
            log.setManagerName(null);
        }
        //获得目标类参数
        Object[] args = pjp.getArgs();
        String message="";
        for (Object object:args){
            message=message+object+"-";
        }
        log.setLogMessage(message);//参数信息
        /*MethodSignature signature =(MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        String methodName = method.getName();*/
        //获取调用方法名
        String  methodName = pjp.getSignature().getName();
        //action
        if(methodName.contains("add")){
            log.setLogAction("新增");
        }else if(methodName.contains("remove")){
            log.setLogAction("删除");
        }else if(methodName.contains("modify")){
            log.setLogAction("修改");
        }
        //结果
        Object proceed=null;
        try {
            //执行完方法的返回值:proceed
            proceed = pjp.proceed();
            log.setLogResult("success");
        } catch (Throwable throwable) {
            log.setLogResult("error");
            throwable.printStackTrace();
        }

        log.setLogResource(tarName);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
        LogService logService = (LogService) applicationContext.getBean("logServiceImpl");
        logService.addLog(log);
        return  proceed;

    }

}
