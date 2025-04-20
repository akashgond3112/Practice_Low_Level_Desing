package com.java.lld.design;


import com.java.lld.design.dao.impl.TrelloApplicationDaoImpl;
import com.java.lld.design.service.TrelloApplicationService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Driver {
	public static void main(String[] args) {
		TrelloApplicationService trelloApplicationService = new TrelloApplicationService(
				TrelloApplicationDaoImpl.getInstance());
		String boardId1 = trelloApplicationService.addBoard("Priyam");
		log.info("Board created: {}", trelloApplicationService.getBoard(boardId1));
		log.info(String.valueOf(trelloApplicationService.show()));
		String listId1 = trelloApplicationService.addList(boardId1, "List1");
		log.info(String.valueOf(trelloApplicationService.show()));
		String card1 = trelloApplicationService.addCard(listId1, "card1");
		trelloApplicationService.assignCard(card1, "priyam@hike.in");
		log.info(String.valueOf(trelloApplicationService.show()));

		String boardId2 = trelloApplicationService.addBoard("Priyam2");
		log.info("Board created: {}", trelloApplicationService.getBoard(boardId2));
		log.info(String.valueOf(trelloApplicationService.show()));
		String listId2 = trelloApplicationService.addList(boardId2, "List2");
		log.info(String.valueOf(trelloApplicationService.show()));
		String card2 = trelloApplicationService.addCard(listId2, "card2");
		trelloApplicationService.assignCard(card2, "priyam2@hike.in");
		log.info(String.valueOf(trelloApplicationService.show()));

		trelloApplicationService.moveList(listId1, boardId2);
		log.info(String.valueOf(trelloApplicationService.show()));
	}
}
