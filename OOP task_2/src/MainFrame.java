import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class MainFrame extends JFrame {
    private JButton button;
    private JTextArea textArea;

    public MainFrame() {
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        button = new JButton("Find Friends");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Person> people = new ArrayList<>();
                people.add(new Person("Денис", 30, "Воронеж", Arrays.asList("Футбол", "Настольные игры", "Чтение")));
                people.add(new Person("Дима", 32, "Липецк", Arrays.asList("Футбол", "Плавание", "Шахматы")));
                people.add(new Person("Кристина", 27, "Елец", Arrays.asList("Танцы", "Вышивание", "Чтение")));
                people.add(new Person("Ангелина", 31, "Воронеж", Arrays.asList("Гимнастика", "Чтение", "Рисование")));
                people.add(new Person("Антон", 29, "Воронеж", Arrays.asList("Тренажёрный зал", "Бег", "Настольные игры")));

                RelationshipFinder finder = new RelationshipFinder(people);
                List<Person> johnsFriends = finder.findCommonHobbyFriends(people.get(0));

                textArea.append("вот возможные друзья Дениса:\n");
                for (Person friend : johnsFriends) {
                    String friendData = String.format(
                            "Name: %s\nAge: %d\nCity: %s\nHobbies: %s\n\n",
                            friend.getName(),
                            friend.getAge(),
                            friend.getLocation(),
                            String.join(", ", friend.getHobbies()));

                    textArea.append(friendData);
                }
            }
        });

        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);

        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}