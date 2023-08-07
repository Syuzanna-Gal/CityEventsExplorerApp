package com.example.cityeventsexplorerapp.ui.adapter

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.os.Build
import android.text.Html
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.isGone
import com.example.cityeventsexplorerapp.R
import com.example.cityeventsexplorerapp.databinding.ItemChipGroupBinding
import com.example.cityeventsexplorerapp.databinding.ItemDescriptionBinding
import com.example.cityeventsexplorerapp.databinding.ItemInfoBinding
import com.example.cityeventsexplorerapp.databinding.ItemSliderBinding
import com.example.cityeventsexplorerapp.ui.adapter.item.EventDetailStates
import com.example.cityeventsexplorerapp.util.type_alias.RColor
import com.example.cityeventsexplorerapp.util.type_alias.RString
import com.google.android.material.chip.Chip
import me.ibrahimyilmaz.kiel.adapterOf
import me.ibrahimyilmaz.kiel.core.RecyclerViewHolder

class EventDetailsAdapter(
    private val onBackClick: () -> Unit
) {

    val adapter =
        adapterOf<EventDetailStates> {
            diff(
                areItemsTheSame = { old, new -> old.identifier == new.identifier },
                areContentsTheSame = { old, new -> old == new },
            )

            register(
                layoutResource = R.layout.item_info,
                viewHolder = { v ->
                    InfoViewHolder(v)
                },
                onBindViewHolder = { vh, _, p -> vh.onBind(p) })

            register(
                layoutResource = R.layout.item_slider,
                viewHolder = { v ->
                    SliderViewHolder(v, onBackClick)
                },
                onBindViewHolder = { vh, _, p -> vh.onBind(p) })

            register(
                layoutResource = R.layout.item_chip_group,
                viewHolder = { v ->
                    ChipGroupViewHolder(v)
                },
                onBindViewHolder = { vh, _, p -> vh.onBind(p) })

            register(
                layoutResource = R.layout.item_description,
                viewHolder = { v ->
                    DescriptionViewHolder(v)
                },
                onBindViewHolder = { vh, _, p -> vh.onBind(p) })
        }

    class InfoViewHolder(
        view: View
    ) : RecyclerViewHolder<EventDetailStates.Info>(view) {

        private val binding = ItemInfoBinding.bind(view)

        fun onBind(item: EventDetailStates.Info) = with(binding) {
            tvInfo.text = item.text
            tvInfo.setCompoundDrawablesWithIntrinsicBounds(item.image, 0, 0, 0)
            if (item.text.isBlank())
                tvInfo.isGone = true
        }
    }

    class SliderViewHolder(
        view: View,
        private val onBackClick: () -> Unit
    ) : RecyclerViewHolder<EventDetailStates.Slider>(view) {

        private val binding = ItemSliderBinding.bind(view)

        fun onBind(item: EventDetailStates.Slider) = with(binding) {
            var finalImageList =
                listOf("https://images.unsplash.com/photo-1503614472-8c93d56e92ce?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8NXx8fGVufDB8fHx8fA%3D%3D&w=1000&q=80",
                "https://images.unsplash.com/photo-1431631927486-6603c868ce5e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8MTN8fHxlbnwwfHx8fHw%3D&w=1000&q=80")
//            if (item.imageList.isNotEmpty())
//                finalImageList = item.imageList

            val imageAdapter = ImageSliderAdapter()
            vpSlider.adapter = imageAdapter.adapter
            imageAdapter.adapter.submitList(finalImageList)
            ivBack.setOnClickListener {
                onBackClick()
            }
            tvTitle.text = item.title
        }
    }


    class ChipGroupViewHolder(
        view: View
    ) : RecyclerViewHolder<EventDetailStates.ChipGroup>(view) {

        private val binding = ItemChipGroupBinding.bind(view)

        @SuppressLint("ResourceAsColor")
        fun onBind(item: EventDetailStates.ChipGroup) = with(binding) {
            item.titles.forEach {
                val chip = Chip(itemView.context)
                chip.text = it
                chip.backgroundDrawable = ContextCompat.getDrawable(
                    itemView.context,
                    com.example.coreui.R.drawable.bg_rounded_purple
                )
                binding.chipGroup.addView(chip)
            }
            tvTitle.text = item.title
        }
    }

    class DescriptionViewHolder(
        view: View
    ) : RecyclerViewHolder<EventDetailStates.Description>(view) {

        private val binding = ItemDescriptionBinding.bind(view)

        fun onBind(item: EventDetailStates.Description) = with(binding) {

            tvExpandable.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Html.fromHtml(item.text, Html.FROM_HTML_MODE_LEGACY).toString()
            } else {
                Html.fromHtml(item.text).toString()
            }

            tvMoreOrLess.setOnClickListener {
                if (tvExpandable.isExpanded) {
                    tvExpandable.collapse()
                    tvMoreOrLess.text = itemView.context.getString(RString.read_more)
                } else {
                    tvExpandable.expand()
                    tvMoreOrLess.text = itemView.context.getString(RString.read_less)
                }
            }
        }
    }
}