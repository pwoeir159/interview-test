package com.koda.interview_test.unit;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.koda.interview_test.model.po.CurrencyInfoPO;
import com.koda.interview_test.repository.CurrencyInfoRepository;

@DataJpaTest
public class CurrencyInfoRepositoryTest {

    @Autowired
    private CurrencyInfoRepository repository;
    
    @Test
    @DisplayName("Create CurrencyInfo - should save and return entity")
    void saveCurrencyInfo_success() {
        CurrencyInfoPO po = new CurrencyInfoPO();
        po.setCurrencyCode("TWD");
        po.setDescription("New Taiwan dollar");

        CurrencyInfoPO saved = repository.save(po);

        assertThat(saved.getCurrencyCode()).isEqualTo("TWD");
        assertThat(saved.getDescription()).isEqualTo("New Taiwan dollar");
    }

    @Test
    @DisplayName("Read CurrencyInfo - should find entity by code")
    void findCurrencyInfoByCode_success() {
        CurrencyInfoPO po = new CurrencyInfoPO();
        po.setCurrencyCode("EUR");
        po.setDescription("Euro");
        repository.save(po);

        Optional<CurrencyInfoPO> found = repository.findById("EUR");

        assertThat(found).isPresent();
        assertThat(found.get().getDescription()).isEqualTo("Euro");
    }

    @Test
    @DisplayName("Update CurrencyInfo - should update name correctly")
    void updateCurrencyInfo_success() {
        CurrencyInfoPO po = new CurrencyInfoPO();
        po.setCurrencyCode("JPY");
        po.setDescription("Yen");
        CurrencyInfoPO saved = repository.save(po);

        saved.setDescription("Japanese Yen");
        CurrencyInfoPO updated = repository.save(saved);

        assertThat(updated.getDescription()).isEqualTo("Japanese Yen");
    }

    @Test
    @DisplayName("Delete CurrencyInfo - should remove entity")
    void deleteCurrencyInfo_success() {
        CurrencyInfoPO po = new CurrencyInfoPO();
        po.setCurrencyCode("GBP");
        po.setDescription("Pound Sterling");
        CurrencyInfoPO saved = repository.save(po);

        repository.delete(saved);

        Optional<CurrencyInfoPO> deleted = repository.findById(saved.getCurrencyCode());
        assertThat(deleted).isNotPresent();
    }
}
