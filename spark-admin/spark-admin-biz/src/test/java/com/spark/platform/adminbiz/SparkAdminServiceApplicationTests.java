package com.spark.platform.adminbiz;

import com.google.common.collect.Lists;
import com.spark.platform.adminapi.dto.FileInfoDTO;
import com.spark.platform.adminapi.vo.GeneratorConfigVo;
import com.spark.platform.adminbiz.service.file.FileInfoService;
import com.spark.platform.adminbiz.service.gen.GenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SparkAdminServiceApplicationTests {

    @Autowired
    GenService genService;
    @Autowired
    FileInfoService fileInfoService;

    @Test
    void contextLoads() {
        GeneratorConfigVo generatorConfigVo =new GeneratorConfigVo();
        generatorConfigVo.setTableName("sys_api_log");
        generatorConfigVo.setProjectName("spark-admin");
        generatorConfigVo.setAuthor("wangdingfeng");
        generatorConfigVo.setModelName("log");
        generatorConfigVo.setParentPackage("com.spark.platform.adminbiz");
        genService.generatorCode(generatorConfigVo);
    }

    @Test
    void bind() {
        FileInfoDTO fileInfoDTO = new FileInfoDTO();
        fileInfoDTO.setBizId("10002");
        fileInfoDTO.setBizType("PROCESS_ARTICLE");
        fileInfoDTO.setFileIds(Lists.newArrayList(2l));
        fileInfoService.bindFile(fileInfoDTO);
    }

}
