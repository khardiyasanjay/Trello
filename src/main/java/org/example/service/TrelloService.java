package org.example.service;

import org.example.entity.Board;
import org.example.entity.LIST;
import org.example.entity.User;

import java.util.*;

public class TrelloService {
    Map<String,Board> boards;

    public TrelloService(){
        boards = new HashMap<>();
    }

    public void show(){
        if(boards.isEmpty()){
            System.out.println("No boards");
        }else{
            System.out.println(boards.toString());
        }
    }

    public void showBoard(String boardId){
        if(boards.isEmpty() || !boards.containsKey(boardId)){
            System.out.println("Board " + boardId + " does not exist");
        }else{
            System.out.println(boards.get(boardId).toString());
        }
    }

    public void createBoard(String name){
        Board board = new Board();
        board.setMembers(new ArrayList<>());
        board.setLists(new ArrayList<>());
        board.setId(UUID.randomUUID().toString());
        board.setName(name);

        boards.put(board.getId(),board);
    }

    public void updateBoardName(String id, String name){
        boards.get(id).setName(name);
    }

    public void updateBoardPrivacy(String id, String privacy){
        boards.get(id).setPrivacy(privacy);
    }

    public void addMemberInBoard(String id, User user){
        boards.get(id).getMembers().add(user);
    }

    public void removeMemberInBoard(String id, User user){
        boards.get(id).getMembers().add(user);
    }

    public void deleteBoard(String boardId){
        if(boards.isEmpty() || !boards.containsKey(boardId)){
            System.out.println("Board " + boardId + " does not exist");
        }else{
            boards.remove(boardId);
            System.out.println("Board " + boardId + " deleted";
        }
    }

    public void createList(String boardId, String listName){
        if(!boards.containsKey(boardId)){
            System.out.println("Board " + boardId + " does not exist");
        } else {
            LIST list = new LIST();
            list.setId(UUID.randomUUID().toString());
            list.setName(listName);
            list.setCards(new ArrayList<>());

            boards.get(boardId).getLists().add(list);
        }
    }
}
