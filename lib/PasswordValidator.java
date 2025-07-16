package lib;

public class PasswordValidator {

    /**
     * เมธอดนี้ทำการตรวจสอบความยากง่ายของพาสเวิร์ด โดยแบ่งเป็น INVALID คือพาสเวิร์ดที่ไม่ผ่าน(ความยาวไม่ถึง 8 ตัวอักษร) , 
     * WEAK ตือพาสเวิร์ดที่เดาได้ง่าย , MEDIUM คือพาสเวิร์ดที่ความยากปานกลาง , STRONG คือพาสเวิร์ดที่เดาได้ยาก
     * โดยความยากง่ายจะพิจารณาจากส่วนประกอบว่ามีตัวอักษรพิมใหญ่ พิมเล็ก ตัวเลข หรืออักษรพิเศษหรือไม่
     * @param password คือข้อความที่ต้องการตรวจสอบ
     * @return enum ชื่อ PasswordStrength ที่ประกอบด้วย {INVALID , WEAK , MEDIUM , STRONG}
     */
    public static PasswordStrength validate(String password) { 
        
        int minLength = 8 ;
        if(password.length() < minLength || password == null)
            return PasswordStrength.INVALID ; 

        boolean hasLower = false ;
        boolean hasUpper = false ;
        boolean hasDigit = false ;
        boolean hasSymbol = false ;

        for (Character c : password.toCharArray()) {
            if(Character.isLowerCase(c))
                hasLower = true ;
            else if(Character.isUpperCase(c))
                hasUpper = true ;
            else if(Character.isDigit(c))
                hasDigit = true ;
            else 
                hasSymbol = true;
        }

        int count = 0 ;
        if(hasLower) count++;
        if(hasUpper) count++;
        if(hasDigit) count++;
        if(hasSymbol) count++;

        if(count<=2) return PasswordStrength.WEAK ;
        if(count==3) return PasswordStrength.MEDIUM ;
        if(count==4) return PasswordStrength.STRONG ;
        
        return PasswordStrength.INVALID ; 
    }
}