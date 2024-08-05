package run;

import view.TodoListView;

public class TodoListRun {
    public static void main(String[] args) {
        try {
            TodoListView view = new TodoListView();
            view.mainMenu();
        } catch (Exception e) {  
            e.printStackTrace();
        }
    }
}
