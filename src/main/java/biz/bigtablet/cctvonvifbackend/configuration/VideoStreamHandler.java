package biz.bigtablet.cctvonvifbackend.configuration;


import biz.bigtablet.cctvonvifbackend.service.VideoStreamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@RequiredArgsConstructor
@Component
public class VideoStreamHandler extends TextWebSocketHandler {

    private final VideoStreamService videoStreamService;
    // 연결이 설정된 후 비디오 스트림 시작

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        videoStreamService.startStream(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
    }

}
