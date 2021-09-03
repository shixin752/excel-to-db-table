package com.shixin.exceltodbtable.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author shixin
 * @date 2021/9/2 17:46
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DBModel1 {

    @Excel(name="列名")
    private String columnName;
    @Excel(name="类型")
    private String type;
    @Excel(name="大小")
    private String size;
    @Excel(name="主键")
    private String key;
    @Excel(name="非空")
    private String isNull;
    @Excel(name="字段描述")
    private String notes;
    @Excel(name="表描述")
    private String tableDesc;
    @Excel(name="表名称")
    private String tableName;

}
