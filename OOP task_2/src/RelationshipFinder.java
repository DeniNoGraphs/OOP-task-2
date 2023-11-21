import java.util.ArrayList;
import java.util.List;

class RelationshipFinder {
    private List<Person> users;

    public RelationshipFinder(List<Person> users) {
        this.users = users;
    }


    public List<Person> findCommonHobbyFriends(Person person) {
        List<Person> friends = new ArrayList<>();
        for (Person user : users) {
            boolean sharedHobby = user.getHobbies().stream().anyMatch(hobby -> person.getHobbies().contains(hobby));

            if (!user.getName().equals(person.getName()) &&
                    user.getLocation().equals(person.getLocation()) &&
                    Math.abs(user.getAge() - person.getAge()) <= 2 &&
                    sharedHobby) {
                friends.add(user);
            }
        }
        return friends;
    }
}