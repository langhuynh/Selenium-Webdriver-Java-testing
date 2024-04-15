public class Topic_06_String {
    static String courseName = "Automation Testing Advanced";
    public static void main(String[] args) {
      //  TC_01();
        TC_02();

    }
    public static void TC_01(){
        char courseNameArr[] = courseName.toCharArray();
        int count = 0;
        for (char character : courseNameArr){
            if (character <= 'Z' && character >= 'A'){
                count++;

            }

        }
        System.out.println("Sum of lowercase: " +count);
        for (char character : courseNameArr){
            if (character <= 'z' && character >= 'a'){
                count++;

            }

        }
        System.out.println("Sum of lowercase: " +count);


    }
    public static void TC_02() {
        char courseNameArr[] = courseName.toCharArray();
        int count = 0;
        for (char character : courseNameArr){
            if (character == 'a'){
                count++;

            }

        }
        System.out.println(count);
    }

}