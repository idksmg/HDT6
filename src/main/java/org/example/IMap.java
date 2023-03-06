package org.example;

public interface IMap<K, V> {
    void put(K key,V value);
    V get(K key);
    void remove(K key);
}
