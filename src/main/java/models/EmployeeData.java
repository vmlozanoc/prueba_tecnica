package models;
public class EmployeeData {
    private String firstName;
    private String middleName;
    private String lastName;



    public EmployeeData(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;


    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getLastName() { return lastName; }


}