package hello.core.singleton;

public class StatefulService {

    private int price;

    public void order(String name, int price){
        System.out.println("nmae ="+ name + "price = " +price );
        this.price  = price; //이쪽이 문제
    }

    public  int getPrice(){
        return price;
    }
}

