package com.jh.leetcode;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    private static final Map<String, List<String>> COLORS_MAP = ImmutableMap.<String, List<String>>builder()
            .put("现代商务", ImmutableList.of("#597694","#42C4FF","#009191","#99CCFF","#6D739E","#C9FFC2","#709986","#FEE8A5","#A261C2","#CBB9FE","#BF88C2","#9EA7FF"))

            .build();

    public static void main(String[] args) {
        String s = "INSERT INTO FINE_CONF_ENTITY VALUES('ChartPreStyleConfig.preStyleMap.%s.colorList',";
        COLORS_MAP.forEach((key, value) -> {
//            INSERT INTO FINE_CONF_ENTITY VALUES('ChartPreStyleConfig.preStyleMap.\u5546\u52a1\u84dd.colorList','["-11358999","-14260562","-7287938","-11950436","-281518","-5471383","-9382960","-9333320","-350562","-4699548","-9331218","-9738572"]')
            String collect = value.stream().map(color -> String.valueOf(Color.decode(color).getRGB())).collect(Collectors.joining("\",\""));
            System.out.println(String.format(s, key)+String.format("'[\"%s\"]');", collect));
        });
    }
}
