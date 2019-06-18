package com.skiff2011.baseadapter.item;

import androidx.annotation.NonNull;

public interface DiffItem extends Item {

  boolean isEqualItem(@NonNull Item item);

  boolean isEqualContent(@NonNull Item item);
}
