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
public class StackRefGeneric<T> implements StackGeneric<T> {
    private NodeGeneric<T> top;
    public StackRefGeneric(){ 
        top = null;
    } 
    public boolean empty() { 
        return (top == null);
        
    }
    
    public boolean full() {
        return false; 
    } 
    
    public T pop() {
        T item = null;
        if(!empty()){
            item = top.getData();
            top = top.getNext();
            return item;
        }else
            return null;
    }
    
    
    public void push(T item) { 
        NodeGeneric<T> newp = new NodeGeneric<T>(item);
        newp.setNext(top);
        top = newp;
    }
}