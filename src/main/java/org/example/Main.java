package org.example;

import org.example.service.TrelloService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();

        TrelloService trelloService = new TrelloService();

        switch (command){
            case "SHOW" :
                trelloService.show();
            case "Board" :
                String command2 = scanner.next();
                if(command2.equals("CREATE")){
                    String boardName = scanner.next();
                    trelloService.createBoard(boardName);
                } else{
                    String boardId = scanner.next();

                }
        }
    }
}