package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class BookingServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookingServiceApplication.class, args);
    }
}

//// Декларативный клиент: вместо URL — имя сервиса в реестре
//@FeignClient(name = "price-service")
//public interface PriceFeignClient {
//    @GetMapping("/api/prices/{sku}")
//    BigDecimal getPrice(@PathVariable String sku);
//}
//
//@Service
//public class PriceServiceFacade {
//    private final PriceFeignClient client;
//    public PriceServiceFacade(PriceFeignClient client) { this.client = client; }
//    public BigDecimal priceFor(String sku) { return client.getPrice(sku); }
//}