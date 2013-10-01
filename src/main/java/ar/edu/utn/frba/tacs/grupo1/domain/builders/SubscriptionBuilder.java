package ar.edu.utn.frba.tacs.grupo1.domain.builders;

import ar.edu.utn.frba.tacs.grupo1.domain.Subscription;

public class SubscriptionBuilder {

  private String url = "www.default.com";

  public SubscriptionBuilder withUrl(String url) {
    this.url = url;
    return this;
  }

  public Subscription build() {
    return new Subscription(url);
  }
}
