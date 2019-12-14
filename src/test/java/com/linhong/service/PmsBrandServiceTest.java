package com.linhong.service;

import com.linhong.mbg.mapper.PmsBrandMapper;
import com.linhong.mbg.model.PmsBrand;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PmsBrandServiceTest {

    @Autowired
    private PmsBrandService pmsBrandService;

    @Test
    public void testListAllBrand(){
        List<PmsBrand> pmsBrands = pmsBrandService.listAllBrand();
        Assert.assertNotNull(pmsBrands);
    }
}