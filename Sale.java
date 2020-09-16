import java.util.Scanner;

public class Sale 
{
 private ProductList prodList;
 private SaleTransaction transaction;

 public Sale() 
 {
  prodList = new ProductList();
  transaction = new SaleTransaction();

 }

 public Sale(ProductList prodList, SaleTransaction transaction) 
 {

 }

 public void setProductList(ProductList prodList) 
 {
  this.prodList = prodList;

 }

 public ProductList getProductList() 
 {
  return prodList;

 }

 public void setSaleTransaction(SaleTransaction transaction) 
 {
  this.transaction = transaction;

 }

 public SaleTransaction getSaleTransaction() 
 {
  return transaction;

 }
 //The main controlling class which will call all the methods and classes to run different options.
 public void Shopping() 
 {
  Scanner input = new Scanner(System.in);
  int n = 0;
  int option;
  int m = 0;
  Scanner selectedOption = new Scanner(System.in);
  do 
  {
   System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
   System.out.println("Welcome To The Simple Inventory Management System");
   System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
   System.out.println("");
   System.out.println("Please Select from the following options:");
   System.out.println("");
   System.out.println("Press 1 to Register a Product for Sale");
   System.out.println("Press 2 to Buy a Product to the Cart");
   System.out.println("Press 3 to Remove a Product from the cart");
   System.out.println("Press 4 to View all Available Products");
   System.out.println("Press 5 to Check out");
   System.out.println("Press 6 to Get Help");
   System.out.println("Press 7 to Exit");
   System.out.println("");
   System.out.println("Enter your choice:");

   option = selectedOption.nextInt();


   switch (option)

   {
    case 1:
    //Method to register products.Only one product can be registered at a time and maximum of only 5 products can be registered.  
    registerProduct(n);
     n++;

     break;

    case 2:
       //Method will add selected product to cart. Only maximum of 3 products can be added to cart for checkout.
     additionProductToCart(m, n);
     m++;


     break;

    case 3:
    //Method will help delete a product from cart products.
     m = deleteProductFromCart(m);

     break;

    case 4:
    //Method will display all the avaiable products in the inventory.
    prodList.displayAllProductsInArray(n);

     break;

    case 5: 
     //Shows all product from cart and buy them and display total cost.
     checkOutProducts(m);
     break;

    case 6:
    //Shows help in understanding what each option does
     getHelp();
     break;
    }
  } while (option != 7);

}
 
 //Method to register products.Only one product can be registered at a time and maximum of only 5 products can be registered
 public void registerProduct(int n) 
 {
  if (n >= 5) 
  {
   System.out.println("Maximun Number of products entered");
  } 
  else 
  {
   String productName;
   String productDesc;
   boolean isvalid = true;
   double productPrice;
   int quantityOnHand;
   int minimumOrderQuantity;
   Scanner input = new Scanner(System.in);
   RandomNumberGenerator random = new RandomNumberGenerator();


   System.out.println("Enter the name of the product:");
   productName = input.nextLine();
   
   //Validates the productName string and if the names of two product are similar or not.
   
       while(isvalid)
      {
       if (productName.length() < 3 || productName.length() > 25) 
       {
           System.out.println("Enter Valid Name between 3 to 25 characters");
           productName = input.nextLine();
       }   
           isvalid = prodList.validateName(productName, n);
           if(isvalid)
           {
               System.out.println("Enter the name of the product:");
               productName = input.nextLine();
           }
        }
    
    
   System.out.println("Enter the description of the product:");
   productDesc = input.nextLine();
   
   //Validates the productDesc string.
   if (productDesc.length() < 0 || productDesc.length() > 50) 
   {
    System.out.println("Enter Description upto 50 characters only");
    productDesc = input.nextLine();
   }

   System.out.println("Enter the price of the product:");
   productPrice = Double.parseDouble(input.nextLine());
   
   //Validates the productPrice value.
   if (productPrice <= 0) 
   {
    System.out.println("Enter price greater than zero");
    productPrice = Double.parseDouble(input.nextLine());
   }


   //Generates Random values for quantityOnHand and minimumOrderQuantity.
   quantityOnHand = random.generateRandomNumber(0, 10);
   minimumOrderQuantity = random.generateRandomNumber(1, 5);

   prodList.addProductsToArray(productName, productDesc, productPrice, quantityOnHand, minimumOrderQuantity, n);
  }



 }
 
 //Method will add selected product to cart. Only maximum of 3 products can be added to cart for checkout.
 public void additionProductToCart(int m, int n) 
 {
  Scanner input = new Scanner(System.in);
  int selected;
  //Checks if the mumber of products in array are less than the allowed number i.e. 3.
  if (m >= 3) 
  {
   System.out.println("Maximun Number of products added to cart");
  } 
  else 
  {
   prodList.displayAllProductsInArray(n);
   System.out.println("Enter the choice of product you want to add to cart");
   selected = input.nextInt();
   prodList.addProductToCart(prodList.returnSelectedProduct(selected), m);
   System.out.println("Your product has been successfully added to the cart");
  }

 }

 //Method will help delete a product from cart products.
 public int deleteProductFromCart(int m) 
 {

  Scanner input = new Scanner(System.in);
  int toDelete;
  prodList.displayAllProductsFromCart(m);
  System.out.println("Enter the choice of product you want to remove to cart");
  toDelete = input.nextInt();
  prodList.removeProductFromCart(toDelete);
  System.out.println("Product successfully removed from cart");
  m--;
  return m;

 }
 
 //Shows all product from cart and buy them and display total cost.
 public void checkOutProducts(int m)
 {
     int toBuy;
     int salesCode;
     RandomNumberGenerator random = new RandomNumberGenerator();
     salesCode = random.generateRandomNumber(1000, 9999);
     prodList.displayAllProductsFromCart(m);
     prodList.setProductList(transaction.checkOut(prodList.getCartProducts(), m, salesCode));
 }
 
 //Shows help in understanding what each option does
 public void getHelp() 
 {
  System.out.println("Help");
  System.out.println("Press 1 option to Register a Product for Sale. This will help register new product. It will ask to enter details of new product to register.");
  System.out.println("Press 2 option to Buy a Product to the Cart. This will help to add a product into the cart. Just press the number of the product from the displayed list.");
  System.out.println("Press 3 option to Remove a Product from the cart. This will help to remove any product form the cart if not needed. Just press the number of product to remove.");
  System.out.println("Press 4 option to View all Available Products. This will help to explore all the avaiable products in the inventory");
  System.out.println("Press 5 option to Check out.This will help to buy/checkout all the products added to the cart.");
  System.out.println("Press 7 option to exit the program");


 }
}