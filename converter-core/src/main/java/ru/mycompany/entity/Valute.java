package ru.mycompany.entity;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Стоимость валюты в российских рублях
 */
public class Valute {

    private Integer numCode;
    private String charCode;

    /**
     * За какое количество валюты указана цена
     */
    private Integer nominal;
    private String name;

    /**
     * Цена nominal единиц валюты
     */
    private BigDecimal value;

    public Valute() {
    }

    public Valute(Integer numCode, String charCode, Integer nominal, String name, BigDecimal value) {
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
    }

    public Integer getNumCode() {
        return numCode;
    }

    public void setNumCode(Integer numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public Integer getNominal() {
        return nominal;
    }

    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Valute valute = (Valute) o;
        return Objects.equals(numCode, valute.numCode) && Objects.equals(charCode, valute.charCode) && Objects.equals(nominal, valute.nominal) && Objects.equals(name, valute.name) && Objects.equals(value, valute.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numCode, charCode, nominal, name, value);
    }
}
