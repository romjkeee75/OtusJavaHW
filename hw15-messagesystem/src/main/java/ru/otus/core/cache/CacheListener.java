package ru.otus.core.cache;

/**
 * @author Roman
 */
public interface CacheListener<K, V> {

    void notify(K key, V value, String action);

}
