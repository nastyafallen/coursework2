package pro.sky.coursework2.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pro.sky.coursework2.exception.QuestionNotFoundException;
import pro.sky.coursework2.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository{

    private final Set<Question> questions;

    public JavaQuestionRepository() {
        this.questions = new HashSet<>();
    }

    @PostConstruct
    public void init() {
        add(new Question("Какие два класса не наследуются от Object?", "Таких классов нет. Все классы прямо или через предков наследуются от класса Object! Кроме самого класса Object, конечно :)"));
        add(new Question("Что такое пул строк?", "Это механизм, позволяющий хранить в памяти компьютера только один экземпляр строки с идентичным содержанием"));
        add(new Question("Что такое сигнатура метода?", "Это имя метода и принимаемые параметры (в определенном порядке). В сигнатуру метода не входит возвращаемое значение, а также бросаемые им исключения"));
        add(new Question("Что такое JSON?", "JavaScript Object Notation. Это формат обмена данными, описание объекта в текстовом формате. Состоит из пар ключ-значение, где ключ - какой-то параметр"));
        add(new Question("Почему HashMap - не коллекция?", "Потому что мапа не реализует интерфейс Collection. Она является реализацией интерфейса AbstractMap"));
        add(new Question("Что такое интерфейс?", "Это класс без полей, в нем есть только методы (без реализации)"));
        add(new Question("В чём отличия абстрактного класса от интерфейса?", "Абстрактный класс может иметь поля. Нельзя создавать объекты интерфейса. Методы интерфейса не имеют реализации и по умолчанию являются абстрактными"));
        add(new Question("Какой интерфейс называется функциональным?", "Это интерфейс, содержащий только 1 абстрактный метод. Это то же самое, что и лямбда-выражение. Примеры: Consumer, Supplier, Predicate и Function"));
        add(new Question("Что такое контракт класса?", "Это способы взимодействия с объектом этого класса, т.е. все его методы"));
        add(new Question("Что такое коллекции?", "Это сущности/структуры данных, реализующие интерфейс Collection (который расширяет интерфейс Iterable), используемые для упорядоченного и неупорядоченного хранения однотипных объектов"));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new QuestionNotFoundException("Вопрос не найден!");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions
                .stream()
                .toList();
    }
}
