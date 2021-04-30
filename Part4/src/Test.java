public class Test {
// а обязательно паблик? нет если лежит в этом классе
    private Test(int x) {
        System.out.println(x);
    }

    public void Test1(){
        new Test(10);
    }
}