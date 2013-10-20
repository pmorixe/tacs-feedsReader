package ar.edu.utn.frba.tacs.grupo1.updaterServices;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import ar.edu.utn.frba.tacs.grupo1.domain.Entry;
import ar.edu.utn.frba.tacs.grupo1.domain.Feed;
import ar.edu.utn.frba.tacs.grupo1.predicates.EntryAlreadyExistsPredicate;

@Service
public class FeedUpdaterService {

  private static FeedUpdaterService instance = null;

  public static FeedUpdaterService getInstance() {
    if (instance == null)
      return instance = new FeedUpdaterService();
    return instance;
  }

  public int update(Feed feed, List<Entry> newEntries) {
    List<Entry> entries = feed.getEntries();
    int updates = 0;
    for (Entry newEntry : newEntries) {
      if (!CollectionUtils.exists(entries, new EntryAlreadyExistsPredicate(newEntry))) {
        entries.add(newEntry);
        updates++;
      }
    }
    return updates;
  }
}
