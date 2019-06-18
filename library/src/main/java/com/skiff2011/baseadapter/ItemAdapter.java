package com.skiff2011.baseadapter;

import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import com.skiff2011.baseadapter.item.Item;
import com.skiff2011.baseadapter.misc.function.Predicate;
import com.skiff2011.baseadapter.view.BaseViewHolder;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public interface ItemAdapter<V extends Item> extends Observable,
    Serializable,
    ObservableAdapter,
    Iterable<V> {

  int indexOf(@NonNull V vm);

  int lastIndexOf(@NonNull V vm);

  boolean contains(@NonNull V vm);

  boolean containsAll(@NonNull Collection<? extends V> c);

  @NonNull ListIterator<V> listIterator();

  boolean remove(@NonNull V vm);

  void clear();

  void add(@NonNull V vm);

  boolean addAll(@NonNull Collection<? extends V> c);

  boolean removeIf(@NonNull Predicate<V> predicate);

  void set(@NonNull Collection<? extends V> c);

  void bindViewHolder(BaseViewHolder<V> viewHolder, int position);

  @Bindable int getSize();

  @Bindable boolean isEmpty();

  void refresh();

  @NonNull ListIterator<V> listIterator(int index);

  @NonNull V get(int index);

  @NonNull List<V> vms();

  //CRUD

  //remove methods
  @NonNull V remove(int index);

  boolean removeIf(@NonNull Predicate<V> predicate, boolean withDiffUtil);

  List<V> removeRange(int beginIndex, int endIndex);

  void clear(boolean withDiffUtil);

  //add methods

  void add(int index, @NonNull V element);

  boolean addAll(int index, @NonNull Collection<? extends V> c);

  //set methods

  @NonNull V set(int index, @NonNull V element);

  void set(@NonNull Collection<? extends V> c, boolean withDiffUtil);
}
