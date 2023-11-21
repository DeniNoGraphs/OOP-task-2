import java.util.List;

class Person {
    private String name;
    private List<String> hobbies;

    private int age;

    private String location;

    public Person(String name, int age, String location, List<String> hobbies) {
        this.name = name;
        this.hobbies = hobbies;
        this.age = age;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public int getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }
}
