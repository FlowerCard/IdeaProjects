package com.qf.test0820.test02.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * 国家实体类
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/21.
 */
public class Countries implements Serializable {

    private static final long serialVersionUID = -8280747101924857196L;
    private String countryId;
    private String countryName;

    public Countries() {
    }

    public Countries(String countryId, String countryName) {
        this.countryId = countryId;
        this.countryName = countryName;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "countryId='" + countryId + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Countries countries = (Countries) o;
        return Objects.equals(countryId, countries.countryId) && Objects.equals(countryName, countries.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, countryName);
    }
}
