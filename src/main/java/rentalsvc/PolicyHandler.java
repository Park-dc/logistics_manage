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
            System.out.println("##### listener 요금 완납 이벤트 수신  : " + feeReceived.toJson());
            
           DeliveryStarted deliveryStarted = new DeliveryStarted();
           deliveryStarted.setOrderId(feeReceived.getOrderId());
           deliveryStarted.publish();
           System.out.println("##### 배송 시작 이벤트 발송 : (DeliveryStarted)");
           
        }
    }
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverRentalCancellationOccured_ProductRetrieve(@Payload RentalCancellationOccured rentalCancellationOccured){

        if(rentalCancellationOccured.isMe()){
            System.out.println("##### listener 랜탈취소 이벤트 수신 RentalCancellationOccured : " + rentalCancellationOccured.toJson());
            
            RetriveStarted retriveStarted = new RetriveStarted();
            retriveStarted.setOrderId(rentalCancellationOccured.getOrderId());
            retriveStarted.publish();
            System.out.println("##### 제품 회수 시작 이벤트 발송 : (RetriveStarted)");
        }
    }
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverFeeRefuldCompleted_ProductRetrieve(@Payload FeeRefundCompleted feeRefundCompleted){

        if(feeRefundCompleted.isMe()){
            System.out.println("##### listener 환불 완료 이벤트 수신 FeeRefundCompleted : " + feeRefundCompleted.toJson());
            
            RetriveStarted retriveStarted = new RetriveStarted();
            retriveStarted.setOrderId(feeRefundCompleted.getOrderId());
            retriveStarted.publish();
            System.out.println("##### 제품 회수 시작 이벤트 발송 : (RetriveStarted)");
        }
    }    


}
