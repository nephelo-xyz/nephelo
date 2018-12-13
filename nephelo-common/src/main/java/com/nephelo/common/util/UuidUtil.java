package com.nephelo.common.util;

import java.util.UUID;

/**
 * Created by nephelo on 2018-12-13.
 */
public class UuidUtil {

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr = str.replace("-", "");
        return uuidStr;
    }

}