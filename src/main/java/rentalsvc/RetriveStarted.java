package rentalsvc;

public class RetriveStarted extends AbstractEvent {

    private Long id;
    private Long orderId;

    public RetriveStarted(){
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
}
