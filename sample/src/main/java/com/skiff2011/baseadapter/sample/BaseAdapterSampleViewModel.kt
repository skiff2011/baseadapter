package com.skiff2011.baseadapter.sample

import com.skiff2011.baseadapter.BaseItemAdapter
import com.skiff2011.baseadapter.ItemAdapter
import com.skiff2011.baseadapter.item.TitledItem

class BaseAdapterSampleViewModel : TabbedViewModel() {

  override val adapter: ItemAdapter<TitledItem> =
    BaseItemAdapter(listOf(BaseRVItem(), BasePagerItem()))

}