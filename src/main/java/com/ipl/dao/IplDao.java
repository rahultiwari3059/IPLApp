package com.ipl.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IplDao<E> {
	public boolean isValid(String username, String password);

	public List<E> showList();

	public List<E> delete(int id);

	public boolean add(E user);
}
