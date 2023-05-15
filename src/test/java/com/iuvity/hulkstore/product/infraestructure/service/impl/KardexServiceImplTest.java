package com.iuvity.hulkstore.product.infraestructure.service.impl;

import com.iuvity.hulkstore.product.domain.entities.KardexEntity;
import com.iuvity.hulkstore.product.infraestructure.service.KardexService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class KardexServiceImplTest {
    @Mock
    KardexService kardexService;


    @AfterEach
    void tearDown() {
    }

    @Test
    void findByIdText(){
        when(kardexService.findById(1L)).thenReturn(Optional.of(UtilTexts.getKardex()));
        Optional<KardexEntity> kardex = kardexService.findById(1L);
        assertTrue(kardex.isPresent());
        assertEquals(1L, kardex.orElseThrow().getId());
    }

    @Test
    void findKardexListEmptyTest() {
        List<KardexEntity> data = Collections.emptyList();
        when(kardexService.findAll()).thenReturn(data);
        List<KardexEntity> kardex = kardexService.findAll();
        assertEquals(kardex.size(), 0);
    }

    @Test
    void find(){
        when(kardexService.findAll()).thenReturn(UtilTexts.getKardexs());
        List<KardexEntity> kardexs = kardexService.findAll();
        assertEquals(2, kardexs.size());
    }
}