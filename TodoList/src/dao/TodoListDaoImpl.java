package dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import dto.Todo;

public class TodoListDaoImpl implements TodoListDao {

    private final String FILE_PATH = "TodoList.dat";
    private List<Todo> todoList;

    public TodoListDaoImpl() throws IOException, ClassNotFoundException {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
                todoList = (List<Todo>) ois.readObject();
            }
        } else {
            todoList = new ArrayList<>();
        }
    }

    @Override
    public List<Todo> getTodoList() {
        return todoList;
    }

    @Override
    public boolean addTodo(Todo todo) throws IOException {
        todoList.add(todo);
        saveFile();
        return true;
    }

    @Override
    public boolean deleteTodoByIndex(int index) throws IOException {
        List<Todo> todoList = getTodoList();

        if (index >= 0 && index < todoList.size()) {
            todoList.remove(index); 
            saveFile(); 
            return true;
        }
        return false; 
    }


    @Override
    public void saveFile() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(todoList);
        }
    }
}