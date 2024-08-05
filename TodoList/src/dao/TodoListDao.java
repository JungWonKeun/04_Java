package dao;

import java.io.IOException;
import java.util.List;
import dto.Todo;

public interface TodoListDao {
    List<Todo> getTodoList();
    boolean addTodo(Todo todo) throws IOException;
    boolean deleteTodoByIndex(int index) throws IOException;
    void saveFile() throws IOException;
}
