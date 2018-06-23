package com.zhbit.util;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @ProjectName: ICSystem
 * @ClassName: ExportExcelKit
 * @Description: 导出excel工具类
 * @Author: wenxuan
 * @CreateDate: 2018/6/22 19:10
 */
public class ExportExcelKit {

    private HSSFWorkbook workBook = null;
    private HSSFSheet sheet = null;
    private int rowIndex = 0;

    public ExportExcelKit() {
        HSSFWorkbook workBook = new HSSFWorkbook();
        this.workBook = workBook;
        this.sheet = workBook.createSheet();
    }

    public ExportExcelKit(HSSFWorkbook workBook) {
        this.workBook = workBook;
        this.sheet = workBook.createSheet();
    }

    public static void setFileDownloadHeader(String fileName,
                                             HttpServletResponse response, HttpServletRequest request) {
        String userAgent = request.getHeader("USER-AGENT");
        try {
            String finalFileName = null;
            if (userAgent.indexOf("MSIE") >= 0) {// IE浏览器
                finalFileName = URLEncoder.encode(fileName, "UTF8");
            } else if (userAgent.indexOf("Mozilla") >= 0) {// google,火狐浏览器
                finalFileName = new String(fileName.getBytes(), "ISO8859-1");
            } else {
                finalFileName = URLEncoder.encode(fileName, "UTF8");// 其他浏览器
            }
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=\""
                    + finalFileName + ".xls\"");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    public void exportExcel(ExportExcelUtil vo) {
        if (workBook == null) {
            throw new NullPointerException("请初始化HSSFWorkbook对象!");
        }
        this.workBook.setSheetName(0, vo.getSheetName());
        int columnsSize = vo.getColumnNames().size();

        // 给工作表列定义列宽(实际应用自己更改列数)
        for (int i = 0; i < columnsSize; i++) {
            if (i == 2 || i == 3 || i == 5) {
                sheet.setColumnWidth(i, 6000);
            } else {
                sheet.setColumnWidth(i, 5000);
            }
        }
        // 创建单元格样式
        HSSFCellStyle cellStyle = workBook.createCellStyle();

        // 指定单元格居中对齐
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        // 指定单元格垂直居中对齐
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        // 指定当单元格内容显示不下时自动换行
        cellStyle.setWrapText(true);

        // 设置单元格字体
        HSSFFont font = workBook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setFontName("微软雅黑");
        font.setFontHeight((short) 250);//表头列名字体大小
        cellStyle.setFont(font);

        // 创建报表头部
        createNormalHead(vo.getTitleName(), columnsSize);

        // 设置列头
        HSSFRow row2 = sheet.createRow(rowIndex++);
        HSSFCell cell = null;
        for (int i = 0; i < columnsSize; i++) {
            cell = row2.createCell(i);
            cell.setCellStyle(cellStyle);
            cell
                    .setCellValue(new HSSFRichTextString(vo.getColumnNames()
                            .get(i)));
        }
        int rowsSize = vo.getDatas().size() + rowIndex;
        int startIndex = rowIndex;
        // 循环创建中间的单元格的各项的值
        for (int i = startIndex; i < rowsSize; i++) {
            HSSFRow row = sheet.createRow((short) i);
            rowIndex++;
            for (int j = 0; j < columnsSize; j++) {
                cteateCell(workBook, row, (short) j,
                        HSSFCellStyle.ALIGN_CENTER_SELECTION, vo.getDatas()
                                .get(i - startIndex).get(j));
            }

        }
        //所有导出暂时屏蔽合计行
        if ("receipt".equals(vo.getType())) {
//					createLastSumRowReceipt(vo.getColumnNames().size(), vo.getDatas()
//							.size()
//							+ "");
        } else {
            // 创建最后一行的合计行
//					createLastSumRow(vo.getColumnNames().size(), vo.getDatas().size()
//							+ "");
        }
        // outputExcelStream(vo.getResponse(),vo.getFileName());
    }

    public void resetResponseHead(HttpServletResponse response, String fileName)
            throws Exception {
        try {
            fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new Exception(e);
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\""
                + fileName + ".xls" + "\"");
    }

    /**
     * 创建合计行
     *
     * @param colSum    需要合并到的列索引
     * @param cellValue
     */
    public void createLastSumRowReceipt(int colSum, String cellValue) {

        HSSFCellStyle cellStyle = workBook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 指定单元格居中对齐
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 指定单元格垂直居中对齐
        cellStyle.setWrapText(true);// 指定单元格自动换行

        // 单元格字体
        HSSFFont font = workBook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setFontName("微软雅黑");
        font.setFontHeight((short) 300);
        font.setColor(HSSFColor.ORANGE.index);
        cellStyle.setFont(font);
        HSSFRow lastRow = sheet.createRow((short) (sheet.getLastRowNum() + 1));
        HSSFCell sumCell = lastRow.createCell(0);

        sumCell.setCellValue(new HSSFRichTextString("合计"));
        sumCell.setCellStyle(cellStyle);
        HSSFCell sumCell2 = lastRow.createCell(1);
        sumCell2.setCellValue(new HSSFRichTextString(""));
        HSSFCell sumCell3 = lastRow.createCell(2);
        sumCell3 = lastRow.createCell(2);
        sumCell3.setCellStyle(cellStyle);
        sumCell3.setCellValue(new HSSFRichTextString(cellValue));

    }

    /**
     * @return the sheet
     */
    public HSSFSheet getSheet() {
        return sheet;
    }

    /**
     * @return the workBook
     */
    public HSSFWorkbook getWorkBook() {
        return workBook;
    }

    /**
     * 创建通用EXCEL头部
     *
     * @param headString 头部显示的字符
     * @param colSum     该报表的列数
     */
    public void createNormalHead(String headString, int colSum) {

        HSSFRow row = sheet.createRow(rowIndex++);

        // 设置第一行
        HSSFCell cell = row.createCell(0);
        row.setHeight((short) 450);

        // 定义单元格为字符串类型
        cell.setCellType(HSSFCell.ENCODING_UTF_16);
        cell.setCellValue(new HSSFRichTextString(headString));

        // 指定合并区域
        sheet
                .addMergedRegion(new CellRangeAddress(0, (short) 0, 0,
                        (short) (colSum - 1)));

        HSSFCellStyle cellStyle = workBook.createCellStyle();

        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 指定单元格居中对齐
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 指定单元格垂直居中对齐
        cellStyle.setWrapText(true);// 指定单元格自动换行

        // 设置单元格字体
        HSSFFont font = workBook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setFontName("微软雅黑");
        font.setFontHeight((short) 350);//第一行表名称字体大小
        cellStyle.setFont(font);

        cell.setCellStyle(cellStyle);
    }

    /**
     * 创建通用报表第二行
     *
     * @param params 统计条件数组
     * @param colSum 需要合并到的列索引
     */
    public void createNormalTwoRow(String[] params, int colSum) {
        HSSFRow row1 = sheet.createRow(1);
        row1.setHeight((short) 400);

        HSSFCell cell2 = row1.createCell(0);

        cell2.setCellType(HSSFCell.ENCODING_UTF_16);
        cell2.setCellValue(new HSSFRichTextString("统计时间：" + params[0] + "至"
                + params[1]));

        // 指定合并区域
        sheet.addMergedRegion(new CellRangeAddress(1, (short) 0, 1, (short) colSum));

        HSSFCellStyle cellStyle = workBook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 指定单元格居中对齐
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 指定单元格垂直居中对齐
        cellStyle.setWrapText(true);// 指定单元格自动换行

        // 设置单元格字体
        HSSFFont font = workBook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setFontName("微软雅黑");
        font.setFontHeight((short) 400);
        cellStyle.setFont(font);

        cell2.setCellStyle(cellStyle);

    }

    /**
     * 设置报表标题
     *
     * @param columHeader 标题字符串数组
     */
    public void createColumHeader(String[] columHeader) {

        // 设置列头
        HSSFRow row2 = sheet.createRow(2);

        // 指定行高
        row2.setHeight((short) 600);

        HSSFCellStyle cellStyle = workBook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 指定单元格居中对齐
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 指定单元格垂直居中对齐
        cellStyle.setWrapText(true);// 指定单元格自动换行

        // 单元格字体
        HSSFFont font = workBook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setFontName("微软雅黑");
        font.setFontHeight((short) 500);
        cellStyle.setFont(font);
		/*
		 * cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 设置单无格的边框为粗体
		 * cellStyle.setBottomBorderColor(HSSFColor.BLACK.index); // 设置单元格的边框颜色．
		 * cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		 * cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
		 * cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		 * cellStyle.setRightBorderColor(HSSFColor.BLACK.index);
		 * cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		 * cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
		 */

        // 设置单元格背景色
        cellStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        HSSFCell cell3 = null;

        for (int i = 0; i < columHeader.length; i++) {
            cell3 = row2.createCell(i);
            cell3.setCellType(HSSFCell.ENCODING_UTF_16);
            cell3.setCellStyle(cellStyle);
            cell3.setCellValue(new HSSFRichTextString(columHeader[i]));
        }

    }

    /**
     * 创建内容单元格
     *
     * @param workBook HSSFWorkbook
     * @param row      HSSFRow
     * @param col      short型的列索引
     * @param align    对齐方式
     * @param val      列值
     */
    public void cteateCell(HSSFWorkbook workBook, HSSFRow row, int col,
                           short align, String val) {
        HSSFCell cell = row.createCell(col);
        cell.setCellType(HSSFCell.ENCODING_UTF_16);
        cell.setCellValue(new HSSFRichTextString(val));
        // HSSFCellStyle cellstyle = workBook.createCellStyle();
        // cellstyle.setAlignment(align);
        // cell.setCellStyle(cellstyle);
    }

    /**
     * 创建合计行
     *
     * @param colSum    需要合并到的列索引
     * @param cellValue
     */
    public void createLastSumRow(int colSum, String cellValue) {

        HSSFCellStyle cellStyle = workBook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 指定单元格居中对齐
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 指定单元格垂直居中对齐
        cellStyle.setWrapText(true);// 指定单元格自动换行

        // 单元格字体
        HSSFFont font = workBook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setFontName("微软雅黑");
        font.setFontHeight((short) 400);
        font.setColor(HSSFColor.ORANGE.index);
        cellStyle.setFont(font);
        HSSFRow lastRow = sheet.createRow((short) (sheet.getLastRowNum() + 1));
        HSSFCell sumCell = lastRow.createCell(0);

        sumCell.setCellValue(new HSSFRichTextString("合计"));
        sumCell.setCellStyle(cellStyle);
        sheet.addMergedRegion(new CellRangeAddress(sheet.getLastRowNum(), (short) 1,
                sheet.getLastRowNum(), (short) (colSum - 1)));// 指定合并区域

        sumCell = lastRow.createCell(1);
        sumCell.setCellStyle(cellStyle);
        sumCell.setCellValue(new HSSFRichTextString(cellValue));

    }

    /**
     * 输入EXCEL文件
     *
     * @param fileName 文件名
     */
    public void outputExcel(String fileName) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File(fileName));
            workBook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 输入EXCEL文件
     *
     * @param fileName 文件名
     */
    public void outputExcelStream(HttpServletResponse response, String fileName) {
        try {
            resetResponseHead(response, fileName);
            workBook.write(response.getOutputStream());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}