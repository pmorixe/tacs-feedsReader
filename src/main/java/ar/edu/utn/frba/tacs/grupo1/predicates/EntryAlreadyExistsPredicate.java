package ar.edu.utn.frba.tacs.grupo1.predicates;

import org.apache.commons.collections.Predicate;

import ar.edu.utn.frba.tacs.grupo1.domain.Entry;

public class EntryAlreadyExistsPredicate implements Predicate {

  private String newEntryLink;

  public EntryAlreadyExistsPredicate(Entry newEntry) {
    newEntryLink = newEntry.getLink();
  }

  @Override
  public boolean evaluate(Object arg0) {
    Entry entry = (Entry) arg0;
    return newEntryLink.equals(entry.getLink());
  }

}
