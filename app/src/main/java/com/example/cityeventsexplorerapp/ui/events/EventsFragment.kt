package com.example.cityeventsexplorerapp.ui.events

import androidx.fragment.app.viewModels
import com.example.cityeventsexplorerapp.R
import com.example.cityeventsexplorerapp.base.BaseFragment
import com.example.cityeventsexplorerapp.databinding.FragmentEventsBinding
import com.example.cityeventsexplorerapp.ui.adapter.EventsAdapter
import com.example.coreui.delegate.viewBinding
import com.example.coreui.extensions.collectLatestWhenStarted
import com.example.coreui.extensions.collectWhenStarted
import com.example.coreui.extensions.dp
import com.example.coreui.util.AdaptiveSpacingItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventsFragment : BaseFragment<EventsViewModel>(R.layout.fragment_events) {
    override val viewModel: EventsViewModel by viewModels()
    private val binding by viewBinding(FragmentEventsBinding::bind)

    private val eventsAdapter by lazy {
        EventsAdapter(
            onEventClick = {
                viewModel.navigateToDetails(it)
            }
        )
    }

    override fun initView() = with(binding){
        rvEvents.adapter = eventsAdapter.adapter
        rvEvents.addItemDecoration(AdaptiveSpacingItemDecoration(16.dp, edgeEnabled = true))
    }

    override fun initObservers() {
        collectLatestWhenStarted(viewModel.eventPagingState){
            eventsAdapter.adapter.submitData(it)
        }
    }
}