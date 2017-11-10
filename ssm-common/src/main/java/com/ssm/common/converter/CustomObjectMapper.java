package com.ssm.common.converter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;  
import org.codehaus.jackson.map.SerializerProvider;  
import org.codehaus.jackson.map.ser.CustomSerializerFactory;  
import com.ssm.common.constant.DateConstant;

  
 
/**
* @ClassName: CustomObjectMapper
* @Description:解决Date类型返回json格式为自定义格式 
*/
public class CustomObjectMapper extends ObjectMapper {  
  
    public CustomObjectMapper(){  
        CustomSerializerFactory factory = new CustomSerializerFactory();  
        factory.addGenericMapping(Date.class, new JsonSerializer<Date>(){  
            @Override  
            public void serialize(Date value,   
                    JsonGenerator jsonGenerator,
                    SerializerProvider provider)
                    throws IOException, JsonProcessingException {
                SimpleDateFormat sdf = new SimpleDateFormat(DateConstant.YYYY_MM_DD_HH_MM_SS);  
                jsonGenerator.writeString(sdf.format(value));  
            }  
        });  
        this.setSerializerFactory(factory);  
    }  
} 