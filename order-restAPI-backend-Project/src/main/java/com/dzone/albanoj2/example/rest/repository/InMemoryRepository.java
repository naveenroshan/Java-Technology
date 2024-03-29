package com.dzone.albanoj2.example.rest.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.dzone.albanoj2.example.rest.domain.Identifiable;


public abstract class InMemoryRepository<T extends Identifiable> {

	@Autowired
	private IdGenerator idGenerator;
	
	private List<T> elements = Collections.synchronizedList(new ArrayList<>());

	//create operation
	public T create(T element) {
		elements.add(element);
		element.setId(idGenerator.getNextId());
		return element;
	}
    //delete operation
	public boolean delete(Long id) {
		return elements.removeIf(element -> element.getId().equals(id));
	}
    //read all operation
	public List<T> findAll() {
		return elements;
	}
    //find by id operation
	public Optional<T> findById(Long id) {
		return elements.stream().filter(e -> e.getId().equals(id)).findFirst();
	}
    //get number of order
	public int getCount() {
		return elements.size();
	}

	public void clear() {
		elements.clear();
	}
    //update operation
	public boolean update(Long id, T updated) {
		
		if (updated == null) {
			return false;
		}
		else {
			Optional<T> element = findById(id);
			element.ifPresent(original -> updateIfExists(original, updated));
			return element.isPresent();
		}
	}
	
	protected abstract void updateIfExists(T original, T desired);

}
