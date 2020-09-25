public class Todo extends Task{

    public Todo(String description,String construct) {
        super(description,construct);
    }


    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
