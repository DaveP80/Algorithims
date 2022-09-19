package com.logic.service;

import com.logic.dao.EntryDao;
import com.logic.dao.IEntryDao;
import com.logic.model.Entry;

public class EntryService {
    //dependency injection, this implementation will start the Account Dao layer
    //, and connect to db to do transaction.
    //this Service class can do more abstraction
    public Entry insertExample(Entry a) {
        IEntryDao adao = new EntryDao();
        int generated_id = adao.insert(a);
        if (generated_id != -1 && generated_id != a.getId()) {
            a.setId(generated_id); //the account (for business math) is now set to the result from
            //the db query
        }
       return a;
    }
}
