package rentalsvc;

import rentalsvc.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverFeeReceived_DeliveryCreate(@Payload FeeReceived feeReceived){

        if(feeReceived.isMe()){
            System.out.println("##### listener DeliveryCreate : " + feeReceived.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverRentalCancellationOccured_ProductRetrieve(@Payload RentalCancellationOccured rentalCancellationOccured){

        if(rentalCancellationOccured.isMe()){
            System.out.println("##### listener ProductRetrieve : " + rentalCancellationOccured.toJson());
        }
    }

}
