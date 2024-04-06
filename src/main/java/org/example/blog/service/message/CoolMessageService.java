package org.example.blog.service.message;


import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.exception.NurigoMessageNotReceivedException;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.example.blog.util.ReceiverNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CoolMessageService implements MessageService {

    @Value("${message.api-key}")
    private String apiKey;
    @Value("${message.secret-key}")
    private String secretKey;
    @Value("${message.receiver-numbers}")
    private String receiverNumbers;
    @Value("${message.send-number}")
    private String sendNumber;
    @Value("${message.platform-url}")
    private String platformUrl;

    @Override
    public void send() {
        DefaultMessageService messageService = NurigoApp.INSTANCE.initialize(apiKey, secretKey,
            platformUrl);
        Message message = new Message();
        message.setFrom(sendNumber);
        message.setTo(ReceiverNumber.choice(receiverNumbers));
        message.setText("해당 메시지는 제 나태함으로 전송되는 메시지입니다. 사진을 캡쳐해서 드시고 싶은 음식을 저한테 보내주시면 사겠습니다.");
        try {
            messageService.send(message);
        } catch (NurigoMessageNotReceivedException exception) {
            System.out.println(exception.getFailedMessageList());
            System.out.println(exception.getMessage());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
