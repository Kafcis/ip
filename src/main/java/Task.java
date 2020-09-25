public class Task {
    protected String description;
    protected boolean isDone=false;
    protected String construct;

    public Task(String description,String construct) {
        this.description=description;
        this.construct=construct;
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
    public String check() {
        if (isDone()){
            return "[Y]";
        } else{
            return "[N]";
        }
    }

    public String getConstruct() {
        return construct;
    }

    public String toString(){
        return check()+ " " + getDescription();
    }
}
