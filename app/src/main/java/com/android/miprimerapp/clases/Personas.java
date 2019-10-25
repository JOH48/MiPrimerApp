package com.android.miprimerapp.clases;

public class Personas {
    private String name;
    private String lastName;
    private Integer age;
    private String address;
    private Boolean cilvilStatus;

    public Personas(String name, String lastName, Integer age, String address, Boolean civilStatus) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.cilvilStatus = civilStatus;

    }

    public String getName(){
        return name;
    }

    public String getMyName (){
      return name + " " + lastName;

    }

    public Boolean getCilvilStatus () {
        return cilvilStatus;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public Integer quieroQueSumes(Integer valor1, Integer valor2){
        return valor1+valor2;
    }

    public Integer quieroQueReste(Integer valor1,Integer valor2){
        return valor1-valor2;
    }

    public Integer dividir(Integer valor1 ,Integer valor2){
        return valor1/valor2;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setAge (Integer age){
        this.age=age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCilvilStatus(Boolean cilvilStatus) {
        this.cilvilStatus = cilvilStatus;
    }
}



