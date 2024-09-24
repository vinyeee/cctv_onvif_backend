package biz.bigtablet.cctvonvifbackend.service;

import com.github.kokorin.jaffree.LogLevel;
import com.github.kokorin.jaffree.ffmpeg.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class VideoStreamService {
    private static final String RTSP_URI = "rtsp://192.168.0.146:554";
    private Logger logger = LoggerFactory.getLogger(VideoStreamService.class);
    public void startStream(WebSocketSession session){// websocket 연결을 통해 비디오 스트리밍을 시작

        // Jaffree(FFmpeg)를 사용하여 rtsp 스트림을 클라이언트로 전송
        FFmpeg ffmpeg = FFmpeg.atPath()
                .addInput(UrlInput.fromUrl(RTSP_URI)) // pathToVideo
                .addOutput(PipeOutput.pumpTo(OutputStream.nullOutputStream())
                        .setFormat("mpegts")
                        .addArguments("-vcodec", "copy")
                        .addArguments("-acodec", "copy"))
                .setLogLevel(LogLevel.INFO);;

        // FFmpeg 실행


        try{
            FFmpegResult result = ffmpeg.execute();
            logger.info("FFmpeg finished successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
