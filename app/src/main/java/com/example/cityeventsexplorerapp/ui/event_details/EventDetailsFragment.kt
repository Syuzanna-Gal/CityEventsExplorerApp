package com.example.cityeventsexplorerapp.ui.event_details

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.cityeventsexplorerapp.R
import com.example.cityeventsexplorerapp.base.BaseFragment
import com.example.cityeventsexplorerapp.databinding.FragmentEventDetailsBinding
import com.example.cityeventsexplorerapp.ui.adapter.EventDetailsAdapter
import com.example.coreui.delegate.viewBinding
import com.example.coreui.extensions.collectWhenStarted
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventDetailsFragment : BaseFragment<EventDetailsViewModel>(R.layout.fragment_event_details) {
    override val viewModel: EventDetailsViewModel by viewModels()
    private val binding by viewBinding(FragmentEventDetailsBinding::bind)
    private val navArgs by navArgs<EventDetailsFragmentArgs>()

    private val eventDetailsAdapter by lazy {
        EventDetailsAdapter()
    }

    override fun initView() = with(binding) {
        rvDetails.adapter = eventDetailsAdapter.adapter
        viewModel.getEventDetails(navArgs.id)
    }

    override fun initObservers() {
        collectWhenStarted(viewModel.eventDetails) {
            eventDetailsAdapter.adapter.submitList(it)
        }
    }

}