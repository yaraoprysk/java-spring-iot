package ua.lviv.iot.spring.rest.model;

public class Student {
    private String firstName;
    private String lastName;
    private Integer id;

    public Student(String firstStudent, String lastName) {
        super();
        this.firstName = firstStudent;
        this.lastName = lastName;
    }

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
