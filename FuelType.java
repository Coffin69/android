public class FuelType {
    private int id;
    private String name;
    private int quantity;
    private String nextDeliveryDate;

    public FuelType(String name, int quantity, String nextDeliveryDate) {
        this.name = name;
        this.quantity = quantity;
        this.nextDeliveryDate = nextDeliveryDate;
    }

    public FuelType(int id, String name, int quantity, String nextDeliveryDate) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.nextDeliveryDate = nextDeliveryDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getNextDeliveryDate() {
        return nextDeliveryDate;
    }
}
