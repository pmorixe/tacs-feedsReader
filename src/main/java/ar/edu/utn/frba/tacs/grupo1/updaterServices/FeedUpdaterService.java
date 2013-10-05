package ar.edu.utn.frba.tacs.grupo1.updaterServices;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import ar.edu.utn.frba.tacs.grupo1.domain.Entry;
import ar.edu.utn.frba.tacs.grupo1.domain.Feed;
import ar.edu.utn.frba.tacs.grupo1.predicates.EntryAlreadyExistsPredicate;

public class FeedUpdaterService {

  public static void update(Feed feed, List<Entry> newEntries) {
    List<Entry> entries = feed.getEntries();
    for (Entry newEntry : newEntries) {
      if (!CollectionUtils.exists(entries, new EntryAlreadyExistsPredicate(newEntry)))
        entries.add(newEntry);
    }

  }
}
