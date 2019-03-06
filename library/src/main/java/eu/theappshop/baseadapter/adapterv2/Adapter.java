package eu.theappshop.baseadapter.adapterv2;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.support.annotation.NonNull;
import eu.theappshop.baseadapter.adapter.BaseViewHolder;
import eu.theappshop.baseadapter.vm.VM;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public interface Adapter<V extends VM>
    extends Serializable, Observable, ObservableAdapter<V>, Iterable<V> {

  @Bindable int getSize();

  @Bindable boolean isEmpty();

  boolean contains(@NonNull V vm);

  boolean containsAll(@NonNull Collection<? extends V> c);

  @NonNull Iterator<V> iterator();

  @NonNull V remove(int index);

  boolean remove(@NonNull V vm);

  boolean removeIf(@NonNull Predicate<V> predicate);

  boolean removeIf(@NonNull Predicate<V> predicate, boolean withDiffUtil);

  List<V> removeRange(int beginIndex, int endIndex);

  void clear();

  void clear(boolean withDiffUtil);

  void add(@NonNull V vm);

  void add(int index, @NonNull V element);

  boolean addAll(@NonNull Collection<? extends V> c);

  boolean addAll(int index, @NonNull Collection<? extends V> c);

  @NonNull V get(int index);

  //copy list to avoid modification in original
  @NonNull List<V> vms();

  @NonNull V set(int index, @NonNull V element);

  void set(@NonNull Collection<? extends V> c);

  void set(@NonNull Collection<? extends V> c, boolean withDiffUtil);

  int indexOf(@NonNull V vm);

  int lastIndexOf(@NonNull V vm);

  @NonNull ListIterator<V> listIterator();

  @NonNull ListIterator<V> listIterator(int index);

  void bindViewHolder(BaseViewHolder<V> viewHolder, int position);

  void refresh();
}
