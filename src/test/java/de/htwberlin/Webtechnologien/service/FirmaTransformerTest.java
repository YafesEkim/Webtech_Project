package de.htwberlin.Webtechnologien.service;

import de.htwberlin.Webtechnologien.persistence.FirmaEntity;
import de.htwberlin.Webtechnologien.persistence.RechnungEntity;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;

import static org.mockito.Mockito.doReturn;


import static org.junit.jupiter.api.Assertions.*;

class FirmaTransformerTest implements WithAssertions {

    private final FirmaTransformer test = new FirmaTransformer();

    @Test
    @DisplayName("Should transform FirmaEntity to Firma")
    void transformEntity() {
        // given
        var firmaEntity = Mockito.mock(FirmaEntity.class);
        doReturn(111L).when(firmaEntity).getId();
        doReturn("YM AG").when(firmaEntity).getFirmaName();
        doReturn("Kurfürstendamm").when(firmaEntity).getFirmaAddress();
        doReturn("12345").when(firmaEntity).getUst_id();
        doReturn(List.of(new RechnungEntity())).when(firmaEntity).getRechnungen();

        // when
        var result = test.transformEntity(firmaEntity);

        // then
        assertThat(result.getId()).isEqualTo(111);
        assertThat(result.getFirmaName()).isEqualTo("YM AG");
        assertThat(result.getAddress()).isEqualTo("Kurfürstendamm");
        assertThat(result.getUst_id()).isEqualTo("12345");
        assertThat(result.getRechnungIds()).hasSize(1);
    }


}
