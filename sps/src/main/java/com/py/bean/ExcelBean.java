package com.py.bean;

import java.util.List;


public class ExcelBean<T> {
	
	private String sheetName = "Sheet1";//默认生成的sheet名称
    private String header="";//题头
    private String footer="";//脚注
    //底下是必须具备的属性
    private String fileName;
    private String[] columnNames;//列名
    private String[] methodNames;//与列名对应的方法名
    private List<T> entities;//数据实体
     
     
     
 
    public ExcelBean(String fileName, String[] columnNames, String[] methodNames, List<T> entities) {
        this("sheet1","","",fileName,columnNames,methodNames,entities);
    }
    public ExcelBean(String sheetName, String header, String footer, String fileName, String[] columnNames,
            String[] methodNames, List<T> entities) {
         
        this.sheetName = sheetName;
        this.header = header;
        this.footer = footer;
        this.fileName = fileName;
        this.columnNames = columnNames;
        this.methodNames = methodNames;
        this.entities = entities;
    }
    public String getHeader() {
        return header;
    }
    public void setHeader(String header) {
        this.header = header;
    }
     
    public String getSheetName() {
        return sheetName;
    }
    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }
    public List<T> getEntities() {
        return entities;
    }
    /**
     * 
     * @param entities 用于导出Excel的实体集合
     */
    public void setEntities(List<T> entities) {
        this.entities = entities;
    }
     
    public String getFooter() {
        return footer;
    }
    public void setFooter(String footer) {
        this.footer = footer;
    }
 
    public String[] getColumnNames() {
        return columnNames;
    }
 
    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }
 
    public String getFileName() {
        return fileName;
    }
 
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
 
 
 
    public String[] getMethodNames() {
        return methodNames;
    }
 
 
 
    public void setMethodNames(String[] methodNames) {
        this.methodNames = methodNames;
    } 

}
