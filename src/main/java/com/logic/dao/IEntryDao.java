package com.logic.dao;
import com.logic.model.Entry;
public interface IEntryDao {
    int insert (Entry a);

    void delete ();

    int create ();

    int read ();
}
