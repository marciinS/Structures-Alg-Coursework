public class PetProducts {

    int PetStockQuantity;
    String PetProductCode;
    String PetProductName;

    public PetProducts (Integer PetStockQuantity, String PetProductCode, String PetProductName) {
        this.PetStockQuantity = PetStockQuantity;
        this.PetProductCode = PetProductCode;
        this.PetProductName = PetProductName;
    }

    public String getProductInformation() {
        return "Code: " + this.PetProductCode + " Name: " + this.PetProductName + " Qty: " + this.PetStockQuantity;
    }

    public String getName() {
        return PetProductName;
    }

    public String getCode() {
        return PetProductCode;
    }
}