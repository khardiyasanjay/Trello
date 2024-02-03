package org.example.service;

import org.example.entity.Board;
import org.example.entity.Card;
import org.example.entity.LIST;
import org.example.entity.User;
import org.example.exception.TrelloException;

import java.util.*;

public class TrelloService {
    Map<String, User> users;
    Map<String, Board> boards;
    Map<String, LIST> lists;
    Map<String, Card> cards;

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

    public void createBoard(String name){
        Board board = new Board();
        board.setMembers(new ArrayList<>());
        board.setLists(new ArrayList<>());
        board.setId(UUID.randomUUID().toString());
        board.setName(name);

        boards.put(board.getId(),board);
        System.out.println("Board created with board id " + board.getId());
    }

    public void showBoard(String boardId) throws TrelloException {
        if(boards.isEmpty() || !boards.containsKey(boardId)){
            System.out.println("Board " + boardId + " does not exist");
            throw new TrelloException("Board does not exist with board id " + boardId);
        }else{
            System.out.println(boards.get(boardId).toString());
        }
    }
    public void updateBoardName(String id, String name){
        boards.get(id).setName(name);
    }

    public void updateBoardPrivacy(String id, String privacy){
        boards.get(id).setPrivacy(privacy);
    }

    public void addMemberInBoard(String boardId, String userName){
        User user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setName(userName);

        users.put(user.getUserId(),user);
        boards.get(boardId).getMembers().add(user.getUserId());
    }

    public void removeMemberInBoard(String boardId, String userName) throws TrelloException {
        for(String userId: boards.get(boardId).getMembers()){
            if(!users.containsKey(userId)){
                throw new TrelloException("User not found in this board with this userName");
            } else {
                if(users.get(userId).getName().equals(userName)){
                    boards.get(boardId).getMembers().remove(userId);
                    System.out.println("User deleted from board " + boardId + " with user name " + userName);
                    break;
                }
            }
        }

    }

    public void deleteBoard(String boardId) throws TrelloException {
        if(boards.isEmpty() || !boards.containsKey(boardId)){
            System.out.println("Board " + boardId + " does not exist");
            throw new TrelloException("board does not exist with id " + boardId);
        }else{
            boards.remove(boardId);
            System.out.println("Board " + boardId + " deleted");
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

            lists.put(list.getId(), list);
            boards.get(boardId).getLists().add(list.getId());
        }
    }

    public void showList(String boardId) throws TrelloException {
        if(!boards.containsKey(boardId)){
            System.out.println("Board " + boardId + " does not exist");
            throw new TrelloException("Board does not exist");
        } else {
            System.out.println(boards.get(boardId).getLists().toString());
        }
    }

    public void createCard(String listId) throws TrelloException {
        Card card = new Card();
        card.setId(UUID.randomUUID().toString());

        if(!lists.containsKey(listId)){
            System.out.println("list not found");
            throw new TrelloException("List not found with list id " + listId);
        } else {
            lists.get(listId).getCards().add(card.getId());
            System.out.println("Card created with id " + card.getId());
        }
    }

    public void addCardName(String cardId, String cardName) throws TrelloException {
        if(!cards.containsKey(cardId)){
            System.out.println("Card does not exist");
            throw new TrelloException("Card does not exist");
        } else {
            cards.get(cardId).setName(cardName);
        }
    }

    public void addCardDescription(String cardId, String cardDescription) throws TrelloException {
        if(!cards.containsKey(cardId)){
            System.out.println("Card does not exist");
            throw new TrelloException("Card does not exist");
        } else {
            cards.get(cardId).setDescription(cardDescription);
        }
    }
}
