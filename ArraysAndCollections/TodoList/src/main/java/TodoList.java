import java.util.ArrayList;

public class TodoList {

    private final ArrayList<String> toDoList;
    {
        toDoList = new ArrayList<>();
    }

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        toDoList.add(todo);
        System.out.println("Добавлено дело \"" + todo + "\"");
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        if (toDoList.size() > index){
            toDoList.add(index, todo);
        }else {
            toDoList.add(todo);
        }
        System.out.println("Добавлено дело \"" + todo + "\"");
    }

    public void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        if (toDoList.size() > index){
            String tmp = toDoList.get(index);
            toDoList.set(index, todo);
            System.out.println("Дело \"" + tmp + "\" заменено на \"" + todo + "\"");
        }else {
            System.out.println("Дело с таким номером не существует");
        }
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if (toDoList.size() > index){
            String tmp = toDoList.get(index);
            toDoList.remove(index);
            System.out.println("Дело \"" + tmp + "\" удалено");
        }else {
            System.out.println("Дело с таким номером не существует");
        }
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return toDoList;
    }

}