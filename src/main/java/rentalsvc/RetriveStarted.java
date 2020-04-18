package rentalsvc;

public class RetriveStarted extends AbstractEvent {

    private Long id;

    public RetriveStarted(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
