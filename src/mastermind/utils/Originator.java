package mastermind.utils;

import mastermind.models.Memento;

public interface Originator {

    void restore(Memento memento);

    Memento createMemento();
}
