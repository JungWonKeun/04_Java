package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import dto.Todo;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListView {

    private TodoListService service;
    private BufferedReader br;

    public TodoListView() {
        try {
            service = new TodoListServiceImpl();
            br = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
            System.out.println("*** 프로그램 실행 중 오류 발생 ***");
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void mainMenu() throws IOException {
        while (true) {
            System.out.println("\n====== Todo List =====");
            System.out.println("1. Todo List Full View");
            System.out.println("2. Todo Detail View");
            System.out.println("3. Todo Add");
            System.out.println("4. Todo Complete");
            System.out.println("5. Todo Update");
            System.out.println("6. Todo Delete");
            System.out.println("0. EXIT");
            System.out.print("select menu number >>> ");
            
            int menu = Integer.parseInt(br.readLine());

            switch (menu) {
                case 1: todoListFullView(); break;
                case 2: detailView(); break;
                case 3: addTodo(); break;
                case 4: completeTodo(); break;
                case 5: updateTodo(); break;
                case 6: deleteTodo(); break;
                case 0:
                    System.out.println("\n@@@ 프로그램 종료 @@@\n");
                    return;
                default:
                    System.out.println("### 메뉴에 작성된 번호만 입력해 주세요 ###");
            }
            System.out.println("=====================================================================");
        }
    }

    private void todoListFullView() {
        System.out.println("\n===============[1. Todo List Full View]===============\n");

        List<Todo> todoList = service.getTodoList();
        
        // 완료된 Todo의 개수를 직접 세기
        int completedCount = 0;
        for (Todo todo : todoList) {
            if (todo.isCompleted()) {
                completedCount++;
            }
        }

        System.out.printf("[ 완료된 Todo 개수 / 전체 Todo 수 : %d / %d ]\n", 
        			completedCount, todoList.size());
        System.out.println("--------------------------------------------------------------------");
        System.out.println("인덱스        등록일                완료여부     할 일 제목");
        System.out.println("--------------------------------------------------------------------");

        for (int i = 0; i < todoList.size(); i++) {
            Todo todo = todoList.get(i);
            String completionStatus = todo.isCompleted() ? "(O)" : "(X)";
            System.out.printf("[%3d]   %s    %10s       %4s\n",
                    i, todo.getFormattedDate(), completionStatus, todo.getTitle());
        }
        System.out.println("=====================================================================\n");
    }


    private void detailView() throws IOException {
        System.out.println("\n===============[2. Todo Detail View]===============\n");
        System.out.print("인덱스 번호 입력 : ");
        int index = Integer.parseInt(br.readLine());

        Todo todo = service.getTodoByIndex(index); 

        if (todo != null) {
            System.out.println("--------------------------------------------");
            System.out.println("제목 : " + todo.getTitle());
            System.out.println("등록일 : " + todo.getFormattedDate());
            System.out.println("완료여부 : " + (todo.isCompleted() ? "O" : "X"));
            System.out.println("\n[세부 내용]");
            System.out.println("--------------------------------------------");
            System.out.println(todo.getDetail());
        } else {
            System.out.println("### 입력한 인덱스 번호에 할 일(Todo)가 존재하지 않습니다 ###");
        }
        System.out.println("=====================================================================\n");
    }

    private void addTodo() throws IOException {
        System.out.print("할 일 제목 입력 : ");
        String title = br.readLine();

        System.out.println("세부 내용 작성 (입력 종료 시 !wq 작성 후 엔터)");
        StringBuilder detail = new StringBuilder(); 
        String line;

        while (!(line = br.readLine()).equals("!wq")) {
            detail.append(line).append("\n");
        }

        int index = service.addTodoList(title, detail.toString());

        System.out.printf("[ %d ] 인덱스에 추가되었습니다.\n", index);
    }

    private void completeTodo() throws IOException {
        System.out.println("\n===============[4. Todo Complete]===============\n");
        System.out.print("O <-> X 변경할 인덱스 번호 입력 : ");
        int index = Integer.parseInt(br.readLine());

        boolean isCompleted = service.completeTodoByIndex(index); 

        if (isCompleted) {
            System.out.println("완료 여부가 변경되었습니다.");
        } else {
            System.out.println("잘못된 인덱스 번호입니다.");
        }
    }

    private void updateTodo() throws IOException {
        System.out.println("\n===============[5. Todo Update]===============\n");
        System.out.print("수정할 To do 인덱스 번호 입력 : ");
        int index = Integer.parseInt(br.readLine());

        Todo todo = service.getTodoByIndex(index);  

        if (todo != null) {
            System.out.println("@@@@@@@@@@@[수정 전]@@@@@@@@@@@@@@@");
            System.out.println("--------------------------------------------");
            System.out.println("제목 : " + todo.getTitle());
            System.out.println("등록일 : " + todo.getFormattedDate());
            System.out.println("완료여부 : " + (todo.isCompleted() ? "O" : "X"));
            System.out.println("\n[세부 내용]");
            System.out.println("--------------------------------------------");
            System.out.println(todo.getDetail());
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

            System.out.print("수정할 제목 : ");
            String newTitle = br.readLine();

            System.out.println("수정할 세부 내용 작성 (입력 종료 시 !wq 작성 후 엔터)");
            StringBuilder newDetail = new StringBuilder();  
            String line;

            while (!(line = br.readLine()).equals("!wq")) {
                newDetail.append(line).append("\n");
            }

            boolean Update = service.updateTodoByIndex(index, newTitle, newDetail.toString());

            if (Update) {
                System.out.println("Todo가 수정되었습니다.");
            } else {
                System.out.println("Todo 수정 중 오류 발생");
            }
        } else {
            System.out.println("### 입력한 인덱스에 Todo가 존재하지 않습니다 ###");
        }
    }

    private void deleteTodo() throws IOException {
        System.out.println("\n===============[6. Todo Delete]===============\n");
        System.out.print("삭제할 인덱스 번호 입력 : ");
        int index = Integer.parseInt(br.readLine());

        boolean remove = service.deleteTodoByIndex(index);

        if (remove) {
            System.out.println("[삭제 되었습니다]");
        } else {
            System.out.println("잘못된 인덱스 번호입니다.");
        }
        System.out.println("=====================================================================\n");
    }

}
