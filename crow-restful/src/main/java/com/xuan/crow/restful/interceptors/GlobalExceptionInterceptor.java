package com.xuan.crow.restful.interceptors;

import com.alibaba.fastjson.JSON;
import com.xuan.crow.common.enums.BaseErrorEnum;
import com.xuan.crow.common.exception.CrowException;
import com.xuan.crow.common.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * 不必在Controller中对异常进行处理，抛出即可，由此异常解析器统一控制。<br>
 * ajax请求（有@ResponseBody的Controller）发生错误，输出JSON。<br>
 * 页面请求（无@ResponseBody的Controller）发生错误，输出错误页面。<br>
 * 需要与AnnotationMethodHandlerAdapter使用同一个messageConverters<br>
 * Controller中需要有专门处理异常的方法。
 * <p>
 * Created by xuan on 17/3/27.
 */
public class GlobalExceptionInterceptor extends ExceptionHandlerExceptionResolver {
    private static Logger log = LoggerFactory.getLogger(GlobalExceptionInterceptor.class);

    @Override
    protected ModelAndView doResolveHandlerMethodException(HttpServletRequest request, HttpServletResponse response,
                                                           HandlerMethod handlerMethod, Exception e) {
        if (null == handlerMethod) {
            log.info("handlerMethod is null.");
            return null;
        }
        Method method = handlerMethod.getMethod();
        if (null == method) {
            log.info("method is null.");
            return null;
        }
        try {
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            Result result;
            if (e instanceof CrowException) {
                logger.error(request.getRequestURI() + "--->" + e.getMessage());
                CrowException crowException = (CrowException) e;
                result = Result.obtainError(crowException.getBizCode(), crowException.getMessage());
            } else {
                logger.error(request.getRequestURI() + "--->" + e.getMessage());
                result = Result.obtainError(BaseErrorEnum.UNKNOWN.getBizCode(), BaseErrorEnum.UNKNOWN.buildMsg(e.getMessage()));
            }
            writer.write(JSON.toJSONString(result));
            return new ModelAndView();
        } catch (IOException ioe) {
            logger.info("exception io error");
        } finally {
            try {
                response.getWriter().close();
            } catch (IOException e1) {
                logger.info("exception close error");
            }
        }
        return new ModelAndView();
    }

}
