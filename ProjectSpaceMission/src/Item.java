public class Item {
    String name;
    int weight;

    public String toString(){
        String string = this.name + Integer.toString(this.weight);

        return string;
    }


}
