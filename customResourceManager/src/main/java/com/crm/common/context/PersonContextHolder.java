package com.crm.common.context;

public class PersonContextHolder {

    static ThreadLocal<PersonContext> threadLocal = new ThreadLocal<>();

    public static PersonContext getPersonContext() {
        return threadLocal.get();
    }

    public static void setPersonContext(PersonContext personContext) {
        threadLocal.set(personContext);
    }

}
