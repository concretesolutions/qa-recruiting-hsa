
import java.util.HashMap;
import javax.swing.JOptionPane;

public class SalesPrice {
	
	//Start sample data by simulating a database "Priceperproduct"
	/*
	 * Note: it is necessary to clarify that this is not the most adequate database scheme, 
	 * the database schema was clarified in the first solution of the kata problem
	 * 
	 * */
	
	static HashMap<String, int[]> pricePerProduct = new HashMap<String, int[]>();

	public static void main(String[] args) {
		
		 String products;
		 pricePerProduct.put("A",new int[]{50,1,3,130});
		 pricePerProduct.put("B",new int[]{30,1,2,45});
		 pricePerProduct.put("C",new int[]{20,0,0,0});
		 pricePerProduct.put("D",new int[]{15,0,0,0});			 	 
		 products = getAskForProducts();
		 validateQuantityOfProducts(products);
	}
	
	 //Function for ask for products to evaluate
	public static  String getAskForProducts(){
		String products;
		products = JOptionPane.showInputDialog(" Introduzca las letras de los Producto");
		return products;
	}
	
	//Function to evaluate Quantity of products will be greater than to zero
	public static void validateQuantityOfProducts(String products){
		if (products.length()== 0){
			JOptionPane.showMessageDialog(null,"Debe incluir aunque sea un producto");
			getAskForProducts();
		}else{
			validateCharacters(products);
		} 		
	}
	
	//Function to evaluate the products will be of the data
	public static void validateCharacters(String productos){
		
		for (int i = 0; i < productos.length(); i++){
			int countPositive = 0;
			for(String letter : pricePerProduct.keySet()){
				if(letter.equals(String.valueOf(productos.charAt(i)))){
					countPositive++;
					break;
				}
			}
			if(countPositive == 0){
				JOptionPane.showMessageDialog(null,"Inserto productos inexistente como " + productos.charAt(i));
				getAskForProducts();				
			}
		}
		calculatePriceTotal(productos);		
	}
	
	//Function to calculate price total of products add for user
	public static void calculatePriceTotal(String productos) {
		long priceTotal = 0;
		long priceTotalPerProduct = 0;
		for(String letter : pricePerProduct.keySet()){			
			long countLetter = productos.chars().filter(ch -> ch ==  letter.charAt(0)).count();
			priceTotalPerProduct = getPricePerProduct(countLetter, letter);
			priceTotal = priceTotal + priceTotalPerProduct;			
		}
		JOptionPane.showMessageDialog(null,"El total de su compra es de: " + priceTotal);
	}
	
	//Function to calculate price per products and verific if the product has promotion
	public static long getPricePerProduct(long countLetter, String letter) {
		long totalPerProduct = 0;
		int valueProduct = pricePerProduct.get(letter)[0];
		int existPromotion = pricePerProduct.get(letter)[1];
		int quantityPromotion = pricePerProduct.get(letter)[2];
		int pricePromotion = pricePerProduct.get(letter)[3];
		
		if(existPromotion == 1){
			long unitsWithPromotion = countLetter / quantityPromotion;
			long unitsWithOutPromotion = countLetter % quantityPromotion;
			long totalPriceWithPromotion = unitsWithPromotion * pricePromotion;
			long totalPriceWithOutPromotion = unitsWithOutPromotion * valueProduct;
			totalPerProduct = totalPriceWithPromotion + totalPriceWithOutPromotion;
		}else{
			totalPerProduct = valueProduct * countLetter;
		}
		return totalPerProduct;
		
	}
}
