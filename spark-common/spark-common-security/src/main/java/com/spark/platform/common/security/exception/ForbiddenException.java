package com.spark.platform.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.spark.platform.common.security.component.SparkAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

/**
 * @author: wangdingfeng
 * @ProjectName: spark-platform
 * @Package: com.spark.platform.common.security.exception
 * @ClassName: ForbiddenException
 * @Description:
 * @Version: 1.0
 */
@JsonSerialize(using = SparkAuth2ExceptionSerializer.class)
public class ForbiddenException extends SparkAuth2Exception {

	public ForbiddenException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "access_denied";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.FORBIDDEN.value();
	}

}

