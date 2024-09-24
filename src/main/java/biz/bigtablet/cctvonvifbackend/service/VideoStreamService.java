package biz.bigtablet.cctvonvifbackend.service;

import com.github.kokorin.jaffree.ffmpeg.FFmpeg;
import org.springframework.web.socket.WebSocketSession;

public class VideoStreamService {
    private static final String RTSP_URI = "rtsp://192.168.0.146:554";

    public void startStream(WebSocketSession session){// websocket 연결을 통해 비디오 스트리밍을 시작

        //Jaffree(FFmpeg)를 사용하여 rtsp 스트림을 클라이언트로 전송
        FFmpeg ffmpeg = FFmpeg.atPath();


    }
}
