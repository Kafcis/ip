public class Task {
    protected String description;
    protected boolean isDone=false;

    public Task(String description) {
        this.description=description;
    }

    public  void main(int index, String name) {
        setName(name);
    }

    private  void setName(String name) {
        this.description = name;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }


    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }
    public String check(){
        if (isDone()){
            return "[✓]";
        }
        else{
            return "[✗]";
        }
    }

    public String descTask(){
        return check()+ " " + getDescription();
    }
}
