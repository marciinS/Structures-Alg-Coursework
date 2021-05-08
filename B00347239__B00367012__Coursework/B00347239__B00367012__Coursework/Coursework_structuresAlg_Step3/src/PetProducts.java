public class PetProducts {


    String name, code;
    int stockQuantity;


    public PetProducts(String name, String code, int stockQuantity) {
        this.name = name;
        this.code = code;
        this.stockQuantity = stockQuantity;
    }



    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
}
