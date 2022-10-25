package br.edu.utfpr.moraesfausto.englishschool.model.bo;

public interface GenericBO<T> {
    void save(T object);
    void update(T object);
    void delete(T object);
}
