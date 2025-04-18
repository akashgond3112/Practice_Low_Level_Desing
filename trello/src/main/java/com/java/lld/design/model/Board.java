package com.java.lld.design.model;


import com.java.lld.design.constants.BoardType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
public class Board extends Entity {
	private BoardType privacy;
	private String url;
	private List<User> members;
	private List<BoardList> list;

	public Board(String name) {
		super(name);
		this.privacy = BoardType.PUBLIC;
		this.url = "http://trello.com/" + getEntityId();
		this.members = new ArrayList<>();
		this.list = new ArrayList<>();
	}

	public void addMember(User user) {
		members.add(user);
	}

	public void removeMember(String userId) {
		this.members = members.stream().filter(user -> !user.getUserId().equals(userId)).collect(Collectors.toList());
	}

	public void removeList(String listId) {
		this.list = list.stream().filter(listObj -> !listObj.getEntityId().equals(listId)).collect(Collectors.toList());
	}

	public void addToList(BoardList boardList) {
		this.list.add(boardList);
	}

	@Override
	public String toString() {
		return super.toString() + " Board{" + "privacy=" + privacy + ", URL='" + url + '\'' + ", members=" + members + ", list=" + list + '}';
	}
}
