package com.iuvity.hulkstore.product.infraestructure.service.impl;

import com.iuvity.hulkstore.product.domain.entities.KardexEntity;

import java.util.ArrayList;
import java.util.List;

public class UtilTexts {
    public static List<KardexEntity> getKardexs() {
        List<KardexEntity> list = new ArrayList<>();
        KardexEntity k1 = new KardexEntity();
        KardexEntity k2 = new KardexEntity();
        k1.setId(1L);
        k2.setId(2L);
        k1.setCant(20);
        k2.setCant(20);
        list.add(k1);
        list.add(k2);
        return list;
    }

    public static KardexEntity getKardex() {
        KardexEntity k = new KardexEntity();
        k.setId(1L);
        k.setCant(20);
        return k;
    }
}
