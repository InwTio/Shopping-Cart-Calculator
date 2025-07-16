package lib;

public class PasswordValidatorTest{
    
    public static void run() {
        System.out.println("--- Running Password Validator Tests ---");
        
        String pw ;

        // Test Case 1: รหัสผ่านสั้นควรจะ INVALID
        pw = "123" ;
        PasswordStrength result1 = PasswordValidator.validate(pw);
        if (result1 == PasswordStrength.INVALID) {
            System.out.println("Test Case 1 : "+pw+" : Passed: Short password is INVALID.");
        } else {
            System.out.println("Test Case 1 : "+pw+" : FAILED : Expected INVALID but got " + result1);
        }

        // Test Case 2: เจอ 1 ส่วนประกอบจาก ตัวอักษรพิมใหญ่ พิมเล็ก ตัวเลข หรืออักษรพิเศษ
        pw = "123456789" ;
        PasswordStrength result2 = PasswordValidator.validate(pw);
        if (result2 == PasswordStrength.WEAK) {
            System.out.println("Test Case 2 : "+pw+" : Passed: The pw has 1 type.(WEAK)");
        } else {
            System.out.println("Test Case 2 : "+pw+" : FAILED : Expected WEAK but got " + result2);
        }

        // Test Case 3: เจอ 2 ส่วนประกอบจาก ตัวอักษรพิมใหญ่ พิมเล็ก ตัวเลข หรืออักษรพิเศษ
        pw = "ab123456cd" ;
        PasswordStrength result3 = PasswordValidator.validate(pw);
        if (result3 == PasswordStrength.WEAK) {
            System.out.println("Test Case 3 : "+pw+" : Passed: The pw has 2 type.(WEAK)");
        } else {
            System.out.println("Test Case 3 : "+pw+" : FAILED : Expected WEAK but got " + result3);
        }

        // Test Case 4: เจอ 3 ส่วนประกอบจาก ตัวอักษรพิมใหญ่ พิมเล็ก ตัวเลข หรืออักษรพิเศษ
        pw = "ab123456cdEF" ;
        PasswordStrength result4 = PasswordValidator.validate(pw);
        if (result4 == PasswordStrength.MEDIUM) {
            System.out.println("Test Case 4 : "+pw+" : Passed: The pw has 3 type.(Medium)");
        } else {
            System.out.println("Test Case 4 : "+pw+" : FAILED : Expected Medium but got " + result4);
        }

        // Test Case 5: เจอทั้งหมด คือตัวอักษรพิมใหญ่ พิมเล็ก ตัวเลข หรืออักษรพิเศษ
        pw = "!ab123456cdEF" ;
        PasswordStrength result5 = PasswordValidator.validate(pw);
        if (result5 == PasswordStrength.STRONG) {
            System.out.println("Test Case 5 : "+pw+" : Passed: The pw has 4 type.(Strong)");
        } else {
            System.out.println("Test Case 5 : "+pw+" : FAILED : Expected Strong but got " + result5);
        }
        
        System.out.println("--------------------------------");
    }
}
