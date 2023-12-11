package cl.accenture.api.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@EnableCaching
@Configuration
public class CacheManagerConfig {
	@Autowired
	private CacheManager cacheManager;
	
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("CouponDTO");
    }
    
    @Scheduled(cron = "0 0/30 * * * ?")
    public void clearCache(){
        for(String name:cacheManager.getCacheNames()){
            cacheManager.getCache(name).clear();
        }
    }
}

