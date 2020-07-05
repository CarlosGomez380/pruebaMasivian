package prueba.model;

import java.util.ArrayList;

public class Bet {
    private ArrayList<Integer> numbers;
    private String color;
    private int amount;
    public Bet(ArrayList<Integer> numbers, String color, int amount){
        this.numbers= numbers;
        this.amount=amount;
        this.color=color;
    }
    public int getAmount() { return amount; }
    public ArrayList<Integer> getNumbers() { return numbers; }
    public String getColor() { return color; }
    public void invalidColor(){
        if (this.color != "Black" || this.color != "Red" ){
            this.color="White";
        }
    }
    public void invalidNumber(){
        int i=0;
        while(i< numbers.size()) {
            if (numbers.get(i)<0 || numbers.get(i) > 36) {
                numbers.remove(i);
            }else{i+=1;}
        }
    }
}
