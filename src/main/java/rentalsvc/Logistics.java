package rentalsvc;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Logistics_table")
public class Logistics {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long logistisId;
    private Long orderId;

    @PostPersist
    public void when_PostPersist_publishEvent(){
        DeliveryStarted deliveryStarted = new DeliveryStarted();
        BeanUtils.copyProperties(this, deliveryStarted);
        deliveryStarted.publish();

    }

    @PrePersist
    public void when_PrePersist_publishEvent(){
        RetriveStarted retriveStarted = new RetriveStarted();
        BeanUtils.copyProperties(this, retriveStarted);
        retriveStarted.publish();

    }

//
//    @PrePersist
//    public void publishRetriveStarted(){
//
//        RetriveStarted retriveStarted = new RetriveStarted();
//        BeanUtils.copyProperties(this, retriveStarted);
//        retriveStarted.publish();
//
//    }
//
//    @PostPersist
//    public void publishDeliveryStarted(){
//
//        DeliveryStarted deliveryStarted = new DeliveryStarted();
//        BeanUtils.copyProperties(this, deliveryStarted);
//        deliveryStarted.publish();
//
//    }
//

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getLogistisId() {
        return logistisId;
    }

    public void setLogistisId(Long logistisId) {
        this.logistisId = logistisId;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

}
