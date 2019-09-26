/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package undo;

/**
 *
 * @author Estudiante
 */
interface StackGeneric<T> {
    public boolean empty();
    public boolean full();
    public T pop();
    public void push(T item);

}
