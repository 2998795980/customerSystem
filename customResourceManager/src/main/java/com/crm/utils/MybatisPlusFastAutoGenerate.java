package com.crm.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

public class MybatisPlusFastAutoGenerate {

    /**
     * 数据源配置
     */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig.Builder(
        "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;CASE_INSENSITIVE_IDENTIFIERS=TRUE;MODE=MYSQL", "sa",
        "");

    public static void main(String[] args) {

        String projectUrl = "D:\\CODE\\customerSystem\\customResourceManager";

        FastAutoGenerator.create("jdbc:mysql://localhost:3306/custom_resource_manager", "root", "root")
            .globalConfig(builder -> {
                builder.author("yuzhe") // 设置作者
                    // .enableSwagger() // 开启 swagger 模式
                    // .fileOverride() // 覆盖已生成文件
                    .outputDir(projectUrl + "\\src\\main\\java"); // 指定输出目录
            }).packageConfig(builder -> {
                builder.parent("com.crm") // 设置父包名
                    // .moduleName("java") // 设置父包模块名
                    .pathInfo(Collections.singletonMap(OutputFile.xml,
                        projectUrl + "\\src\\main\\resources\\com\\crm\\dao\\mapper")); // 设置mapperXml生成路径
            }).strategyConfig(builder -> {
                builder.addInclude("account", "company", "person"); // 设置需要生成的表名
                // .addTablePrefix("t_", "c_"); // 设置过滤表前缀
            }).templateEngine(new VelocityTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
            .execute();

    }

    public static void fastAutoGenerateOne() {
        FastAutoGenerator.create("url", "username", "password").globalConfig(builder -> {
            builder.author("baomidou") // 设置作者
                .enableSwagger() // 开启 swagger 模式
                .fileOverride() // 覆盖已生成文件
                .outputDir("D://"); // 指定输出目录
        }).packageConfig(builder -> {
            builder.parent("com.baomidou.mybatisplus.samples.generator") // 设置父包名
                .moduleName("system") // 设置父包模块名
                .pathInfo(Collections.singletonMap(OutputFile.xml, "D://")); // 设置mapperXml生成路径
        }).strategyConfig(builder -> {
            builder.addInclude("t_simple") // 设置需要生成的表名
                .addTablePrefix("t_", "c_"); // 设置过滤表前缀
        }).templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
            .execute();

    }

    public static void fastAutoGenerateTwo() {
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
            // 全局配置
            .globalConfig((scanner, builder) -> builder.author(scanner.apply("请输入作者名称？")).fileOverride())
            // 包配置
            .packageConfig((scanner, builder) -> builder.parent(scanner.apply("请输入包名？")))
            // 策略配置
            .strategyConfig(
                (scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                    .controllerBuilder().enableRestStyle().enableHyphenStyle().entityBuilder().enableLombok()
                    .addTableFills(new Column("create_time", FieldFill.INSERT)).build())
            /*
                模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
               .templateEngine(new BeetlTemplateEngine())
               .templateEngine(new FreemarkerTemplateEngine())
             */.execute();
    }

    // 处理 all 情况
    public static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }

}
