package com.shixin.exceltodbtable.service;


import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.excel.imports.ExcelImportService;
import com.shixin.exceltodbtable.deal.TransDeal;
import com.shixin.exceltodbtable.model.DBModel1;
import com.shixin.exceltodbtable.model.TFModel;
import com.shixin.exceltodbtable.model.TypeCase;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @author shixin
 * @date 2021/9/2 17:43
 */
public class Exx {

    public static void main(String[] args) throws Exception {
        String filePath = "src/main/resources/model.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        ImportParams params = new ImportParams();
        final ExcelImportService excelImportService = new ExcelImportService();
        ExcelImportResult excelImportResult =excelImportService.importExcelByIs(fis, DBModel1.class, params, false);
        //校验成功数据
        List<DBModel1> list = excelImportResult.getList();
        final Field failCollection = ExcelImportService.class.getDeclaredField("failCollection");
        failCollection.setAccessible(true);
        //校验失败数据
        List<DBModel1> failList = (List) failCollection.get(excelImportService);

        System.out.println(TransDeal.dealWay1(list));


    }

}
