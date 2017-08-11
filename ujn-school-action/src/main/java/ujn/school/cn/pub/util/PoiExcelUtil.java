/**   
 * @Title: PoiExcelUtil.java 
 * @Package: com.egintra.sdcyy.zgzssb.pub 
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com   
 * @date 2017年3月17日 下午2:28:54 
 * @version V1.0   
 */
package ujn.school.cn.pub.util;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @Title: PoiExcelUtil.java
 * @Description: TODO
 * @author lizhaotao lzh_me@126.com
 * @date 2017年3月17日 下午2:28:54
 * @version V1.0
 */
public class PoiExcelUtil {

	public static void export(HttpServletResponse response, List<?> dataList,
			String[] titles, String[] columns, Integer[] widths,
			String sheetName, @SuppressWarnings("rawtypes") Class clz,
			boolean isXssF,String titlename) {

		OutputStream os = null;
		try {
			os = response.getOutputStream();
			// 构建excel
			buildExcel(dataList, titles, columns, widths, clz, sheetName, os,
					isXssF,titlename);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static void buildExcel(List<?> dataList, String[] titles,
			String[] columns, Integer[] widths,
			@SuppressWarnings("rawtypes") Class clz, String sheetName,
			OutputStream os, boolean isXssF,String titlename) {
		Workbook workbook = null;
		if (isXssF) {
			// 创建2007excel后缀是.xlsx
		//	workbook = new XSSFWorkbook();
		} else {
			// 创建2003excel后缀是.xls
			workbook = new HSSFWorkbook();
		}
		CellRangeAddress cra=new CellRangeAddress(0, 0, 0, titles.length-1);
		// 创建sheet
		Sheet sheet = workbook.createSheet(sheetName);
		sheet.addMergedRegion(cra);
		// 设置默认列宽度与高度
		sheet.setDefaultColumnWidth(20);
		// sheet.setDefaultRowHeight(Short.parseShort("5"));
		// 得到第一行,在excel中第一行第一列的坐标是(0,0)
		Row row1 = sheet.createRow(0);
		Cell cell1 = row1.createCell(0);
		cell1.setCellValue(titlename);
		cell1.setCellStyle(headStyle(workbook));
		Row row = sheet.createRow(1);
		// 将表头插入到第一行
		for (int i = 0; i < titles.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(titles[i]);
			cell.setCellStyle(headStyle(workbook));
			// sheet.setColumnWidth(i, widths[i]);
		}
		// 数据不为空的时候执行
		if (null != dataList && !dataList.isEmpty()) {
			Row dataRow = null;
			//CellStyle contentStyle = workbook.createCellStyle();
			HSSFCellStyle cellStyle = (HSSFCellStyle) workbook.createCellStyle();
			// 插入对象数据,从0开始，createRow的时候是i+1
			for (int i = 0; i < dataList.size(); i++) {
				Object t = dataList.get(i);
				// 新建一行
				dataRow = sheet.createRow(i + 2);
				for (int j = 0; j < columns.length; j++) {
					Cell cell = dataRow.createCell(j);
					String fieldName = columns[j];
					String getMethodName = "get"
							+ fieldName.substring(0, 1).toUpperCase()
							+ fieldName.substring(1);
					try {
						Method getMethod = clz.getMethod(getMethodName,
								new Class[] {});
						Object value = getMethod.invoke(t, new Object[] {});
						// 判断值的类型后进行强制类型转换
						// 判断值的类型后进行强制类型转换
						String textValue = "";
						if (value == null || "".equals(value)) {
							value = "";
						} else if (value instanceof Integer) {
							int intValue = (Integer) value;
							cell.setCellValue(intValue);
						} else if (value instanceof Float) {
							float fValue = (Float) value;
							cell.setCellValue(fValue + "");
						} else if (value instanceof Double) {
							double dValue = (Double) value;
							cell.setCellValue(dValue + "");
						} else if (value instanceof Long) {
							long longValue = (Long) value;
							cell.setCellValue(longValue);
						}
						// boolean
						if (value instanceof Boolean) {
							/*
							 * boolean bValue = (Boolean) value; textValue =
							 * "男"; if (!bValue) { textValue = "女"; }
							 */
						} else if (value instanceof Date) {
							Date date = (Date) value;
							SimpleDateFormat sdf = new SimpleDateFormat("");
							textValue = sdf.format(date);
							cell.setCellValue(textValue);
							cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
						} else {
							// 其它数据类型都当作字符串简单处理
							textValue = value.toString();
							cell.setCellValue(textValue);
						}
						// 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
						/*
						 * if (textValue != null) { Pattern p =
						 * Pattern.compile("^//d+(//.//d+)?{1}"); Matcher
						 * matcher = p.matcher(textValue); if
						 * (matcher.matches()) { // 是数字当作double处理
						 * cell.setCellValue(Double.parseDouble(textValue)); }
						 * else { HSSFRichTextString richString = new
						 * HSSFRichTextString( textValue); Font font3 =
						 * workbook.createFont();
						 * font3.setColor(HSSFColor.BLUE.index);
						 * richString.applyFont(font3);
						 * cell.setCellValue(richString); } }
						 */
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} finally {
						// 清理资源
					}
				}

			}
		}

		// 将工作薄写入到输出流中
		try {
			workbook.write(os);
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * // 创建HSSFWorkbook工作薄对象 public static HSSFWorkbook
	 * export_text(List<Person> list) { try { // 创建工作薄对象 HSSFWorkbook wb = new
	 * HSSFWorkbook(); // 创建标题行样式 HSSFCellStyle headStyle = headStyle(wb); //
	 * 创建内容行样式 HSSFCellStyle contentStyle = contentStyle(wb);
	 * 
	 * // 创建表 HSSFSheet sheet_1 = wb.createSheet("人员信息"); // 设置表的默认列宽
	 * sheet_1.setDefaultColumnWidth(30);
	 * 
	 * // 创建标题行 HSSFRow headRow = sheet_1.createRow(0); HSSFCell head_cell_1 =
	 * headRow.createCell(0); // 创建标题行第一列 head_cell_1.setCellValue("姓名"); //
	 * 第一列内容 head_cell_1.setCellStyle(headStyle); // 将标题行样式添加
	 * 
	 * HSSFCell head_cell_2 = headRow.createCell(1);
	 * head_cell_2.setCellValue("性别"); head_cell_2.setCellStyle(headStyle);
	 * 
	 * HSSFCell head_cell_3 = headRow.createCell(2);
	 * head_cell_3.setCellValue("年龄"); head_cell_3.setCellStyle(headStyle);
	 * 
	 * // 为内容行添加数据和样式 for (int i = 1; i <= list.size(); i++) { HSSFRow
	 * contentRow = sheet_1.createRow(i); HSSFCell content_cell_1 =
	 * contentRow.createCell(0); content_cell_1.setCellValue(list.get(i -
	 * 1).getName()); content_cell_1.setCellStyle(contentStyle);
	 * 
	 * HSSFCell content_cell_2 = contentRow.createCell(1);
	 * content_cell_2.setCellValue(list.get(i - 1).getSex());
	 * content_cell_2.setCellStyle(contentStyle);
	 * 
	 * HSSFCell content_cell_3 = contentRow.createCell(2);
	 * content_cell_3.setCellValue(list.get(i - 1).getAge());
	 * content_cell_3.setCellStyle(contentStyle); } return wb; } catch
	 * (Exception e) { e.getStackTrace(); }
	 * 
	 * return null; }
	 */

	/**
	 * 创建标题行样式
	 * 
	 * @param wb
	 * @return
	 */
	public static CellStyle headStyle(Workbook wb) {
		CellStyle headStyle = wb.createCellStyle(); // 创建样式对象
		Font headFont = wb.createFont(); // 创建字体
		headFont.setFontName("微软雅黑");
		headFont.setBold(true);
		//headFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		headFont.setColor(HSSFFont.COLOR_NORMAL);
		headStyle.setAlignment(HorizontalAlignment.CENTER);
		headStyle.setFont(headFont);
		headStyle.setBorderBottom(BorderStyle.THIN); // 下边框
		headStyle.setBorderLeft(BorderStyle.THIN);// 左边框
		headStyle.setBorderTop(BorderStyle.THIN);// 上边框
		headStyle.setBorderRight(BorderStyle.THIN);// 右边框

		return headStyle;
	}

	/**
	 * 创建内容行样式
	 * 
	 * @param wb
	 * @return
	 */
	public static CellStyle contentStyle(Workbook wb) {
		CellStyle contentStyle = wb.createCellStyle();
		Font contentFont = wb.createFont();
		contentFont.setFontName("微软雅黑");
		// contentFont.setBold(true);
		contentFont.setColor(HSSFFont.COLOR_NORMAL);

		contentStyle.setAlignment(HorizontalAlignment.CENTER);
		contentStyle.setFont(contentFont);
		contentStyle.setBorderBottom(BorderStyle.THIN); // 下边框
		contentStyle.setBorderLeft(BorderStyle.THIN);// 左边框
		contentStyle.setBorderTop(BorderStyle.THIN);// 上边框
		contentStyle.setBorderRight(BorderStyle.THIN);// 右边框
		return contentStyle;
	}
}
