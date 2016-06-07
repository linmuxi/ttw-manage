/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.common.util;

import java.io.File;
import java.util.List;
import java.util.Map;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * Excel导入导出
 * @author 
 *
 */
public class ExcelUtils {
	

	/** 
     * 导出Excel表 
     * @param data 数据库结果 
     * @param filePath 要保存的路径，文件名为 fileName.xls 
     * @param sheetName 工作簿名称
     * @param columnName 列名，类型为Vector<String> 
     */  
	public static void WriteExcel(List<Map<String, Object>> data, String filePath,String sheetName, String[] cnNames,String[] enNames) {
		WritableWorkbook workbook = null;
		WritableSheet sheet = null;
		int rowNum = 1; // 从第一行开始写入
		try {
			workbook = Workbook.createWorkbook(new File(filePath)); // 创建Excel文件
			sheet = workbook.createSheet(sheetName, 0); // 创建名为 sheetName 的工作簿
			writeCol(sheet, cnNames, 0); // 首先将列名写入
			int rows = null != data && data.size() > 0 ? data.size() : 0;
			for (int i = 0; i < rows; i++) {
				Map<String, Object> rowData = data.get(i);
				// 将结果集写入
				int columnCount = null != cnNames && cnNames.length > 0 ? cnNames.length : 0;
				String[] col = new String[columnCount]; // 用以保存一行数据
				for (int j = 0; j < columnCount; j++) {// 将一行内容保存在col中
					String columnName = enNames[j];
					String columnValue = null == rowData.get(columnName) ? "" : String.valueOf(rowData.get(columnName));
					col[j] = columnValue;
				}
				// 写入Excel
				writeCol(sheet, col, rowNum++);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭
				workbook.write();
				workbook.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}  
    
    
    
    /*** 
     * 将数组写入工作簿  
     * @param sheet 要写入的工作簿 
     * @param col 要写入的数据数组 
     * @param rowNum 要写入哪一行 
     * @throws WriteException  
     * @throws RowsExceededException  
     */  
    private static void writeCol(WritableSheet sheet, String[] col, int rowNum) throws RowsExceededException, WriteException {  
        int size = col.length; // 获取集合大小  
        for(int i = 0; i < size; i++) { // 写入每一列  
            Label label = new Label(i, rowNum, col[i]);   
            sheet.addCell(label);  
        }  
    }  
	
}
