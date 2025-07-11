package com.hms.common;

import java.util.List;
import java.util.Map;

//import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

public interface IcommonController<T> {
	public T save(T t);

	public ResponseEntity<T> edit(int id);

	public ResponseEntity<T> update(int id, T t);

	public Map<String, Boolean> delete(int id);

	public List<T> getAll();
}
