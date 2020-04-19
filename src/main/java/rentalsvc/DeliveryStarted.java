package rentalsvc;

public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long logistisId;

    public DeliveryStarted(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getLogistisId() {
		return logistisId;
	}

	public void setLogistisId(Long logistisId) {
		this.logistisId = logistisId;
	}
}
