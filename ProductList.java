 public class ProductList 
 {
  Product[] productsList;
  Product[] cartProducts;
  public ProductList() 
  {
   productsList = new Product[5];
   cartProducts = new Product[5];

  }

  public ProductList(Product[] productsList) 
  {

  }

  public void setProductList(Product[] prodcutsList) 
  {
   this.productsList = productsList;

  }

  public Product[] getProductList() 
  {
   return productsList;
  }


  //Adds the registered into the array for all products.  
  public void addProductsToArray(String productName, String productDesc, double productPrice, int quantityOnHand, int minimumOrderQuantity, int n) 
  {
   productsList[n] = new Product();
   productsList[n].setProductName(productName);
   productsList[n].setProductDesc(productDesc);
   productsList[n].setProductPrice(productPrice);
   productsList[n].setQuantityOnHand(quantityOnHand);
   productsList[n].setMinimumOrderQuantity(minimumOrderQuantity);
   System.out.println("Product Registered!");

  }
  
  //Displays all the registered products.  
  public void displayAllProductsInArray(int n) 
  {
   for (int i = 0; i < n; i++) 
   {
    System.out.println("Select Product" + " " + (i + 1) + " ");
    System.out.println("Product Name:" + " " + productsList[i].getProductName());
    System.out.println("Product Description:" + " " + productsList[i].getProductDesc());
    System.out.println("Product Quantity On Hand:" + " " + productsList[i].getQuantityOnHand());
    System.out.println("Product Minimum Order Quantity:" + " " + productsList[i].getMinimumOrderQuantity());
    System.out.println(" ");
   }
  }
  
  //Returns a particular selected product depending upon the index.
  public Product returnSelectedProduct(int selected) 
  {

   return productsList[selected - 1];

  }
  
  //Displays all the products added to the cart.
  public void displayAllProductsFromCart(int m) 
  {
   for (int i = 0; i < m; i++) 
   {
    System.out.print("Select Product" + " " + (i + 1) + " ");
    System.out.println("Product Name:" + " " + cartProducts[i].getProductName());
    System.out.println("Product Description:" + " " + cartProducts[i].getProductDesc());
    System.out.println("Product Quantity On Hand:" + " " + cartProducts[i].getQuantityOnHand());
    System.out.println("Product Minimum Order Quantity:" + " " + cartProducts[i].getMinimumOrderQuantity());
    System.out.println(" ");
   }


  }
  
  //To add a single product the the cart array.
  public void addProductToCart(Product item, int m) 
  {
      

   cartProducts[m] = new Product();
   cartProducts[m] = item;




  }
  
  //Remove product from the cart array. And position all the other arrays accordingly.
  public void removeProductFromCart(int toDeleted) 
  {
   toDeleted--;
   cartProducts[toDeleted] = null;
   
   if (toDeleted == 0) {
    cartProducts[toDeleted] = cartProducts[++toDeleted];

   }
   if (toDeleted == 1) {
    cartProducts[toDeleted] = cartProducts[++toDeleted];
   }

   if (toDeleted == 2) {
    cartProducts[toDeleted] = null;
   }



  }
  
  public Product[] getCartProducts() 
  {
   return cartProducts;

  }
  
  //Validate the product name whether it matches with other products name or not.
  public boolean validateName(String productName, int n) 
  {
   if (n != 0)

   {
    int i;

    for (i = 0; i <n; i++) 
    {
     
     if(productsList[i].getProductName().equalsIgnoreCase(productName))
     {
         System.out.println("Enter unique product name");
         return true;
     }
    }
   }
   return false;

  }



 }
   

