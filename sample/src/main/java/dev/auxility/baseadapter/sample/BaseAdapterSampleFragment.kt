package dev.auxility.baseadapter.sample

import androidx.lifecycle.ViewModelProviders
import dev.auxility.baseadapter.sample.R.string

class BaseAdapterSampleFragment : TabbedFragment() {

  override val viewModel: TabbedViewModel by lazy {
    ViewModelProviders.of(this)
        .get(BaseAdapterSampleViewModel::class.java)
  }

  override val titleRes: Int = string.baseadapter_sample

}