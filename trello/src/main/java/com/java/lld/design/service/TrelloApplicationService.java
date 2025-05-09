package com.java.lld.design.service;

import com.java.lld.design.constants.BoardType;
import com.java.lld.design.dao.TrelloApplicationDao;
import com.java.lld.design.model.Board;
import com.java.lld.design.model.BoardList;
import com.java.lld.design.model.Card;
import com.java.lld.design.model.User;

import java.util.List;

public class TrelloApplicationService {
    private final TrelloApplicationDao trelloApplicationDao;

    public TrelloApplicationService(TrelloApplicationDao trelloApplicationDao) {
        this.trelloApplicationDao = trelloApplicationDao;
    }

    public String addBoard(String name) {
        Board board = new Board(name);
        trelloApplicationDao.addBoard(board);
        return board.getEntityId();
    }

    public Board setBoardName(String boardId, String name) {
        return trelloApplicationDao.setBoardName(name, boardId);
    }

    public Board setBoardPrivacy(String boardId, BoardType privacy) {
        return trelloApplicationDao.setBoardPrivacy(boardId, privacy);
    }

    public Board addMemberInBoard(String boardId, String userId) {
        User user = trelloApplicationDao.getUser(userId);
        if (user != null) {
            return trelloApplicationDao.addMemberInBoard(user, boardId);
        }
        return null;
    }

    public Board removeMemberInBoard(String boardId, String userId) {
        return trelloApplicationDao.removeMemberInBoard(userId, boardId);
    }

    public Board deleteBoard(String boardId) {
        return trelloApplicationDao.deleteBoard(boardId);
    }

    public String addList(String boardId, String name) {
        BoardList boardList = new BoardList(name);
        return trelloApplicationDao.addList(boardList, boardId).getEntityId();

    }

    public String addCard(String listId, String assignedTo) {
        Card card = new Card(null, assignedTo);
        return trelloApplicationDao.addCard(card, listId).getEntityId();
    }

    public Card setCardName(String cardId, String name) {
        return trelloApplicationDao.setCardName(name, cardId);
    }

    public Card assignCard(String cardId, String email) {
        return trelloApplicationDao.setCardAssignedTo(email, cardId);
    }

    public Card unassignCard(String cardId) {
        return trelloApplicationDao.setCardAssignedTo(null, cardId);
    }

    public Board showBoard(String boardId) {
        return trelloApplicationDao.getBoard(boardId);
    }

    public List<Board> show() {
        return trelloApplicationDao.getAllBoards();
    }

    public BoardList getBoardList(String listId) {
        return trelloApplicationDao.getBoardList(listId);
    }

    public Board getBoard(String boardId) {
        return trelloApplicationDao.getBoard(boardId);
    }

    public Card getCard(String cardId) {
        return trelloApplicationDao.getCard(cardId);
    }

    public BoardList deleteList(String listId) {
        return trelloApplicationDao.deleteList(listId);
    }

    public Card deleteCard(String cardId) {
        return trelloApplicationDao.deleteCard(cardId);
    }

    public BoardList moveList(String listId, String newBoardId) {
        return trelloApplicationDao.moveList(listId, newBoardId);
    }

    public Card moveCard(String cardId, String newListId) {
        return trelloApplicationDao.moveCard(cardId, newListId);
    }


}
