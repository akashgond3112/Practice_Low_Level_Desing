package com.java.lld.design.dao;


import com.java.lld.design.constants.BoardType;
import com.java.lld.design.model.Board;
import com.java.lld.design.model.BoardList;
import com.java.lld.design.model.Card;
import com.java.lld.design.model.User;

import java.util.List;

public interface TrelloApplicationDao {
	List<Board> getAllBoards();

	void addBoard(Board board);

	BoardList addList(BoardList list, String boardId);

	Card addCard(Card card, String listId);

	Board getBoard(String boardId);

	List<BoardList> getListForBoard(String boardId);

	List<Card> getCardsForList(String listId);

	BoardList getBoardList(String listId);

	Card getCard(String cardId);

	Board setBoardName(String name, String boardId);

	Board setBoardPrivacy(String boardId, BoardType privacy);

	Board addMemberInBoard(User user, String boardId);

	void addUser(User user);

	User getUser(String userId);

	Board removeMemberInBoard(String userId, String boardId);

	Board deleteBoard(String boardId);

	BoardList getList(String listId);

	BoardList setListName(String name, String listId);

	Card setCardName(String name, String cardId);

	Card setCardAssignedTo(String assignedToEmail, String cardId);

	BoardList deleteList(String listId);

	Card deleteCard(String cardId);

	BoardList moveList(String listId, String newBoardId);

	Card moveCard(String cardId, String newListId);
}
