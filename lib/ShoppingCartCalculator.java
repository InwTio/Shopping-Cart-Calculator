package lib;

import java.util.ArrayList;

public class ShoppingCartCalculator {

    /**
     * เขียน Javadoc ที่นี่เพื่ออธิบายกฎการทำงานและกรณีพิเศษ:
     * - ถ้า items เป็น null หรือ empty จะคืนค่า 0.0
     * - ถ้า CartItem มี price หรือ quantity ติดลบ จะคืนค่า 0.0
     * - กฎส่วนลด BOGO (ซื้อ 1 แถม 1)
     * - กฎส่วนลด BULK (ซื้อ >= 6 ชิ้น ลด 10%)
     * @param items คือสินค้าที่ต้องการนำไปคำนวณ
     * @return ราคาทั้งหมดของสินค้าที่ได้เลือกมา พร้อมคำนวณส่วนลด (BOGO, BULK)
     */
    public static double calculateTotalPrice(ArrayList<CartItem> items) {
        double total = 0.0;

        if (items!=null){
        for (CartItem item : items) {
               String sku = item.sku();
               String name = item.name();
               double price = item.price();
               int quantity = item.quantity();

                if(price<0 || quantity<0) return 0.0;

                if (quantity>=6 && sku == "BULK"){
                    total += price * quantity * 0.9;
                    return total;
                }

                if (sku == "BOGO"){
                    int BOGO = quantity/2;
                    if(quantity%2 != 0) BOGO+=1;
                    total += price * BOGO;
                    return total;
                }

               if (sku == "NORMAL"){
                    total += price * quantity;
                }

            }
             return total;
        } 
        return 0.0;
    }
}
