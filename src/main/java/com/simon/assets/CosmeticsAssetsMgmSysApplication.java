package com.simon.assets;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * date:20190712
 * author:simon
 */
@SpringBootApplication
@MapperScan("com.simon.assets.dao")
public class CosmeticsAssetsMgmSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(CosmeticsAssetsMgmSysApplication.class, args);
    }

}
