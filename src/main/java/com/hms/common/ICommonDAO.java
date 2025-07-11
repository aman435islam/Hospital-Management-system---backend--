package com.hms.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface ICommonDAO<T> {
	public <T> T save(HttpServletRequest request);

	public <T> T edit(String id);

	public <T> T update(HttpServletRequest request);

	public <T> List<T> getAll();

	public boolean delete(String id);

}
