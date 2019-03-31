package com.example.demo;

import com.example.demo.models.Charge;
import com.example.demo.models.Multiplier;
import com.example.demo.models.Summary;
import com.example.demo.repositories.ChargeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataJdbcApplicationTests {

    @Autowired
    ChargeRepository chargeRepository;


    @Test
    public void contextLoads() {
        var charge = new Charge(
                null,
                2.0,
                new Summary(
                        null,
                        3.0,
                        Arrays.asList(
                                new Multiplier(null, 1.0),
                                new Multiplier(null, 2.0))
                ));
        var result = chargeRepository.save(charge);

        Assert.notNull(result);

        var reload = chargeRepository.findById(result.getId());
        Assert.notNull(reload);
    }

}
