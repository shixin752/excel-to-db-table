package com.shixin.exceltodbtable.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * 生成建表语句中  数据类型的大小写模型
 * @author INHE0985
 * @date 2021/9/3 17:47
 */
public class TypeCase {

    public static Map<String,Boolean> map = new HashMap<>();
    static {
        map.put("varchar",false);
        map.put("int",false);
        map.put("date",false);
        map.put("smallint",false);
        map.put("double",false);
        map.put("integer",false);
        map.put("decimal",false);
    }

    public static Map<String, Boolean> getMap() {
        return map;
    }
}
