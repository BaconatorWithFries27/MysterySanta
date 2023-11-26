import java.util.ArrayList;

public class Person {

    protected String name;
    protected String email;

    protected Person receiver;

    protected ArrayList<Person> restrictedGift = new ArrayList<Person>();

    public Person(String name, String email){
        this.name = name;
        this.email = email;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public void setRestrictedGift(Person restricted){
        restrictedGift.add(restricted);
    }

    public void removeRestrictedGift(){
        restrictedGift.clear();
    }

    public void setReceiver(Person receiver){
        this.receiver = receiver;
    }

    public String toString(){
        return ("Name: " + name + " Email: " + email);
    }

    public String printSanta(){
        return (name +", you have " + receiver + " for Mystery Santa");
    }

}

