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
        for(int i=0;i<amountNumbers.size();i++){
            if(totalAmount<10000 || amountNumbers.get(i) + totalAmount > 10000){
                totalAmount+=amountNumbers.get(i);
            }else{
                amountNumbers.remove(i);
                numbers.remove(i);
            }
        }
        for(int i=0;i<amountColors.size();i++){
            if(totalAmount<10000 || amountColors.get(i) + totalAmount > 10000 ){
                totalAmount+=amountColors.get(i);
            }else{
                amountColors.remove(i);
                colors.remove(i);
            }
        }
    }

}
