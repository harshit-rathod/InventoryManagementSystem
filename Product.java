public class Product 
{
 private String productName;
 private String productDesc;
 private double productPrice;
 private int quantityOnHand;
 private int minimumOrderQuantity;
 
 //Default Constructor
 public Product() 
 {

 }
 
 //Alternate Constructor
 public Product(String productName, String productDesc, double productPrice, int qunatityOnHand, int minimumQuantityOnHand) 
 {


 }

 public void setProductName(String productName) 
 {
  this.productName = productName;

 }

 public void setProductDesc(String productDesc) 
 {
  this.productDesc = productDesc;

 }

 public void setProductPrice(double productPrice) 
 {
  this.productPrice = productPrice;

 }

 public void setQuantityOnHand(int quantityOnHand) 
 {
  this.quantityOnHand = quantityOnHand;

 }

 public void setMinimumOrderQuantity(int minimumOrderQuantity) 
 {
  this.minimumOrderQuantity = minimumOrderQuantity;

 }
 public String getProductName() 
 {
  return productName;

 }

 public String getProductDesc() 
 {
  return productDesc;

 }

 public double getProductPrice() 
 {
  return productPrice;

 }

 public int getQuantityOnHand() 
 {
  return quantityOnHand;

 }

 public int getMinimumOrderQuantity() 
 {
  return minimumOrderQuantity;

 }

 //Displays all the insformation about a particular product.
 public void displayProduct() 
 {
  System.out.println("Name" + productName);
  System.out.println("Description" + productDesc);
  System.out.println("Price" + productPrice);
  System.out.println("Quantity" + quantityOnHand);
  System.out.println("Min order quantity" + minimumOrderQuantity);


 }

}