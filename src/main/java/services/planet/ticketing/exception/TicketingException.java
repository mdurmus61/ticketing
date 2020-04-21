package services.planet.ticketing.exception;

public class TicketingException extends RuntimeException {
    private String type;
    private String operation;

    public TicketingException(String type, String operation, String message) {
        super(message);
        this.type = type;
        this.operation = operation;
    }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getOperation() { return operation; }

    public void setOperation(String operation) { this.operation = operation; }
}
