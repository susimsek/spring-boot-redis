package com.redis.springbootredis.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {

    //uzun süren bir işlem yapılıyor
    @Cacheable(cacheNames = "myCache")//verdiğimiz isimde method cachelenir
    public String longRunningMethod() throws InterruptedException {
        Thread.sleep(5000L);//5 milisanaye bekle
        return "method is running";
    }

    @CacheEvict(cacheNames = "myCache")
    public String clearCache(){
       return "cache cleared";
    }
}
