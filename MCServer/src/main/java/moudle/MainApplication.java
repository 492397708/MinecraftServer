package moudle;

import moudle.data.StaticData;
import moudle.utils.InitUtil;
import moudle.utils.JwtUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;


/**
 * 程序入口
 *
 * @author
 */
@SpringBootApplication
@MapperScan("moudle.dao")
@Configuration
public class MainApplication {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException, SQLException {
        SpringApplication.run(MainApplication.class, args);
        InitUtil.init();

        System.out.println();
        System.out.println(JwtUtil.createJWT("test", "wula"));
        ;


        for (
                Class c : StaticData.allClasses
        ) {

            System.out.println(c.getName());

        }


    }
}
