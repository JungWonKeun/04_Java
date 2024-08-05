package service;

import java.io.IOException;
import java.util.List;

import dto.Todo;



public interface TodoListService {
	 int addTodoList(String title, String detail) throws IOException;
    
    List<Todo> getTodoList();
    
    Todo getTodoByIndex(int index);
    
    boolean updateTodoByIndex(int index, String newTitle, String newDetail) throws IOException;
    boolean completeTodoByIndex(int index) throws IOException;
    boolean deleteTodoByIndex(int index) throws IOException;
}
