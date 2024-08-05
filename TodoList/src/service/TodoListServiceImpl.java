package service;

import java.io.IOException;
import java.util.List;
import dao.TodoListDao;
import dao.TodoListDaoImpl;
import dto.Todo;

public class TodoListServiceImpl implements TodoListService {

    private TodoListDao dao;

    public TodoListServiceImpl() throws IOException, ClassNotFoundException {
        dao = new TodoListDaoImpl();
    }

    @Override
    public int addTodoList(String title, String detail) throws IOException {
        Todo todo = new Todo(title, detail);
        dao.addTodo(todo);
        return dao.getTodoList().size() - 1; 
    }




    @Override
    public List<Todo> getTodoList() {
        return dao.getTodoList();
    }

    @Override
    public Todo getTodoByIndex(int index) {
        List<Todo> todos = dao.getTodoList();
        if (index >= 0 && index < todos.size()) {
            return todos.get(index);
        }
        return null;
    }

    @Override
    public boolean updateTodoByIndex(int index, String newTitle, String newDetail) throws IOException {
        Todo todo = getTodoByIndex(index);
        if (todo != null) {
            todo.setTitle(newTitle);
            todo.setDetail(newDetail);
            dao.saveFile();
            return true;
        }
        return false;
    }

    @Override
    public boolean completeTodoByIndex(int index) throws IOException {
        Todo todo = getTodoByIndex(index);
        if (todo != null) {
            todo.setComplete(!todo.isCompleted());
            dao.saveFile();
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTodoByIndex(int index) throws IOException {
        return dao.deleteTodoByIndex(index);
    }
}
