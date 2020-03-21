
package com.spark.platform.common.base.exception;

import com.spark.platform.common.base.enums.SparkHttpStatus;
import com.spark.platform.common.base.support.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @author: wangdingfeng
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.common.base.exception
 * @ClassName: GlobalExceptionHandler
 * @Description: 全局异常处理类
 * @Version: 1.0
 */

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = CommonException.class)
    public ApiResponse defaultErrorHandler(CommonException e) {
        e.printStackTrace();
        return new ApiResponse(SparkHttpStatus.COMMON_FAIL.getCode(),new CommonException().getMessage());
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ApiResponse defaultErrorHandler(RuntimeException e) {
        e.printStackTrace();
        createLogger(e);
        return new ApiResponse(SparkHttpStatus.SERVER_FUGUE.getCode(), SparkHttpStatus.SERVER_FUGUE.getMessage()+"，错误信息："+e.getMessage());
    }


    /**
     * desc 请求参数合法性校验
     * @param exception
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse validationBodyException(MethodArgumentNotValidException exception){

//        StringBuffer buffer = new StringBuffer();

        BindingResult result  = exception.getBindingResult();
        if (result.hasErrors()) {

            List<ObjectError> errors = result.getAllErrors();

            errors.forEach(p ->{

                FieldError fieldError = (FieldError) p;
                log.error("Data check failure : object{"+fieldError.getObjectName()+"},field{"+fieldError.getField()+
                        "},errorMessage{"+fieldError.getDefaultMessage()+"}");
//                buffer.append(fieldError.getDefaultMessage()).append(",");
            });
        }
        return new ApiResponse(SparkHttpStatus.GL99990100.getCode(), SparkHttpStatus.GL99990100.getMessage());
    }

    /**
     * 缺少参数
     * @param ex
     * @return
     */
    @ExceptionHandler( ServletRequestBindingException.class)
    public ApiResponse validationBodyException(Exception ex){
        log.error("缺少必要的参数:"+ex.getMessage());
        return new ApiResponse(SparkHttpStatus.GL99990100.getCode(), SparkHttpStatus.GL99990100.getMessage());
    }

    /**
     * 请求参数转换异常
     * @param exception
     * @return
     */
    @ExceptionHandler(HttpMessageConversionException.class)
    public ApiResponse parameterTypeException(HttpMessageConversionException exception){
        log.error("请求参数转换异常"+exception.getMessage());
        return new ApiResponse(SparkHttpStatus.GL99990100.getCode(), SparkHttpStatus.GL99990100.getMessage());

    }


    /**
     * 打印关键log信息
     * @param e
     */

    private void createLogger(Exception e) {
        log.info(e.getMessage());
        log.info(e.getStackTrace()[0].toString());
        log.error(e.getMessage());
        for (StackTraceElement stackTraceElement : e.getStackTrace()) {
            log.error(stackTraceElement.toString());
        }
    }
}
