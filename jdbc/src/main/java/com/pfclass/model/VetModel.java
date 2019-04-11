package com.pfclass.model;

public class VetModel {
    private Long id;
    private String firstName;
    private String lastName;

    public VetModel(String firstName, String lastName){
        this(null, firstName, lastName);
    }

    public VetModel(Long id, String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public VetModel withId(Long id){
        return new VetModel(id, this.getFirstName(), this.getLastName());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }

        if(!(obj instanceof VetModel)){
            return false;
        }

        VetModel vet = (VetModel) obj;

        return vet.getId().equals(this.getId()) && vet.getLastName().equals(this.getLastName()) && vet.getFirstName().equals(this.getFirstName());
    }
}
