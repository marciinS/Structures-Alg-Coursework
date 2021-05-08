public class Main {

    public static void main(String[] args) {
        
        PetLinkedList products = new PetLinkedList();
        String userSelection, searchTerm;

        do {
            System.out.println("1. Add Products");
            System.out.println("2. Display Products");
            System.out.println("3. Find a Product");
            System.out.println("4. Delete a Product");

            userSelection = Input.getString("Please Select an option:  ");

            switch (userSelection) {

                case "0" -> System.out.println("Thank you, Goodbye!. "); // Quits the program

                // To add product information
                case "1" -> {
                    int repeat;

                    do {

                        String PetProductName = Input.getString("Please Enter Product Name: ");
                        String PetProductCode = Input.getString("Please Enter Product Code:  ");
                        int PetStockQuantity = Input.getInteger("Please Enter Stock Quantity of Item: ");

                     
                       PetProducts product = new PetProducts(PetStockQuantity, PetProductCode, PetProductName);
                       products.addProducts(product);

                        repeat = Input.getInteger("Would you like to add another product? ");

                    } while (repeat != 0);
                }

                case "2" -> products.displayProducts(products.getHead());  // Displays the products

                case "3" -> {
                    searchTerm = Input.getString("Please Enter Product Name or ID:  ");  // Search and display
                    products.findProduct(searchTerm, products.getHead());
                }

                case "4" -> {
                    searchTerm = Input.getString("Please enter Name or Code of product you would like to delete:  "); //Removes a product
                    products.deleteNode(searchTerm);

                }
            }
        } while (!userSelection.equals("0"));
    }
}

