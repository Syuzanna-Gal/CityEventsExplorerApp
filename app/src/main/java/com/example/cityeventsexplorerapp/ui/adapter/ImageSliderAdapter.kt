package com.example.cityeventsexplorerapp.ui.adapter

import android.view.View
import coil.load
import com.example.cityeventsexplorerapp.R
import com.example.cityeventsexplorerapp.databinding.ItemImageBinding
import me.ibrahimyilmaz.kiel.adapterOf
import me.ibrahimyilmaz.kiel.core.RecyclerViewHolder

/*class ImageSliderAdapter(
    private val context: Context,
    private val imageList: List<String>
) : PagerAdapter() {
    // on below line we are creating a method
    // as get count to return the size of the list.
    override fun getCount(): Int {
        return imageList.size
    }

    // on below line we are returning the object
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as FrameLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val mLayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView: View = mLayoutInflater.inflate(R.layout.item_image, container, false)
        val imageView: ImageView = itemView.findViewById<View>(R.id.idIVImage) as ImageView
        imageView.load(imageList[position])
        Objects.requireNonNull(container).addView(itemView)
        return itemView
    }

    // on below line we are creating a destroy item method.
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        // on below line we are removing view
        container.removeView(`object` as FrameLayout)
    }
}*/

class ImageSliderAdapter {

    val adapter =
        adapterOf<String> {
            diff(
                areItemsTheSame = { old, new -> old == new },
                areContentsTheSame = { old, new -> old == new },
            )

            register(
                layoutResource = R.layout.item_image,
                viewHolder = { v ->
                    ImageViewHolder(v)
                },
                onBindViewHolder = { vh, _, p -> vh.onBind(p) })
        }


    class ImageViewHolder(
        view: View
    ) : RecyclerViewHolder<String>(view) {
        private val binding = ItemImageBinding.bind(view)

        fun onBind(item: String) = with(binding) {
            idImage.load(item)
        }
    }

}