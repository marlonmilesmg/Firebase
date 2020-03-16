package www.technoextreme.co.zw.firebase;

public class RequestTowing {

    private String Name;
    private Integer Age;
    private Long ph;

    public RequestTowing() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public Long getPh() {
        return ph;
    }

    public void setPh(Long ph) {
        this.ph = ph;
    }
}
