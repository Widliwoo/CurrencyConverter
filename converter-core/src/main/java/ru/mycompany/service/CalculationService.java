package ru.mycompany.service;

import ru.mycompany.entity.Valute;

import java.math.BigDecimal;

public class CalculationService {

    private ValuteService valuteService;

    /**
     * Конвертируета одну валюту в другую.
     * Формула конвертации валюты A в B:
     * quantityB = quantityA : nominalA * valueA : valueB * nominalB
     */
    public BigDecimal convertToCurrency(BigDecimal quantityFrom, String charCodeFrom, String charCodeTo) {
        Valute from = valuteService.getByCharCode(charCodeFrom);
        Valute to = valuteService.getByCharCode(charCodeTo);

        BigDecimal nominalFrom = BigDecimal.valueOf(from.getNominal());
        BigDecimal nominalTo = BigDecimal.valueOf(to.getNominal());

        BigDecimal valueFrom = from.getValue();
        BigDecimal valueTo = to.getValue();

        return quantityFrom
                .divide(nominalFrom)
                .multiply(valueFrom)
                .divide(valueTo)
                .multiply(nominalTo);
    }
}
