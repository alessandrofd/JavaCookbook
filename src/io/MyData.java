package io;

import java.io.Serializable;

public class MyData implements Serializable {
    String userName;
    String passwordCypher;
    transient String passwordClear;

    /** This constructor is required by most APIs */
    public MyData() {
        // Nothing to do
    }

    public MyData(String name, String clear) {
        setUserName(name);
        setPassword(clear);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String s) {
        this.userName = s;
    }

    public String getPasswordCypher() {
        return passwordCypher;
    }

    /** Save the clear text p/w in the object, it won't get serialized
     * So we must save the encryption! Encryption not shown here.
     */
    public void setPassword(String s) {
        passwordClear = s;
        passwordCypher = encrypt(s);
    }

    public String toString() {
        return "MyData[" + userName + ",----]";
    }

    protected String encrypt(String s) { return "fjslkjlqj2TOP+SECRETkjlskl"; }
}
