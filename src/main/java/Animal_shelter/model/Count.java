package Animal_shelter.model;

public class Count implements AutoCloseable {
    private static Integer count = 0;
    private Integer instanceCount;
    private boolean closed = false;

    //region Method Add
    public void add(String value_1, String value_2) throws Exception{
        if(value_1.isEmpty() || value_2.isEmpty() || this.closed){
            throw new IllegalArgumentException();
        }
        else{
            count++;
            this.instanceCount = count;
        }

    }
    //endregion

    //region Getter

    public Integer getCount() {
        return count;
    }

    public Integer getInstanceCount() {
        return instanceCount;
    }

    //endregion

    @Override
    public void close(){
        closed = true;
    }
}
