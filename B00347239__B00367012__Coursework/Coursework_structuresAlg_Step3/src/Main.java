public class Main {

    public static void main(String[] args) {

        String userSelection, petName;
        PetTree tree = new PetTree();

        do {
            //Navigation Menu for the user
            System.out.println("1. Add a new Pet");
            System.out.println("2. Add new product for specified pet type");
            System.out.println("3. Search for a Pet Type");
            System.out.println("4. Display all pets types");
            System.out.println("5. Display all products for a specific pet type");
            System.out.println("6. Display all product details for all pets");
            System.out.println("7. Remove a particular product for a specified pet");
            System.out.println("8. Remove a pet type from the system");
            System.out.println("0. Exit");
            System.out.println("\n");
            System.out.println("\n");
            
            userSelection = Input.getString("Please select an option:  ");

            switch (userSelection) {

                // Quits the program
                case "0" -> System.out.println("Thank you! Goodbye ");

                // Adds a new Pet Type
                case "1" -> {
                    petName = Input.getString("Please Enter Name of Pet Type:  ");

                    if (tree.insert(petName)) {
                        System.out.println("Pet Has Been Added to the System. ");
                    } else {
                        System.out.println("Pet Type is already in the System. ");
                    }

                }

                // Adds products for a specified pet type
                case "2" -> {
                    petName = Input.getString("Please Enter Pet Type You Would Like to Add Products For: ");

                    if (tree.find(petName)) {
                        String productName = Input.getString("Enter Product Name: ");
                        String productCode = Input.getString("Enter Product Code: ");
                        int stockQuantity = Input.getInteger("Enter Stock Quantity: ");

                        tree.getNode(petName, tree.root).getPetObject().getPetProducts().addProducts(productName, productCode, stockQuantity);
                    } else {
                        System.out.println("Pet Type Not Found");
                    }

                }

                // Find the stock for specified pet type
                case "3" -> {
                    petName = Input.getString("Enter Pet Type You Would Like to Search For:  ");

                    if (tree.find(petName)) {
                        System.out.println("We DO stock products for " + petName + "'s");
                    } else {
                        System.out.println("We DON'T stock products for " + petName + "'s");
                    }

                }

                case "4" -> tree.inorder();

                // Display all the products stocked for a specific pet type
                case "5" -> {
                    petName = Input.getString("Enter Pet Type You Would Like to View Products For:  ");
                    tree.getNode(petName, tree.root).getPetObject().getPetProducts().displayProducts();
                }

                // Display all the products of all pets
                case "6" -> tree.outputAllProducts();

                // Remove a product
                case "7" -> {
                    petName = Input.getString("Enter Pet Type of the Product:  ");
                    if (tree.find(petName)) {
                        String remove = Input.getString("Enter the Code of the Product to be Deleted:  ");
                        tree.getNode(petName, tree.root).getPetObject().getPetProducts().deleteProduct(remove);
                    } else {
                        System.out.println("Pet Type Not Found");
                    }
                }

                // Remove a pet type
                case "8" -> {
                    petName = Input.getString("Enter Pet Type to be Deleted: ");
                    tree.deleteNode(petName);
                }
            }
        } while (!userSelection.equals("0"));
    }
}

