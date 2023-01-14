package ru.mycompany.service;

import ru.mycompany.entity.Valute;
import ru.mycompany.repository.ValuteRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ValuteService {

    private ValuteCacheService valuteCacheService;
    private ValuteRepository valuteRepository;

    public Valute getByCharCode(String charCodeFrom) {
        if (!valuteCacheService.isAlive()) {
            updateCache();
        }
        return valuteCacheService.get(charCodeFrom);
    }

    public List<Valute> getAllAvailableValutes() {
        if (!valuteCacheService.isAlive()) {
            updateCache();
        }
        return valuteCacheService.getList();
    }

    private void updateCache() {
        List<Valute> valutes = valuteRepository.getValutes();
        Map<String, Valute> valuteMap = valutes.stream()
                .collect(Collectors.toMap(Valute::getCharCode, valute -> valute));
        valuteCacheService.set(valuteMap);
    }
}
