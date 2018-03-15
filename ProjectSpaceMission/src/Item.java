public class Item implements Comparable{
    String name;
    int weight;

    public String toString(){
        String string = this.name + Integer.toString(this.weight);

        return string;
    }



    @Override
    public int compareTo(Object o) {
        int compareWeight = ((Item)o).weight;

        return (compareWeight - this.weight);
    }
}
