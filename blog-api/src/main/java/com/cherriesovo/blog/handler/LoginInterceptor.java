package com.cherriesovo.blog.handler;

import com.alibaba.fastjson.JSON;
import com.cherriesovo.blog.dao.pojo.SysUser;
import com.cherriesovo.blog.service.LoginService;
import com.cherriesovo.blog.utils.UserThreadLocal;
import com.cherriesovo.blog.vo.ErrorCode;
import com.cherriesovo.blog.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j  //日志
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    //该方法在执行controller方法之前执行
        /*
        * 1、需要判断请求的接口路径是否为HandlerMethod(controller方法)
        * 2、判断token是否为空，如果为空 未登录
        * 3、如果token不为空，登录验证loginService checkToken
        * 4、如果认证成功，放行即可
        * */
        if (!(handler instanceof HandlerMethod)){
            //handler可能是RequestResourceHandler springboot程序访问静态资源默认去classpath下的static目录去查询
            return true;
        }
        String token = request.getHeader("Authorization");
        log.info("=================request start===========================");
        String requestURI = request.getRequestURI();
        log.info("request uri:{}",requestURI);
        log.info("request method:{}",request.getMethod());
        log.info("token:{}", token);
        log.info("=================request end===========================");

        if (token == null){
            Result result = Result.fail(ErrorCode.NO_LOGIN.getCode(), "未登录");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        SysUser sysUser = loginService.checkToken(token);
        if (sysUser == null){
            Result result = Result.fail(ErrorCode.NO_LOGIN.getCode(), "未登录");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        //至此是登录状态，放行
        //我希望在controller中直接获取用户信息，怎么获取
        UserThreadLocal.put(sysUser);
        return true;
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //如果不删除，Threadlocal中用完的信息会有内存泄漏的风险
        UserThreadLocal.remove();
    }

}
