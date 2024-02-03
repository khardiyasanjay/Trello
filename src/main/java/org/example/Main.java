package org.example;

import org.example.exception.TrelloException;
import org.example.service.TrelloService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TrelloService trelloService = new TrelloService();


        while (true) {
            System.out.println("Enter command SHOW/BOARD");
            String command = scanner.next();

            switch (command) {
                case "SHOW":
                    trelloService.show();
                    break;
                case "BOARD":
                    System.out.println("Enter CREATE/name/privacy or boardId");
                    String command2 = scanner.next();
                    if (command2.equals("CREATE")) {
                        scanner.nextLine(); // USE THIS TO CONSUME \n CHARACTER OF COMMAND2
                        System.out.println("Enter board name");
                        String boardName = scanner.nextLine();
                        trelloService.createBoard(boardName);
                    } else if (command2.equals("name")) {
                        System.out.println("Enter board id");
                        String boardId = scanner.next();
                        System.out.println("Enter new name");
                        scanner.nextLine();// USE THIS TO CONSUME \n CHARACTER OF PREVIOUS next()
                        String boardName = scanner.nextLine();
                        trelloService.updateBoardName(boardId, boardName);
                    } else if (command2.equals("privacy")) {
                        System.out.println("Enter board id");
                        String boardId = scanner.next();
                        System.out.println("Enter privacy type");
                        scanner.nextLine();// USE THIS TO CONSUME \n CHARACTER OF PREVIOUS next()
                        String privacy = scanner.next();
                        trelloService.updateBoardPrivacy(boardId, privacy);
                    } else {
                        try {
                            trelloService.showBoard(command2);
                        } catch (TrelloException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                default:
                    System.out.println("no command given try again");
            }

        }
    }
}