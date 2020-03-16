package com.spark.platform.common.security.component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.spark.platform.common.base.constants.GlobalsConstants;
import com.spark.platform.common.security.exception.SparkAuth2Exception;
import lombok.SneakyThrows;

/**
 * @author: LHL
 * @ProjectName: sophia_scaffolding
 * @Package: com.scaffolding.sophia.common.security.component
 * @ClassName: SophiaAuth2ExceptionSerializer
 * @Description: OAuth2 异常格式化
 * @Version: 1.0
 */
public class SparkAuth2ExceptionSerializer extends StdSerializer<SparkAuth2Exception> {


	public SparkAuth2ExceptionSerializer() {
		super(SparkAuth2Exception.class);
	}

	@Override
	@SneakyThrows
	public void serialize(SparkAuth2Exception value, JsonGenerator gen, SerializerProvider provider) {
		gen.writeStartObject();
		gen.writeObjectField("code", GlobalsConstants.FAIL);
		gen.writeStringField("msg", value.getMessage());
		gen.writeStringField("data", value.getErrorCode());
		gen.writeEndObject();
	}
}
