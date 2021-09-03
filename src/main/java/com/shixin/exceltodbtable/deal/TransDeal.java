package com.shixin.exceltodbtable.deal;

import com.shixin.exceltodbtable.model.DBModel1;
import com.shixin.exceltodbtable.model.TFModel;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shixin
 * @date 2021/9/3 11:48
 */
public class TransDeal {

    public static Map<String,Boolean> typeMap = TFModel.getTypeMap();
    public static Map<String,Boolean> tfMap = TFModel.getTFMap();
    public static Boolean  columnCase = true;


    /**
     * (fileName=C1, type=DECIAML, size=(16,2), key=false, isNull=true,
     *  notes=C1备注, tableDesc=表备注, tableName=table_test)
     * @param list 数据列表
     * param columnCase 列名大小写 true：大写  false：小写
     * param typeMap 类型大小写模型 true：大写  false：小写
     * @return
     */
    public static String dealWay1(List<DBModel1> list){
        StringBuilder sql = new StringBuilder();
        sql.append("create table " + list.get(0).getTableName() + "\n");
        sql.append("(");
        sql.append("\n");
        for (int i=0;i<list.size();i++){
            DBModel1 dbModel1 = list.get(i);
            sql.append("\t"+ columnCase(dbModel1.getColumnName(),columnCase));
            sql.append("\t"+ typeCase(dbModel1.getType(),typeMap) + dbModel1.getSize());
            sql.append("\t"+ isNull(dbModel1.getIsNull(),tfMap));
            sql.append("\t"+ comment(dbModel1.getNotes()));
            if (i<list.size()-1){
                sql.append(","+"\n");
            }else {
                sql.append("\n");
            }
        }
        sql.append(")");

        return new String(sql);

    }


    /**
     * 列名 大小写转换
     * @param columnName
     * @param columnCase
     * @return
     */
    public static String columnCase(String columnName, boolean columnCase){
        if (columnCase){
            return columnName.toUpperCase();
        }else {
            return columnName.toLowerCase();
        }
    }
    /**
     * type 大小写转换
     * @param typeName
     * @param map
     * @return
     */
    public static String typeCase(String typeName, Map<String,Boolean> map){
        Boolean aBoolean = map.get(typeName);
        if (aBoolean){
            return typeName.toUpperCase();
        }else {
            return typeName.toLowerCase();
        }
    }

    public static String isNull(String tf, Map<String,Boolean> map){
        Boolean aBoolean = map.get(tf);
        if (aBoolean){
            return "null";
        }else {
            return "not null";
        }
    }

    public static String comment(String comment){
        if (StringUtils.isNotBlank(comment)){
            return "comment" + "\t" + "'" + comment + "'";
        }else {
            return "";
        }
    }





}
