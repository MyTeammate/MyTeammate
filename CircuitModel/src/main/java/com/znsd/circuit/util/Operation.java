package com.znsd.circuit.util;

public class Operation {

	public String getOperation(int state,String msg) {
		String status = state==0?"禁用":"启用";
		return "<a href='javascript:onclick=able"+msg+"()'>"+status+"</a>  &nbsp;&nbsp;|&nbsp;&nbsp;  <a href='javascript:onclick=update"+msg+"()'>修改</a>  &nbsp;&nbsp;|&nbsp;&nbsp;  <a href='javascript:onclick=delete"+msg+"()'>删除</a>";
	}
}
