package moudle;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import moudle.data.StaticData;
import moudle.entity.bmentity.BmCategory;
import moudle.entity.bmentity.BmType;
import moudle.utils.InitUtil;
import moudle.utils.ReflectUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;


/**
 * 程序入口
 *
 * @author
 */
@SpringBootApplication
@MapperScan("moudle.dao")
@Configuration
public class MainApplication {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {
        SpringApplication.run(MainApplication.class, args);
        InitUtil.init();
        ReflectUtil.getObjectFJSON("{\"password\":\"123456\",\"name\":\"wula\",\"uuid\":\"9f9643c3-81c1-4df2-a819-47a3a1262883\",\"account\":\"492397708\"}", "User");


        BmCategory bmCategory = new BmCategory() {{
            this.setName("测试大类");
            this.setImage("测试图片");
            this.setCreateBy("wula");
            this.setCreateTime(new Date());
            this.setDelFlag("undelete");
            this.setUpdateBy("wula");
            this.setUpdateTime(new Date());
        }};
        System.out.println("{\"image\":\"测试图片\",\"createBy\":\"wula\",\"createTime\":1663166010197,\"updateBy\":\"wula\",\"name\":\"测试大类\",\"updateTime\":1663166010197,\"delFlag\":\"undelete\"}");
        System.out.println(JSON.parseObject(JSON.toJSONString(bmCategory)));
        for (Class c : StaticData.allClasses
        ) {

            System.out.println(c.getName());

        }


    }
}
