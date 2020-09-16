 public class SaleTransaction 
 {
 private int saleCode;
 private Product[] item = new Product[5];
 private double totalCost;

 public SaleTransaction() 
 {
  totalCost = 0;
 }

 public SaleTransaction(int saleCode, double totalCost, Product[] item) 
 {


 }


 public void setSalesCode(int saleCode) 
 {
  this.saleCode = saleCode;

 }

 public int getSalesCode() 
 {

  return saleCode;
 }

 public void setTotalCost(double totalCost) 
 {
  this.totalCost = totalCost;
 }

 public double getTotalCost() 
 {
  return totalCost;
 }

 public void setItem(Product[] item) 
 {
  this.item = item;

 }

 public Product[] getItem() 
 {
  return item;

 }

 //Displays totalcost hen the checkout funtion is called and dislays all the products in the cart 
 public Product[] checkOut(Product[] buy, int m, int salesCode) 
 {
  if (m == 0) 
  {
   System.out.println("Cart is Empty Nothing to Checkout");

  } 
  else 
  {
   for (int i = 0; i < m; i++) 
   {//Checks if the quantity on hand is not less than the order quantity
    if (buy[i].getQuantityOnHand() < buy[i].getMinimumOrderQuantity()) 
    {
     System.out.println("Not Enough Quantity on hand");
    } 
    else 
    {//Add the total cost for all products and according to the ordered quantity.
     totalCost += buy[i].getMinimumOrderQuantity() * buy[i].getProductPrice();
     buy[i].setQuantityOnHand(buy[i].getQuantityOnHand() - buy[i].getMinimumOrderQuantity());
    }
   }
  }

  System.out.println("Sales Code:" +" "+ salesCode);
  System.out.println("Your cart subtotal is:- " +" "+ totalCost);
  System.out.println("Thank You for shopping!");
  return buy;
 }
}