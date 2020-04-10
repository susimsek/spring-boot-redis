package com.redis.springbootredis.api;

import com.redis.springbootredis.service.RedisCacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RedisCacheController {

    //redis cache servis çağrıldı
    private final RedisCacheService redisCacheService;

    private int sayac = 0;

    //işlem süresini kısaltmak için kullanılır
    @GetMapping("/api/v1/test")
    public String cacheControl() throws InterruptedException {
        if (sayac == 5){
            redisCacheService.clearCache();//cache temizlendi
            sayac = 0;
        }
        sayac++;

        return redisCacheService.longRunningMethod();

    }


}
