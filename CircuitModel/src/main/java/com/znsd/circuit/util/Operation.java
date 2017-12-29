package com.znsd.circuit.util;

public class Operation {

	public String getOperation(int state) {
		String status = state==0?"禁用":"启用";
		return "<a href='javascript:onclick=ableLine()'>"+status+"</a>  &nbsp;&nbsp;|&nbsp;&nbsp;  <a href='javascript:onclick=updateLine()'>修改</a>  &nbsp;&nbsp;|&nbsp;&nbsp;  <a href='javascript:onclick=deleteLine()'>删除</a>";
	}
}
