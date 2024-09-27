package biz.bigtablet.cctvonvifbackend.configuration;


import biz.bigtablet.cctvonvifbackend.service.VideoStreamService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;


@Component
public class VideoStreamHandler extends TextWebSocketHandler {

    // CLIENTS에 웹소켓 세션을 담아둠
    private static final ConcurrentHashMap<String, WebSocketSession> CLIENTS = new ConcurrentHashMap<String,WebSocketSession>();

    // 클라이언트가 웹소켓 서버에 접속하게 되면 만들어지는 세션 값을 클라이언트 해시맵에 담아줌
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
       //super.afterConnectionEstablished(session);
        CLIENTS.put(session.getId(),session);
        System.out.println("연결되었습니다");
    }

    // 웹소켓 서버 접속이 끝났을 때 세션 값을 클라이언트 해시맵에서 제거
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        //super.afterConnectionClosed(session, status);
        CLIENTS.remove(session.getId());
    }



}
