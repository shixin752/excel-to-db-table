package com.shixin.exceltodbtable.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * 真*假 模型
 * @author INHE0985
 * @date 2021/9/3 18:02
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TFModel {

    public static Map<String,Boolean> typeMap = new HashMap<>();
    public static Map<String,Boolean> tfMap = new HashMap<>();

    static {
        typeMap.put("varchar",false);
        typeMap.put("int",false);
        typeMap.put("date",false);
        typeMap.put("smallint",false);
        typeMap.put("double",false);
        typeMap.put("integer",false);
        typeMap.put("decimal",false);
    }
    static {
        tfMap.put("true",true);
        tfMap.put("false",false);

        tfMap.put("1",true);
        tfMap.put("0",false);

        tfMap.put("√",true);
        tfMap.put("×",false);
    }

    public static Map<String, Boolean> getTypeMap() {
        return typeMap;
    }

    public static Map<String, Boolean> getTFMap() {
        return tfMap;
    }

}
