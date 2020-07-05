package prueba.model;
import org.springframework.data.redis.core.RedisHash;
import java.util.ArrayList;
import java.util.UUID;
@RedisHash("Roulette")
public class Roulette {
    private boolean open;
    private UUID uuid;
    private String id;
    private ArrayList<Bet> bets;
    public Roulette(){
        open=false;
        id=uuid.randomUUID().toString().replace("-", "");
        bets = new ArrayList<>();
    }
    public String getId() {
        System.out.println(id);
        return id;
    }
    public boolean isOpen() { return open; }
    public void setId(String id) { this.id = id; }
    public void setOpen(boolean open) { this.open = open; }
    public ArrayList<Bet> getBets() { return bets; }
    public void setBets(ArrayList<Bet> bets) { this.bets = bets; }
}
