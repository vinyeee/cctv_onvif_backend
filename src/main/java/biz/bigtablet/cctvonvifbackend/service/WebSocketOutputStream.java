package biz.bigtablet.cctvonvifbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

@RequiredArgsConstructor
public class WebSocketOutputStream extends OutputStream {

    private final WebSocketSession session;

    @Override
    public void write(int b) throws IOException {
        // WebSocket을 통해 전송할 데이터를 준비
        byte[] data = new byte[]{(byte) b};
        session.sendMessage(new BinaryMessage(ByteBuffer.wrap(data)));
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        // 데이터를 WebSocket을 통해 전송
        session.sendMessage(new BinaryMessage(ByteBuffer.wrap(b, off, len)));
    }
}
