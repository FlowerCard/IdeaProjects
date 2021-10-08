package com.huapai.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/8.
 */
public class MyJsonSerialize extends JsonSerializer<Double> {
    @Override
    public void serialize(Double aDouble, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        // 四舍五入
        String value = BigDecimal.valueOf(aDouble).setScale(2,BigDecimal.ROUND_HALF_UP).toString();
        // 数据写出
        jsonGenerator.writeNumber(value);
    }
}
