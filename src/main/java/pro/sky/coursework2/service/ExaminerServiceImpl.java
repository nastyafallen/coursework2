package pro.sky.coursework2.service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.exception.WrongNumberException;
import pro.sky.coursework2.model.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    /*private Collection<Question> examQuestions = new ArrayList<>(List.of(
            new Question("Какие два класса не наследуются от Object?", "Таких классов нет. Все классы прямо или через предков наследуются от класса Object! Кроме самого класса Object, конечно :)"),
            new Question("Что такое пул строк?", "Это механизм, позволяющий хранить в памяти компьютера только один экземпляр строки с идентичным содержанием"),
            new Question("Что такое сигнатура метода?", "Это имя метода и принимаемые параметры (в определенном порядке). В сигнатуру метода не входит возвращаемое значение, а также бросаемые им исключения"),
            new Question("Что такое JSON?", "JavaScript Object Notation. Это формат обмена данными, описание объекта в текстовом формате. Состоит из пар ключ-значение, где ключ - какой-то параметр"),
            new Question("Почему HashMap - не коллекция?", "Потому что мапа не реализует интерфейс Collection. Она является реализацией интерфейса AbstractMap"),
            new Question("Что такое интерфейс?", "Это класс без полей, в нем есть только методы (без реализации)"),
            new Question("В чём отличия абстрактного класса от интерфейса?", "Абстрактный класс может иметь поля. Нельзя создавать объекты интерфейса. Методы интерфейса не имеют реализации и по умолчанию являются абстрактными"),
            new Question("Какой интерфейс называется функциональным?", "Это интерфейс, содержащий только 1 абстрактный метод. Это то же самое, что и лямбда-выражение. Примеры: Consumer, Supplier, Predicate и Function"),
            new Question("Что такое контракт класса?", "Это способы взимодействия с объектом этого класса, т.е. все его методы"),
            new Question("Что такое коллекции?", "Это сущности/структуры данных, реализующие интерфейс Collection (который расширяет интерфейс Iterable), используемые для упорядоченного и неупорядоченного хранения однотипных объектов")
            ));*/


    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0 || amount > questionService.getAll().size()) {
            throw new WrongNumberException("Введены некорректные данные!");
        }
        Set<Question> setOfRandomQuestions = new HashSet<>(amount);
        while (setOfRandomQuestions.size() < amount) {
            setOfRandomQuestions.add(questionService.getRandomQuestion());
        }
        return setOfRandomQuestions;
    }
}
