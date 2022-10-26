package _26102022;

public class Card {
    public String name;

    public Card(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name=" + name + '\'' +
                '}';
    }
}

