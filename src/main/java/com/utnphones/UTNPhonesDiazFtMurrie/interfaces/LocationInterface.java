package com.utnphones.UTNPhonesDiazFtMurrie.interfaces;

import java.net.URI;

public interface LocationInterface<T> {
    //region Methods:
    public URI getLocation(T data);
    //endregion
}
