package mybatisPlus;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class MybatisFastAutoGenerator {
  public static void main(String[] args) {
    FastAutoGenerator.create("jdbc:mysql://122.112.160.7:3306/test",
            "root", "123456")
            .globalConfig(builder -> {
              builder.author("zhufangyuan") // 设置作者
                      .enableSwagger() // 开启 swagger 模式
                      .fileOverride() // 覆盖已生成文件
                      .commentDate("yyyy-MM-dd") //时间格式
                      .outputDir(System.getProperty("user.dir")+"\\src\\main\\java"); // 指定输出目录
            })
            .packageConfig(builder -> {
              builder.parent("com.zhu") // 设置父包名
                      .moduleName("generator") // 设置父包模块名
                      .entity("entity")
                      .service("service")
                      .serviceImpl("serviceImpl")
                      .controller("controller")
                      .mapper("mapper")
                      .xml("mapper")
                      .pathInfo(Collections.singletonMap(OutputFile.mapperXml, System.getProperty("user.dir")+"\\src" +
                              "\\main\\resources\\")); // 设置mapperXml生成路径
            })
            .strategyConfig(builder -> {
              builder.addInclude("t_book") // 设置需要生成的表名
                      .addTablePrefix("t_") // 设置过滤表前缀
                      .serviceBuilder()
                      .formatServiceFileName("%sService")
                      .formatServiceImplFileName("%sServiceImpl")
                      .entityBuilder()
                      .enableLombok() //开启lombok
                      .logicDeleteColumnName("deleted") //说明逻辑删除是哪个字段
                      .enableTableFieldAnnotation() //属性加上说明注释
                      .controllerBuilder()
                      .formatFileName("%sController")
                      .enableRestStyle() //开启restController
                      .mapperBuilder()
                      .superClass(BaseMapper.class) //继承哪个父类
                      .formatMapperFileName("%sMapper")
                      .enableMapperAnnotation() //@mapper开启
                      .formatXmlFileName("%sMapper");
            })
            .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
            .execute();
  }
}
