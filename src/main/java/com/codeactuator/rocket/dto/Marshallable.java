package com.codeactuator.rocket.dto;

public interface Marshallable<E, D> {

    public E marshall();
    public void unmarshal(E e);
}
