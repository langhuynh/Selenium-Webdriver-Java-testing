import org.testng.annotations.Test;

public class Exercise {
    @Test
    public void topic_01(){
        int a = 6;
        int b = 2;

        System.out.println("Addition:"+ (a+b));
        System.out.println("Multiplication:"+ (a*b));
        System.out.println("Division:"+ (a/b));
        System.out.println("Subtraction:"+ (a-b));
    }
    @Test
    public void topic_02(){
        float width = 7.5f;
        float height = 3.8f;
        System.out.println("Area of a rectangle:" + width*height);
    }
    @Test
    public void topic_03_SwapNumber()
    {
        int a = 5;
        int b = 6;
        a = a + b;

        b = a - b;
        a = a - b;
        System.out.println(+ a +","+ b);

    }
}
