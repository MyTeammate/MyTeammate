package com.lxit.circuit.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.znsd.circuit.model.User;




@ServerEndpoint(value="/perWork",configurator=GetHttpSessionConfigurator.class)
public class PerWork {

	 //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static CopyOnWriteArraySet<PerWork> webSocketSet = new CopyOnWriteArraySet<PerWork>();

    private static Map<Integer,Session> sessionList = new HashMap<Integer,Session>();
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    //private HttpSession session2;

    /**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session,EndpointConfig  config){
    	//System.out.println("连接成功！");
    HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
   	User user = (User) httpSession.getAttribute("user");	
        this.session = session;
        sessionList.put(user.getId(),session);
        webSocketSet.add(this);     //加入set中
      
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(){
   	 webSocketSet.remove(this);  //从set中删除
    }
    
    
    
    /**
     * 收到客户端消息后调用的方法、
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session,EndpointConfig  config) {
   	 //  System.out.println("来自客户端的消息:" + message);
   	     Set<Integer> users = sessionList.keySet();
	   	for (Integer userId : users) {
	   		int id = Integer.parseInt(message);
			if(userId==id) {
				Session se = sessionList.get(userId);
				try {
					se.getBasicRemote().sendText(userId+"");
					// System.out.println("发送给:" + userId);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
        
    }

    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        error.printStackTrace();
    }
    
    
    public void sendMessage(String message) throws IOException{
        this.session.getBasicRemote().sendText(message);
    }
}
