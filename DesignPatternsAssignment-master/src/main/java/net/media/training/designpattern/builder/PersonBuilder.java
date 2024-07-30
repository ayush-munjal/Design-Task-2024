package net.media.training.designpattern.builder;

public class PersonBuilder implements Builder{
    private String name = null;
    private int id = 0;
    private String city = null;
    private String country = null;

    public PersonBuilder setName(String name){
        this.name = name;
        return this;
    }
    public PersonBuilder setCity(String city){
        this.city = city;
        return this;
    }
    public PersonBuilder setId(int id){
        this.id = id;
        return this;
    }
    public PersonBuilder setCountry(String country){
        this.country = country;
        return this;
    }
    public Person build(){
        return new Person(name,id,city,country);
    }
}
