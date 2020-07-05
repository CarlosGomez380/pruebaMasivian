package prueba.model;
import java.util.ArrayList;
public class Bet {
    private ArrayList<Integer> numbers;
    private ArrayList<String> colors;
    private ArrayList<Integer> amountNumbers;
    private ArrayList<Integer> amountColors;
    private int totalAmount;
    public Bet(ArrayList<Integer> numbers, ArrayList<String> colors,
               ArrayList<Integer> amountNumbers,ArrayList<Integer> amountColors){
        this.numbers= numbers;
        this.amountNumbers=amountNumbers;
        this.amountColors=amountColors;
        this.colors=colors;
    }
    public ArrayList<Integer> getAmountNumbers() { return amountNumbers; }
    public ArrayList<Integer> getAmountColors() { return amountColors; }
    public ArrayList<Integer> getNumbers() { return numbers; }
    public ArrayList<String> getColor() { return colors; }
    public int getTotalAmount() { return totalAmount; }
    public void invalidNumber(){
        int i=0;
        while(i< numbers.size()) {
            if (numbers.get(i)<0 || numbers.get(i) > 36) {
                numbers.remove(i);
                amountNumbers.remove(i);
            }else{i+=1;}
        }
    }
    public void invalidAmount(){
        int i= 0;
        while(i<amountNumbers.size()){
            if(amountNumbers.get(i) + totalAmount < 10000){
                totalAmount+=amountNumbers.get(i);
                i+=1;
            }
            else{
                amountNumbers.remove(i);
                numbers.remove(i);
            }
        }
        i=0;
        while(i<amountNumbers.size()){
            if(amountColors.get(i) + totalAmount < 10000){
                totalAmount+=amountColors.get(i);
                i+=1;
            }
            else{
                amountColors.remove(i);
                colors.remove(i);
            }
        }
    }
}
