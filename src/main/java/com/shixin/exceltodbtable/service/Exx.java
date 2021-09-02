package com.shixin.exceltodbtable.service;


import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.excel.imports.ExcelImportService;
import com.shixin.exceltodbtable.model.DBModel1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @author INHE0985
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

        System.out.println(list.toString());
    }

    public static <E> List<E> readExcel(String filePath, int sheetIndex, Class<E> clazz) {
        // 定义输入流
        FileInputStream fis = null;
        List<E> datas = null;

        try {
            // 创建输入流对象
            fis = new FileInputStream(filePath);
            // 创建一个easypoi使用的配置类
            ImportParams params = new ImportParams();
            // 设置表格坐标
            params.setStartSheetIndex(sheetIndex);
            // 校验Excel文件，去掉空行
            params.setNeedVerify(true);
            // 读取数据
            datas = ExcelImportUtil.importExcel(fis, clazz, params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return datas;
    }


}
