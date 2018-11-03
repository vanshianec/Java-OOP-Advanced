public class Coffee {
    private String type;
    private String size;

    public Coffee(String type, String size) {
        this.type = type;
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public String toString(){
        return String.format("%s %s",this.size,this.type);
    }
}
