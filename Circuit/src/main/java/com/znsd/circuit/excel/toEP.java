package com.znsd.circuit.excel;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.plaf.synth.SynthSpinnerUI;

import com.znsd.circuit.model.TaskEliminate;
import com.znsd.circuit.model.Taskpolling;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class toEP {
	public String  outputExcel(List<?> arrayList,String type,String path,String name){
		//System.out.println("type:"+type+",path:"+path+",name:"+name);
		WritableWorkbook bWorkuser = null;  
        try {  
            // 创建Excel对象  
        	if(name.indexOf(".xls")>0) {
        	}else {
        		name=name+".xls";
        	}
            bWorkuser = Workbook.createWorkbook(new File(path+name));  
            // 通过Excel对象创建一个选项卡对象  
            WritableSheet sheet = bWorkuser.createSheet("sheet1", 0);  
            for (int i = 0; i < arrayList.size(); i++) {  
            	if("消缺".equals(type)) {
            		if(i==0) {
            			Label label9=new Label(0,i+1,String.valueOf("任务编号"));  
    	                Label label8=new Label(1+1,i+1,String.valueOf("任务名称"));  
    	                Label label7=new Label(2+2,i+1,String.valueOf("线路编号"));  
    	                Label label6=new Label(3+3,i+1,String.valueOf("起始杆号")); 
    	                Label label0=new Label(4+4,i+1,String.valueOf("终止杆号"));
    	                // 将创建好的单元格放入选项卡中  
    	                sheet.addCell(label9);  
    	                sheet.addCell(label8);  
    	                sheet.addCell(label7);  
    	                sheet.addCell(label6);  
    	                sheet.addCell(label0);
            		}
            		TaskEliminate t=(TaskEliminate) arrayList.get(i);
            		// 创建一个单元格对象，第一个为列，第二个为行，第三个为值  
	                Label label=new Label(0,i+2,String.valueOf(t.getTcoding()));  
	                Label label1=new Label(1+1,i+2,String.valueOf(t.getTename()));  
	                Label label2=new Label(2+2,i+2,String.valueOf(t.getEthreadCoding()));  
	                Label label3=new Label(3+3,i+2,String.valueOf(t.getEstartTower())); 
	                Label label4=new Label(4+4,i+2,String.valueOf(t.getTendTower()));
	                // 将创建好的单元格放入选项卡中  
	                sheet.addCell(label);  
	                sheet.addCell(label1);  
	                sheet.addCell(label2);  
	                sheet.addCell(label3);  
	                sheet.addCell(label4);
            	}else if("巡检".equals(type)){
            		if(i==0) {
            			Label label9=new Label(0,i+1,String.valueOf("任务编号"));  
    	                Label label8=new Label(1+1,i+1,String.valueOf("任务名称"));  
    	                Label label7=new Label(2+2,i+1,String.valueOf("线路编号"));  
    	                Label label6=new Label(3+3,i+1,String.valueOf("起始杆号")); 
    	                Label label0=new Label(4+4,i+1,String.valueOf("终止杆号"));
    	                // 将创建好的单元格放入选项卡中  
    	                sheet.addCell(label9);  
    	                sheet.addCell(label8);  
    	                sheet.addCell(label7);  
    	                sheet.addCell(label6);  
    	                sheet.addCell(label0);
            		}
            		// 创建一个单元格对象，第一个为列，第二个为行，第三个为值  
            		Taskpolling t=(Taskpolling) arrayList.get(i);
	                Label label=new Label(0,i+2,String.valueOf(t.getCoding()));  
	                Label label1=new Label(1+1,i+2,String.valueOf(t.getTanem()));  
	                Label label2=new Label(2+2,i+2,String.valueOf(t.getThreadCoding())); 
	                Label label3=new Label(3+3,i+2,String.valueOf(t.getStartTower())); 
	                Label label4=new Label(4+4,i+2,String.valueOf(t.getEngTower())); 
	                // 将创建好的单元格放入选项卡中  
	                sheet.addCell(label);  
	                sheet.addCell(label1);  
	                sheet.addCell(label2);  
	                sheet.addCell(label3); 
	                sheet.addCell(label4);
            	}
             
            
            }  
            // 写入目标路径  
            bWorkuser.write();  
  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                bWorkuser.close();  
            } catch (WriteException | IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return "success";
	}  
}
