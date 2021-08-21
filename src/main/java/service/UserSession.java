package service;

import jakarta.ejb.Stateful;

import java.io.Serializable;

@Stateful
public class UserSession implements Serializable {

    public String getCurrentName() {
        return "";
    }

}
