package com.logic.service;

import com.logic.dao.EntryDao;
import com.logic.dao.IEntryDao;
import com.logic.model.Entry;

public class EntryService {

    //dependency injection, this implementation will start the Account Dao layer
    //, and connect to db to do transaction.
    //business math
    public Entry insertExample(Entry a) {
        IEntryDao adao = new EntryDao();
//        System.out.println("inserting BigInteger");

        int generated_id = adao.insert(a);
        if (generated_id != -1 && generated_id != a.getId()) {
            a.setId(generated_id); //the account (for business math) is now set to the result from
            //the db query
        }
//        System.out.println("Successfully entered with Id of " + a.getId());

       return a;
    }
}
