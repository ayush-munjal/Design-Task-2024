package net.media.training.designpattern.builder;

public class XMLBuilder{
    private Person person;

    public XMLBuilder setPerson(Person person){
        this.person = person;
        return this;
    }

    public String build(){
        TagBuilder tagbuilder =  new TagBuilder();
        String cityTag  = tagbuilder.setTagName("City").setvalue(person.getCity()).build();
        String countryTag  = tagbuilder.setTagName("Country").setvalue(person.getCountry()).build();
        String addressTag = tagbuilder.setTagName("Address").setvalue(cityTag + countryTag).build();
        String PersonTag = tagbuilder.setTagName("Person")
                            .setAttribute("id", String.valueOf(person.getId()))
                            .setAttribute("name", String.valueOf(person.getName()))
                            .setvalue(addressTag)
                            .build();
        return PersonTag;
    }
}