package ro.sandorrobertk94.exceptions.controller;

import ro.sandorrobertk94.repository.IRepository;

/**
 * Created by robert on 12/7/15.
 */
public class Controller {
    private IRepository repository;

    public Controller(IRepository repository) {
        this.repository = repository;
    }

    void oneStep() {

    }
}
