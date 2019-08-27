package com.nephelo.study.maps;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HashMaps {

    void synchronizedSetTest() {
        Map map = new HashMap();
        Map map1 = Collections.synchronizedMap(map);
    }
}
