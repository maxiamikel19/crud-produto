package com.maxi.apiProducto.exceptions;

public class EntityFindByIdNotFoundException extends RuntimeException{
    
    public EntityFindByIdNotFoundException(String message){ super(message); }
}
