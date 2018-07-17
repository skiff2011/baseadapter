package eu.theappshop.baseadapter.adapter;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public abstract class ObservableAdapter {

  private transient List<AdapterDataObserver> observers = new ArrayList<>();

  public void registerObserver(@NonNull AdapterDataObserver observer) {
    synchronized (this) {
      if (observers == null) {
        observers = new ArrayList<>();
      }
      if (!observers.contains(observer)) {
        observers.add(observer);
      }
    }
  }

  public void unregisterObserver(@NonNull AdapterDataObserver observer) {
    synchronized (this) {
      if (observers != null) {
        observers.remove(observer);
      }
    }
  }

  public List<AdapterDataObserver> getObservers() {
    return observers;
  }
}