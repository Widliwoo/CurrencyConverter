package ru.mycompany.service;

import ru.mycompany.entity.Valute;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class ValuteCacheService {
    private Map<String, Valute> cache;
    private LocalDateTime expireAt;
    private Integer liveSeconds = 10;

    public Valute get(String charCode) {
        return cache.get(charCode);
    }

    public List<Valute> getList() {
        return cache.values().stream().toList();
    }

    public void set(Map<String, Valute> newCache) {
        this.cache = newCache;
        this.expireAt = LocalDateTime.now().plusSeconds(liveSeconds);
    }

    public void evict() {
        this.cache = null;
    }

    public Boolean isAlive() {
        return this.cache != null
                && LocalDateTime.now().isBefore(expireAt);
    }
}
